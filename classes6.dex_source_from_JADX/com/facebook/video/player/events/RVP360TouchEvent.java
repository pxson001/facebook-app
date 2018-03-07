package com.facebook.video.player.events;

/* compiled from: composer_entry */
public class RVP360TouchEvent extends RichVideoPlayerEvent {
    public int f19263a;
    public float f19264b;
    public float f19265c;

    public RVP360TouchEvent(int i) {
        this.f19263a = i;
    }

    public RVP360TouchEvent(int i, float f, float f2) {
        this.f19263a = i;
        this.f19264b = f;
        this.f19265c = f2;
    }
}
