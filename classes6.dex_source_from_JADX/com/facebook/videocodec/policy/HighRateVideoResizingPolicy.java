package com.facebook.videocodec.policy;

import com.google.common.base.Preconditions;

/* compiled from: retail_agent_item_suggestion */
public class HighRateVideoResizingPolicy extends AbstractVideoResizingPolicy {
    private VideoResizeConfig f5562a = VideoResizeConfig.f5563e;

    protected final VideoResizeConfig m8250a() {
        return this.f5562a;
    }

    public final void m8251a(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f5562a = new VideoResizeConfig(i2, i, 30.0f, 10);
    }
}
