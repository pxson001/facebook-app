package rx.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: birthdayPerson */
public final class ImmediateScheduler extends Scheduler {
    private static final ImmediateScheduler f7942a = new ImmediateScheduler();

    /* compiled from: birthdayPerson */
    class InnerImmediateScheduler extends Worker implements Subscription {
        final BooleanSubscription f7940a = new BooleanSubscription();
        final /* synthetic */ ImmediateScheduler f7941b;

        public InnerImmediateScheduler(ImmediateScheduler immediateScheduler) {
            this.f7941b = immediateScheduler;
        }

        public final Subscription mo1025a(Action0 action0) {
            action0.a();
            return Subscriptions.a;
        }

        public final void m14069b() {
            this.f7940a.m14083b();
        }

        public final boolean m14070c() {
            return this.f7940a.m14084c();
        }

        public final Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit) {
            return mo1025a(new SleepingAction(action0, this, System.currentTimeMillis() + timeUnit.toMillis(j)));
        }
    }

    ImmediateScheduler() {
    }

    public final Worker mo1028a() {
        return new InnerImmediateScheduler(this);
    }
}
