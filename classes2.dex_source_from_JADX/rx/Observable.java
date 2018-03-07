package rx;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorAsObservable;
import rx.internal.operators.OperatorConcat;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.internal.operators.OperatorFilter;
import rx.internal.operators.OperatorMap;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnErrorResumeNextViaObservable;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ScalarSynchronousObservable;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaObservableExecutionHookDefault;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/* compiled from: rtc_conferencing_call_tab */
public class Observable<T> {
    private static final RxJavaObservableExecutionHook f6484b;
    final OnSubscribe<T> f6485a;

    /* compiled from: rtc_conferencing_call_tab */
    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    static {
        RxJavaPlugins rxJavaPlugins = RxJavaPlugins.f6487b;
        if (rxJavaPlugins.f6489d.get() == null) {
            Object a = RxJavaPlugins.m11257a(RxJavaObservableExecutionHook.class);
            if (a == null) {
                rxJavaPlugins.f6489d.compareAndSet(null, RxJavaObservableExecutionHookDefault.f6491a);
            } else {
                rxJavaPlugins.f6489d.compareAndSet(null, (RxJavaObservableExecutionHook) a);
            }
        }
        f6484b = (RxJavaObservableExecutionHook) rxJavaPlugins.f6489d.get();
    }

    protected Observable(OnSubscribe<T> onSubscribe) {
        this.f6485a = onSubscribe;
    }

    public static final <T> Observable<T> m11239a(OnSubscribe<T> onSubscribe) {
        return new Observable(onSubscribe);
    }

    private <R> Observable<R> m11240a(Operator<? extends R, ? super T> operator) {
        return new Observable(new 1(this, operator));
    }

    public static <T> Observable<T> m11246d(Observable<? extends Observable<? extends T>> observable) {
        return observable.m11240a(new OperatorConcat());
    }

    public static <T> Observable<T> m11244b(Iterable<? extends T> iterable) {
        return m11239a(new OnSubscribeFromIterable(iterable));
    }

    public static <T> Observable<T> m11247e(Observable<? extends Observable<? extends T>> observable) {
        return observable.m11240a(new OperatorMerge());
    }

    public static final <T> Observable<T> m11241a(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m11247e(m11244b(Arrays.asList(new Observable[]{observable, observable2})));
    }

    public static final <T1, T2, R> Observable<R> m11242a(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return ScalarSynchronousObservable.a(new Observable[]{observable, observable2}).m11240a(new OperatorZip(func2));
    }

    public static final <T1, T2, T3, R> Observable<R> m11243a(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return ScalarSynchronousObservable.a(new Observable[]{observable, observable2, observable3}).m11240a(new OperatorZip(func3));
    }

    public final Observable<T> m11252b() {
        return m11240a(new OperatorAsObservable());
    }

    public final Observable<T> m11248a(long j, TimeUnit timeUnit) {
        return m11238a(j, timeUnit, Schedulers.a());
    }

    private Observable<T> m11238a(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m11240a(new OperatorDebounceWithTime(j, timeUnit, scheduler));
    }

    public final Observable<T> m11250a(Func1<? super T, Boolean> func1) {
        return m11240a(new OperatorFilter(func1));
    }

    public final <R> Observable<R> m11254b(Func1<? super T, ? extends R> func1) {
        return m11240a(new OperatorMap(func1));
    }

    public final Observable<T> m11249a(Scheduler scheduler) {
        return m11240a(new OperatorObserveOn(scheduler));
    }

    public final Observable<T> m11256c(Observable<? extends T> observable) {
        return m11240a(new OperatorOnErrorResumeNextViaObservable(observable));
    }

    public final Subscription m11251a(Subscriber<? super T> subscriber) {
        try {
            subscriber.m11205d();
            RxJavaObservableExecutionHook.m11264b(this.f6485a).mo1602a(subscriber);
            return RxJavaObservableExecutionHook.m11263a((Subscription) subscriber);
        } catch (Throwable th) {
            Exceptions.b(th);
            try {
                subscriber.mo1599a(RxJavaObservableExecutionHook.m11261a(th));
                return Subscriptions.m11663a();
            } catch (OnErrorNotImplementedException e) {
                throw e;
            } catch (Throwable th2) {
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
            }
        }
    }

    public final Subscription m11255b(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("observer can not be null");
        } else if (this.f6485a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        } else {
            Subscription safeSubscriber;
            subscriber.m11205d();
            if (!(subscriber instanceof SafeSubscriber)) {
                safeSubscriber = new SafeSubscriber(subscriber);
            }
            try {
                RxJavaObservableExecutionHook.m11264b(this.f6485a).mo1602a(safeSubscriber);
                return RxJavaObservableExecutionHook.m11263a(safeSubscriber);
            } catch (Throwable th) {
                Exceptions.b(th);
                try {
                    safeSubscriber.mo1599a(RxJavaObservableExecutionHook.m11261a(th));
                    return Subscriptions.m11663a();
                } catch (OnErrorNotImplementedException e) {
                    throw e;
                } catch (Throwable th2) {
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                }
            }
        }
    }

    public final Observable<T> m11253b(Scheduler scheduler) {
        return ScalarSynchronousObservable.a(this).m11240a(new OperatorSubscribeOn(scheduler));
    }
}
