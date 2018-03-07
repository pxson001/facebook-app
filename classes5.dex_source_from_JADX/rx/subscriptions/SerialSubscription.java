package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Subscription;

/* compiled from: beta.facebook.com */
public final class SerialSubscription implements Subscription {
    static final State f7976a = new State(false, Subscriptions.a);
    static final AtomicReferenceFieldUpdater<SerialSubscription, State> f7977c = AtomicReferenceFieldUpdater.newUpdater(SerialSubscription.class, State.class, "b");
    volatile State f7978b = f7976a;

    /* compiled from: beta.facebook.com */
    public final class State {
        public final boolean f7974a;
        public final Subscription f7975b;

        public State(boolean z, Subscription subscription) {
            this.f7974a = z;
            this.f7975b = subscription;
        }
    }

    public final boolean m14095c() {
        return this.f7978b.f7974a;
    }

    public final void m14094b() {
        State state;
        do {
            state = this.f7978b;
            if (!state.f7974a) {
            } else {
                return;
            }
        } while (!f7977c.compareAndSet(this, state, new State(true, state.f7975b)));
        state.f7975b.b();
    }

    public final void m14093a(Subscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        State state;
        do {
            state = this.f7978b;
            if (state.f7974a) {
                subscription.b();
                return;
            }
        } while (!f7977c.compareAndSet(this, state, new State(state.f7974a, subscription)));
        state.f7975b.b();
    }
}
