package rx.internal.operators;

import rx.Observable;
import rx.Observable$Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

/* compiled from: boosted_local_awareness_promotion_status_description */
public class OperatorSubscribeOn<T> implements Observable$Operator<T, Observable<T>> {
    private final Scheduler f7807a;

    public final Object mo611a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        final Worker a = this.f7807a.mo1028a();
        subscriber.a(a);
        return new Subscriber<Observable<T>>(this, subscriber) {
            final /* synthetic */ OperatorSubscribeOn f7806c;

            public final void m13958a(Object obj) {
                final Observable observable = (Observable) obj;
                a.mo1025a(new Action0(this) {
                    final /* synthetic */ C08901 f7803b;

                    public final void m13957a() {
                        final Thread currentThread = Thread.currentThread();
                        observable.a(new Subscriber<T>(this, subscriber) {
                            final /* synthetic */ C08891 f7801b;

                            public final void N_() {
                                subscriber.N_();
                            }

                            public final void m13955a(Throwable th) {
                                subscriber.a(th);
                            }

                            public final void m13954a(T t) {
                                subscriber.a(t);
                            }

                            public final void m13956a(final Producer producer) {
                                subscriber.a(new Producer(this) {
                                    final /* synthetic */ C08881 f7799b;

                                    public final void mo1024a(final long j) {
                                        if (Thread.currentThread() == currentThread) {
                                            producer.mo1024a(j);
                                        } else {
                                            a.mo1025a(new Action0(this) {
                                                final /* synthetic */ C08871 f7797b;

                                                public final void m13952a() {
                                                    producer.mo1024a(j);
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }

            public final void N_() {
            }

            public final void m13959a(Throwable th) {
                subscriber.a(th);
            }
        };
    }

    public OperatorSubscribeOn(Scheduler scheduler) {
        this.f7807a = scheduler;
    }
}
