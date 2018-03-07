package com.facebook.video.player.events;

/* compiled from: deleteContact */
public class RVPDialogEvent extends RichVideoPlayerEvent {
    public final boolean f14076a;
    public boolean f14077b = false;

    public RVPDialogEvent(boolean z) {
        this.f14076a = z;
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{super.toString(), Boolean.valueOf(this.f14076a)});
    }
}
