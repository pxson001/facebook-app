package com.facebook.widget.listview.throttling;

import com.facebook.debug.fps.FrameCounter;
import com.google.common.base.Preconditions;

/* compiled from: photo_dialtone */
public class FrameBasedThrottler implements ThrottlingPolicy {
    private final FrameCounter f10072a;
    private final long f10073b;
    private long f10074c = -1;

    public FrameBasedThrottler(int i, FrameCounter frameCounter) {
        Preconditions.checkArgument(i > 0, "Interval %s is invalid.", Integer.valueOf(i));
        this.f10073b = (long) i;
        this.f10072a = frameCounter;
    }

    public final boolean mo1975a() {
        if (this.f10072a.f9493c < this.f10074c + this.f10073b && this.f10074c != -1) {
            return true;
        }
        this.f10074c = this.f10072a.f9493c;
        return false;
    }
}
