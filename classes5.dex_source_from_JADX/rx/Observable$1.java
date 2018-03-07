package rx;

import rx.Observable.OnSubscribe;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaObservableExecutionHook;

/* compiled from: breakup_restrict */
class Observable$1 implements OnSubscribe<R> {
    final /* synthetic */ Observable$Operator f7689a;
    final /* synthetic */ Observable f7690b;

    Observable$1(Observable observable, Observable$Operator observable$Operator) {
        this.f7690b = observable;
        this.f7689a = observable$Operator;
    }

    public final void m13855a(Object obj) {
        OnErrorNotImplementedException onErrorNotImplementedException;
        Subscriber subscriber = (Subscriber) obj;
        try {
            Observable.c();
            Subscriber subscriber2 = (Subscriber) RxJavaObservableExecutionHook.a(this.f7689a).mo611a(subscriber);
            try {
                subscriber2.d();
                this.f7690b.a.a(subscriber2);
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    onErrorNotImplementedException = (OnErrorNotImplementedException) th;
                } else {
                    subscriber2.a(th);
                }
            }
        } catch (Throwable th2) {
            if (th2 instanceof OnErrorNotImplementedException) {
                onErrorNotImplementedException = (OnErrorNotImplementedException) th2;
            } else {
                subscriber.a(th2);
            }
        }
    }
}
