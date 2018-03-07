package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Subscription;

/* compiled from: bg_color */
public final class MultipleAssignmentSubscription implements Subscription {
    static final State f7971a = new State(false, Subscriptions.a);
    static final AtomicReferenceFieldUpdater<MultipleAssignmentSubscription, State> f7972c = AtomicReferenceFieldUpdater.newUpdater(MultipleAssignmentSubscription.class, State.class, "b");
    volatile State f7973b = f7971a;

    /* compiled from: bg_color */
    public final class State {
        public final boolean f7969a;
        public final Subscription f7970b;

        public State(boolean z, Subscription subscription) {
            this.f7969a = z;
            this.f7970b = subscription;
        }
    }

    public final boolean m14092c() {
        return this.f7973b.f7969a;
    }

    public final void m14091b() {
        State state;
        do {
            state = this.f7973b;
            if (!state.f7969a) {
            } else {
                return;
            }
        } while (!f7972c.compareAndSet(this, state, new State(true, state.f7970b)));
        state.f7970b.b();
    }

    public final void m14090a(Subscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        State state;
        do {
            state = this.f7973b;
            if (state.f7969a) {
                subscription.b();
                return;
            }
        } while (!f7972c.compareAndSet(this, state, new State(state.f7969a, subscription)));
    }
}
