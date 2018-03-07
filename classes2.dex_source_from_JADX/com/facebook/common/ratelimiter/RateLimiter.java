package com.facebook.common.ratelimiter;

import com.facebook.common.time.Clock;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: sessionless_index.bin */
public class RateLimiter {
    private final Clock f5381a;
    private final int f5382b;
    private final long f5383c;
    private double f5384d;
    private long f5385e;

    public RateLimiter(Clock clock, int i, long j) {
        this.f5381a = clock;
        this.f5382b = i;
        this.f5383c = j;
        this.f5384d = (double) i;
    }

    public final synchronized boolean m9265a() {
        boolean z;
        long a = this.f5381a.mo211a();
        long j = a - this.f5385e;
        this.f5385e = a;
        this.f5384d += ((double) j) * (((double) this.f5382b) / ((double) this.f5383c));
        if (this.f5384d > ((double) this.f5382b)) {
            this.f5384d = (double) this.f5382b;
        }
        if (this.f5384d < 1.0d) {
            z = false;
        } else {
            this.f5384d -= 1.0d;
            z = true;
        }
        return z;
    }
}
