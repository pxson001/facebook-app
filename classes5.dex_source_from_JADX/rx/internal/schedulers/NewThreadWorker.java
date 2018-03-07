package rx.internal.schedulers;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction.FutureCompleter;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.subscriptions.Subscriptions;

/* compiled from: boosted_component_app */
public class NewThreadWorker extends Worker implements Subscription {
    volatile boolean f7825a;
    private final ScheduledExecutorService f7826b;
    private final RxJavaSchedulersHook f7827c = RxJavaPlugins.b.d();

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f7826b = Executors.newScheduledThreadPool(1, threadFactory);
    }

    public final Subscription mo1025a(Action0 action0) {
        return mo1026a(action0, 0, null);
    }

    public final Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.f7825a) {
            return Subscriptions.a;
        }
        return m13972b(action0, j, timeUnit);
    }

    public final void m13973b() {
        this.f7825a = true;
        this.f7826b.shutdownNow();
    }

    public final ScheduledAction m13972b(Action0 action0, long j, TimeUnit timeUnit) {
        Future a;
        Runnable scheduledAction = new ScheduledAction(action0);
        if (j <= 0) {
            a = ExecutorDetour.a(this.f7826b, scheduledAction, 238633267);
        } else {
            a = this.f7826b.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.cancel.m14086a(new FutureCompleter(scheduledAction, a));
        return scheduledAction;
    }

    public final boolean m13974c() {
        return this.f7825a;
    }
}
