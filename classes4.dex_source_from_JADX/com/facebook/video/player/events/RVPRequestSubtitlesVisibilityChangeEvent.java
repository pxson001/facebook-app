package com.facebook.video.player.events;

/* compiled from: permissions */
public class RVPRequestSubtitlesVisibilityChangeEvent extends RichVideoPlayerEvent {
    public final boolean f5096a;

    public RVPRequestSubtitlesVisibilityChangeEvent(boolean z) {
        this.f5096a = z;
    }

    public String toString() {
        return String.format("%s: isSubtitlesOn: %s", new Object[]{super.toString(), Boolean.valueOf(this.f5096a)});
    }
}
