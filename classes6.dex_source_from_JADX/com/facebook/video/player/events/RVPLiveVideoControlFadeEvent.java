package com.facebook.video.player.events;

/* compiled from: composer_discard_dialog_displayed */
public class RVPLiveVideoControlFadeEvent extends RichVideoPlayerEvent {
    public final State f19287a;

    /* compiled from: composer_discard_dialog_displayed */
    public enum State {
        FADE_IN,
        FADE_OUT
    }

    public RVPLiveVideoControlFadeEvent(State state) {
        this.f19287a = state;
    }
}
