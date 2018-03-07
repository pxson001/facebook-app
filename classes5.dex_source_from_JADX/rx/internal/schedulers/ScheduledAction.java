package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

/* compiled from: boostable_story */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    final Action0 action;
    public final CompositeSubscription cancel = new CompositeSubscription();

    /* compiled from: boostable_story */
    public final class FutureCompleter implements Subscription {
        final /* synthetic */ ScheduledAction f7828a;
        private final Future<?> f7829b;

        public FutureCompleter(ScheduledAction scheduledAction, Future<?> future) {
            this.f7828a = scheduledAction;
            this.f7829b = future;
        }

        public final void m13975b() {
            if (this.f7828a.get() != Thread.currentThread()) {
                this.f7829b.cancel(true);
            } else {
                this.f7829b.cancel(false);
            }
        }

        public final boolean m13976c() {
            return this.f7829b.isCancelled();
        }
    }

    /* compiled from: boostable_story */
    final class Remover extends AtomicBoolean implements Subscription {
        final CompositeSubscription parent;
        final Subscription f7830s;

        public Remover(Subscription subscription, CompositeSubscription compositeSubscription) {
            this.f7830s = subscription;
            this.parent = compositeSubscription;
        }

        public final boolean m13978c() {
            return this.f7830s.c();
        }

        public final void m13977b() {
            if (compareAndSet(false, true)) {
                this.parent.m14088b(this.f7830s);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
    }

    public final void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.a();
        } catch (Throwable th) {
            Throwable th2;
            if (th2 instanceof OnErrorNotImplementedException) {
                th2 = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th2);
            } else {
                th2 = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2);
            }
            RxJavaPlugins.a().b();
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
        } finally {
            m13980b();
        }
    }

    public final boolean m13981c() {
        return this.cancel.m14089c();
    }

    public final void m13980b() {
        if (!this.cancel.m14089c()) {
            this.cancel.m14087b();
        }
    }

    public final void m13979a(CompositeSubscription compositeSubscription) {
        this.cancel.m14086a(new Remover(this, compositeSubscription));
    }
}
