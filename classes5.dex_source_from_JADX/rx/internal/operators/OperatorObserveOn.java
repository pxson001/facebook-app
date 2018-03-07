package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable$Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.NotificationLite.OnErrorSentinel;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.schedulers.ImmediateScheduler;
import rx.schedulers.TrampolineScheduler;

/* compiled from: boosted_page_like_promotion_status_description */
public final class OperatorObserveOn<T> implements Observable$Operator<T, T> {
    private final Scheduler f7789a;

    /* compiled from: boosted_page_like_promotion_status_description */
    public final class ObserveOnSubscriber<T> extends Subscriber<T> {
        public static final AtomicLongFieldUpdater<ObserveOnSubscriber> f7772c = AtomicLongFieldUpdater.newUpdater(ObserveOnSubscriber.class, "k");
        public static final AtomicLongFieldUpdater<ObserveOnSubscriber> f7773e = AtomicLongFieldUpdater.newUpdater(ObserveOnSubscriber.class, "d");
        public final Subscriber<? super T> f7774a;
        final NotificationLite<T> f7775b = NotificationLite.a;
        volatile long f7776d;
        private final Worker f7777f;
        public final ScheduledUnsubscribe f7778g;
        public final RxRingBuffer f7779h;
        private boolean f7780i;
        public boolean f7781j;
        private volatile long f7782k;

        /* compiled from: boosted_page_like_promotion_status_description */
        class C08811 implements Producer {
            final /* synthetic */ ObserveOnSubscriber f7770a;

            C08811(ObserveOnSubscriber observeOnSubscriber) {
                this.f7770a = observeOnSubscriber;
            }

            public final void mo1024a(long j) {
                ObserveOnSubscriber.f7772c.getAndAdd(this.f7770a, j);
                this.f7770a.m13942e();
            }
        }

        /* compiled from: boosted_page_like_promotion_status_description */
        class C08822 implements Action0 {
            final /* synthetic */ ObserveOnSubscriber f7771a;

            C08822(ObserveOnSubscriber observeOnSubscriber) {
                this.f7771a = observeOnSubscriber;
            }

            public final void m13938a() {
                ObserveOnSubscriber observeOnSubscriber = this.f7771a;
                int i = 0;
                do {
                    ObserveOnSubscriber.f7773e.set(observeOnSubscriber, 1);
                    while (!observeOnSubscriber.f7778g.m13945c()) {
                        Object i2;
                        if (!observeOnSubscriber.f7781j) {
                            if (ObserveOnSubscriber.f7772c.getAndDecrement(observeOnSubscriber) == 0) {
                                ObserveOnSubscriber.f7772c.incrementAndGet(observeOnSubscriber);
                                break;
                            }
                            i2 = observeOnSubscriber.f7779h.m14013i();
                            if (i2 == null) {
                                ObserveOnSubscriber.f7772c.incrementAndGet(observeOnSubscriber);
                                break;
                            } else if (!NotificationLite.a(observeOnSubscriber.f7774a, i2)) {
                                i++;
                            }
                        } else {
                            i2 = observeOnSubscriber.f7779h.m14013i();
                            if (i2 instanceof OnErrorSentinel) {
                                NotificationLite.a(observeOnSubscriber.f7774a, i2);
                                return;
                            }
                        }
                    }
                } while (ObserveOnSubscriber.f7773e.decrementAndGet(observeOnSubscriber) > 0);
                if (i > 0) {
                    observeOnSubscriber.a((long) i);
                }
            }
        }

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber) {
            RxRingBuffer rxRingBuffer;
            if (UnsafeAccess.m14041a()) {
                rxRingBuffer = new RxRingBuffer(RxRingBuffer.f7853i, RxRingBuffer.f7850c);
            } else {
                rxRingBuffer = new RxRingBuffer();
            }
            this.f7779h = rxRingBuffer;
            this.f7780i = false;
            this.f7781j = false;
            this.f7782k = 0;
            this.f7774a = subscriber;
            this.f7777f = scheduler.mo1028a();
            this.f7778g = new ScheduledUnsubscribe(this.f7777f, this.f7779h);
            subscriber.a(this.f7778g);
            subscriber.a(new C08811(this));
            subscriber.a(this.f7777f);
            subscriber.a(this);
        }

        public final void m13941d() {
            a((long) RxRingBuffer.f7850c);
        }

        public final void m13939a(T t) {
            if (!c() && !this.f7780i) {
                try {
                    this.f7779h.m14007a(t);
                    m13942e();
                } catch (Throwable e) {
                    m13940a(e);
                }
            }
        }

        public final void N_() {
            if (!c() && !this.f7780i) {
                this.f7780i = true;
                this.f7779h.m14010e();
                m13942e();
            }
        }

        public final void m13940a(Throwable th) {
            if (!c() && !this.f7780i) {
                b();
                this.f7780i = true;
                this.f7781j = true;
                RxRingBuffer rxRingBuffer = this.f7779h;
                if (rxRingBuffer.f7854a == null) {
                    rxRingBuffer.f7854a = NotificationLite.a(th);
                }
                m13942e();
            }
        }

        protected final void m13942e() {
            if (f7773e.getAndIncrement(this) == 0) {
                this.f7777f.mo1025a(new C08822(this));
            }
        }
    }

    /* compiled from: boosted_page_like_promotion_status_description */
    public final class ScheduledUnsubscribe implements Subscription {
        static final AtomicIntegerFieldUpdater<ScheduledUnsubscribe> f7784c = AtomicIntegerFieldUpdater.newUpdater(ScheduledUnsubscribe.class, "b");
        final Worker f7785a;
        volatile int f7786b;
        final RxRingBuffer f7787d;
        volatile boolean f7788e = false;

        /* compiled from: boosted_page_like_promotion_status_description */
        class C08831 implements Action0 {
            final /* synthetic */ ScheduledUnsubscribe f7783a;

            C08831(ScheduledUnsubscribe scheduledUnsubscribe) {
                this.f7783a = scheduledUnsubscribe;
            }

            public final void m13943a() {
                this.f7783a.f7785a.b();
                this.f7783a.f7788e = true;
            }
        }

        public ScheduledUnsubscribe(Worker worker, RxRingBuffer rxRingBuffer) {
            this.f7785a = worker;
            this.f7787d = rxRingBuffer;
        }

        public final boolean m13945c() {
            return this.f7788e;
        }

        public final void m13944b() {
            if (f7784c.getAndSet(this, 1) == 0) {
                this.f7785a.mo1025a(new C08831(this));
            }
        }
    }

    public final Object mo611a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return ((this.f7789a instanceof ImmediateScheduler) || (this.f7789a instanceof TrampolineScheduler)) ? subscriber : new ObserveOnSubscriber(this.f7789a, subscriber);
    }

    public OperatorObserveOn(Scheduler scheduler) {
        this.f7789a = scheduler;
    }
}
