package rx.subscriptions;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Actions;

/* compiled from: reranking_enabled_by_connection_class */
public final class Subscriptions {
    public static final Empty f7205a = new Empty();

    /* compiled from: reranking_enabled_by_connection_class */
    final class Empty implements Subscription {
        public final void mo1600b() {
        }

        public final boolean mo1601c() {
            return false;
        }
    }

    /* compiled from: reranking_enabled_by_connection_class */
    final class ActionSubscription implements Subscription {
        static final AtomicReferenceFieldUpdater<ActionSubscription, Action0> f7206b = AtomicReferenceFieldUpdater.newUpdater(ActionSubscription.class, Action0.class, "a");
        private static final Unsubscribed f7207c = new Unsubscribed();
        volatile Action0 f7208a;

        /* compiled from: reranking_enabled_by_connection_class */
        final class Unsubscribed implements Action0 {
            public final void mo1603a() {
            }
        }

        public ActionSubscription(Action0 action0) {
            if (action0 == null) {
                Object obj = Actions.f6518a;
            }
            this.f7208a = action0;
        }

        public final boolean mo1601c() {
            return this.f7208a == f7207c;
        }

        public final void mo1600b() {
            ((Action0) f7206b.getAndSet(this, f7207c)).mo1603a();
        }
    }

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription m11663a() {
        return f7205a;
    }

    public static Subscription m11665a(Action0 action0) {
        return new ActionSubscription(action0);
    }

    public static Subscription m11664a(Future<?> future) {
        return new FutureSubscription(future);
    }
}
