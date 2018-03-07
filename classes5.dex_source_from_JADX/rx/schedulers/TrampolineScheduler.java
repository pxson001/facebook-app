package rx.schedulers;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: binary */
public final class TrampolineScheduler extends Scheduler {
    static final AtomicIntegerFieldUpdater<TrampolineScheduler> f7961b = AtomicIntegerFieldUpdater.newUpdater(TrampolineScheduler.class, "a");
    private static final TrampolineScheduler f7962c = new TrampolineScheduler();
    volatile int f7963a;

    /* compiled from: binary */
    class InnerCurrentThreadScheduler extends Worker implements Subscription {
        final PriorityQueue<TimedAction> f7954a = new PriorityQueue();
        final /* synthetic */ TrampolineScheduler f7955b;
        private final BooleanSubscription f7956c = new BooleanSubscription();
        private final AtomicInteger f7957d = new AtomicInteger();

        public InnerCurrentThreadScheduler(TrampolineScheduler trampolineScheduler) {
            this.f7955b = trampolineScheduler;
        }

        public final Subscription mo1025a(Action0 action0) {
            return m14077a(action0, Worker.m13858a());
        }

        public final Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit) {
            long a = Worker.m13858a() + timeUnit.toMillis(j);
            return m14077a(new SleepingAction(action0, this, a), a);
        }

        private Subscription m14077a(Action0 action0, long j) {
            if (this.f7956c.m14084c()) {
                return Subscriptions.a;
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j), TrampolineScheduler.f7961b.incrementAndGet(this.f7955b));
            this.f7954a.add(timedAction);
            if (this.f7957d.getAndIncrement() != 0) {
                return Subscriptions.a(new Action0(this) {
                    final /* synthetic */ InnerCurrentThreadScheduler f7953b;

                    public final void m14076a() {
                        PriorityQueue priorityQueue = this.f7953b.f7954a;
                        if (priorityQueue != null) {
                            priorityQueue.remove(timedAction);
                        }
                    }
                });
            }
            do {
                timedAction = (TimedAction) this.f7954a.poll();
                if (timedAction != null) {
                    timedAction.f7958a.a();
                }
            } while (this.f7957d.decrementAndGet() > 0);
            return Subscriptions.a;
        }

        public final void m14080b() {
            this.f7956c.m14083b();
        }

        public final boolean m14081c() {
            return this.f7956c.m14084c();
        }
    }

    /* compiled from: binary */
    final class TimedAction implements Comparable<TimedAction> {
        final Action0 f7958a;
        final Long f7959b;
        final int f7960c;

        public final int compareTo(Object obj) {
            TimedAction timedAction = (TimedAction) obj;
            int compareTo = this.f7959b.compareTo(timedAction.f7959b);
            if (compareTo != 0) {
                return compareTo;
            }
            compareTo = this.f7960c;
            int i = timedAction.f7960c;
            int i2 = compareTo < i ? -1 : compareTo == i ? 0 : 1;
            return i2;
        }

        public TimedAction(Action0 action0, Long l, int i) {
            this.f7958a = action0;
            this.f7959b = l;
            this.f7960c = i;
        }
    }

    public final Worker mo1028a() {
        return new InnerCurrentThreadScheduler(this);
    }

    TrampolineScheduler() {
    }
}
