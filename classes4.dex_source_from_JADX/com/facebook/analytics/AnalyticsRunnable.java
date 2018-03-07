package com.facebook.analytics;

import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Provider;

/* compiled from: updateDeviceLastSyncOnServer */
public class AnalyticsRunnable extends NamedRunnable {
    private final Runnable f517c;
    private final ExecutorService f518d;
    private final Provider<Boolean> f519e;
    private final int f520f;
    private AtomicBoolean f521g = new AtomicBoolean(false);
    private AtomicBoolean f522h = new AtomicBoolean(false);

    public AnalyticsRunnable(VMMemoryInfo vMMemoryInfo, Provider<Boolean> provider, ExecutorService executorService, NamedRunnable namedRunnable) {
        super(namedRunnable.a, namedRunnable.b);
        this.f518d = executorService;
        this.f517c = namedRunnable;
        this.f520f = vMMemoryInfo.a() ? 100 : 200;
        this.f519e = provider;
    }

    public void run() {
        if (this.f521g.compareAndSet(false, true)) {
            try {
                this.f517c.run();
                this.f521g.set(false);
                this.f522h.set(false);
            } catch (Throwable e) {
                BLog.a("AnalyticsRunnable", "RuntimeException while executing runnable", e);
                throw e;
            } catch (Throwable th) {
                this.f521g.set(false);
                this.f522h.set(false);
            }
        }
    }

    public final void m810a(int i) {
        if (i > (((Boolean) this.f519e.get()).booleanValue() ? 50 : this.f520f) && !this.f521g.get() && this.f522h.compareAndSet(false, true)) {
            Integer.valueOf(i);
            this.f517c.getClass().getSimpleName();
            ExecutorDetour.a(this.f518d, this, 1300787044);
        }
    }
}
