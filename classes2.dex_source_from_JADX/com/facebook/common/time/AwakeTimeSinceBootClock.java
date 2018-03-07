package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
/* compiled from: zero_rating */
public class AwakeTimeSinceBootClock implements MonotonicClock {
    @DoNotStrip
    public static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @DoNotStrip
    public long now() {
        return SystemClock.uptimeMillis();
    }
}
