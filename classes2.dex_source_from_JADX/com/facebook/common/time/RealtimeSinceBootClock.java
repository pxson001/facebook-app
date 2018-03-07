package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
/* compiled from: strip_defaults */
public class RealtimeSinceBootClock implements MonotonicClock {
    public static final RealtimeSinceBootClock f3978a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return f3978a;
    }

    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
