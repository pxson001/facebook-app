package rx.subscriptions;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: big_profile_image */
public final class BooleanSubscription implements Subscription {
    static final AtomicIntegerFieldUpdater<BooleanSubscription> f7964b = AtomicIntegerFieldUpdater.newUpdater(BooleanSubscription.class, "a");
    volatile int f7965a;
    private final Action0 f7966c = null;

    public final boolean m14084c() {
        return this.f7965a != 0;
    }

    public final void m14083b() {
        if (f7964b.compareAndSet(this, 0, 1) && this.f7966c != null) {
            this.f7966c.a();
        }
    }
}
