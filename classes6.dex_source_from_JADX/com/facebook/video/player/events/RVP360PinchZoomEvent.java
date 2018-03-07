package com.facebook.video.player.events;

/* compiled from: composer_entry_picker */
public class RVP360PinchZoomEvent extends RichVideoPlayerEvent {
    public final float f19261a;
    public final int f19262b;

    public RVP360PinchZoomEvent(int i, float f) {
        this.f19262b = i;
        this.f19261a = f;
    }

    public RVP360PinchZoomEvent(int i) {
        this(i, 1.0f);
    }
}
