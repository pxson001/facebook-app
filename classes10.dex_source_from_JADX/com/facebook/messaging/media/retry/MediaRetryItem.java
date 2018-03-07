package com.facebook.messaging.media.retry;

import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.google.common.base.Preconditions;

/* compiled from: script */
public class MediaRetryItem {
    private final long f3201a;
    private final MonotonicClock f3202b;
    private final Uri f3203c;
    private int f3204d;

    public MediaRetryItem(Uri uri, long j, int i, MonotonicClock monotonicClock) {
        boolean z = true;
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(monotonicClock);
        Preconditions.checkArgument(i > 0);
        if (j <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f3203c = uri;
        this.f3201a = j;
        this.f3204d = i;
        this.f3202b = monotonicClock;
    }

    private synchronized int m3137d() {
        return this.f3204d;
    }

    public final synchronized int m3138a() {
        this.f3204d--;
        return this.f3204d;
    }

    public final boolean m3139b() {
        return this.f3201a < this.f3202b.now();
    }

    public final boolean m3140c() {
        return m3137d() > 0 && !m3139b();
    }
}
