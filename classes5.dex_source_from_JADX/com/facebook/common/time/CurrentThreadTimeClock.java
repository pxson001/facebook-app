package com.facebook.common.time;

import android.os.SystemClock;

/* compiled from: should_show_reviews_on_profile */
public class CurrentThreadTimeClock implements Clock {
    public final long m3849a() {
        return SystemClock.currentThreadTimeMillis();
    }
}
