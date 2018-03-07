package com.facebook.video.server;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.video.abtest.ThrottlingConfig;
import com.facebook.video.api.playersession.VideoPlayerSessionBase;
import com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;

/* compiled from: comment_edit_failed */
public class VideoPlayerSessionManagerBasedThrottlingPolicy implements ThrottlingPolicy {
    private final VideoPlayerSessionManager f19550a;
    private final ThrottlingConfig f19551b;
    private final VideoBufferCalculator f19552c;
    private final MonotonicClock f19553d;
    private final FbDataConnectionManager f19554e;
    private long f19555f = -1;

    public VideoPlayerSessionManagerBasedThrottlingPolicy(MonotonicClock monotonicClock, VideoPlayerSessionManager videoPlayerSessionManager, ThrottlingConfig throttlingConfig, FbDataConnectionManager fbDataConnectionManager) {
        this.f19550a = videoPlayerSessionManager;
        this.f19551b = throttlingConfig;
        this.f19553d = monotonicClock;
        this.f19552c = new VideoBufferCalculator(monotonicClock, throttlingConfig);
        this.f19554e = fbDataConnectionManager;
    }

    private static long m28272a(VideoServerRequestIdentifier videoServerRequestIdentifier, VideoPlayerSessionBase videoPlayerSessionBase) {
        if (videoPlayerSessionBase == null) {
            return -1;
        }
        int b = videoPlayerSessionBase.b();
        long b2 = videoServerRequestIdentifier.b();
        if (b <= 0 || b2 <= 0) {
            return -1;
        }
        return (1000 * b2) / ((long) b);
    }

    private static long m28271a(int i, int i2, long j, int i3) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        return (long) ((((float) ((i3 * 1000) + i)) / ((float) i2)) * ((float) j));
    }

    public final long m28273a(VideoServerRequestIdentifier videoServerRequestIdentifier, long j) {
        VideoPlayerSessionBase b = this.f19550a.b(videoServerRequestIdentifier.a);
        Object obj = (!this.f19550a.a() || this.f19551b.o) ? null : 1;
        Object obj2 = (this.f19551b.t.compareTo(ConnectionQuality.POOR) == 0 || this.f19554e.c().compareTo(this.f19551b.t) >= 0) ? 1 : null;
        if ((b == null && !this.f19551b.k) || ((b != null && b.d() == SessionState.INSEEK) || ((b != null && b.c() && !this.f19551b.q) || obj2 == null || obj != null))) {
            return -2;
        }
        if (b != null && b.d() == SessionState.STOP && this.f19551b.l) {
            return -1;
        }
        if (b != null && b.d() == SessionState.PAUSED && this.f19551b.m) {
            return 0;
        }
        long now;
        long j2 = -1;
        if (this.f19551b.n > 0 && b != null) {
            j2 = m28271a(b.a(), b.b(), videoServerRequestIdentifier.b(), this.f19551b.n);
        }
        int i = -1;
        int i2 = -1;
        if (b != null) {
            i = b.f();
            i2 = b.g();
        }
        long a = this.f19552c.m28267a(videoServerRequestIdentifier, j, i, i2, m28272a(videoServerRequestIdentifier, b), j2);
        if (a > 0) {
            a = Math.max(Math.min(a, (long) this.f19551b.f), (long) this.f19551b.d);
        }
        if (a <= 0) {
            if (a != 0) {
                return a;
            }
            now = this.f19553d.now() - this.f19555f;
            if (now <= this.f19551b.r) {
                return a;
            }
            a = this.f19551b.s;
            long a2 = m28272a(videoServerRequestIdentifier, b);
            if (a2 > 0 && this.f19551b.u) {
                if (this.f19555f <= 0) {
                    now = this.f19551b.r;
                }
                now = VideoBufferCalculator.m28263a(Math.max(a, (long) ((((float) (now * a2)) * this.f19551b.j) / 1000.0f)));
                this.f19555f = this.f19553d.now();
                return now;
            }
        }
        now = a;
        this.f19555f = this.f19553d.now();
        return now;
    }
}
