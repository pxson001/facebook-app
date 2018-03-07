package rx.internal.operators;

import rx.Observable$Operator;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/* compiled from: boosted_post_default_audience */
public final class OperatorMap<T, R> implements Observable$Operator<R, T> {
    public final Func1<? super T, ? extends R> f7743a;

    public final Object mo611a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        return new Subscriber<T>(this, subscriber) {
            final /* synthetic */ OperatorMap f7742b;

            public final void N_() {
                subscriber.N_();
            }

            public final void m13907a(Throwable th) {
                subscriber.a(th);
            }

            public final void m13906a(T t) {
                try {
                    subscriber.a(this.f7742b.f7743a.mo611a(t));
                } catch (Throwable th) {
                    m13907a(OnErrorThrowable.m13877a(th, t));
                }
            }
        };
    }

    public OperatorMap(Func1<? super T, ? extends R> func1) {
        this.f7743a = func1;
    }
}
