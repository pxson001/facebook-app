package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observable$Operator;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: bottom */
public final class OperatorConcat<T> implements Observable$Operator<T, Observable<? extends T>> {

    /* compiled from: bottom */
    class ConcatInnerSubscriber<T> extends Subscriber<T> {
        private static final AtomicIntegerFieldUpdater<ConcatInnerSubscriber> f7707d = AtomicIntegerFieldUpdater.newUpdater(ConcatInnerSubscriber.class, "c");
        private final Subscriber<T> f7708a;
        private final ConcatSubscriber<T> f7709b;
        private volatile int f7710c = 0;

        public ConcatInnerSubscriber(ConcatSubscriber<T> concatSubscriber, Subscriber<T> subscriber, long j) {
            this.f7709b = concatSubscriber;
            this.f7708a = subscriber;
            a(j);
        }

        public final void m13884a(T t) {
            ConcatSubscriber.f7714i.decrementAndGet(this.f7709b);
            this.f7708a.a(t);
        }

        public final void m13885a(Throwable th) {
            if (f7707d.compareAndSet(this, 0, 1)) {
                this.f7709b.m13891a(th);
            }
        }

        public final void N_() {
            if (f7707d.compareAndSet(this, 0, 1)) {
                this.f7709b.m13893e();
            }
        }
    }

    /* compiled from: bottom */
    final class ConcatProducer<T> implements Producer {
        final ConcatSubscriber<T> f7711a;

        ConcatProducer(ConcatSubscriber<T> concatSubscriber) {
            this.f7711a = concatSubscriber;
        }

        public final void mo1024a(long j) {
            ConcatSubscriber.m13888b(this.f7711a, j);
        }
    }

    /* compiled from: bottom */
    public final class ConcatSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final AtomicIntegerFieldUpdater<ConcatSubscriber> f7713e = AtomicIntegerFieldUpdater.newUpdater(ConcatSubscriber.class, "d");
        public static final AtomicLongFieldUpdater<ConcatSubscriber> f7714i = AtomicLongFieldUpdater.newUpdater(ConcatSubscriber.class, "h");
        final NotificationLite<Observable<? extends T>> f7715a = NotificationLite.a;
        final ConcurrentLinkedQueue<Object> f7716b;
        volatile ConcatInnerSubscriber<T> f7717c;
        volatile int f7718d;
        private final Subscriber<T> f7719f;
        private final SerialSubscription f7720g;
        private volatile long f7721h;

        /* compiled from: bottom */
        class C08751 implements Action0 {
            final /* synthetic */ ConcatSubscriber f7712a;

            C08751(ConcatSubscriber concatSubscriber) {
                this.f7712a = concatSubscriber;
            }

            public final void m13887a() {
                this.f7712a.f7716b.clear();
            }
        }

        public final void m13890a(Object obj) {
            this.f7716b.add(NotificationLite.a((Observable) obj));
            if (f7713e.getAndIncrement(this) == 0) {
                m13889g();
            }
        }

        public ConcatSubscriber(Subscriber<T> subscriber, SerialSubscription serialSubscription) {
            super(subscriber);
            this.f7719f = subscriber;
            this.f7720g = serialSubscription;
            this.f7716b = new ConcurrentLinkedQueue();
            a(Subscriptions.a(new C08751(this)));
        }

        public final void m13892d() {
            a(2);
        }

        public static void m13888b(ConcatSubscriber concatSubscriber, long j) {
            if (f7714i.getAndAdd(concatSubscriber, j) == 0 && concatSubscriber.f7717c == null && concatSubscriber.f7718d > 0) {
                concatSubscriber.m13889g();
            } else if (concatSubscriber.f7717c != null) {
                concatSubscriber.f7717c.a(j);
            }
        }

        public final void m13891a(Throwable th) {
            this.f7719f.a(th);
            b();
        }

        public final void N_() {
            this.f7716b.add(NotificationLite.b);
            if (f7713e.getAndIncrement(this) == 0) {
                m13889g();
            }
        }

        final void m13893e() {
            a(1);
            this.f7717c = null;
            if (f7713e.decrementAndGet(this) > 0) {
                m13889g();
            }
        }

        private void m13889g() {
            if (this.f7721h > 0) {
                Object poll = this.f7716b.poll();
                if (NotificationLite.b(poll)) {
                    this.f7719f.N_();
                } else if (poll != null) {
                    Observable observable = (Observable) NotificationLite.d(poll);
                    this.f7717c = new ConcatInnerSubscriber(this, this.f7719f, this.f7721h);
                    this.f7720g.m14093a(this.f7717c);
                    observable.a(this.f7717c);
                }
            } else if (NotificationLite.b(this.f7716b.peek())) {
                this.f7719f.N_();
            }
        }
    }

    public final Object mo611a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.a(serialSubscription);
        ConcatSubscriber concatSubscriber = new ConcatSubscriber(serializedSubscriber, serialSubscription);
        subscriber.a(new ConcatProducer(concatSubscriber));
        return concatSubscriber;
    }
}
