package com.facebook.video.player.events;

/* compiled from: post_privacy_followup_info */
public class RVPLoadingSpinnerStateEvent extends RichVideoPlayerEvent {
    public final State f5098a;

    /* compiled from: post_privacy_followup_info */
    public enum State {
        DEFAULT,
        HIDE
    }

    public RVPLoadingSpinnerStateEvent(State state) {
        this.f5098a = state;
    }
}
