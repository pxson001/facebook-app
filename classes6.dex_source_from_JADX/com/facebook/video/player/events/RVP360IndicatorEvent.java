package com.facebook.video.player.events;

/* compiled from: composer_entry_point_description */
public class RVP360IndicatorEvent extends RichVideoPlayerEvent {
    public final State f19260a;

    /* compiled from: composer_entry_point_description */
    public enum State {
        INDICATOR_STOP
    }

    public RVP360IndicatorEvent(State state) {
        this.f19260a = state;
    }
}
