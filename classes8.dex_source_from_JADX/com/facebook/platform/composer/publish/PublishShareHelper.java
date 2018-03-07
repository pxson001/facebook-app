package com.facebook.platform.composer.publish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.FaceBoxStoreCopy;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.store.TagStoreCopy;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_source */
public class PublishShareHelper {
    public final PlatformComposerModel f4279a;
    private final User f4280b;
    private final long f4281c;
    private final FbDataConnectionManager f4282d;
    public final Clock f4283e;
    public final TagStore f4284f;
    public final FaceBoxStore f4285g;
    public final UploadManager f4286h;
    public final Toaster f4287i;
    public final FbSharedPreferences f4288j;
    private final UploadOperationFactory f4289k;
    private final AbstractFbErrorReporter f4290l;
    private final MediaItemFactory f4291m;
    private final Photos360QEHelper f4292n;
    private final OptimisticPostHelper f4293o;
    public long f4294p = -1;
    public ImmutableList<ComposerAttachment> f4295q;
    public GraphQLTextWithEntities f4296r;
    private String f4297s;

    @Inject
    public PublishShareHelper(@Assisted PlatformComposerModel platformComposerModel, @Assisted User user, @Assisted long j, @Nullable @Assisted OptimisticPostHelper optimisticPostHelper, FbDataConnectionManager fbDataConnectionManager, Clock clock, TagStore tagStore, FaceBoxStore faceBoxStore, Toaster toaster, FbSharedPreferences fbSharedPreferences, UploadManager uploadManager, UploadOperationFactory uploadOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter, MediaItemFactory mediaItemFactory, Photos360QEHelper photos360QEHelper) {
        this.f4279a = platformComposerModel;
        this.f4280b = user;
        this.f4281c = j;
        this.f4293o = optimisticPostHelper;
        this.f4282d = fbDataConnectionManager;
        this.f4283e = clock;
        this.f4284f = tagStore;
        this.f4285g = faceBoxStore;
        this.f4287i = toaster;
        this.f4288j = fbSharedPreferences;
        this.f4286h = uploadManager;
        this.f4289k = uploadOperationFactory;
        this.f4295q = AttachmentUtils.a(this.f4279a.f4188c.m4153e());
        this.f4296r = this.f4279a.f4188c.m4155g();
        this.f4297s = this.f4279a.f4188c.m4156h();
        this.f4290l = abstractFbErrorReporter;
        this.f4291m = mediaItemFactory;
        this.f4292n = photos360QEHelper;
        m4207c();
    }

    private PublishPostParams m4206b() {
        String valueOf;
        MinutiaeTag d;
        boolean z;
        long longValue;
        String str = null;
        if (this.f4279a.f4188c.m4157i().a() != null) {
            valueOf = String.valueOf(this.f4279a.f4188c.m4157i().j());
        } else {
            valueOf = null;
        }
        ImmutableList copyOf = ImmutableList.copyOf(this.f4279a.f4188c.m4169u());
        ComposerConfiguration composerConfiguration = this.f4279a.f4187b;
        Long n = this.f4279a.f4188c.m4162n();
        if (this.f4279a.f4188c.m4158j() != null) {
            d = this.f4279a.f4188c.m4158j().d();
        } else {
            d = null;
        }
        if (this.f4279a.f4188c.m4164p() != null) {
            str = this.f4279a.f4188c.m4164p().stickerId;
        }
        Builder builder = new Builder();
        builder.G = this.f4279a.f4186a;
        builder = builder;
        builder.r = this.f4279a.f4186a;
        builder = builder;
        builder.t = this.f4283e.a() / 1000;
        builder = builder;
        builder.b = this.f4279a.f4190e.targetId;
        builder = builder;
        builder.c = this.f4297s;
        builder = builder;
        builder.d = valueOf;
        Builder builder2 = builder;
        builder2.p = composerConfiguration.getComposerType();
        builder = builder2;
        if (this.f4279a.f4188c.m4157i().a() != null) {
            z = true;
        } else {
            z = false;
        }
        builder.s = z;
        builder2 = builder.d(copyOf);
        builder2.j = Long.parseLong(this.f4280b.a);
        builder2 = builder2;
        builder2.m = composerConfiguration.getNectarModule();
        builder2 = builder2;
        builder2.w = this.f4279a.f4188c.m4166r();
        builder2 = builder2;
        builder2.A = composerConfiguration.getPlatformConfiguration().insightsPlatformRef;
        builder2 = builder2;
        builder2.S = this.f4279a.f4191f;
        builder2 = builder2;
        builder2.o = this.f4279a.f4188c.m4161m();
        builder2 = builder2;
        builder2.ab = this.f4279a.f4188c.m4157i().c();
        builder2 = builder2;
        if (n != null) {
            longValue = n.longValue();
        } else {
            longValue = 0;
        }
        builder2 = builder2.a(Long.valueOf(longValue));
        builder2.W = composerConfiguration.isThrowbackPost();
        builder2 = builder2.a(d);
        builder2.Y = this.f4282d.c().name();
        builder2 = builder2;
        builder2.g = this.f4279a.f4189d.a();
        builder2 = builder2;
        builder2.R = true;
        builder2 = builder2;
        builder2.ac = composerConfiguration.getSourceType().toString();
        builder2 = builder2;
        builder2.O = str;
        builder2 = builder2;
        builder2.ad = this.f4279a.f4188c.m4171w();
        builder2 = builder2;
        ComposerShareParams q = this.f4279a.f4188c.m4165q();
        if (q != null) {
            if (q.linkForShare != null) {
                builder2.i = q.linkForShare;
                Builder builder3 = builder2;
                builder3.B = composerConfiguration.getPlatformConfiguration().nameForShareLink;
                builder3 = builder3;
                builder3.C = composerConfiguration.getPlatformConfiguration().captionForShareLink;
                builder3 = builder3;
                builder3.D = composerConfiguration.getPlatformConfiguration().descriptionForShareLink;
                builder3.F = composerConfiguration.getPlatformConfiguration().pictureForShareLink;
            }
            if (q.quoteText != null) {
                builder2.E = q.quoteText;
            }
            builder2.k = q.shareable;
            builder2.l = q.shareTracking;
        }
        if (this.f4279a.f4188c.m4172x() != null) {
            builder2.y = this.f4279a.f4188c.m4172x().b();
            Builder builder4 = builder2;
            builder4.x = this.f4279a.f4188c.m4172x().a();
            builder4.z = this.f4279a.f4188c.m4172x().c();
        }
        return builder2.a();
    }

    public final Intent m4211a() {
        Intent intent = new Intent();
        Parcelable b = m4206b();
        intent.putExtra("publishPostParams", b);
        if (m4208d()) {
            Builder builder = new Builder(b);
            builder.q = true;
            b = builder.a();
            intent.putExtra("is_uploading_media", true);
        } else if (this.f4279a.f4188c.m4161m() == PublishMode.SCHEDULE_POST) {
            intent.putExtra("extra_actor_viewer_context", this.f4279a.f4194i);
        }
        intent.putExtra("publishPostParams", b);
        if (this.f4293o != null) {
            intent.putExtra("extra_optimistic_feed_story", this.f4293o.b().a());
        }
        return intent;
    }

    private void m4207c() {
        if (!this.f4279a.f4188c.m4146A() && !Strings.isNullOrEmpty(this.f4279a.f4188c.m4174z())) {
            String str = "\n" + this.f4279a.f4188c.m4174z();
            GraphQLTextWithEntities graphQLTextWithEntities = this.f4296r;
            GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
            builder.i = str;
            this.f4296r = GraphQLHelper.a(graphQLTextWithEntities, builder.a());
            this.f4297s += str;
        }
    }

    private boolean m4208d() {
        int i;
        if (AttachmentUtils.i(this.f4279a.f4188c.m4153e())) {
            i = 1;
        } else if (AttachmentUtils.k(this.f4279a.f4188c.m4153e())) {
            Editor edit = this.f4288j.edit();
            edit.a(FeedPrefKeys.u, this.f4283e.a());
            edit.commit();
            if (this.f4279a.f4188c.m4157i().a() != null) {
                this.f4294p = this.f4279a.f4188c.m4157i().j();
            }
            if (this.f4279a.f4188c.m4151c() != null) {
                this.f4295q = m4205a(this.f4295q, this.f4296r);
                this.f4296r = GraphQLHelper.h;
            } else if (this.f4295q.size() == 1 && !StringUtil.a(((ComposerAttachment) this.f4295q.get(0)).d().a())) {
                ComposerAttachment composerAttachment = (ComposerAttachment) this.f4295q.get(0);
                int i2 = (StringUtil.a(this.f4296r.a()) || StringUtil.a(composerAttachment.d().a())) ? 0 : 1;
                if (i2 != 0) {
                    this.f4296r = GraphQLHelper.a(this.f4296r, GraphQLHelper.a("\n"));
                }
                this.f4296r = GraphQLHelper.a(this.f4296r, ((ComposerAttachment) this.f4295q.get(0)).d());
                ComposerAttachment.Builder a = ComposerAttachment.Builder.a(composerAttachment);
                a.d = GraphQLHelper.h;
                composerAttachment = a.a();
                if (composerAttachment != null) {
                    this.f4295q = ImmutableList.of(composerAttachment);
                }
            }
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            return false;
        }
        UploadOperation f = m4209f();
        Preconditions.checkNotNull(f);
        List arrayList = new ArrayList();
        ImmutableList immutableList = f.a;
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i3);
            if (mediaItem.b().mType == Type.Photo) {
                arrayList.add(mediaItem.d());
            }
        }
        f.a(TagStoreCopy.a(this.f4284f, arrayList), FaceBoxStoreCopy.a(this.f4285g, arrayList));
        this.f4286h.a(f);
        if (AttachmentUtils.k(this.f4279a.f4188c.m4153e())) {
            if (AttachmentUtils.d(this.f4279a.f4188c.m4153e())) {
                i = 2131234577;
            } else if (this.f4279a.f4188c.m4153e().size() > 1) {
                i = 2131238376;
            } else {
                i = 2131238377;
            }
            this.f4287i.b(new ToastBuilder(i));
        }
        return true;
    }

    @Nullable
    private UploadOperation m4209f() {
        if (AttachmentUtils.n(this.f4279a.f4188c.m4153e())) {
            return m4210g();
        }
        MinutiaeTag minutiaeTag = MinutiaeTag.a;
        if (this.f4279a.f4188c.m4158j() != null) {
            minutiaeTag = this.f4279a.f4188c.m4158j().d();
        }
        ImmutableList copyOf = ImmutableList.copyOf(this.f4279a.f4188c.m4169u());
        UploadOperationFactory uploadOperationFactory;
        ImmutableList o;
        ImmutableList p;
        String a;
        long j;
        String c;
        boolean d;
        RedSpaceValue f;
        boolean z;
        if (this.f4279a.f4188c.m4151c() != null) {
            if (this.f4279a.f4190e.a()) {
                return this.f4289k.a(AttachmentUtils.o(this.f4295q), AttachmentUtils.p(this.f4295q), Long.parseLong(this.f4279a.f4188c.m4151c().u()), MentionsUtils.a(this.f4296r), this.f4279a.f4186a, this.f4279a.f4194i, this.f4279a.f4187b.getSourceType().toString());
            }
            uploadOperationFactory = this.f4289k;
            o = AttachmentUtils.o(this.f4295q);
            p = AttachmentUtils.p(this.f4295q);
            a = MentionsUtils.a(this.f4296r);
            long parseLong = Long.parseLong(this.f4279a.f4188c.m4151c().u());
            j = this.f4294p;
            c = this.f4279a.f4188c.m4157i().c();
            d = this.f4279a.f4188c.m4157i().d();
            f = this.f4279a.f4188c.m4154f();
            z = AttachmentUtils.r(this.f4295q) && this.f4292n.i();
            return uploadOperationFactory.a(o, p, a, parseLong, copyOf, j, c, d, f, z, AttachmentUtils.s(this.f4295q), this.f4279a.f4186a, this.f4279a.f4188c.m4172x(), this.f4279a.f4188c.m4166r(), this.f4279a.f4188c.m4157i().a() != null, this.f4279a.f4187b.getSourceType().toString(), false, this.f4279a.f4188c.m4173y(), this.f4279a.f4188c.m4147B());
        } else if (this.f4279a.f4190e.targetId == Long.parseLong(this.f4280b.d())) {
            uploadOperationFactory = this.f4289k;
            o = AttachmentUtils.o(this.f4295q);
            p = AttachmentUtils.p(this.f4295q);
            a = MentionsUtils.a(this.f4296r);
            PhotoUploadPrivacy photoUploadPrivacy = new PhotoUploadPrivacy(this.f4279a.f4189d.a());
            j = this.f4294p;
            c = this.f4279a.f4188c.m4157i().c();
            d = this.f4279a.f4188c.m4157i().d();
            f = this.f4279a.f4188c.m4154f();
            z = AttachmentUtils.r(this.f4295q) && this.f4292n.i();
            return uploadOperationFactory.a(o, p, a, minutiaeTag, photoUploadPrivacy, copyOf, j, c, d, f, z, AttachmentUtils.s(this.f4295q), this.f4279a.f4186a, this.f4279a.f4188c.m4172x(), this.f4279a.f4188c.m4166r(), this.f4279a.f4188c.m4157i().a() != null, this.f4279a.f4187b.getSourceType().toString(), AttachmentUtils.l(this.f4295q), this.f4279a.f4188c.m4173y(), this.f4279a.f4188c.m4147B());
        } else if (this.f4279a.f4190e.targetId <= 0 || this.f4295q.size() <= 0) {
            this.f4290l.b("photo upload error", StringFormatUtil.formatStrLocaleSafe("Unsupported upload type target=%d, user=%d, attach=%s", Long.valueOf(this.f4279a.f4190e.targetId), Long.valueOf(Long.parseLong(this.f4280b.d())), Integer.valueOf(this.f4295q.size())));
            return null;
        } else if (this.f4279a.f4190e.a() || this.f4279a.f4194i != null) {
            UploadOperationFactory uploadOperationFactory2 = this.f4289k;
            copyOf = AttachmentUtils.o(this.f4295q);
            ImmutableList p2 = AttachmentUtils.p(this.f4295q);
            long j2 = this.f4279a.f4190e.targetId;
            String a2 = MentionsUtils.a(this.f4296r);
            long j3 = this.f4294p;
            this.f4279a.f4188c.m4157i().c();
            boolean d2 = this.f4279a.f4188c.m4157i().d();
            RedSpaceValue f2 = this.f4279a.f4188c.m4154f();
            boolean z2 = AttachmentUtils.r(this.f4295q) && this.f4292n.i();
            return uploadOperationFactory2.a(copyOf, p2, j2, a2, minutiaeTag, j3, d2, f2, z2, AttachmentUtils.s(this.f4295q), this.f4279a.f4186a, this.f4279a.f4194i, this.f4279a.f4188c.m4161m(), this.f4279a.f4188c.m4162n() != null ? this.f4279a.f4188c.m4162n().longValue() : 0, null, this.f4279a.f4187b.getSourceType().toString(), this.f4279a.f4188c.m4157i().a() != null, AttachmentUtils.l(this.f4295q), this.f4279a.f4188c.m4173y());
        } else {
            UploadOperationFactory uploadOperationFactory3 = this.f4289k;
            ImmutableList o2 = AttachmentUtils.o(this.f4295q);
            ImmutableList p3 = AttachmentUtils.p(this.f4295q);
            long j4 = this.f4279a.f4190e.targetId;
            String targetType = this.f4279a.f4190e.targetType.toString();
            String a3 = MentionsUtils.a(this.f4296r);
            long j5 = this.f4294p;
            boolean z3 = this.f4279a.f4188c.m4157i().a() != null;
            String c2 = this.f4279a.f4188c.m4157i().c();
            boolean d3 = this.f4279a.f4188c.m4157i().d();
            RedSpaceValue f3 = this.f4279a.f4188c.m4154f();
            boolean z4 = AttachmentUtils.r(this.f4295q) && this.f4292n.i();
            return uploadOperationFactory3.a(o2, p3, j4, targetType, a3, minutiaeTag, copyOf, j5, z3, c2, d3, f3, z4, AttachmentUtils.s(this.f4295q), this.f4279a.f4186a, this.f4279a.f4188c.m4159k(), this.f4279a.f4188c.m4160l(), this.f4279a.f4187b.getSourceType().toString(), AttachmentUtils.l(this.f4295q), this.f4279a.f4188c.m4173y());
        }
    }

    private UploadOperation m4210g() {
        long parseLong = Long.parseLong(this.f4280b.d());
        long j = this.f4279a.f4190e.targetId;
        Uri g = AttachmentUtils.g(this.f4279a.f4188c.m4153e());
        Bundle h = AttachmentUtils.h(this.f4279a.f4188c.m4153e());
        ImmutableSet u = this.f4279a.f4188c.m4169u();
        String str = this.f4279a.f4186a;
        long j2 = -1;
        if (this.f4279a.f4188c.m4157i().a() != null) {
            j2 = this.f4279a.f4188c.m4157i().j();
        }
        PublishMode m = this.f4279a.f4188c.m4161m();
        Long n = this.f4279a.f4188c.m4162n();
        VideoItem videoItem = (VideoItem) this.f4291m.a(g, FallbackMediaId.DEFAULT);
        if (videoItem == null) {
            this.f4290l.b("video upload error", StringFormatUtil.formatStrLocaleSafe("Null VideoItem for Uri %s", g));
            return null;
        }
        MinutiaeTag minutiaeTag = MinutiaeTag.a;
        if (this.f4279a.f4188c.m4158j() != null) {
            minutiaeTag = this.f4279a.f4188c.m4158j().d();
        }
        if (parseLong == j || j <= 0) {
            return this.f4289k.a(videoItem, h, this.f4297s, minutiaeTag, new PhotoUploadPrivacy(this.f4279a.f4189d.a()), ImmutableList.copyOf(u), j2, this.f4279a.f4188c.m4157i().c(), false, this.f4279a.f4188c.m4154f(), str, this.f4279a.f4188c.m4172x(), this.f4279a.f4188c.m4166r(), this.f4279a.f4188c.m4157i().a() != null, this.f4279a.f4187b.getSourceType().toString(), this.f4279a.f4188c.m4173y(), this.f4279a.f4188c.m4147B());
        } else if (this.f4279a.f4194i != null) {
            return this.f4289k.a(videoItem, h, j, this.f4297s, minutiaeTag, j2, this.f4279a.f4188c.m4157i().a() != null, this.f4279a.f4188c.m4157i().c(), false, this.f4279a.f4188c.m4154f(), m, n, str, this.f4279a.f4194i, this.f4279a.f4187b.getSourceType().toString(), this.f4279a.f4188c.m4173y());
        } else {
            return this.f4289k.a(videoItem, h, j, this.f4279a.f4190e.targetType.toString(), this.f4297s, minutiaeTag, ImmutableList.copyOf(u), j2, this.f4279a.f4188c.m4157i().a() != null, this.f4279a.f4188c.m4157i().c(), false, this.f4279a.f4188c.m4154f(), str, this.f4279a.f4188c.m4159k(), this.f4279a.f4188c.m4160l(), this.f4279a.f4187b.getSourceType().toString(), this.f4279a.f4188c.m4173y());
        }
    }

    public static ImmutableList<ComposerAttachment> m4205a(ImmutableList<ComposerAttachment> immutableList, GraphQLTextWithEntities graphQLTextWithEntities) {
        int i;
        int i2 = 0;
        Preconditions.checkArgument(!immutableList.isEmpty());
        ImmutableList.Builder builder = ImmutableList.builder();
        ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(0);
        if (StringUtil.a(composerAttachment.d().a()) || StringUtil.a(graphQLTextWithEntities.a())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            graphQLTextWithEntities = GraphQLHelper.a(graphQLTextWithEntities, GraphQLHelper.a("\n"));
        }
        GraphQLTextWithEntities a = GraphQLHelper.a(graphQLTextWithEntities, composerAttachment.d());
        ComposerAttachment.Builder a2 = ComposerAttachment.Builder.a((ComposerAttachment) immutableList.get(0));
        a2.d = a;
        ComposerAttachment.Builder builder2 = a2;
        builder2.e = ((ComposerAttachment) immutableList.get(0)).e();
        builder.c(builder2.a());
        ImmutableList subList = immutableList.subList(1, immutableList.size());
        i = subList.size();
        while (i2 < i) {
            builder.c((ComposerAttachment) subList.get(i2));
            i2++;
        }
        return builder.b();
    }
}
