package com.facebook.video.player.events;

/* compiled from: composer_edit_add_minutiae_tag */
public class RVPLiveVideoControlChangeHideTimeEvent extends RichVideoPlayerEvent {
    public final Event f19286a;

    /* compiled from: composer_edit_add_minutiae_tag */
    public enum Event {
        STOP_HIDE,
        REFRESH_HIDE
    }

    public RVPLiveVideoControlChangeHideTimeEvent(Event event) {
        this.f19286a = event;
    }
}
