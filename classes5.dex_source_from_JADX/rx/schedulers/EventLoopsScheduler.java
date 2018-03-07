package rx.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: blacklist */
class EventLoopsScheduler extends Scheduler {
    public static final RxThreadFactory f7923b = new RxThreadFactory("RxComputationThreadPool-");
    final FixedSchedulerPool f7924a = new FixedSchedulerPool();

    /* compiled from: blacklist */
    class EventLoopWorker extends Worker {
        private final CompositeSubscription f7918a = new CompositeSubscription();
        private final PoolWorker f7919b;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f7919b = poolWorker;
        }

        public final void m14056b() {
            this.f7918a.m14087b();
        }

        public final boolean m14057c() {
            return this.f7918a.m14089c();
        }

        public final Subscription mo1025a(Action0 action0) {
            return mo1026a(action0, 0, null);
        }

        public final Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f7918a.m14089c()) {
                return Subscriptions.a;
            }
            Subscription b = this.f7919b.m13972b(action0, j, timeUnit);
            this.f7918a.m14086a(b);
            b.m13979a(this.f7918a);
            return b;
        }
    }

    /* compiled from: blacklist */
    public final class FixedSchedulerPool {
        public final int f7920a = Runtime.getRuntime().availableProcessors();
        public final PoolWorker[] f7921b = new PoolWorker[this.f7920a];
        public long f7922c;

        FixedSchedulerPool() {
            for (int i = 0; i < this.f7920a; i++) {
                this.f7921b[i] = new PoolWorker(EventLoopsScheduler.f7923b);
            }
        }
    }

    /* compiled from: blacklist */
    final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    EventLoopsScheduler() {
    }

    public final Worker mo1028a() {
        FixedSchedulerPool fixedSchedulerPool = this.f7924a;
        PoolWorker[] poolWorkerArr = fixedSchedulerPool.f7921b;
        long j = fixedSchedulerPool.f7922c;
        fixedSchedulerPool.f7922c = 1 + j;
        return new EventLoopWorker(poolWorkerArr[(int) (j % ((long) fixedSchedulerPool.f7920a))]);
    }
}
