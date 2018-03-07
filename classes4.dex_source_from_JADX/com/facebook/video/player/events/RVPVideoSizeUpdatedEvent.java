package com.facebook.video.player.events;

/* compiled from: defaultapp/ */
public class RVPVideoSizeUpdatedEvent extends RichVideoPlayerEvent {
    public final int f14123a;
    public final int f14124b;

    public RVPVideoSizeUpdatedEvent(int i, int i2) {
        this.f14123a = i;
        this.f14124b = i2;
    }

    public String toString() {
        return String.format("%s: width=%d, height=%d", new Object[]{super.toString(), Integer.valueOf(this.f14123a), Integer.valueOf(this.f14124b)});
    }
}
