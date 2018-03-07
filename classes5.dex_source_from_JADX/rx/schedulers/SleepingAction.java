package rx.schedulers;

import rx.Scheduler.Worker;
import rx.functions.Action0;

/* compiled from: bing_results */
class SleepingAction implements Action0 {
    private final Action0 f7949a;
    private final Worker f7950b;
    private final long f7951c;

    public SleepingAction(Action0 action0, Worker worker, long j) {
        this.f7949a = action0;
        this.f7950b = worker;
        this.f7951c = j;
    }

    public final void m14075a() {
        if (!this.f7950b.c()) {
            if (this.f7951c > Worker.m13858a()) {
                long a = this.f7951c - Worker.m13858a();
                if (a > 0) {
                    try {
                        Thread.sleep(a);
                    } catch (Throwable e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
            if (!this.f7950b.c()) {
                this.f7949a.a();
            }
        }
    }
}
