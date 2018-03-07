package com.facebook.video.server;

import com.facebook.common.time.MonotonicClock;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.abtest.ThrottlingConfig;

/* compiled from: comments.count */
public class VideoBandwidthBasedThrottlingPolicy implements ThrottlingPolicy {
    private final int f19543a = 65536;
    private final MonotonicClock f19544b;
    private final ThrottlingConfig f19545c;

    public VideoBandwidthBasedThrottlingPolicy(ThrottlingConfig throttlingConfig, MonotonicClock monotonicClock) {
        this.f19544b = monotonicClock;
        this.f19545c = throttlingConfig;
    }

    public final long m28262a(VideoServerRequestIdentifier videoServerRequestIdentifier, long j) {
        Range range = videoServerRequestIdentifier.c;
        long now = this.f19544b.now() - videoServerRequestIdentifier.b;
        if (now <= 0) {
            return 0;
        }
        now *= (long) (this.f19545c.b / 1000);
        long j2 = j - range.a;
        if (j2 < 0) {
            return -1;
        }
        if (j2 < now) {
            return ((now - j2) / 65536) * 65536;
        }
        return 0;
    }
}
