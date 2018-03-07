package rx.internal.operators;

import rx.Observable$Operator;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/* compiled from: boosted_post_mobile */
public final class OperatorFilter<T> implements Observable$Operator<T, T> {
    public final Func1<? super T, Boolean> f7740a;

    public final Object mo611a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        return new Subscriber<T>(this, subscriber) {
            final /* synthetic */ OperatorFilter f7739b;

            public final void N_() {
                subscriber.N_();
            }

            public final void m13904a(Throwable th) {
                subscriber.a(th);
            }

            public final void m13903a(T t) {
                try {
                    if (((Boolean) this.f7739b.f7740a.mo611a(t)).booleanValue()) {
                        subscriber.a(t);
                    } else {
                        a(1);
                    }
                } catch (Throwable th) {
                    subscriber.a(OnErrorThrowable.m13877a(th, t));
                }
            }
        };
    }

    public OperatorFilter(Func1<? super T, Boolean> func1) {
        this.f7740a = func1;
    }
}
