package com.facebook.http.observer;

import com.facebook.common.time.MonotonicClock;

/* compiled from: numConnections */
public class ResponseBandwidthManager {
    private long f12007a = 0;
    private long f12008b = 0;
    private long f12009c = -1;
    private long f12010d = -1;
    private long f12011e = -1;
    private final DownloadBandwidthManager f12012f;
    private final MonotonicClock f12013g;

    public ResponseBandwidthManager(DownloadBandwidthManager downloadBandwidthManager, MonotonicClock monotonicClock) {
        this.f12012f = downloadBandwidthManager;
        this.f12013g = monotonicClock;
    }

    public final void m17709a(long j, long j2) {
        if (j < 20000 || j2 < 20) {
            m17706c(j, j2);
            return;
        }
        int min = (int) Math.min(j / 10000, j2 / 10);
        long j3 = j / ((long) min);
        long j4 = j2 / ((long) min);
        min--;
        while (min > 0) {
            m17705b(j3, j4);
            min--;
            j -= j3;
            j2 -= j4;
        }
        m17706c(j, j2);
    }

    public final synchronized void m17708a(long j) {
        if (this.f12007a == 0) {
            this.f12009c = this.f12013g.now();
            this.f12011e = this.f12009c;
            this.f12010d = this.f12011e;
        }
        this.f12007a += j;
        if (this.f12007a - this.f12008b >= 10000) {
            this.f12010d = this.f12013g.now();
        }
        if (m17705b(this.f12007a - this.f12008b, this.f12010d - this.f12011e)) {
            this.f12008b = this.f12007a;
            this.f12011e = this.f12010d;
        }
    }

    public final synchronized void m17707a() {
        m17706c(this.f12007a - this.f12008b, this.f12010d - this.f12011e);
    }

    private boolean m17705b(long j, long j2) {
        if ((j < 10000 || j2 < 10) && (j < 50000 || j2 <= 0)) {
            return false;
        }
        this.f12012f.m4085a(j, j2);
        return true;
    }

    private void m17706c(long j, long j2) {
        if (!m17705b(j, j2) && j >= 10000 && j2 > 0) {
            this.f12012f.m4085a(j, j2);
        }
    }
}
