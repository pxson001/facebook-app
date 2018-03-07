package com.facebook.video.player.events;

/* compiled from: composer_delete_all_pending_stories */
public class RVPSeekBarStateEvent extends RichVideoPlayerEvent {
    public final State f19295a;

    /* compiled from: composer_delete_all_pending_stories */
    public enum State {
        DEFAULT,
        ALWAYS_INVISIBLE
    }

    public RVPSeekBarStateEvent(State state) {
        this.f19295a = state;
    }
}
