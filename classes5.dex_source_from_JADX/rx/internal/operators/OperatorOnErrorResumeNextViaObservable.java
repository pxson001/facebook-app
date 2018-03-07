package rx.internal.operators;

import rx.Observable;
import rx.Observable$Operator;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaPlugins;

/* compiled from: boosted_page_like_mobile */
public final class OperatorOnErrorResumeNextViaObservable<T> implements Observable$Operator<T, T> {
    final Observable<? extends T> f7795a;

    public final Object mo611a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        C08851 c08851 = new Subscriber<T>(this) {
            final /* synthetic */ OperatorOnErrorResumeNextViaObservable f7793b;
            private boolean f7794c = false;

            public final void m13948a(T t) {
                if (!this.f7794c) {
                    subscriber.a(t);
                }
            }

            public final void m13949a(Throwable th) {
                if (this.f7794c) {
                    Exceptions.m13874b(th);
                    return;
                }
                this.f7794c = true;
                RxJavaPlugins.b.b();
                b();
                this.f7793b.f7795a.a(subscriber);
            }

            public final void N_() {
                if (!this.f7794c) {
                    this.f7794c = true;
                    subscriber.N_();
                }
            }

            public final void m13950a(final Producer producer) {
                subscriber.a(new Producer(this) {
                    final /* synthetic */ C08851 f7791b;

                    public final void mo1024a(long j) {
                        producer.mo1024a(j);
                    }
                });
            }
        };
        subscriber.a(c08851);
        return c08851;
    }

    public OperatorOnErrorResumeNextViaObservable(Observable<? extends T> observable) {
        this.f7795a = observable;
    }
}
