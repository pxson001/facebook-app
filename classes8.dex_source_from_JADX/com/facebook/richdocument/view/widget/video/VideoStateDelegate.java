package com.facebook.richdocument.view.widget.video;

import android.os.Bundle;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.media.plugins.VideoControlsPlugin.VideoStateChangeListener;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerEvent;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerState;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: null pages connection for category %s */
public class VideoStateDelegate {
    private static final Class f7774a = VideoStateDelegate.class;
    private static final VideoPlayerStateMachineFactory f7775b = new VideoPlayerStateMachineFactory();
    public VideoPlayerStateMachine f7776c;
    public RichDocumentVideoPlayer f7777d;
    public Bundle f7778e;
    public LoadingState f7779f;
    public VideoStateChangeListener f7780g;
    public boolean f7781h;
    public boolean f7782i;
    public VideoPlayingAudioPolicy f7783j;
    public boolean f7784k;

    /* compiled from: null pages connection for category %s */
    public class LoadingState {
        final /* synthetic */ VideoStateDelegate f7768a;
        public boolean f7769b;
        public boolean f7770c;
        public boolean f7771d;
        public boolean f7772e;
        public boolean f7773f;

        public LoadingState(VideoStateDelegate videoStateDelegate) {
            this.f7768a = videoStateDelegate;
        }

        public final void m8033b(boolean z) {
            this.f7770c = this.f7769b;
            this.f7769b = z;
            if (this.f7769b) {
                this.f7773f = false;
            }
        }
    }

    public static VideoStateDelegate m8034a(InjectorLike injectorLike) {
        return new VideoStateDelegate();
    }

    public final void m8038a(RichDocumentVideoPlayer richDocumentVideoPlayer, boolean z, boolean z2, boolean z3, boolean z4, VideoPlayingAudioPolicy videoPlayingAudioPolicy) {
        if (m8036g()) {
            m8037a();
        }
        this.f7777d = richDocumentVideoPlayer;
        VideoPlayerStateMachine videoPlayerStateMachine = new VideoPlayerStateMachine();
        VideoPlayerState videoPlayerState;
        if (z) {
            if (z2) {
                videoPlayerState = VideoPlayerStateMachineFactory.f7751d;
                videoPlayerStateMachine.f7747b = videoPlayerState;
                videoPlayerStateMachine.m8016a(videoPlayerState, VideoPlayerEvent.SYSTEM_VIDEO_PLAY, VideoPlayerStateMachineFactory.f7752e);
                videoPlayerStateMachine.m8016a(videoPlayerState, VideoPlayerEvent.USER_CLICK_MEDIA, videoPlayerState);
                if (z3) {
                    videoPlayerStateMachine.m8016a(videoPlayerState, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7752e);
                    videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, videoPlayerState);
                    videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, videoPlayerState);
                }
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7753f);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_CONTROLLER_PAUSED, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_AUTOHIDE_CONTROLS, VideoPlayerStateMachineFactory.f7752e);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, videoPlayerState);
            } else {
                videoPlayerState = VideoPlayerStateMachineFactory.f7751d;
                videoPlayerStateMachine.f7747b = videoPlayerState;
                videoPlayerStateMachine.m8016a(videoPlayerState, VideoPlayerEvent.SYSTEM_VIDEO_PLAY, VideoPlayerStateMachineFactory.f7752e);
                if (z3) {
                    videoPlayerStateMachine.m8016a(videoPlayerState, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7752e);
                    videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, videoPlayerState);
                    videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, videoPlayerState);
                }
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7749b);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, videoPlayerState);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_PRESSED_BACK, VideoPlayerStateMachineFactory.f7752e);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, videoPlayerState);
            }
        } else if (z2) {
            r2 = VideoPlayerStateMachineFactory.f7748a;
            videoPlayerState = z3 ? VideoPlayerStateMachineFactory.f7749b : r2;
            videoPlayerStateMachine.f7747b = r2;
            videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.SYSTEM_VIDEO_PLAY, VideoPlayerStateMachineFactory.f7749b);
            videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            if (z3) {
                videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7750c, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, VideoPlayerStateMachineFactory.f7748a);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7748a, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
            }
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7753f);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7750c, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7753f);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7753f);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_SCROLL_FINISHED, videoPlayerState);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_PRESSED_BACK, videoPlayerState);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_CONTROLLER_PAUSED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.SYSTEM_AUTOHIDE_CONTROLS, VideoPlayerStateMachineFactory.f7752e);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_SCROLL_FINISHED, videoPlayerState);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7753f, VideoPlayerEvent.USER_PRESSED_BACK, videoPlayerState);
        } else {
            r2 = VideoPlayerStateMachineFactory.f7748a;
            videoPlayerState = z3 ? VideoPlayerStateMachineFactory.f7749b : r2;
            videoPlayerStateMachine.f7747b = r2;
            videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.SYSTEM_VIDEO_PLAY, VideoPlayerStateMachineFactory.f7749b);
            videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            if (z3) {
                videoPlayerStateMachine.m8016a(r2, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7750c, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE, r2);
                videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7748a, VideoPlayerEvent.APPLICATION_AUTOPLAY, VideoPlayerStateMachineFactory.f7749b);
            }
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7750c, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7748a, VideoPlayerEvent.USER_CLICK_MEDIA, VideoPlayerStateMachineFactory.f7752e);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7749b, VideoPlayerEvent.USER_UNFOCUSED_MEDIA, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_PAUSE, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.SYSTEM_VIDEO_FINISHED, r2);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_CLICK_MEDIA, videoPlayerState);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_SCROLL_FINISHED, videoPlayerState);
            videoPlayerStateMachine.m8016a(VideoPlayerStateMachineFactory.f7752e, VideoPlayerEvent.USER_PRESSED_BACK, videoPlayerState);
        }
        this.f7776c = videoPlayerStateMachine;
        this.f7779f = new LoadingState(this);
        boolean z5 = z4 && z3;
        this.f7781h = z5;
        this.f7783j = videoPlayingAudioPolicy;
    }

    public final void m8037a() {
        this.f7777d = null;
        this.f7776c = null;
        this.f7778e = null;
        this.f7779f = null;
    }

    private boolean m8036g() {
        return (this.f7777d == null || this.f7776c == null) ? false : true;
    }

    public final boolean m8040b() {
        if (this.f7779f == null) {
            return false;
        }
        return this.f7779f.f7769b;
    }

    public final boolean m8041c() {
        if (this.f7779f == null) {
            return false;
        }
        return this.f7779f.f7771d;
    }

    public final void m8042e() {
        if (this.f7778e != null && this.f7777d != null) {
            this.f7778e.putInt("player_current_position", this.f7777d.getCurrentPositionMs());
        }
    }

    public final boolean m8039a(VideoPlayerEvent videoPlayerEvent) {
        new Object[1][0] = videoPlayerEvent.name();
        if (!m8036g()) {
            return false;
        }
        boolean z = false;
        if (this.f7781h) {
            if (this.f7782i && videoPlayerEvent == VideoPlayerEvent.APPLICATION_AUTOPLAY) {
                z = true;
            } else if (this.f7782i && (videoPlayerEvent == VideoPlayerEvent.APPLICATION_AUTOPLAY_PAUSE || videoPlayerEvent == VideoPlayerEvent.ATTEMPT_TO_PLAY || videoPlayerEvent == VideoPlayerEvent.SYSTEM_VIDEO_PLAY || videoPlayerEvent == VideoPlayerEvent.USER_CLICK_MEDIA)) {
                this.f7782i = false;
            }
        }
        if (z) {
            return false;
        }
        Object obj;
        boolean z2;
        boolean a;
        Object[] objArr;
        if (videoPlayerEvent == VideoPlayerEvent.ATTEMPT_TO_PLAY) {
            if (this.f7780g != null) {
                VideoStateChangeListener videoStateChangeListener = this.f7780g;
                HandlerDetour.a(videoStateChangeListener.f7711a.f7726o, videoStateChangeListener.f7711a.f7728q);
                HandlerDetour.b(videoStateChangeListener.f7711a.f7726o, videoStateChangeListener.f7711a.f7728q, 1000, 1511451695);
            }
            this.f7779f.f7773f = true;
            this.f7779f.m8033b(false);
        }
        if (videoPlayerEvent == VideoPlayerEvent.SYSTEM_LOADING) {
            this.f7779f.m8033b(true);
        } else if (this.f7779f.f7769b || this.f7779f.f7773f) {
            if (videoPlayerEvent == VideoPlayerEvent.SYSTEM_VIDEO_PLAY || videoPlayerEvent == VideoPlayerEvent.SYSTEM_VIDEO_PAUSE || videoPlayerEvent == VideoPlayerEvent.SYSTEM_VIDEO_FINISHED) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f7779f.m8033b(false);
                this.f7779f.f7773f = false;
            }
        }
        LoadingState loadingState = this.f7779f;
        if (this.f7777d.getPlayerState() == State.ERROR) {
            z2 = true;
        } else {
            z2 = false;
        }
        loadingState.f7772e = loadingState.f7771d;
        loadingState.f7771d = z2;
        LoadingState loadingState2 = this.f7779f;
        if (loadingState2.f7771d != loadingState2.f7772e) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            loadingState2 = this.f7779f;
            if (loadingState2.f7769b != loadingState2.f7770c) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                z2 = false;
                if (videoPlayerEvent == VideoPlayerEvent.ATTEMPT_TO_PLAY) {
                    videoPlayerEvent = VideoPlayerEvent.SYSTEM_VIDEO_PLAY;
                }
                a = this.f7776c.m8017a(videoPlayerEvent);
                objArr = new Object[]{Boolean.toString(a), Boolean.toString(z2)};
                if (a || z2) {
                    m8035a(this.f7776c.f7747b);
                    if (this.f7780g != null) {
                        this.f7780g.m7993a(this.f7776c.f7747b, this.f7779f.f7769b, this.f7779f.f7771d);
                    }
                }
                if (a && this.f7781h && videoPlayerEvent == VideoPlayerEvent.USER_CONTROLLER_PAUSED) {
                    this.f7782i = true;
                }
                return a;
            }
        }
        z2 = true;
        if (videoPlayerEvent == VideoPlayerEvent.ATTEMPT_TO_PLAY) {
            videoPlayerEvent = VideoPlayerEvent.SYSTEM_VIDEO_PLAY;
        }
        a = this.f7776c.m8017a(videoPlayerEvent);
        objArr = new Object[]{Boolean.toString(a), Boolean.toString(z2)};
        m8035a(this.f7776c.f7747b);
        if (this.f7780g != null) {
            this.f7780g.m7993a(this.f7776c.f7747b, this.f7779f.f7769b, this.f7779f.f7771d);
        }
        this.f7782i = true;
        return a;
    }

    private void m8035a(VideoPlayerState videoPlayerState) {
        new Object[1][0] = videoPlayerState.toString();
        if (!this.f7779f.f7771d && !this.f7779f.f7769b) {
            if (this.f7783j != null) {
                Object[] objArr = new Object[]{Boolean.valueOf(videoPlayerState.f7740a == PresentationMode.COLLAPSED), Boolean.valueOf(this.f7784k)};
                this.f7777d.m7613a(this.f7783j.mo460a(videoPlayerState.f7740a == PresentationMode.COLLAPSED, this.f7784k));
            }
            if (videoPlayerState.f7741b) {
                if (!this.f7777d.o()) {
                    this.f7777d.iE_();
                }
            } else if (this.f7777d.o()) {
                this.f7777d.b();
            }
        }
    }
}
