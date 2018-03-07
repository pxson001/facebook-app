package rx.internal.util;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Subscription;
import rx.functions.Func1;

/* compiled from: bookmark */
public final class SubscriptionIndexedRingBuffer<T extends Subscription> implements Subscription {
    private static final AtomicIntegerFieldUpdater<SubscriptionIndexedRingBuffer> f7863c = AtomicIntegerFieldUpdater.newUpdater(SubscriptionIndexedRingBuffer.class, "b");
    public static final Func1<Subscription, Boolean> f7864d = new C08971();
    private volatile IndexedRingBuffer<T> f7865a = ((IndexedRingBuffer) IndexedRingBuffer.f7840e.m13984b());
    private volatile int f7866b = 0;

    /* compiled from: bookmark */
    final class C08971 implements Func1<Subscription, Boolean> {
        C08971() {
        }

        public final Object mo611a(Object obj) {
            ((Subscription) obj).b();
            return Boolean.TRUE;
        }
    }

    public final boolean m14023c() {
        return this.f7866b == 1;
    }

    public final synchronized int m14019a(T t) {
        int i;
        if (this.f7866b == 1 || this.f7865a == null) {
            t.b();
            i = -1;
        } else {
            i = this.f7865a.m13994a((Object) t);
            if (this.f7866b == 1) {
                t.b();
            }
        }
        return i;
    }

    public final void m14021a(int i) {
        if (this.f7866b != 1 && this.f7865a != null && i >= 0) {
            Subscription subscription = (Subscription) this.f7865a.m13996a(i);
            if (subscription != null && subscription != null) {
                subscription.b();
            }
        }
    }

    public final void m14022b() {
        if (f7863c.compareAndSet(this, 0, 1) && this.f7865a != null) {
            IndexedRingBuffer indexedRingBuffer = this.f7865a;
            if (indexedRingBuffer != null) {
                int a = indexedRingBuffer.m13995a(f7864d, 0);
            }
            indexedRingBuffer = this.f7865a;
            this.f7865a = null;
            indexedRingBuffer.m13997b();
        }
    }

    public final synchronized int m14020a(Func1<T, Boolean> func1, int i) {
        int i2;
        if (this.f7866b == 1 || this.f7865a == null) {
            i2 = 0;
        } else {
            i2 = this.f7865a.m13995a(func1, i);
        }
        return i2;
    }
}
