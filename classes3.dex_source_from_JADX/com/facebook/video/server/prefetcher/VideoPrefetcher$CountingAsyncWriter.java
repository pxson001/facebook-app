package com.facebook.video.server.prefetcher;

import com.facebook.common.iolite.ProgressOutputStream$Listener;
import com.facebook.common.time.MonotonicClock;
import com.facebook.video.server.AsyncWriter;
import com.facebook.video.server.AsyncWriter.Handler;

/* compiled from: SubtitlesLocalesKey */
class VideoPrefetcher$CountingAsyncWriter implements ProgressOutputStream$Listener, AsyncWriter {
    private final AsyncWriter f407a;
    private final MonotonicClock f408b;
    private long f409c = 0;

    public VideoPrefetcher$CountingAsyncWriter(AsyncWriter asyncWriter, MonotonicClock monotonicClock) {
        this.f407a = asyncWriter;
        this.f408b = monotonicClock;
    }

    public final long m362a() {
        return this.f409c;
    }

    public final void mo7a(long j, long j2, Handler handler) {
        this.f407a.mo7a(j, j2, new 1(this, handler));
    }

    public final void mo8a(long j, long j2) {
        this.f409c += j;
        long now = this.f408b.now() - VideoPrefetcher.b;
        if (now > 0) {
            VideoPrefetcher.c = ((this.f409c * 8) * 1000) / now;
        }
    }
}
