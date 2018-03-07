package com.facebook.messaging.attachments;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ExifOrientation;
import com.facebook.common.util.ExifOrientationUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.attachments.VideoAttachmentData.AttachmentType;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentMediaModel;
import com.facebook.messaging.media.upload.config.MediaUploadConfiguration;
import com.facebook.messaging.media.upload.config.MessagesVideoResizingPolicy;
import com.facebook.messaging.messageclassifier.AttachmentClassifier;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.messageclassifier.MessageExaminer;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageDataUtil;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.server.VideoServer;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mResuming= */
public class AttachmentDataFactory {
    private static final Class f15458a = AttachmentDataFactory.class;
    public static final Pattern f15459b = Pattern.compile("_[ts]\\.jpg$");
    public static final Pattern f15460c = Pattern.compile("\\/[ts]([^/]+\\.jpg)$");
    private static AttachmentDataFactory f15461o;
    private static final Object f15462p = new Object();
    private final MessageClassifier f15463d;
    private final MessageExaminer f15464e;
    public final AttachmentClassifier f15465f;
    public final AttachmentUriHelper f15466g;
    private final MessagesVideoResizingPolicy f15467h;
    private final AbstractFbErrorReporter f15468i;
    private final Set<String> f15469j;
    private final Provider<Boolean> f15470k;
    private final Provider<Boolean> f15471l;
    private final Provider<MediaUploadConfiguration> f15472m;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<VideoServer> f15473n = UltralightRuntime.f368b;

    private static AttachmentDataFactory m22015b(InjectorLike injectorLike) {
        AttachmentDataFactory attachmentDataFactory = new AttachmentDataFactory(MessageClassifier.m21990a(injectorLike), AttachmentClassifier.m22003a(injectorLike), MessageExaminer.m21995a(injectorLike), AttachmentUriHelper.m22032b(injectorLike), MessagesVideoResizingPolicy.m22035b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), IdBasedProvider.m1811a(injectorLike, 7945), IdBasedProvider.m1811a(injectorLike, 4371), IdBasedProvider.m1811a(injectorLike, 4106));
        attachmentDataFactory.f15473n = IdBasedSingletonScopeProvider.m1810b(injectorLike, 3695);
        return attachmentDataFactory;
    }

    public static AttachmentDataFactory m22010a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentDataFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f15462p) {
                AttachmentDataFactory attachmentDataFactory;
                if (a2 != null) {
                    attachmentDataFactory = (AttachmentDataFactory) a2.mo818a(f15462p);
                } else {
                    attachmentDataFactory = f15461o;
                }
                if (attachmentDataFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m22015b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f15462p, b3);
                        } else {
                            f15461o = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentDataFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    private AttachmentDataFactory(MessageClassifier messageClassifier, AttachmentClassifier attachmentClassifier, MessageExaminer messageExaminer, AttachmentUriHelper attachmentUriHelper, MessagesVideoResizingPolicy messagesVideoResizingPolicy, FbErrorReporter fbErrorReporter, Provider<MediaUploadConfiguration> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f15463d = messageClassifier;
        this.f15465f = attachmentClassifier;
        this.f15464e = messageExaminer;
        this.f15466g = attachmentUriHelper;
        this.f15467h = messagesVideoResizingPolicy;
        this.f15468i = fbErrorReporter;
        this.f15469j = Sets.m1313a();
        this.f15472m = provider;
        this.f15470k = provider2;
        this.f15471l = provider3;
    }

    public final boolean m22021a(Message message) {
        if (message.l == MessageType.SET_IMAGE) {
            return true;
        }
        if (message.i.isEmpty() && message.a().isEmpty()) {
            return false;
        }
        int i;
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (AttachmentClassifier.m22005b((Attachment) immutableList.get(i))) {
                return true;
            }
        }
        immutableList = message.a();
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (MediaResourceUtil.b((MediaResource) immutableList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public final int m22022b(Message message) {
        int i = 0;
        if (message.i.isEmpty() && message.a().isEmpty()) {
            return 0;
        }
        int i2;
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (AttachmentClassifier.m22005b((Attachment) immutableList.get(i3))) {
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        if (i4 > 0) {
            return i4;
        }
        ImmutableList a = message.a();
        int size2 = a.size();
        while (i < size2) {
            if (MediaResourceUtil.b((MediaResource) a.get(i))) {
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i++;
            i4 = i2;
        }
        return i4;
    }

    public final boolean m22023c(Message message) {
        int i;
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (AttachmentClassifier.m22006c((Attachment) immutableList.get(i))) {
                return true;
            }
        }
        immutableList = message.a();
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (((MediaResource) immutableList.get(i)).c()) {
                return true;
            }
        }
        return false;
    }

    public final int m22024d(Message message) {
        int i = 0;
        if (message.i.isEmpty() && message.a().isEmpty()) {
            return 0;
        }
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4;
            if (AttachmentClassifier.m22006c((Attachment) immutableList.get(i2))) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        if (i3 > 0) {
            return i3;
        }
        ImmutableList a = message.a();
        int size2 = a.size();
        while (i < size2) {
            if (((MediaResource) a.get(i)).c()) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i++;
            i3 = i4;
        }
        return i3;
    }

    public final boolean m22025e(Message message) {
        if (message.i.isEmpty() && message.a().isEmpty()) {
            return false;
        }
        int i;
        ImmutableList immutableList = message.i;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (AttachmentClassifier.m22007d((Attachment) immutableList.get(i))) {
                return true;
            }
        }
        immutableList = message.a();
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (((MediaResource) immutableList.get(i)).d == Type.VIDEO) {
                return true;
            }
        }
        return false;
    }

    public final ImmutableList<ImageAttachmentData> m22026f(Message message) {
        int i = 0;
        if (message.l == MessageType.SET_IMAGE) {
            return ImmutableList.of(m22012a(message, null, null));
        }
        if (message.i.isEmpty() && message.a().isEmpty()) {
            return RegularImmutableList.f535a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a;
        if (message.l == MessageType.PENDING_SEND || message.l == MessageType.FAILED_SEND || (message.i.isEmpty() && !message.a().isEmpty())) {
            a = message.a();
            int size = a.size();
            while (i < size) {
                MediaResource mediaResource = (MediaResource) a.get(i);
                if (MediaResourceUtil.b(mediaResource)) {
                    ImageAttachmentUris a2 = ImageAttachmentUris.a(mediaResource.c);
                    ImageAttachmentDataBuilder imageAttachmentDataBuilder = new ImageAttachmentDataBuilder();
                    imageAttachmentDataBuilder.a = a2;
                    ImageAttachmentDataBuilder imageAttachmentDataBuilder2 = imageAttachmentDataBuilder;
                    imageAttachmentDataBuilder2.e = mediaResource;
                    imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
                    imageAttachmentDataBuilder2.c = mediaResource.j;
                    imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
                    imageAttachmentDataBuilder2.d = mediaResource.k;
                    imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
                    imageAttachmentDataBuilder2.g = mediaResource.B;
                    imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
                    imageAttachmentDataBuilder2.h = null;
                    builder.m1069c(imageAttachmentDataBuilder2.i());
                }
                i++;
            }
            return builder.m1068b();
        }
        if (message.a().isEmpty() || message.a().size() != message.i.size()) {
            a = null;
        } else {
            a = message.a();
        }
        for (int i2 = 0; i2 < message.i.size(); i2++) {
            MediaResource mediaResource2;
            Attachment attachment = (Attachment) message.i.get(i2);
            if (a != null) {
                mediaResource2 = (MediaResource) a.get(i2);
            } else {
                mediaResource2 = null;
            }
            if (AttachmentClassifier.m22005b(attachment)) {
                builder.m1069c(m22012a(message, attachment, mediaResource2));
            }
        }
        return builder.m1068b();
    }

    public final AudioAttachmentData m22027g(Message message) {
        if (this.f15463d.m21993a(message) != MessageClassification.AUDIO_CLIP) {
            return null;
        }
        if (!message.a().isEmpty()) {
            boolean z;
            long j;
            MediaResource mediaResource = (MediaResource) message.a().get(0);
            long j2 = mediaResource.i;
            if (j2 == 0 && !message.i.isEmpty()) {
                j2 = AudioAttachmentDurationUtil.a(((Attachment) message.i.get(0)).e);
                if (((Attachment) message.i.get(0)).i != null) {
                    z = ((Attachment) message.i.get(0)).i.a;
                    j = j2;
                    return new AudioAttachmentData(j, mediaResource.c, z);
                }
            }
            z = false;
            j = j2;
            return new AudioAttachmentData(j, mediaResource.c, z);
        } else if (message.i.isEmpty()) {
            return null;
        } else {
            return m22011a(message, (Attachment) message.i.get(0));
        }
    }

    public final boolean m22028h(Message message) {
        ImmutableList immutableList;
        int size;
        int i;
        if (this.f15463d.m21993a(message) == MessageClassification.NORMAL) {
            immutableList = message.i;
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                if (this.f15465f.m22008e((Attachment) immutableList.get(i))) {
                    return true;
                }
            }
        }
        immutableList = message.a();
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            if (((MediaResource) immutableList.get(i)).d == Type.OTHER) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final VideoAttachmentData m22029j(@Nullable Message message) {
        if (message == null) {
            return null;
        }
        if (this.f15464e.m21997b(message)) {
            return m22017k(message);
        }
        if (this.f15464e.m21998c(message)) {
            return m22018l(message);
        }
        return null;
    }

    private VideoAttachmentData m22017k(Message message) {
        Attachment attachment = (Attachment) Iterables.m950a(message.i, null);
        MediaResource mediaResource = (MediaResource) Iterables.m950a(message.a(), null);
        List m = m22019m(message);
        VideoAttachmentDataBuilder newBuilder = VideoAttachmentData.newBuilder();
        newBuilder.g = m;
        VideoAttachmentDataBuilder videoAttachmentDataBuilder = newBuilder;
        videoAttachmentDataBuilder.a = AttachmentType.MESSAGE_ATTACHMENT;
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        if (mediaResource != null) {
            m22014a(videoAttachmentDataBuilder, mediaResource);
        }
        if (attachment != null) {
            if (attachment.h != null) {
                int i = (int) (((long) attachment.h.d) * 1000);
                videoAttachmentDataBuilder.b = attachment.h.a;
                VideoAttachmentDataBuilder videoAttachmentDataBuilder2 = videoAttachmentDataBuilder;
                videoAttachmentDataBuilder2.c = attachment.h.b;
                videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
                videoAttachmentDataBuilder2.d = attachment.h.c;
                videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
                videoAttachmentDataBuilder2.e = i;
                VideoAttachmentDataBuilder videoAttachmentDataBuilder3 = videoAttachmentDataBuilder2;
                videoAttachmentDataBuilder3.f = attachment.f;
                videoAttachmentDataBuilder3 = videoAttachmentDataBuilder3;
                videoAttachmentDataBuilder3.h = attachment.h.g;
                videoAttachmentDataBuilder3 = videoAttachmentDataBuilder3;
                videoAttachmentDataBuilder3.i = attachment.h.e;
                videoAttachmentDataBuilder3.j = attachment.c;
            } else if (!this.f15469j.contains(message.a)) {
                this.f15468i.m2340a("MESSENGER_INLINE_VIDEO_ATTACHMENT_WITHOUT_VIDEO_DATA", "Attachment without videoData info:\n" + "fbid: " + attachment.c + "\nfilename: " + attachment.e + "\nfileSize: " + attachment.f + "\nid: " + attachment.a + "\nmimeType: " + attachment.d + "\n\nmessage info:\nid: " + message.a + "\nmsgType: " + message.l + "\nchannelSource: " + message.q);
                this.f15469j.add(message.a);
            }
        }
        return videoAttachmentDataBuilder.n();
    }

    private VideoAttachmentData m22018l(Message message) {
        Preconditions.checkNotNull(message.G);
        Preconditions.checkNotNull(message.G.l());
        List m = m22019m(message);
        XMAAttachmentMediaModel o = message.G.l().o();
        if (o == null) {
            return null;
        }
        DefaultImageFieldsModel n = o.n();
        if (n == null) {
            n = o.m();
        }
        VideoAttachmentDataBuilder newBuilder = VideoAttachmentData.newBuilder();
        newBuilder.a = AttachmentType.FACEBOOK_STORY_ATTACHMENT;
        newBuilder = newBuilder;
        newBuilder.g = m;
        VideoAttachmentDataBuilder videoAttachmentDataBuilder = newBuilder;
        videoAttachmentDataBuilder.b = o.l();
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder.c = o.b();
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder.j = message.G.b();
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder.e = o.j();
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder.i = Source.NONQUICKCAM;
        videoAttachmentDataBuilder = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder.h = Uri.parse(n.b());
        return videoAttachmentDataBuilder.n();
    }

    public final VideoAttachmentData m22020a(MediaResource mediaResource) {
        Preconditions.checkNotNull(mediaResource);
        Preconditions.checkArgument(mediaResource.d == Type.VIDEO);
        List of = ImmutableList.of(m22016c(mediaResource));
        VideoAttachmentDataBuilder newBuilder = VideoAttachmentData.newBuilder();
        newBuilder.a = AttachmentType.MESSAGE_ATTACHMENT;
        newBuilder = newBuilder;
        newBuilder.g = of;
        VideoAttachmentDataBuilder videoAttachmentDataBuilder = newBuilder;
        m22014a(videoAttachmentDataBuilder, mediaResource);
        return videoAttachmentDataBuilder.n();
    }

    private ImageAttachmentData m22012a(Message message, @Nullable Attachment attachment, @Nullable MediaResource mediaResource) {
        ImageAttachmentDataBuilder imageAttachmentDataBuilder = new ImageAttachmentDataBuilder();
        if (!(attachment == null || attachment.g == null)) {
            ImageData imageData = attachment.g;
            imageAttachmentDataBuilder.c = imageData.a;
            ImageAttachmentDataBuilder imageAttachmentDataBuilder2 = imageAttachmentDataBuilder;
            imageAttachmentDataBuilder2.d = imageData.b;
            imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
            imageAttachmentDataBuilder2.f = attachment.c;
            imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
            imageAttachmentDataBuilder2.e = mediaResource;
            imageAttachmentDataBuilder2 = imageAttachmentDataBuilder2;
            imageAttachmentDataBuilder2.g = imageData.f;
            imageAttachmentDataBuilder2.h = imageData.g;
            imageAttachmentDataBuilder.a = m22013a(message, attachment, imageData.c, true);
            imageAttachmentDataBuilder.b = m22013a(message, attachment, imageData.d, false);
        }
        if (imageAttachmentDataBuilder.a == null) {
            Uri a = m22009a(message.a, attachment);
            ImageAttachmentUrisBuilder newBuilder = ImageAttachmentUris.newBuilder();
            newBuilder.a = a;
            newBuilder = newBuilder;
            newBuilder.e = a;
            imageAttachmentDataBuilder.a = newBuilder.f();
        }
        return imageAttachmentDataBuilder.i();
    }

    private ImageAttachmentUris m22013a(Message message, Attachment attachment, AttachmentImageMap attachmentImageMap, boolean z) {
        if (attachmentImageMap == null) {
            return null;
        }
        Uri a;
        if (z) {
            a = m22009a(message.a, attachment);
        } else {
            a = null;
        }
        ImageAttachmentUrisBuilder newBuilder;
        if (ImageDataUtil.a(attachmentImageMap)) {
            newBuilder = ImageAttachmentUris.newBuilder();
            newBuilder.a = Uri.parse(attachmentImageMap.a(AttachmentImageType.FULL_SCREEN).c);
            newBuilder = newBuilder;
            newBuilder.b = Uri.parse(attachmentImageMap.a(AttachmentImageType.SMALL_PREVIEW).c);
            newBuilder = newBuilder;
            newBuilder.c = Uri.parse(attachmentImageMap.a(AttachmentImageType.MEDIUM_PREVIEW).c);
            newBuilder = newBuilder;
            newBuilder.d = Uri.parse(attachmentImageMap.a(AttachmentImageType.LARGE_PREVIEW).c);
            newBuilder = newBuilder;
            newBuilder.e = a;
            return newBuilder.f();
        } else if (ImageDataUtil.b(attachmentImageMap)) {
            ImageAttachmentUrisBuilder newBuilder2 = ImageAttachmentUris.newBuilder();
            newBuilder2.a = Uri.parse(attachmentImageMap.a(AttachmentImageType.FULL_SCREEN).c);
            return newBuilder2.f();
        } else {
            BLog.c(f15458a, ImageDataUtil.a(message.a, attachmentImageMap));
            if (a == null) {
                return null;
            }
            newBuilder = ImageAttachmentUris.newBuilder();
            newBuilder.a = a;
            newBuilder = newBuilder;
            newBuilder.e = a;
            return newBuilder.f();
        }
    }

    private AudioAttachmentData m22011a(Message message, Attachment attachment) {
        Uri a = m22009a(message.a, attachment);
        long a2 = AudioAttachmentDurationUtil.a(attachment.e);
        boolean z = false;
        if (attachment.i != null) {
            z = attachment.i.a;
        }
        return new AudioAttachmentData(a2, a, z);
    }

    private Uri m22009a(String str, @Nullable Attachment attachment) {
        Uri.Builder a = this.f15466g.m22033a();
        a.appendQueryParameter("mid", AttachmentUriHelper.m22030a(str));
        if (attachment != null) {
            a.appendQueryParameter("aid", attachment.a);
        } else {
            a.appendQueryParameter("aid", "1");
        }
        a.appendQueryParameter("format", "binary");
        if (((Boolean) this.f15470k.get()).booleanValue() && ((Boolean) this.f15471l.get()).booleanValue() && attachment != null && attachment.g != null) {
            a.appendQueryParameter("ext", "webp");
        }
        return a.build();
    }

    private void m22014a(VideoAttachmentDataBuilder videoAttachmentDataBuilder, MediaResource mediaResource) {
        ExifOrientation a;
        int i;
        int i2;
        Object obj;
        Preconditions.checkNotNull(mediaResource);
        Preconditions.checkArgument(mediaResource.d == Type.VIDEO);
        if (((MediaUploadConfiguration) this.f15472m.get()).a) {
            VideoTranscodeParams a2 = this.f15467h.m22039a(mediaResource.j, mediaResource.k, ExifOrientationUtil.a(mediaResource.l, 0), mediaResource.q, VideoMirroringMode.NONE);
            a = ExifOrientationUtil.a(a2.a());
            i = a2.d;
            i2 = a2.e;
        } else {
            a = mediaResource.l;
            i = mediaResource.j;
            i2 = mediaResource.k;
        }
        if (a == ExifOrientation.ROTATE_90 || a == ExifOrientation.ROTATE_270) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        Source source = mediaResource.e.isQuickCamSource() ? Source.QUICKCAM : Source.NONQUICKCAM;
        videoAttachmentDataBuilder.b = i2;
        VideoAttachmentDataBuilder videoAttachmentDataBuilder2 = videoAttachmentDataBuilder;
        videoAttachmentDataBuilder2.c = i;
        videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
        videoAttachmentDataBuilder2.e = mediaResource.b();
        videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
        videoAttachmentDataBuilder2.f = (int) mediaResource.p;
        videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
        videoAttachmentDataBuilder2.h = mediaResource.f;
        videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
        videoAttachmentDataBuilder2.i = source;
        videoAttachmentDataBuilder2 = videoAttachmentDataBuilder2;
        videoAttachmentDataBuilder2.j = "";
        videoAttachmentDataBuilder2.k = mediaResource;
        if (mediaResource.s > 0) {
            videoAttachmentDataBuilder.l = mediaResource.s;
        }
        if (mediaResource.t > 0) {
            videoAttachmentDataBuilder.m = mediaResource.t;
        }
    }

    private ImmutableList<VideoDataSource> m22019m(Message message) {
        MediaResource mediaResource = (MediaResource) Iterables.m950a(message.a(), null);
        Attachment attachment = (Attachment) Iterables.m950a(message.i, null);
        Builder builder = ImmutableList.builder();
        if (mediaResource != null) {
            builder.m1069c(m22016c(mediaResource));
        }
        if (attachment != null) {
            VideoServer videoServer = (VideoServer) this.f15473n.get();
            Uri.Builder b = this.f15466g.m22034b();
            b.appendQueryParameter("id", attachment.c);
            b.appendQueryParameter("preview", null != null ? "true" : "false");
            Uri a = videoServer.m27011a(b.build(), attachment.a, true);
            VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
            newBuilder.a = a;
            VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
            videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
            builder.m1069c(videoDataSourceBuilder.i());
        }
        if (!(message.G == null || message.G.l() == null || message.G.l().o() == null)) {
            XMAAttachmentMediaModel o = message.G.l().o();
            videoDataSourceBuilder = VideoDataSource.newBuilder();
            videoDataSourceBuilder.a = Uri.parse(o.k());
            videoDataSourceBuilder = videoDataSourceBuilder;
            videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
            builder.m1069c(videoDataSourceBuilder.i());
        }
        return builder.m1068b();
    }

    private static VideoDataSource m22016c(MediaResource mediaResource) {
        VideoDataSource.VideoMirroringMode videoMirroringMode;
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = mediaResource.c;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        newBuilder = newBuilder;
        newBuilder.g = mediaResource.q;
        VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
        if (mediaResource.e == MediaResource.Source.QUICKCAM_FRONT) {
            videoMirroringMode = VideoDataSource.VideoMirroringMode.MIRROR_HORIZONTALLY;
        } else {
            videoMirroringMode = VideoDataSource.VideoMirroringMode.NONE;
        }
        videoDataSourceBuilder.h = videoMirroringMode;
        return videoDataSourceBuilder.i();
    }
}
