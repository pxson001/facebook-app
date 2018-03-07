package rx.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: block_promotion */
public final class CachedThreadScheduler extends Scheduler {
    public static final RxThreadFactory f7916a = new RxThreadFactory("RxCachedThreadScheduler-");
    public static final RxThreadFactory f7917b = new RxThreadFactory("RxCachedWorkerPoolEvictor-");

    /* compiled from: block_promotion */
    public final class CachedWorkerPool {
        public static CachedWorkerPool f7907d = new CachedWorkerPool(60, TimeUnit.SECONDS);
        public final long f7908a;
        public final ConcurrentLinkedQueue<ThreadWorker> f7909b = new ConcurrentLinkedQueue();
        private final ScheduledExecutorService f7910c = Executors.newScheduledThreadPool(1, CachedThreadScheduler.f7917b);

        /* compiled from: block_promotion */
        class C08981 implements Runnable {
            final /* synthetic */ CachedWorkerPool f7906a;

            C08981(CachedWorkerPool cachedWorkerPool) {
                this.f7906a = cachedWorkerPool;
            }

            public void run() {
                CachedWorkerPool cachedWorkerPool = this.f7906a;
                if (!cachedWorkerPool.f7909b.isEmpty()) {
                    long d = CachedWorkerPool.m14048d();
                    Iterator it = cachedWorkerPool.f7909b.iterator();
                    while (it.hasNext()) {
                        ThreadWorker threadWorker = (ThreadWorker) it.next();
                        if (threadWorker.f7915b > d) {
                            return;
                        }
                        if (cachedWorkerPool.f7909b.remove(threadWorker)) {
                            threadWorker.m13973b();
                        }
                    }
                }
            }
        }

        private CachedWorkerPool(long j, TimeUnit timeUnit) {
            this.f7908a = timeUnit.toNanos(j);
            this.f7910c.scheduleWithFixedDelay(new C08981(this), this.f7908a, this.f7908a, TimeUnit.NANOSECONDS);
        }

        public static long m14048d() {
            return System.nanoTime();
        }
    }

    /* compiled from: block_promotion */
    final class EventLoopWorker extends Worker {
        static final AtomicIntegerFieldUpdater<EventLoopWorker> f7911b = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "a");
        volatile int f7912a;
        private final CompositeSubscription f7913c = new CompositeSubscription();
        private final ThreadWorker f7914d;

        EventLoopWorker(ThreadWorker threadWorker) {
            this.f7914d = threadWorker;
        }

        public final void m14051b() {
            if (f7911b.compareAndSet(this, 0, 1)) {
                CachedWorkerPool cachedWorkerPool = CachedWorkerPool.f7907d;
                ThreadWorker threadWorker = this.f7914d;
                threadWorker.f7915b = CachedWorkerPool.m14048d() + cachedWorkerPool.f7908a;
                cachedWorkerPool.f7909b.offer(threadWorker);
            }
            this.f7913c.m14087b();
        }

        public final boolean m14052c() {
            return this.f7913c.m14089c();
        }

        public final Subscription mo1025a(Action0 action0) {
            return mo1026a(action0, 0, null);
        }

        public final Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f7913c.m14089c()) {
                return Subscriptions.a;
            }
            Subscription b = this.f7914d.m13972b(action0, j, timeUnit);
            this.f7913c.m14086a(b);
            b.m13979a(this.f7913c);
            return b;
        }
    }

    /* compiled from: block_promotion */
    public final class ThreadWorker extends NewThreadWorker {
        public long f7915b = 0;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    CachedThreadScheduler() {
    }

    public final Worker mo1028a() {
        ThreadWorker threadWorker;
        CachedWorkerPool cachedWorkerPool = CachedWorkerPool.f7907d;
        while (!cachedWorkerPool.f7909b.isEmpty()) {
            threadWorker = (ThreadWorker) cachedWorkerPool.f7909b.poll();
            if (threadWorker != null) {
                break;
            }
        }
        threadWorker = new ThreadWorker(f7916a);
        return new EventLoopWorker(threadWorker);
    }
}
