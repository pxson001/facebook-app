package com.facebook.video.player.events;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: default_privacy_enabled */
public class RVPLimitAspectRatioEvent extends RichVideoPlayerEvent {
    public final double f14125a;

    public RVPLimitAspectRatioEvent(double d) {
        this.f14125a = d;
    }

    public String toString() {
        return StringFormatUtil.a("%s: minAspectRatio=%f", new Object[]{super.toString(), Double.valueOf(this.f14125a)});
    }
}
