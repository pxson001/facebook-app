package rx.observers;

import java.util.Arrays;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.plugins.RxJavaPlugins;

/* compiled from: reranking_sortby */
public class SafeSubscriber<T> extends Subscriber<T> {
    boolean f7201a = false;
    private final Subscriber<? super T> f7202b;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f7202b = subscriber;
    }

    public final void N_() {
        if (!this.f7201a) {
            this.f7201a = true;
            try {
                this.f7202b.N_();
            } catch (Throwable th) {
                Exceptions.b(th);
                m11658b(th);
            } finally {
                mo1600b();
            }
        }
    }

    public final void mo1599a(Throwable th) {
        Exceptions.b(th);
        if (!this.f7201a) {
            this.f7201a = true;
            m11658b(th);
        }
    }

    public final void mo1598a(T t) {
        try {
            if (!this.f7201a) {
                this.f7202b.mo1598a((Object) t);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            mo1599a(th);
        }
    }

    private void m11658b(Throwable th) {
        try {
            RxJavaPlugins.m11258a().m11259b();
        } catch (Throwable th2) {
            m11659c(th2);
        }
        OnErrorFailedException onErrorFailedException;
        try {
            this.f7202b.mo1599a(th);
            try {
                mo1600b();
                return;
            } catch (Throwable e) {
                RxJavaPlugins.m11258a().m11259b();
            } catch (Throwable th22) {
                m11659c(th22);
            }
            throw new OnErrorFailedException(e);
            mo1600b();
            onErrorFailedException = new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(new Throwable[]{th, th22}), (byte) 0));
        } catch (Throwable th3) {
            try {
                RxJavaPlugins.m11258a().m11259b();
            } catch (Throwable e2) {
                m11659c(e2);
            }
            onErrorFailedException = new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(new Throwable[]{th, th22, th3}), (byte) 0));
        }
    }

    private static void m11659c(Throwable th) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th.getMessage());
        th.printStackTrace();
    }
}
