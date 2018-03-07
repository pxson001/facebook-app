package rx.schedulers;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: bitrate */
final class ExecutorScheduler extends Scheduler {
    final Executor f7936a;

    /* compiled from: bitrate */
    final class ExecutorAction implements Runnable, Subscription {
        static final AtomicIntegerFieldUpdater<ExecutorAction> f7925d = AtomicIntegerFieldUpdater.newUpdater(ExecutorAction.class, "c");
        final Action0 f7926a;
        final CompositeSubscription f7927b;
        volatile int f7928c;

        public ExecutorAction(Action0 action0, CompositeSubscription compositeSubscription) {
            this.f7926a = action0;
            this.f7927b = compositeSubscription;
        }

        public final void run() {
            if (!m14060c()) {
                try {
                    this.f7926a.a();
                } catch (Throwable th) {
                    RxJavaPlugins.a().b();
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                } finally {
                    m14059b();
                }
            }
        }

        public final boolean m14060c() {
            return this.f7928c != 0;
        }

        public final void m14059b() {
            if (f7925d.compareAndSet(this, 0, 1)) {
                this.f7927b.m14088b(this);
            }
        }
    }

    /* compiled from: bitrate */
    final class ExecutorSchedulerWorker extends Worker implements Runnable {
        final Executor f7932a;
        final CompositeSubscription f7933b = new CompositeSubscription();
        final ConcurrentLinkedQueue<ExecutorAction> f7934c = new ConcurrentLinkedQueue();
        final AtomicInteger f7935d = new AtomicInteger();

        public ExecutorSchedulerWorker(Executor executor) {
            this.f7932a = executor;
        }

        public final Subscription mo1025a(Action0 action0) {
            if (m14064c()) {
                return Subscriptions.a();
            }
            Subscription executorAction = new ExecutorAction(action0, this.f7933b);
            this.f7933b.m14086a(executorAction);
            this.f7934c.offer(executorAction);
            if (this.f7935d.getAndIncrement() != 0) {
                return executorAction;
            }
            try {
                ExecutorDetour.a(this.f7932a, this, -1883123734);
                return executorAction;
            } catch (RejectedExecutionException e) {
                this.f7933b.m14088b(executorAction);
                this.f7935d.decrementAndGet();
                RxJavaPlugins.a().b();
                throw e;
            }
        }

        public final void run() {
            do {
                ((ExecutorAction) this.f7934c.poll()).run();
            } while (this.f7935d.decrementAndGet() > 0);
        }

        public final Subscription mo1026a(final Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo1025a(action0);
            }
            if (m14064c()) {
                return Subscriptions.a();
            }
            ScheduledExecutorService scheduledExecutorService;
            if (this.f7932a instanceof ScheduledExecutorService) {
                scheduledExecutorService = (ScheduledExecutorService) this.f7932a;
            } else {
                scheduledExecutorService = GenericScheduledExecutorService.m14066a();
            }
            final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            try {
                multipleAssignmentSubscription.m14090a(Subscriptions.a(scheduledExecutorService.schedule(new Runnable(this) {
                    final /* synthetic */ ExecutorSchedulerWorker f7931c;

                    public void run() {
                        if (!multipleAssignmentSubscription.m14092c()) {
                            multipleAssignmentSubscription.m14090a(this.f7931c.mo1025a(action0));
                        }
                    }
                }, j, timeUnit)));
                return multipleAssignmentSubscription;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.a().b();
                throw e;
            }
        }

        public final boolean m14064c() {
            return this.f7933b.m14089c();
        }

        public final void m14063b() {
            this.f7933b.m14087b();
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.f7936a = executor;
    }

    public final Worker mo1028a() {
        return new ExecutorSchedulerWorker(this.f7936a);
    }
}
