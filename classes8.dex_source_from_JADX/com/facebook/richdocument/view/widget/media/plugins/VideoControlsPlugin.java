package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.FadeWithControls;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.transition.ViewAttributes;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewOpacity;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.AnnotationViews;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.video.VideoControlsView;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerEvent;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerState;
import com.facebook.richdocument.view.widget.video.VideoPlayingAudioPolicy;
import com.facebook.richdocument.view.widget.video.VideoSeekBarPlugin;
import com.facebook.richdocument.view.widget.video.VideoSeekBarPlugin.SeekbarPluginHelper;
import com.facebook.richdocument.view.widget.video.VideoSeekBarView;
import com.facebook.richdocument.view.widget.video.VideoStateDelegate;
import com.facebook.richdocument.view.widget.video.VideoStateDelegate.LoadingState;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.plugins.PlaybackController.State;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: num */
public class VideoControlsPlugin extends BaseMediaFramePlugin<Void> {
    private static final SpringConfig f7712d = SpringConfig.b(RichDocumentUIConfig.f6535F, RichDocumentUIConfig.f6536G);
    private static final Class f7713i = VideoControlsPlugin.class;
    @Inject
    public HamDimensions f7714a;
    @Inject
    public SpringSystem f7715b;
    @Inject
    public GatekeeperStoreImpl f7716c;
    private final Spring f7717e;
    private final FadeSpringListener f7718f;
    private final VideoStateChangeListener f7719g = new VideoStateChangeListener(this);
    private final VideoPlayingAudioPolicy f7720h;
    public VideoControlsView f7721j;
    public VideoSeekBarPlugin f7722k;
    public boolean f7723l;
    public boolean f7724m;
    public boolean f7725n;
    public Handler f7726o;
    private Runnable f7727p;
    public Runnable f7728q;
    public VideoStateDelegate f7729r;
    public MutedAutoplayPlugin f7730s;

    /* compiled from: num */
    class C08881 implements Runnable {
        final /* synthetic */ VideoControlsPlugin f7704a;

        C08881(VideoControlsPlugin videoControlsPlugin) {
            this.f7704a = videoControlsPlugin;
        }

        public void run() {
            this.f7704a.m7999a(VideoPlayerEvent.SYSTEM_AUTOHIDE_CONTROLS);
        }
    }

    /* compiled from: num */
    class C08892 implements Runnable {
        final /* synthetic */ VideoControlsPlugin f7705a;

        C08892(VideoControlsPlugin videoControlsPlugin) {
            this.f7705a = videoControlsPlugin;
        }

        public void run() {
            if (VideoControlsPlugin.m7994a(this.f7705a).getPlayerState() == State.ATTEMPT_TO_PLAY) {
                this.f7705a.m7999a(VideoPlayerEvent.SYSTEM_LOADING);
                VideoStateDelegate videoStateDelegate = this.f7705a.f7729r;
                if (videoStateDelegate.f7779f != null) {
                    videoStateDelegate.f7779f.f7773f = false;
                }
            }
        }
    }

    /* compiled from: num */
    public class C08903 implements OnClickListener {
        final /* synthetic */ VideoControlsPlugin f7706a;

        public C08903(VideoControlsPlugin videoControlsPlugin) {
            this.f7706a = videoControlsPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 672978619);
            RichDocumentVideoPlayer a2 = VideoControlsPlugin.m7994a(this.f7706a);
            if (this.f7706a.f7725n && (this.f7706a.f7729r.m8040b() || this.f7706a.f7729r.m8041c())) {
                this.f7706a.f7721j.m8011a();
            } else if (a2.m()) {
                this.f7706a.f7729r.m8042e();
                this.f7706a.mo447a(Event.CONTROLLER_PAUSE);
            } else {
                VideoStateDelegate videoStateDelegate = this.f7706a.f7729r;
                if (!(videoStateDelegate.f7778e == null || videoStateDelegate.f7777d == null)) {
                    videoStateDelegate.f7777d.a(videoStateDelegate.f7778e.getInt("player_current_position"), EventTriggerType.BY_AUTOPLAY);
                }
                this.f7706a.mo447a(Event.CLICK_MEDIA);
            }
            LogUtils.a(957508152, a);
        }
    }

    /* compiled from: num */
    class FadeSpringListener extends SimpleSpringListener {
        final /* synthetic */ VideoControlsPlugin f7708a;
        private VideoControlsView.State f7709b;
        private boolean f7710c;

        public FadeSpringListener(VideoControlsPlugin videoControlsPlugin) {
            this.f7708a = videoControlsPlugin;
        }

        public final void m7990a(VideoControlsView.State state, boolean z) {
            this.f7709b = state;
            this.f7710c = z;
        }

        public final void m7991a(Spring spring) {
            VideoControlsPlugin.m7995a(this.f7708a, (float) spring.d());
        }

        public final void m7992b(Spring spring) {
            super.b(spring);
            this.f7708a.f7721j.m8012a(this.f7709b, this.f7710c);
        }
    }

    /* compiled from: num */
    public class VideoStateChangeListener {
        public final /* synthetic */ VideoControlsPlugin f7711a;

        public VideoStateChangeListener(VideoControlsPlugin videoControlsPlugin) {
            this.f7711a = videoControlsPlugin;
        }

        public final void m7993a(VideoPlayerState videoPlayerState, boolean z, boolean z2) {
            VideoControlsPlugin.m7996a(this.f7711a, videoPlayerState);
            VideoControlsPlugin videoControlsPlugin = this.f7711a;
            if (videoControlsPlugin.f7730s != null) {
                videoControlsPlugin.f7730s.m7978l();
            }
            videoControlsPlugin = this.f7711a;
            String str = "Target state = %s, isLoading = %s, isError = %s";
            Object[] objArr = new Object[]{videoPlayerState.toString(), Boolean.toString(z), Boolean.toString(z2)};
        }
    }

    public static void m7997a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        VideoControlsPlugin videoControlsPlugin = (VideoControlsPlugin) obj;
        HamDimensions a = HamDimensions.m5268a(injectorLike);
        SpringSystem b = SpringSystem.b(injectorLike);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        videoControlsPlugin.f7714a = a;
        videoControlsPlugin.f7715b = b;
        videoControlsPlugin.f7716c = a2;
    }

    public VideoControlsPlugin(MediaFrame mediaFrame, VideoPlayingAudioPolicy videoPlayingAudioPolicy) {
        super(mediaFrame);
        Class cls = VideoControlsPlugin.class;
        m7997a((Object) this, getContext());
        this.f7720h = videoPlayingAudioPolicy;
        Spring c = this.f7715b.a().a(f7712d).c(0.0d);
        c.c = true;
        this.f7717e = c.l();
        this.f7718f = new FadeSpringListener(this);
        this.f7717e.a(this.f7718f);
        this.f7726o = new Handler();
        this.f7727p = new C08881(this);
        this.f7725n = this.f7716c.a(695, false);
        if (this.f7725n) {
            this.f7728q = new C08892(this);
        }
    }

    public static void m7995a(VideoControlsPlugin videoControlsPlugin, float f) {
        ViewLayout currentLayout = videoControlsPlugin.f7617a.getCurrentLayout();
        AnnotationViews annotationViews = videoControlsPlugin.f7617a.getBody().getAnnotationViews();
        State playerState = m7994a(videoControlsPlugin).getPlayerState();
        Iterator it = annotationViews.iterator();
        while (it.hasNext()) {
            AnnotationView annotationView = (AnnotationView) it.next();
            if (((FadeWithControls) currentLayout.mo428a(annotationView.mo438b(), ViewAttributeType.FADES_WITH_CONTROLS, FadeWithControls.class)).f6955a.booleanValue()) {
                float f2;
                View b = annotationView.mo438b();
                if ((b instanceof VideoSeekBarView) && (playerState == State.PAUSED || playerState == State.PREPARED || playerState == State.ERROR || playerState == State.PLAYBACK_COMPLETE)) {
                    f2 = 0.0f;
                } else {
                    f2 = f;
                }
                b.setAlpha(f2);
                ViewAttributes a = currentLayout.mo429a(b);
                if (a != null) {
                    a.m7297a(new ViewOpacity(f2));
                }
                if (f2 <= RichDocumentUIConfig.f6566s) {
                    b.setVisibility(8);
                } else {
                    b.setVisibility(0);
                }
                b.invalidate();
            }
        }
    }

    public final void mo509d() {
        VideoStateDelegate videoStateDelegate = this.f7729r;
        videoStateDelegate.f7780g = this.f7719g;
        if (videoStateDelegate.f7780g != null && videoStateDelegate.f7776c != null && videoStateDelegate.f7776c.f7747b != null) {
            videoStateDelegate.f7780g.m7993a(videoStateDelegate.f7776c.f7747b, false, false);
        }
    }

    public final void mo510e() {
        if (this.f7725n) {
            HandlerDetour.a(this.f7726o, this.f7727p);
            HandlerDetour.a(this.f7726o, this.f7728q);
            if (this.f7721j != null) {
                this.f7721j.m8015e();
            }
        }
    }

    public final void mo508c() {
        this.f7723l = false;
        this.f7724m = true;
        if (this.f7725n && this.f7729r != null) {
            VideoStateDelegate videoStateDelegate = this.f7729r;
            if (videoStateDelegate.f7779f != null) {
                LoadingState loadingState = videoStateDelegate.f7779f;
                loadingState.f7769b = false;
                loadingState.f7770c = false;
                loadingState.f7771d = false;
                loadingState.f7772e = false;
                loadingState.f7773f = false;
            }
        }
    }

    public final boolean mo447a(Event event) {
        switch (event) {
            case CLICK_MEDIA:
                return m7999a(VideoPlayerEvent.USER_CLICK_MEDIA);
            case SCROLL_FINISHED:
                return m7999a(VideoPlayerEvent.USER_SCROLL_FINISHED);
            case BACK:
                return m7999a(VideoPlayerEvent.USER_PRESSED_BACK);
            case UNFOCUSED:
                return m7999a(VideoPlayerEvent.USER_UNFOCUSED_MEDIA);
            case CONTROLLER_PAUSE:
                return m7999a(VideoPlayerEvent.USER_CONTROLLER_PAUSED);
            case AUTOPLAY:
                return m7999a(VideoPlayerEvent.APPLICATION_AUTOPLAY);
            default:
                return false;
        }
    }

    public final void mo506b(ViewLayout viewLayout) {
        if (this.f7724m) {
            m7995a(this, (float) this.f7717e.d());
        }
    }

    public final boolean m7999a(VideoPlayerEvent videoPlayerEvent) {
        new Object[1][0] = videoPlayerEvent.name();
        if (this.f7722k != null) {
            Object obj;
            SeekbarPluginHelper seekbarPluginHelper = this.f7722k.f7762o;
            if (seekbarPluginHelper.f7758a == SeekbarPluginHelper.State.CONSUMING_PAUSE && videoPlayerEvent == VideoPlayerEvent.SYSTEM_VIDEO_PAUSE) {
                obj = 1;
            } else {
                seekbarPluginHelper.f7758a = SeekbarPluginHelper.State.IDLE;
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        if (this.f7729r == null) {
            return false;
        }
        return this.f7729r.m8039a(videoPlayerEvent);
    }

    public static void m7996a(VideoControlsPlugin videoControlsPlugin, VideoPlayerState videoPlayerState) {
        PresentationMode presentationMode = videoPlayerState.f7740a;
        boolean z = videoPlayerState.f7741b;
        boolean z2 = videoPlayerState.f7742c;
        PresentationMode presentationMode2 = PresentationMode.COLLAPSED;
        if (videoControlsPlugin.f7725n) {
            if (videoControlsPlugin.f7729r.m8041c() || videoControlsPlugin.f7729r.m8040b()) {
                videoControlsPlugin.f7721j.m8012a(VideoControlsView.State.PLAY_ICON, true);
                videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.PLAY_ICON, true);
                videoControlsPlugin.f7717e.b(1.0d);
            } else if (z2) {
                if (z) {
                    videoControlsPlugin.f7721j.m8012a(VideoControlsView.State.PAUSE_ICON, false);
                    videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.PAUSE_ICON, false);
                    HandlerDetour.b(videoControlsPlugin.f7726o, videoControlsPlugin.f7727p, 3000, -1464562956);
                } else {
                    videoControlsPlugin.f7721j.m8012a(VideoControlsView.State.PLAY_ICON, false);
                    videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.PLAY_ICON, false);
                }
                videoControlsPlugin.f7717e.b(1.0d);
            } else {
                videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.NONE, false);
                videoControlsPlugin.f7717e.b(0.0d);
            }
        } else if (z2) {
            if (z) {
                videoControlsPlugin.f7721j.m8012a(VideoControlsView.State.PAUSE_ICON, false);
                videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.PAUSE_ICON, false);
                HandlerDetour.b(videoControlsPlugin.f7726o, videoControlsPlugin.f7727p, 3000, 1622138882);
            } else {
                videoControlsPlugin.f7721j.m8012a(VideoControlsView.State.PLAY_ICON, false);
                videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.PLAY_ICON, false);
            }
            videoControlsPlugin.f7717e.b(1.0d);
        } else {
            videoControlsPlugin.f7718f.m7990a(VideoControlsView.State.NONE, false);
            videoControlsPlugin.f7717e.b(0.0d);
        }
        if (!videoControlsPlugin.m7896j().f6981e.equals(presentationMode)) {
            if (presentationMode == PresentationMode.COLLAPSED) {
                videoControlsPlugin.f7617a.mo478a(MediaTransitionState.f6977a);
            } else {
                videoControlsPlugin.f7617a.mo478a(MediaTransitionState.f6978b);
            }
        }
    }

    public static RichDocumentVideoPlayer m7994a(VideoControlsPlugin videoControlsPlugin) {
        return (RichDocumentVideoPlayer) videoControlsPlugin.m7895i();
    }
}
