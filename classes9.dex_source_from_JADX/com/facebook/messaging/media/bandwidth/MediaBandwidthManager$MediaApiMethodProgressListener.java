package com.facebook.messaging.media.bandwidth;

import com.facebook.http.protocol.ApiMethodProgressListener;

/* compiled from: mIrisSequenceId */
public class MediaBandwidthManager$MediaApiMethodProgressListener implements ApiMethodProgressListener {
    final /* synthetic */ MediaBandwidthManager f11506a;
    private long f11507b = 0;
    private long f11508c = 0;
    private boolean f11509d = false;

    public MediaBandwidthManager$MediaApiMethodProgressListener(MediaBandwidthManager mediaBandwidthManager) {
        this.f11506a = mediaBandwidthManager;
    }

    public final void m12165a(long j, long j2) {
        long a = this.f11506a.f.a();
        if (this.f11507b == 0) {
            this.f11507b = a;
            this.f11508c = j;
        } else if (!this.f11509d && ((double) ((100 * j) / j2)) > 90.0d) {
            this.f11509d = true;
            this.f11506a.a(j - this.f11508c, a - this.f11507b);
        }
    }
}
