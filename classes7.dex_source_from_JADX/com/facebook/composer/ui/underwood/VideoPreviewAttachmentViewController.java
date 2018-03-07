package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.Builder;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.underwood.UnderwoodController.AttachmentEventsListener;
import com.facebook.composer.ui.underwood.VideoPreviewAttachmentView.C14223;
import com.facebook.facerec.manager.ImagePipelineFaceRecManager;
import com.facebook.friendsharing.videotagging.VideoTaggingManager;
import com.facebook.friendsharing.videotagging.VideoTaggingManagerProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerVideoTaggingInfo;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager.VideoEditGalleryCallback;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* compiled from: comment_on_recent_post */
public class VideoPreviewAttachmentViewController<DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesConfiguration> implements UnderwoodAttachmentViewController {
    public final VideoEditGalleryCallback f17352a = new C14231(this);
    private final WeakReference<DataProvider> f17353b;
    private final ComposerAttachmentViewUtility f17354c;
    public final QeAccessor f17355d;
    private final Context f17356e;
    public final AttachmentEventsListener f17357f;
    private final InputMethodManager f17358g;
    public final VideoCreativeEditingLogger f17359h;
    public final FragmentManager f17360i;
    public final String f17361j;
    private final UnderwoodVideoTranscodingUtil f17362k;
    public final VideoTaggingManagerProvider f17363l;
    private final ExecutorService f17364m;
    public final Handler f17365n;
    private final Runnable f17366o;
    public final Rect f17367p = new Rect(0, 0, 0, 0);
    private Future f17368q;
    public ComposerAttachment f17369r;
    public VideoPreviewAttachmentView f17370s;
    public VideoEditGalleryLaunchConfiguration f17371t;
    public VideoEditGalleryFragmentManager f17372u;
    public boolean f17373v;
    public int f17374w;

    /* compiled from: comment_on_recent_post */
    class C14231 implements VideoEditGalleryCallback {
        final /* synthetic */ VideoPreviewAttachmentViewController f17346a;

        C14231(VideoPreviewAttachmentViewController videoPreviewAttachmentViewController) {
            this.f17346a = videoPreviewAttachmentViewController;
        }

        public final void mo1169a(VideoCreativeEditingData videoCreativeEditingData, int i) {
            Preconditions.checkNotNull(videoCreativeEditingData);
            this.f17346a.f17374w = i;
            this.f17346a.f17357f.m21138a(this.f17346a.f17369r, this.f17346a.f17369r.b(), videoCreativeEditingData);
        }

        public final void mo1168a(int i) {
            this.f17346a.f17374w = i;
            VideoPreviewAttachmentViewController.m21242p(this.f17346a);
        }
    }

    /* compiled from: comment_on_recent_post */
    class C14242 implements Runnable {
        final /* synthetic */ VideoPreviewAttachmentViewController f17347a;

        C14242(VideoPreviewAttachmentViewController videoPreviewAttachmentViewController) {
            this.f17347a = videoPreviewAttachmentViewController;
        }

        public void run() {
            this.f17347a.f17373v = true;
            VideoPreviewAttachmentView videoPreviewAttachmentView = this.f17347a.f17370s;
            if (videoPreviewAttachmentView.f17338d == null) {
                videoPreviewAttachmentView.f17338d = videoPreviewAttachmentView.f17337c.inflate();
            }
            videoPreviewAttachmentView.f17338d.setVisibility(0);
            videoPreviewAttachmentView.f17338d.setOnClickListener(new C14223(videoPreviewAttachmentView));
        }
    }

    @Inject
    public VideoPreviewAttachmentViewController(ComposerAttachmentViewUtility composerAttachmentViewUtility, InputMethodManager inputMethodManager, VideoCreativeEditingLogger videoCreativeEditingLogger, UnderwoodVideoTranscodingUtil underwoodVideoTranscodingUtil, QeAccessor qeAccessor, Context context, VideoTaggingManagerProvider videoTaggingManagerProvider, ExecutorService executorService, Handler handler, @Assisted DataProvider dataProvider, @Assisted AttachmentsEventListener attachmentsEventListener, @Assisted FragmentManager fragmentManager, @Assisted String str) {
        this.f17354c = composerAttachmentViewUtility;
        this.f17358g = inputMethodManager;
        this.f17359h = videoCreativeEditingLogger;
        this.f17362k = underwoodVideoTranscodingUtil;
        this.f17355d = qeAccessor;
        this.f17356e = context;
        this.f17363l = videoTaggingManagerProvider;
        this.f17364m = executorService;
        this.f17365n = handler;
        this.f17353b = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f17357f = attachmentsEventListener;
        this.f17360i = fragmentManager;
        this.f17361j = str;
        this.f17370s = new VideoPreviewAttachmentView(this.f17356e);
        this.f17370s.f17341g = this;
        this.f17366o = new C14242(this);
    }

    public final void mo1346c(final ComposerAttachment composerAttachment) {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f17353b.get());
        this.f17369r = (ComposerAttachment) Preconditions.checkNotNull(composerAttachment);
        this.f17370s.f17342h = m21240e(this, this.f17369r);
        if (((ProvidesIsComposerDrawn) providesAttachments).B()) {
            m21242p(this);
        }
        this.f17362k.m21171a(this.f17369r, this.f17366o);
        if (this.f17355d.a(ExperimentsForComposerAbTestModule.A, false) || this.f17355d.a(ExperimentsForComposerAbTestModule.B, false)) {
            this.f17368q = ExecutorDetour.a(this.f17364m, new Runnable(this) {
                final /* synthetic */ VideoPreviewAttachmentViewController f17351b;

                public void run() {
                    VideoTaggingManagerProvider videoTaggingManagerProvider = this.f17351b.f17363l;
                    final ImmutableList a = new VideoTaggingManager(AnalyticsLoggerMethodAutoProvider.a(videoTaggingManagerProvider), (Context) videoTaggingManagerProvider.getInstance(Context.class), ImagePipelineFaceRecManager.a(videoTaggingManagerProvider), (GLFrameRetrieverProvider) videoTaggingManagerProvider.getOnDemandAssistedProviderForStaticDi(GLFrameRetrieverProvider.class), this.f17351b.f17355d.a(ExperimentsForComposerAbTestModule.y, 1000), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(videoTaggingManagerProvider), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(videoTaggingManagerProvider)).a(composerAttachment.c(), String.valueOf(composerAttachment.b().c.d()), VideoPreviewAttachmentViewController.m21240e(this.f17351b, composerAttachment), ((VideoItem) composerAttachment.b()).d);
                    if (!a.isEmpty()) {
                        HandlerDetour.a(this.f17351b.f17365n, new Runnable(this) {
                            final /* synthetic */ C14263 f17349b;

                            public void run() {
                                AttachmentEventsListener attachmentEventsListener = this.f17349b.f17351b.f17357f;
                                ComposerAttachment composerAttachment = this.f17349b.f17351b.f17369r;
                                ImmutableList immutableList = a;
                                int indexOf = attachmentEventsListener.f17177a.f17208a.indexOf(composerAttachment);
                                if (indexOf != -1) {
                                    Builder a = Builder.a(composerAttachment);
                                    a.g = ComposerVideoTaggingInfo.newBuilder().setHasFaceboxes(true).setFrames(immutableList).a();
                                    ComposerAttachment a2 = a.a();
                                    AttachmentsViewEventListener attachmentsViewEventListener = attachmentEventsListener.f17177a.f17183B;
                                    ComposerEventOriginator composerEventOriginator = UnderwoodController.f17181d;
                                    attachmentsViewEventListener.m21063a(indexOf, a2, false, false);
                                }
                            }
                        }, -724498384);
                    }
                }
            }, -1506901211);
        }
    }

    public final void mo1353j() {
        this.f17369r = null;
        this.f17370s.f17341g = null;
        this.f17370s.m21234a();
        VideoPreviewAttachmentView videoPreviewAttachmentView = this.f17370s;
        if (videoPreviewAttachmentView.f17338d != null) {
            videoPreviewAttachmentView.f17338d.setVisibility(8);
        }
        this.f17373v = false;
        if (this.f17368q != null) {
            this.f17368q.cancel(true);
        }
    }

    public final boolean mo1342a(ComposerAttachment composerAttachment) {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f17353b.get());
        return (((ProvidesConfiguration) providesAttachments).o().isEdit() || providesAttachments.m() == null || providesAttachments.m().size() != 1 || composerAttachment.b() == null || composerAttachment.b().m() != MediaType.VIDEO || composerAttachment.b().c == null || !this.f17355d.a(ExperimentsForComposerAbTestModule.p, false)) ? false : true;
    }

    public final View mo1351h() {
        return this.f17370s;
    }

    @Nullable
    public final ComposerAttachment mo1352i() {
        return this.f17369r;
    }

    public final void mo1344b(ComposerAttachment composerAttachment) {
        this.f17369r = (ComposerAttachment) Preconditions.checkNotNull(composerAttachment);
    }

    public final void mo1339a() {
        VideoPreviewAttachmentView videoPreviewAttachmentView = this.f17370s;
        UnderwoodAttachmentUtils.m21133a(videoPreviewAttachmentView.f17338d, videoPreviewAttachmentView.f17336b, videoPreviewAttachmentView.f17339e);
    }

    public final float mo1345c() {
        return this.f17369r != null ? m21240e(this, this.f17369r) : 0.0f;
    }

    public final void mo1347d() {
    }

    public final void mo1348e() {
    }

    public final void mo1349f() {
    }

    public final void mo1341a(boolean z) {
    }

    public final void mo1340a(float f) {
        VideoPreviewAttachmentView videoPreviewAttachmentView = this.f17370s;
        videoPreviewAttachmentView.f17343i = f;
        videoPreviewAttachmentView.setScaleX(f);
        videoPreviewAttachmentView.setScaleY(f);
        this.f17370s.setAlpha(f);
    }

    public final float mo1350g() {
        return this.f17370s.f17343i;
    }

    public final void m21245a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f17353b.get());
        if (composerEvent == ComposerEvent.ON_FIRST_DRAW) {
            if (this.f17369r != null) {
                m21242p(this);
            }
        } else if (composerEvent == ComposerEvent.ON_RESUME && ((ProvidesIsComposerDrawn) providesAttachments).B()) {
            this.f17370s.m21236h();
            this.f17370s.m21235g();
        }
    }

    public final void m21259l() {
        this.f17357f.m21139b(this.f17369r);
        m21241o();
    }

    public final void m21260m() {
        m21241o();
    }

    public final void mo1343b() {
        this.f17370s.getGlobalVisibleRect(this.f17367p);
        int height = this.f17367p.height();
        this.f17370s.getHitRect(this.f17367p);
        if (((float) height) / ((float) this.f17367p.height()) > 0.7f) {
            this.f17370s.m21236h();
            this.f17370s.m21235g();
            return;
        }
        VideoPreviewAttachmentView videoPreviewAttachmentView = this.f17370s;
        if (!videoPreviewAttachmentView.f17344j) {
            if (videoPreviewAttachmentView.f17336b.m()) {
                videoPreviewAttachmentView.f17336b.b(EventTriggerType.BY_PLAYER);
            }
            videoPreviewAttachmentView.f17340f.setVisibility(0);
        }
        videoPreviewAttachmentView = this.f17370s;
        if (!videoPreviewAttachmentView.f17344j) {
            videoPreviewAttachmentView.f17340f.setVisibility(8);
        }
    }

    public static float m21240e(VideoPreviewAttachmentViewController videoPreviewAttachmentViewController, ComposerAttachment composerAttachment) {
        return videoPreviewAttachmentViewController.f17354c.m21073a(composerAttachment.b());
    }

    private void m21241o() {
        if (this.f17370s != null) {
            this.f17358g.hideSoftInputFromWindow(this.f17370s.getWindowToken(), 0);
        }
    }

    public static void m21242p(VideoPreviewAttachmentViewController videoPreviewAttachmentViewController) {
        VideoPreviewAttachmentView videoPreviewAttachmentView = videoPreviewAttachmentViewController.f17370s;
        Uri c = videoPreviewAttachmentViewController.f17369r.c();
        VideoCreativeEditingData f = videoPreviewAttachmentViewController.f17369r.f();
        int i = videoPreviewAttachmentViewController.f17374w;
        videoPreviewAttachmentView.f17336b.setPlayerOrigin(PlayerOrigin.COMPOSER);
        videoPreviewAttachmentView.f17336b.a(videoPreviewAttachmentView.f17335a);
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = c;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
        a.o = i;
        a = a;
        a.g = true;
        a = a;
        a.n = true;
        a = a;
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = a.m();
        RichVideoPlayerParams.Builder a2 = builder.a("VideoAspectRatioKey", Double.valueOf((double) videoPreviewAttachmentView.f17342h)).a("CoverImageParamsKey", ImageRequest.a(c));
        if (!(f == null || f.a() == null)) {
            a2.a("TrimStartPosition", Integer.valueOf(f.a().videoTrimStartTimeMs));
            a2.a("TrimEndPosition", Integer.valueOf(f.a().videoTrimEndTimeMs));
        }
        videoPreviewAttachmentView.f17336b.a(a2.b());
        if (f != null) {
            videoPreviewAttachmentView.f17345k = f.b();
            videoPreviewAttachmentView.f17336b.setRotation((float) videoPreviewAttachmentView.f17345k);
        }
        videoPreviewAttachmentViewController.f17374w = 0;
    }
}
