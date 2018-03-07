package com.facebook.richdocument.view.widget.video;

import com.facebook.common.util.HashCodeUtil;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: null_state_see_more */
public class VideoPlayerStateMachine {
    private final List<VideoPlayerTransition> f7746a = new ArrayList();
    public VideoPlayerState f7747b;

    /* compiled from: null_state_see_more */
    public enum VideoPlayerEvent {
        SYSTEM_VIDEO_PLAY,
        SYSTEM_VIDEO_PAUSE,
        SYSTEM_VIDEO_FINISHED,
        SYSTEM_AUTOHIDE_CONTROLS,
        ATTEMPT_TO_PLAY,
        SYSTEM_LOADING,
        USER_CLICK_MEDIA,
        USER_SCROLL_FINISHED,
        USER_PRESSED_BACK,
        USER_UNFOCUSED_MEDIA,
        USER_CONTROLLER_PAUSED,
        APPLICATION_AUTOPLAY,
        APPLICATION_AUTOPLAY_PAUSE
    }

    /* compiled from: null_state_see_more */
    public class VideoPlayerState {
        public final PresentationMode f7740a;
        public final boolean f7741b;
        public final boolean f7742c;

        public VideoPlayerState(PresentationMode presentationMode, boolean z, boolean z2) {
            this.f7740a = presentationMode;
            this.f7741b = z;
            this.f7742c = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VideoPlayerState videoPlayerState = (VideoPlayerState) obj;
            if (this.f7740a.equals(videoPlayerState.f7740a) && this.f7741b == videoPlayerState.f7741b && this.f7742c == videoPlayerState.f7742c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return HashCodeUtil.a(this.f7740a, Boolean.valueOf(this.f7741b), Boolean.valueOf(this.f7742c));
        }

        public String toString() {
            return "{mode: " + this.f7740a + ", playing: " + this.f7741b + ", controls: " + this.f7742c + "}";
        }
    }

    /* compiled from: null_state_see_more */
    public class VideoPlayerTransition {
        public VideoPlayerState f7743a;
        public VideoPlayerEvent f7744b;
        public VideoPlayerState f7745c;

        public VideoPlayerTransition(VideoPlayerState videoPlayerState, VideoPlayerEvent videoPlayerEvent, VideoPlayerState videoPlayerState2) {
            this.f7743a = videoPlayerState;
            this.f7744b = videoPlayerEvent;
            this.f7745c = videoPlayerState2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VideoPlayerTransition videoPlayerTransition = (VideoPlayerTransition) obj;
            if (this.f7743a.equals(videoPlayerTransition.f7743a) && this.f7744b.equals(videoPlayerTransition.f7744b) && this.f7745c.equals(videoPlayerTransition.f7745c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return HashCodeUtil.a(this.f7743a, this.f7744b, this.f7745c);
        }
    }

    public final void m8016a(VideoPlayerState videoPlayerState, VideoPlayerEvent videoPlayerEvent, VideoPlayerState videoPlayerState2) {
        for (int size = this.f7746a.size() - 1; size >= 0; size--) {
            VideoPlayerTransition videoPlayerTransition = (VideoPlayerTransition) this.f7746a.get(size);
            if (videoPlayerTransition.f7743a.equals(videoPlayerState) && videoPlayerTransition.f7744b.equals(videoPlayerEvent)) {
                this.f7746a.remove(size);
                break;
            }
        }
        this.f7746a.add(new VideoPlayerTransition(videoPlayerState, videoPlayerEvent, videoPlayerState2));
    }

    public final boolean m8017a(VideoPlayerEvent videoPlayerEvent) {
        for (VideoPlayerTransition videoPlayerTransition : this.f7746a) {
            if (videoPlayerTransition.f7743a.equals(this.f7747b) && videoPlayerTransition.f7744b.equals(videoPlayerEvent)) {
                this.f7747b = videoPlayerTransition.f7745c;
                return true;
            }
        }
        return false;
    }
}
