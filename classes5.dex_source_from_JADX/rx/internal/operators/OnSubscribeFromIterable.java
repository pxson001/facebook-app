package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

/* compiled from: bounded both ways */
public final class OnSubscribeFromIterable<T> implements OnSubscribe<T> {
    final Iterable<? extends T> f7706a;

    /* compiled from: bounded both ways */
    final class IterableProducer<T> implements Producer {
        private static final AtomicLongFieldUpdater<IterableProducer> f7702d = AtomicLongFieldUpdater.newUpdater(IterableProducer.class, "c");
        private final Subscriber<? super T> f7703a;
        private final Iterator<? extends T> f7704b;
        private volatile long f7705c = 0;

        public IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f7703a = subscriber;
            this.f7704b = it;
        }

        public final void mo1024a(long j) {
            if (f7702d.get(this) != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE) {
                    f7702d.set(this, j);
                    while (this.f7704b.hasNext()) {
                        if (!this.f7703a.c()) {
                            this.f7703a.a(this.f7704b.next());
                        } else {
                            return;
                        }
                    }
                    if (!this.f7703a.c()) {
                        this.f7703a.N_();
                    }
                } else if (j > 0 && f7702d.getAndAdd(this, j) == 0) {
                    long j2;
                    do {
                        j2 = this.f7705c;
                        long j3 = j2;
                        while (this.f7704b.hasNext()) {
                            j3--;
                            if (j3 < 0) {
                                break;
                            } else if (!this.f7703a.c()) {
                                this.f7703a.a(this.f7704b.next());
                            } else {
                                return;
                            }
                        }
                        if (!this.f7704b.hasNext()) {
                            this.f7703a.N_();
                            return;
                        }
                    } while (f7702d.addAndGet(this, -j2) != 0);
                }
            }
        }
    }

    public final void m13882a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.a(new IterableProducer(subscriber, this.f7706a.iterator()));
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.f7706a = iterable;
    }
}
