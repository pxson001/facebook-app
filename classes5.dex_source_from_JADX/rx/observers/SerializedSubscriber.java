package rx.observers;

import rx.Observer;
import rx.Subscriber;

/* compiled from: block_title */
public class SerializedSubscriber<T> extends Subscriber<T> {
    private final Observer<T> f7904a;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f7904a = new SerializedObserver(subscriber);
    }

    public final void N_() {
        this.f7904a.N_();
    }

    public final void m14047a(Throwable th) {
        this.f7904a.a(th);
    }

    public final void m14046a(T t) {
        this.f7904a.a(t);
    }
}
