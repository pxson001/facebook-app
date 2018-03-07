package com.facebook.video.player.events;

/* compiled from: composer_change_privacy */
public class RVPVolumeChangeEvent extends RichVideoPlayerEvent {
    public final int f19296a;

    public RVPVolumeChangeEvent(int i) {
        this.f19296a = i;
    }

    public String toString() {
        return String.format("%s: %d", new Object[]{super.toString(), Integer.valueOf(this.f19296a)});
    }
}
