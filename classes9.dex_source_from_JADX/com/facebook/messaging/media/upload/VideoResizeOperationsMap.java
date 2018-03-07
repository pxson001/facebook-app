package com.facebook.messaging.media.upload;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: latency_ms */
class VideoResizeOperationsMap {
    @GuardedBy("this")
    private final Cache<String, Future> f12074a = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    VideoResizeOperationsMap() {
    }

    final synchronized boolean m12594a(String str) {
        boolean cancel;
        Future future = (Future) this.f12074a.a(str);
        if (future != null) {
            cancel = future.cancel(true);
        } else {
            cancel = false;
        }
        return cancel;
    }

    final synchronized void m12593a(String str, Future future) {
        m12596c(str);
        this.f12074a.a(str, future);
    }

    final synchronized void m12595b(String str) {
        m12596c(str);
        this.f12074a.b(str);
    }

    final synchronized void m12596c(String str) {
        Future future = (Future) this.f12074a.a(str);
        if (future != null && future.isCancelled()) {
            throw new CancellationException();
        }
    }
}
