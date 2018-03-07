package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.RichDocumentContextWrapper;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFragmentLifeCycleSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentMediaTransitionEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.AutoplayCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.AutoplayCandidateRegisterEvent.RequestType;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent.FragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.richdocument.event.RichDocumentSessionEvent;
import com.facebook.richdocument.event.RichDocumentSessionEvent.Action;
import com.facebook.richdocument.event.RichDocumentSessionEventBus;
import com.facebook.richdocument.event.RichDocumentSessionEventSubscriber;
import com.facebook.richdocument.event.StartupStateMachine;
import com.facebook.richdocument.gk.RichDocumentGatekeepers;
import com.facebook.richdocument.logging.ImagePerfLogger;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.presenter.VideoBlockPresenter;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationListener;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationOffsetParams;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationOffsetParams.Unit;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.FeedbackAware;
import com.facebook.richdocument.view.block.LocationAnnotationAware;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.widget.RichDocumentCoverImagePlugin.RichDocumentCoverImageParams;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer.VideoCoverImageListener;
import com.facebook.richdocument.view.widget.UFIView.ComposerLaunchParams;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.ImageInteractionMonitorPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MutedAutoplayPlugin;
import com.facebook.richdocument.view.widget.media.plugins.VideoControlsPlugin;
import com.facebook.richdocument.view.widget.media.plugins.VideoControlsPlugin.C08903;
import com.facebook.richdocument.view.widget.video.VideoControlsSyncPlugin;
import com.facebook.richdocument.view.widget.video.VideoControlsView;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerEvent;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy;
import com.facebook.richdocument.view.widget.video.VideoSeekBarPlugin;
import com.facebook.richdocument.view.widget.video.VideoStateDelegate;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.IsVideoSpecDisplayEnabled;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.DebugConsolePlugin;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: page_info_card */
public class VideoBlockViewImpl extends MediaBlockView<VideoBlockPresenter, RichDocumentVideoPlayer> implements VideoBlockView, VideoCoverImageListener, FeedbackAware, LocationAnnotationAware, TextAnnotationAware, VideoCoverImageListener {
    @Inject
    VideoPlayingAudioPolicy f6685A;
    @Inject
    GatekeeperStoreImpl f6686B;
    @Inject
    RichDocumentAnalyticsLogger f6687C;
    @Inject
    RichDocumentSessionEventBus f6688D;
    @Inject
    VideoStateDelegate f6689E;
    public boolean f6690F;
    protected VideoControlsPlugin f6691G;
    protected boolean f6692H;
    public int f6693I = 0;
    public String f6694J;
    public String f6695K;
    public final List<Runnable> f6696L = new ArrayList();
    private final RichDocumentStartupUiTasksCompletedSubscriber f6697M = new C07661(this);
    private final RichDocumentFragmentLifeCycleSubscriber f6698N = new C07672(this);
    private final RichDocumentMediaTransitionEventSubscriber f6699O = new C07683(this);
    private final SessionEventHandler f6700P = new SessionEventHandler(this);
    private int f6701Q;
    private int f6702R;
    private String f6703S;
    private String f6704T;
    private GraphQLDocumentMediaPresentationStyle f6705U;
    private boolean f6706V;
    private final boolean f6707a;
    private final boolean f6708b;
    private final boolean f6709c;
    private final boolean f6710d;
    private final boolean f6711j;
    private final boolean f6712k;
    public boolean f6713l;
    private VideoControlsSyncPlugin f6714m;
    private DebugConsolePlugin f6715n;
    private VideoSeekBarPlugin f6716o;
    private MutedAutoplayPlugin f6717p;
    private VideoControlsView f6718q;
    public VideoOnPauseState f6719r;
    private Bundle f6720s;
    @Inject
    VideoAutoPlaySettingsChecker f6721t;
    @Inject
    StartupStateMachine f6722u;
    @Inject
    RichDocumentEventBus f6723v;
    @Inject
    GatekeeperStoreImpl f6724w;
    @Inject
    QeAccessor f6725x;
    @Inject
    @IsVideoSpecDisplayEnabled
    Boolean f6726y;
    @Inject
    ImagePerfLogger f6727z;

    /* compiled from: page_info_card */
    class C07661 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ VideoBlockViewImpl f6809a;

        C07661(VideoBlockViewImpl videoBlockViewImpl) {
            this.f6809a = videoBlockViewImpl;
        }

        public final void m7101b(FbEvent fbEvent) {
            for (Runnable run : this.f6809a.f6696L) {
                run.run();
            }
            this.f6809a.f6696L.clear();
            this.f6809a.f6723v.b(this);
        }
    }

    /* compiled from: page_info_card */
    class C07672 extends RichDocumentFragmentLifeCycleSubscriber {
        final /* synthetic */ VideoBlockViewImpl f6810a;

        C07672(VideoBlockViewImpl videoBlockViewImpl) {
            this.f6810a = videoBlockViewImpl;
        }

        public final void m7102b(FbEvent fbEvent) {
            FragmentLifeCycleEvent fragmentLifeCycleEvent = ((RichDocumentFragmentLifeCycleEvent) fbEvent).f5175a;
            VideoBlockViewImpl videoBlockViewImpl;
            if (fragmentLifeCycleEvent == FragmentLifeCycleEvent.ON_RESUME) {
                videoBlockViewImpl = this.f6810a;
                if (videoBlockViewImpl.f6719r != null && videoBlockViewImpl.f6719r.f6821a) {
                    RichDocumentVideoPlayer D = videoBlockViewImpl.m7029D();
                    videoBlockViewImpl.m7029D().iE_();
                    D.a((int) videoBlockViewImpl.f6719r.f6822b, EventTriggerType.BY_AUTOPLAY);
                }
            } else if (fragmentLifeCycleEvent == FragmentLifeCycleEvent.ON_PAUSE) {
                videoBlockViewImpl = this.f6810a;
                videoBlockViewImpl.f6719r = new VideoOnPauseState(videoBlockViewImpl.m7029D());
                videoBlockViewImpl.m7029D().b();
            }
        }
    }

    /* compiled from: page_info_card */
    class C07683 extends RichDocumentMediaTransitionEventSubscriber {
        final /* synthetic */ VideoBlockViewImpl f6811a;

        C07683(VideoBlockViewImpl videoBlockViewImpl) {
            this.f6811a = videoBlockViewImpl;
        }

        public final void m7103b(FbEvent fbEvent) {
            boolean z;
            boolean z2;
            boolean z3;
            RichDocumentMediaTransitionEvent richDocumentMediaTransitionEvent = (RichDocumentMediaTransitionEvent) fbEvent;
            boolean z4 = true;
            MediaTransitionState mediaTransitionState = richDocumentMediaTransitionEvent.f5177b;
            if (mediaTransitionState.f6981e == PresentationMode.EXPANDED) {
                z = true;
            } else {
                z = false;
            }
            if (mediaTransitionState.f6982f == Orientation.PORTRAIT) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (richDocumentMediaTransitionEvent.f5176a == this.f6811a.f6634a) {
                z3 = true;
            } else {
                z3 = false;
            }
            RichDocumentVideoPlayer D = this.f6811a.m7029D();
            if (z3) {
                VideoPlayingAudioPolicy a = this.f6811a.mo399a(this.f6811a.f6686B);
                if (z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                D.m7613a(a.mo460a(z3, !z2));
                VideoStateDelegate videoStateDelegate = this.f6811a.f6689E;
                if (z2) {
                    z4 = false;
                }
                videoStateDelegate.f7784k = z4;
            } else if (z) {
                this.f6811a.f6689E.m8039a(VideoPlayerEvent.USER_UNFOCUSED_MEDIA);
            }
        }
    }

    /* compiled from: page_info_card */
    class SessionEventHandler extends RichDocumentSessionEventSubscriber {
        final /* synthetic */ VideoBlockViewImpl f6820a;

        public SessionEventHandler(VideoBlockViewImpl videoBlockViewImpl) {
            this.f6820a = videoBlockViewImpl;
        }

        public final void m7106b(FbEvent fbEvent) {
            if (((RichDocumentSessionEvent) fbEvent).f5186a == Action.OPEN_DOCUMENT) {
                RichDocumentVideoPlayer D = this.f6820a.m7029D();
                if (D != null && D.o()) {
                    VideoBlockViewImpl videoBlockViewImpl = this.f6820a;
                    videoBlockViewImpl.f6719r = new VideoOnPauseState(videoBlockViewImpl.m7029D());
                    videoBlockViewImpl.m7029D().b();
                }
            }
        }
    }

    /* compiled from: page_info_card */
    public class VideoOnPauseState {
        public final boolean f6821a;
        public final long f6822b;

        public VideoOnPauseState(RichDocumentVideoPlayer richDocumentVideoPlayer) {
            this.f6821a = richDocumentVideoPlayer.m();
            this.f6822b = (long) richDocumentVideoPlayer.getCurrentPositionMs();
        }
    }

    public static void m7025a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VideoBlockViewImpl) obj).m7024a(VideoAutoPlaySettingsChecker.a(injectorLike), StartupStateMachine.m5147a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(injectorLike), ImagePerfLogger.m5347a(injectorLike), VideoPlayingAudioPolicy.m7495b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), RichDocumentAnalyticsLogger.m5360a(injectorLike), RichDocumentSessionEventBus.m5143a(injectorLike), VideoStateDelegate.m8034a(injectorLike));
    }

    private void m7024a(VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, StartupStateMachine startupStateMachine, RichDocumentEventBus richDocumentEventBus, GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor, Boolean bool, ImagePerfLogger imagePerfLogger, VideoPlayingAudioPolicy videoPlayingAudioPolicy, GatekeeperStoreImpl gatekeeperStoreImpl2, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, RichDocumentSessionEventBus richDocumentSessionEventBus, VideoStateDelegate videoStateDelegate) {
        this.f6721t = videoAutoPlaySettingsChecker;
        this.f6722u = startupStateMachine;
        this.f6723v = richDocumentEventBus;
        this.f6724w = gatekeeperStoreImpl;
        this.f6725x = qeAccessor;
        this.f6726y = bool;
        this.f6727z = imagePerfLogger;
        this.f6685A = videoPlayingAudioPolicy;
        this.f6686B = gatekeeperStoreImpl2;
        this.f6687C = richDocumentAnalyticsLogger;
        this.f6688D = richDocumentSessionEventBus;
        this.f6689E = videoStateDelegate;
    }

    public VideoBlockViewImpl(MediaFrame mediaFrame, View view) {
        super(mediaFrame, view);
        Class cls = VideoBlockViewImpl.class;
        m7025a((Object) this, getContext());
        this.f6690F = this.f6724w.a(RichDocumentGatekeepers.f5291a, false);
        this.f6707a = this.f6724w.a(703, false);
        this.f6713l = true;
        this.f6708b = this.f6686B.a(68, false);
        this.f6710d = this.f6686B.a(111, false);
        boolean z = this.f6710d || this.f6725x.a(ExperimentsForRichDocumentAbtestModule.t, false);
        this.f6709c = z;
        this.f6711j = this.f6725x.a(ExperimentsForRichDocumentAbtestModule.c, false);
        this.f6712k = this.f6725x.a(ExperimentsForRichDocumentAbtestModule.b, true);
        RichDocumentVideoPlayer D = m7029D();
        D.f7365n = this.f6690F;
        D.f7364m = mo399a(this.f6686B);
        mo400a(mediaFrame);
        this.f6723v.a(this.f6697M);
        this.f6723v.a(this.f6698N);
        if (this.f6724w.a(106, false)) {
            this.f6718q = VideoControlsView.m8010a(getContext(), this.f6634a.mo480b());
            this.f6716o = new VideoSeekBarPlugin(getContext());
        }
    }

    protected void mo400a(MediaFrame mediaFrame) {
        m6983a(new MediaTiltPlugin(mediaFrame));
        m6983a(new MapUnderlayPlugin(mediaFrame));
        m6983a(new ImageInteractionMonitorPlugin(mediaFrame));
        if (this.f6690F) {
            this.f6691G = new VideoControlsPlugin(mediaFrame, mo399a(this.f6686B));
            m6983a(this.f6691G);
            this.f6714m = new VideoControlsSyncPlugin(getContext());
            this.f6714m.f7736c = this.f6691G;
            m7029D().a(this.f6714m);
        }
        if (this.f6726y.booleanValue()) {
            this.f6715n = new DebugConsolePlugin(getContext());
            m7029D().a(this.f6715n);
        }
        if (m7033H()) {
            this.f6717p = new MutedAutoplayPlugin(mediaFrame);
            m6983a(this.f6717p);
            if (this.f6691G != null) {
                this.f6691G.f7730s = this.f6717p;
            }
        }
    }

    public void mo378b(final Bundle bundle) {
        super.mo378b(bundle);
        this.f6727z.m5350a(this.f6704T, this.f6701Q, this.f6702R, this.f6705U, this.f6706V, this.f6706V);
        m7047h(bundle);
        this.f6720s = bundle;
        this.f6635e.m6902a(m7029D(), new ViewLocationOffsetParams(Unit.PERCENTAGE, this.f6693I), new ViewLocationListener(this) {
            final /* synthetic */ VideoBlockViewImpl f6813b;

            public final void mo372a() {
                this.f6813b.mo402f(bundle);
                this.f6813b.f6687C.m5365a(this.f6813b.f6694J, this.f6813b.f6695K);
            }

            public final void mo373b() {
                this.f6813b.mo403g(bundle);
            }
        });
        this.f6723v.a(this.f6699O);
        this.f6688D.a(this.f6700P);
    }

    public final void m7047h(Bundle bundle) {
        this.f6689E.f7778e = bundle;
    }

    public void mo402f(final Bundle bundle) {
        Runnable c07705 = new Runnable(this) {
            final /* synthetic */ VideoBlockViewImpl f6816c;

            public void run() {
                if (!this.f6816c.m7030E()) {
                    return;
                }
                if (this.f6816c.m7032G()) {
                    this.f6816c.f6723v.a(new AutoplayCandidateRegisterEvent(this, RequestType.REGISTER));
                } else {
                    this.f6816c.mo401e(bundle);
                }
            }
        };
        if (!this.f6722u.m5152b()) {
            this.f6696L.add(c07705);
        } else if (((RichDocumentVideoPlayer) m6992h()).getView() != null) {
            ((RichDocumentVideoPlayer) m6992h()).getView().post(c07705);
        } else {
            this.f6602a.a.post(c07705);
        }
    }

    public void mo403g(final Bundle bundle) {
        Runnable c07716 = new Runnable(this) {
            final /* synthetic */ VideoBlockViewImpl f6819c;

            public void run() {
                if (this.f6819c.m7032G()) {
                    RichDocumentVideoPlayer D = this.f6819c.m7029D();
                    if (D != null && D.m()) {
                        this.f6819c.f6689E.m8042e();
                    }
                    this.f6819c.f6689E.m8039a(VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE);
                    this.f6819c.f6723v.a(new AutoplayCandidateRegisterEvent(this, RequestType.UNREGISTER));
                    return;
                }
                VideoBlockViewImpl videoBlockViewImpl = this.f6819c;
                Bundle bundle = bundle;
                RichDocumentVideoPlayer D2 = videoBlockViewImpl.m7029D();
                if (D2 != null) {
                    if (bundle != null) {
                        bundle.putInt("player_current_position", D2.getCurrentPositionMs());
                    }
                    D2.b();
                }
            }
        };
        if (!this.f6722u.m5152b()) {
            this.f6696L.add(c07716);
        } else if (((RichDocumentVideoPlayer) m6992h()).getView() != null) {
            ((RichDocumentVideoPlayer) m6992h()).getView().post(c07716);
        } else {
            this.f6602a.a.post(c07716);
        }
    }

    public void mo379c(Bundle bundle) {
        super.mo379c(bundle);
        this.f6635e.m6901a(m7029D());
        this.f6723v.b(this.f6699O);
        this.f6688D.b(this.f6700P);
        mo403g(this.f6720s);
    }

    public void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6706V = false;
        ((RichDocumentVideoPlayer) m6992h()).m7616u();
        this.f6719r = null;
        this.f6720s = null;
        this.f6689E.m8037a();
        this.f6703S = null;
    }

    public void m7037a(VideoBlockInput videoBlockInput, String str) {
        boolean z;
        this.f6704T = str;
        this.f6703S = videoBlockInput.f5645a;
        this.f6705U = videoBlockInput.f5654j;
        this.f6701Q = videoBlockInput.f5651g;
        this.f6702R = videoBlockInput.f5652h;
        ImageInteractionMonitorPlugin imageInteractionMonitorPlugin = (ImageInteractionMonitorPlugin) m6975a(ImageInteractionMonitorPlugin.class);
        if (imageInteractionMonitorPlugin != null) {
            imageInteractionMonitorPlugin.f7639b = str;
        }
        m6982a(BlockViewUtil.m6916a(this.f6705U));
        if (videoBlockInput.f5655k == GraphQLDocumentVideoAutoplayStyle.AUTOPLAY && this.f6721t.a()) {
            z = true;
        } else {
            z = false;
        }
        this.f6692H = z;
        m7042c(videoBlockInput);
        m7040b(videoBlockInput);
        RichDocumentVideoPlayer D = m7029D();
        VideoPlugin videoPlugin = (VideoPlugin) D.a(VideoPlugin.class);
        if (videoBlockInput.f5653i || videoPlugin == null) {
            D.i();
            D.a(new Video360Plugin(getContext()));
        }
        double d = (double) ((1.0f * ((float) videoBlockInput.f5647c)) / ((float) videoBlockInput.f5648d));
        Builder builder = new Builder();
        builder.b("CoverImageParamsKey", new RichDocumentCoverImageParams(videoBlockInput.f5649e, videoBlockInput.f5650f, videoBlockInput.f5651g, videoBlockInput.f5652h)).b("VideoAspectRatioKey", Double.valueOf(d));
        D.a(m7035a(videoBlockInput.f5646b, builder));
        D.m7612a(videoBlockInput.f5647c, videoBlockInput.f5648d);
        if (this.f6717p != null) {
            this.f6717p.m7977k();
        }
        D.f7362k = this;
    }

    protected RichVideoPlayerParams m7035a(VideoPlayerParams videoPlayerParams, Builder<String, Object> builder) {
        RichVideoPlayerParams.Builder builder2 = new RichVideoPlayerParams.Builder();
        builder2.a = videoPlayerParams;
        return builder2.a(builder.b()).b();
    }

    protected final void m7040b(VideoBlockInput videoBlockInput) {
        boolean z = false;
        if (this.f6690F) {
            boolean z2;
            if (this.f6718q == null) {
                this.f6718q = VideoControlsView.m8010a(getContext(), this.f6634a.mo480b());
            }
            this.f6634a.mo407a(this.f6718q);
            if (videoBlockInput.f5656l == GraphQLDocumentVideoControlStyle.CONTROLS) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!videoBlockInput.f5653i) {
                z = z2;
            }
            if (z && this.f6713l && this.f6707a) {
                if (this.f6716o == null) {
                    this.f6716o = new VideoSeekBarPlugin(getContext());
                }
                m7029D().a(this.f6716o);
                View view = this.f6716o.f7761n;
                this.f6634a.mo407a(view);
                this.f6638h.m6924a(view);
                this.f6691G.f7722k = this.f6716o;
            }
            VideoControlsPlugin videoControlsPlugin = this.f6691G;
            Object obj = this.f6718q;
            boolean z3 = this.f6692H;
            VideoStateDelegate videoStateDelegate = this.f6689E;
            videoControlsPlugin.f7721j = obj;
            videoControlsPlugin.f7723l = z3;
            videoControlsPlugin.f7724m = z;
            videoControlsPlugin.f7729r = videoStateDelegate;
            obj.setOnClickListener(new C08903(videoControlsPlugin));
            int b = videoControlsPlugin.f7714a.m5276b(2131558723);
            RichDocumentTouch.m7189a(obj, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(2));
        }
    }

    protected final void m7042c(VideoBlockInput videoBlockInput) {
        boolean z;
        boolean z2;
        if (videoBlockInput.f5654j == GraphQLDocumentMediaPresentationStyle.FULL_SCREEN) {
            z = true;
        } else {
            z = false;
        }
        if (videoBlockInput.f5656l == GraphQLDocumentVideoControlStyle.CONTROLS) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f6689E.m8038a(m7029D(), z, z2, this.f6692H, true, mo399a(this.f6686B));
    }

    public void mo401e(Bundle bundle) {
        RichDocumentVideoPlayer D = m7029D();
        if (D != null) {
            D.a(bundle.getInt("player_current_position"), EventTriggerType.BY_AUTOPLAY);
            this.f6689E.m8039a(VideoPlayerEvent.APPLICATION_AUTOPLAY);
        }
    }

    public final View m7026A() {
        return m7029D();
    }

    public final boolean m7027B() {
        if (!m7030E()) {
            return false;
        }
        if (m7029D().getPlayerState() == State.PREPARED || m7029D().m7618w()) {
            return true;
        }
        return false;
    }

    public final void m7028C() {
        this.f6689E.m8039a(VideoPlayerEvent.APPLICATION_AUTOPLAY);
    }

    public RichDocumentVideoPlayer m7029D() {
        return (RichDocumentVideoPlayer) m6992h();
    }

    protected boolean m7030E() {
        return this.f6692H;
    }

    public final void mo398F() {
        this.f6706V = true;
        this.f6727z.m5351a(this.f6704T, RichDocumentContextWrapper.m5021a(getContext()), this.f6711j, this.f6712k);
    }

    protected VideoPlayingAudioPolicy mo399a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return this.f6685A;
    }

    protected boolean m7032G() {
        return this.f6709c;
    }

    protected boolean m7033H() {
        return this.f6708b;
    }

    protected final ComposerLaunchParams mo397d() {
        return BlockViewUtil.m6917a(this.f6703S, 82650203);
    }
}
