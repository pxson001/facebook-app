package com.facebook.video.player.events;

/* compiled from: composer_edit_remove_with_tag */
public class RVPCastStateChangeEvent extends RichVideoPlayerEvent {
    public final State f19269a;

    /* compiled from: composer_edit_remove_with_tag */
    public enum State {
        CAST_INITIATED,
        CAST_TOGGLE_PLAYBACK,
        CAST_STOPPED
    }

    public RVPCastStateChangeEvent(State state) {
        this.f19269a = state;
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{super.toString(), this.f19269a});
    }
}
