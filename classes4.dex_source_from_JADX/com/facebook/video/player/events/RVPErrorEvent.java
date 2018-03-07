package com.facebook.video.player.events;

import com.facebook.video.engine.Constants.VideoError;

/* compiled from: deleteContactParams */
public class RVPErrorEvent extends RichVideoPlayerEvent {
    public final String f14074a;
    public final VideoError f14075b;

    public RVPErrorEvent(String str, VideoError videoError) {
        this.f14074a = str;
        this.f14075b = videoError;
    }

    public String toString() {
        return String.format("%s: errorStage - %s, errorCode - %s", new Object[]{super.toString(), this.f14074a, this.f14075b});
    }
}
