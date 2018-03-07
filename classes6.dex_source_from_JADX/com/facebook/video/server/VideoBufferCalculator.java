package com.facebook.video.server;

import com.facebook.common.time.MonotonicClock;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.abtest.ThrottlingConfig;

/* compiled from: comment_video */
public class VideoBufferCalculator {
    private final MonotonicClock f19546a;
    private final ThrottlingConfig f19547b;

    public VideoBufferCalculator(MonotonicClock monotonicClock, ThrottlingConfig throttlingConfig) {
        this.f19546a = monotonicClock;
        this.f19547b = throttlingConfig;
    }

    public final long m28267a(VideoServerRequestIdentifier videoServerRequestIdentifier, long j, int i, int i2, long j2, long j3) {
        Range a = videoServerRequestIdentifier.a();
        if (a.a == j || this.f19547b.u) {
            long j4 = j - videoServerRequestIdentifier.a().a;
            long a2 = m28264a(a.a(), i, i2, this.f19547b.h);
            if (j4 < a2) {
                return m28263a(a2);
            }
        }
        if (j2 > 0) {
            return m28265a(videoServerRequestIdentifier, j, (long) (((float) j2) * this.f19547b.j), this.f19547b.i, j3);
        }
        int i3 = this.f19547b.b;
        long j5 = -1;
        if (m28266a(this.f19547b.h, i, i2)) {
            i3 = 0;
            j5 = (long) (((i2 / 8) * this.f19547b.h) + i);
        }
        return m28265a(videoServerRequestIdentifier, j, (long) i3, 0, j5);
    }

    public static long m28263a(long j) {
        return (((j + 65536) - 1) / 65536) * 65536;
    }

    private long m28264a(long j, int i, int i2, int i3) {
        long max = Math.max((long) this.f19547b.e, (((long) this.f19547b.g) * j) / 100);
        if (m28266a(i3, i, i2)) {
            max = (long) (((i2 / 8) * i3) + i);
        }
        return m28263a(max);
    }

    private long m28265a(VideoServerRequestIdentifier videoServerRequestIdentifier, long j, long j2, int i, long j3) {
        long j4 = j - videoServerRequestIdentifier.a().a;
        long j5 = j3 - videoServerRequestIdentifier.a().a;
        long now = this.f19546a.now() - videoServerRequestIdentifier.b;
        long j6 = (long) this.f19547b.d;
        if (now <= 0 || j4 < 0) {
            return j6;
        }
        j6 = Math.max((now * j2) / 1000, j5);
        if (j6 <= j4) {
            return 0;
        }
        return Math.max(m28263a(Math.max(((long) i) * j2, j6 - j4)), (long) this.f19547b.d);
    }

    private static boolean m28266a(int i, int i2, int i3) {
        return i > 0 && i2 > 0 && i3 > 0;
    }
}
