package com.facebook.feed.loader;

import android.os.Handler;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.internal.Preconditions;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: selfupdate_download_success */
public class AutoRefreshScheduler {
    @ForUiThread
    private final Handler f5731a;
    public final RefreshSchedulerCallback f5732b;
    public long f5733c = 0;
    public AutoRefreshStatus f5734d;
    private final Runnable f5735e = new C02671(this);

    /* compiled from: selfupdate_download_success */
    public interface RefreshSchedulerCallback {
        void mo1396a();

        long mo1397b();

        long mo1398c();

        long mo1399d();
    }

    /* compiled from: selfupdate_download_success */
    class C02671 implements Runnable {
        final /* synthetic */ AutoRefreshScheduler f5736a;

        C02671(AutoRefreshScheduler autoRefreshScheduler) {
            this.f5736a = autoRefreshScheduler;
        }

        public void run() {
            if (this.f5736a.f5734d == AutoRefreshStatus.ON) {
                this.f5736a.f5732b.mo1396a();
            }
            this.f5736a.f5734d = AutoRefreshStatus.OFF;
        }
    }

    /* compiled from: selfupdate_download_success */
    enum AutoRefreshStatus {
        OFF,
        ON
    }

    @Inject
    public AutoRefreshScheduler(Handler handler, @Assisted RefreshSchedulerCallback refreshSchedulerCallback) {
        Preconditions.a(refreshSchedulerCallback);
        this.f5731a = handler;
        this.f5732b = refreshSchedulerCallback;
        this.f5734d = AutoRefreshStatus.OFF;
    }

    public final boolean m9881b(long j) {
        long b = this.f5732b.mo1397b() - (j - this.f5733c);
        if (b < 0) {
            b = 0;
        }
        m9878d(b);
        return b == 0;
    }

    public final boolean m9880a(long j, long j2) {
        long max = Math.max(Math.max(this.f5732b.mo1398c() - (j - j2), this.f5732b.mo1399d() - (j - this.f5733c)), 0);
        m9878d(max);
        return max == 0;
    }

    public final void m9882c(long j) {
        this.f5733c = j;
    }

    private void m9878d(long j) {
        this.f5734d = AutoRefreshStatus.ON;
        HandlerDetour.a(this.f5731a, this.f5735e);
        if (j > 0) {
            HandlerDetour.b(this.f5731a, this.f5735e, j, -1190225023);
        } else {
            this.f5735e.run();
        }
    }

    public final void m9879a() {
        this.f5734d = AutoRefreshStatus.OFF;
        HandlerDetour.a(this.f5731a, this.f5735e);
    }
}
