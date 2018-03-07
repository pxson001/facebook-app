package rx.plugins;

import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Subscription;

/* compiled from: rssi_dbm */
public abstract class RxJavaObservableExecutionHook {
    public static <T> OnSubscribe<T> m11264b(OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    public static <T> Subscription m11263a(Subscription subscription) {
        return subscription;
    }

    public static <T> Throwable m11261a(Throwable th) {
        return th;
    }

    public static <T, R> Operator<? extends R, ? super T> m11262a(Operator<? extends R, ? super T> operator) {
        return operator;
    }
}
