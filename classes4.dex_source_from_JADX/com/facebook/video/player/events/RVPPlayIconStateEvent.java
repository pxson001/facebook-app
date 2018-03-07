package com.facebook.video.player.events;

/* compiled from: default_privacy_client_override */
public class RVPPlayIconStateEvent extends RichVideoPlayerEvent {
    public final State f14166a;

    /* compiled from: default_privacy_client_override */
    public enum State {
        DEFAULT,
        HIDE
    }

    public RVPPlayIconStateEvent(State state) {
        this.f14166a = state;
    }
}
