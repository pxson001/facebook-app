package rx.internal.util;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/* compiled from: bookmark_image */
public final class ScalarSynchronousObservable<T> extends Observable<T> {
    private final T f7862b;

    /* compiled from: bookmark_image */
    class C08961 implements OnSubscribe<T> {
        final /* synthetic */ Object f7861a;

        C08961(Object obj) {
            this.f7861a = obj;
        }

        public final void m14015a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.a(this.f7861a);
            subscriber.N_();
        }
    }

    public static final <T> ScalarSynchronousObservable<T> m14016a(T t) {
        return new ScalarSynchronousObservable(t);
    }

    private ScalarSynchronousObservable(T t) {
        super(new C08961(t));
        this.f7862b = t;
    }

    public final T m14017d() {
        return this.f7862b;
    }
}
