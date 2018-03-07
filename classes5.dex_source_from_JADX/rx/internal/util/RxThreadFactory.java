package rx.internal.util;

import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: bookmark_pinned_rank */
public final class RxThreadFactory implements ThreadFactory {
    static final AtomicLongFieldUpdater<RxThreadFactory> f7858c = AtomicLongFieldUpdater.newUpdater(RxThreadFactory.class, "b");
    final String f7859a;
    volatile long f7860b;

    public RxThreadFactory(String str) {
        this.f7859a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread a = ThreadInitDetour.a(runnable, this.f7859a + f7858c.incrementAndGet(this), -2012021195);
        a.setDaemon(true);
        return a;
    }
}
