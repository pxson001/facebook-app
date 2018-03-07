package com.facebook.widget.listview.throttling;

import com.facebook.common.time.MonotonicClock;

/* compiled from: offers/detail/?coupon_id=%s */
public class TimeBasedThrottler implements ThrottlingPolicy {
    private final int f11610a;
    private final MonotonicClock f11611b;
    private long f11612c = 0;

    public TimeBasedThrottler(int i, MonotonicClock monotonicClock) {
        this.f11610a = i;
        this.f11611b = monotonicClock;
    }

    public final boolean mo1975a() {
        long now = this.f11611b.now();
        if (now - this.f11612c < ((long) this.f11610a)) {
            return true;
        }
        this.f11612c = now;
        return false;
    }
}
