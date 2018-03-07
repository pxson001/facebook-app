package rx.internal.operators;

import com.facebook.graphql.executor.RequestObservable$5;
import com.facebook.graphql.executor.RequestObservable$6;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observable$Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.OnErrorThrowable;
import rx.functions.FuncN;
import rx.functions.Functions.C08733;
import rx.functions.Functions.C08744;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

/* compiled from: boosted_event_mobile */
public final class OperatorZip<R> implements Observable$Operator<R, Observable<?>[]> {
    final FuncN<? extends R> f7824a;

    /* compiled from: boosted_event_mobile */
    public final class Zip<R> {
        static final AtomicLongFieldUpdater<Zip> f7810b = AtomicLongFieldUpdater.newUpdater(Zip.class, "a");
        static final int f7811c = ((int) (((double) RxRingBuffer.f7850c) * 0.7d));
        volatile long f7812a;
        int f7813d = 0;
        public final Observer<? super R> f7814e;
        private final FuncN<? extends R> f7815f;
        public final CompositeSubscription f7816g = new CompositeSubscription();
        public Object[] f7817h;
        public AtomicLong f7818i;

        /* compiled from: boosted_event_mobile */
        public final class InnerSubscriber extends Subscriber {
            final RxRingBuffer f7808a = RxRingBuffer.m14006d();
            final /* synthetic */ Zip f7809b;

            public InnerSubscriber(Zip zip) {
                this.f7809b = zip;
            }

            public final void m13964d() {
                a((long) RxRingBuffer.f7850c);
            }

            public final void m13963b(long j) {
                a(j);
            }

            public final void N_() {
                this.f7808a.m14010e();
                this.f7809b.m13965a();
            }

            public final void m13962a(Throwable th) {
                this.f7809b.f7814e.a(th);
            }

            public final void m13961a(Object obj) {
                try {
                    this.f7808a.m14007a(obj);
                } catch (Throwable e) {
                    m13962a(e);
                }
                this.f7809b.m13965a();
            }
        }

        public Zip(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            this.f7814e = subscriber;
            this.f7815f = funcN;
            subscriber.a(this.f7816g);
        }

        final void m13965a() {
            if (this.f7817h != null && f7810b.getAndIncrement(this) == 0) {
                while (true) {
                    if (this.f7818i.get() > 0) {
                        int i;
                        Object j;
                        Object obj = new Object[this.f7817h.length];
                        int i2 = 1;
                        for (i = 0; i < this.f7817h.length; i++) {
                            j = ((InnerSubscriber) this.f7817h[i]).f7808a.m14014j();
                            if (j == null) {
                                i2 = 0;
                            } else if (NotificationLite.b(j)) {
                                this.f7814e.N_();
                                this.f7816g.m14087b();
                                return;
                            } else {
                                obj[i] = NotificationLite.d(j);
                            }
                        }
                        if (i2 != 0) {
                            try {
                                this.f7814e.a(this.f7815f.mo1023a(obj));
                                this.f7818i.decrementAndGet();
                                this.f7813d++;
                                for (Object j2 : this.f7817h) {
                                    RxRingBuffer rxRingBuffer = ((InnerSubscriber) j2).f7808a;
                                    rxRingBuffer.m14013i();
                                    if (NotificationLite.b(rxRingBuffer.m14014j())) {
                                        this.f7814e.N_();
                                        this.f7816g.m14087b();
                                        return;
                                    }
                                }
                                if (this.f7813d > f7811c) {
                                    for (Object j22 : this.f7817h) {
                                        ((InnerSubscriber) j22).m13963b((long) this.f7813d);
                                    }
                                    this.f7813d = 0;
                                }
                            } catch (Throwable th) {
                                this.f7814e.a(OnErrorThrowable.m13877a(th, obj));
                                return;
                            }
                        }
                    }
                    if (f7810b.decrementAndGet(this) <= 0) {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: boosted_event_mobile */
    final class ZipProducer<R> extends AtomicLong implements Producer {
        private Zip<R> zipper;

        public ZipProducer(Zip<R> zip) {
            this.zipper = zip;
        }

        public final void mo1024a(long j) {
            addAndGet(j);
            this.zipper.m13965a();
        }
    }

    /* compiled from: boosted_event_mobile */
    final class ZipSubscriber extends Subscriber<Observable[]> {
        final Subscriber<? super R> f7819a;
        final Zip<R> f7820b;
        final ZipProducer<R> f7821c;
        boolean f7822d = false;
        final /* synthetic */ OperatorZip f7823e;

        public final void m13967a(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr == null || observableArr.length == 0) {
                this.f7819a.N_();
                return;
            }
            this.f7822d = true;
            Zip zip = this.f7820b;
            AtomicLong atomicLong = this.f7821c;
            int i = 0;
            zip.f7817h = new Object[observableArr.length];
            zip.f7818i = atomicLong;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                Subscription innerSubscriber = new InnerSubscriber(zip);
                zip.f7817h[i2] = innerSubscriber;
                zip.f7816g.m14086a(innerSubscriber);
            }
            while (i < observableArr.length) {
                observableArr[i].a((InnerSubscriber) zip.f7817h[i]);
                i++;
            }
        }

        public ZipSubscriber(OperatorZip operatorZip, Subscriber<? super R> subscriber, Zip<R> zip, ZipProducer<R> zipProducer) {
            this.f7823e = operatorZip;
            super(subscriber);
            this.f7819a = subscriber;
            this.f7820b = zip;
            this.f7821c = zipProducer;
        }

        public final void N_() {
            if (!this.f7822d) {
                this.f7819a.N_();
            }
        }

        public final void m13968a(Throwable th) {
            this.f7819a.a(th);
        }
    }

    public final Object mo611a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Zip zip = new Zip(subscriber, this.f7824a);
        Object zipProducer = new ZipProducer(zip);
        subscriber.a(zipProducer);
        return new ZipSubscriber(this, subscriber, zip, zipProducer);
    }

    public OperatorZip(RequestObservable$5 requestObservable$5) {
        this.f7824a = new C08733(requestObservable$5);
    }

    public OperatorZip(RequestObservable$6 requestObservable$6) {
        this.f7824a = new C08744(requestObservable$6);
    }
}
