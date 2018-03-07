package rx.subjects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

/* compiled from: rows_changed */
public final class SubjectSubscriptionManager<T> implements OnSubscribe<T> {
    public static final AtomicReferenceFieldUpdater<SubjectSubscriptionManager, State> f6500b = AtomicReferenceFieldUpdater.newUpdater(SubjectSubscriptionManager.class, State.class, "a");
    static final AtomicReferenceFieldUpdater<SubjectSubscriptionManager, Object> f6501d = AtomicReferenceFieldUpdater.newUpdater(SubjectSubscriptionManager.class, Object.class, "c");
    public volatile State<T> f6502a = State.f6511e;
    public volatile Object f6503c;
    boolean f6504e = true;
    Action1<SubjectObserver<T>> f6505f = Actions.f6518a;
    public Action1<SubjectObserver<T>> f6506g = Actions.f6518a;
    public Action1<SubjectObserver<T>> f6507h = Actions.f6518a;
    public final NotificationLite<T> f6508i = NotificationLite.f6497a;

    /* compiled from: rows_changed */
    public final class State<T> {
        static final SubjectObserver[] f6509c = new SubjectObserver[0];
        static final State f6510d = new State(true, f6509c);
        static final State f6511e = new State(false, f6509c);
        public final boolean f6512a;
        public final SubjectObserver[] f6513b;

        public State(boolean z, SubjectObserver[] subjectObserverArr) {
            this.f6512a = z;
            this.f6513b = subjectObserverArr;
        }

        public final State m11278b(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.f6513b;
            int length = subjectObserverArr.length;
            if (length == 1 && subjectObserverArr[0] == subjectObserver) {
                return f6511e;
            }
            if (length == 0) {
                return this;
            }
            Object obj = new SubjectObserver[(length - 1)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3;
                SubjectObserver subjectObserver2 = subjectObserverArr[i];
                if (subjectObserver2 == subjectObserver) {
                    i3 = i2;
                } else if (i2 == length - 1) {
                    return this;
                } else {
                    i3 = i2 + 1;
                    obj[i2] = subjectObserver2;
                }
                i++;
                i2 = i3;
            }
            if (i2 == 0) {
                return f6511e;
            }
            SubjectObserver[] subjectObserverArr2;
            if (i2 < length - 1) {
                subjectObserverArr2 = new SubjectObserver[i2];
                System.arraycopy(obj, 0, subjectObserverArr2, 0, i2);
            } else {
                Object obj2 = obj;
            }
            return new State(this.f6512a, subjectObserverArr2);
        }
    }

    /* compiled from: rows_changed */
    public final class SubjectObserver<T> implements Observer<T> {
        final Observer<? super T> f6514a;
        boolean f6515b = true;
        protected volatile boolean f6516c;
        public volatile Object f6517d;

        public SubjectObserver(Observer<? super T> observer) {
            this.f6514a = observer;
        }

        public final void mo1598a(T t) {
            this.f6514a.mo1598a((Object) t);
        }

        public final void mo1599a(Throwable th) {
            this.f6514a.mo1599a(th);
        }

        public final void N_() {
            this.f6514a.N_();
        }
    }

    public final void mo1602a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        final SubjectObserver subjectObserver = new SubjectObserver(subscriber);
        subscriber.m11202a(Subscriptions.m11665a(new Action0(this) {
            final /* synthetic */ SubjectSubscriptionManager f7204b;

            public final void mo1603a() {
                this.f7204b.m11275a(subjectObserver);
            }
        }));
        this.f6505f.mo1602a(subjectObserver);
        if (!subscriber.mo1601c()) {
            Object obj2;
            State state;
            Object obj3;
            do {
                state = this.f6502a;
                if (state.f6512a) {
                    this.f6507h.mo1602a(subjectObserver);
                    obj2 = null;
                    break;
                }
                int length = state.f6513b.length;
                obj3 = new SubjectObserver[(length + 1)];
                System.arraycopy(state.f6513b, 0, obj3, 0, length);
                obj3[length] = subjectObserver;
            } while (!f6500b.compareAndSet(this, state, new State(state.f6512a, obj3)));
            this.f6506g.mo1602a(subjectObserver);
            obj2 = 1;
            if (obj2 != null && subscriber.mo1601c()) {
                m11275a(subjectObserver);
            }
        }
    }

    SubjectSubscriptionManager() {
    }

    final SubjectObserver<T>[] m11276b(Object obj) {
        this.f6503c = obj;
        this.f6504e = false;
        if (this.f6502a.f6512a) {
            return State.f6509c;
        }
        return ((State) f6500b.getAndSet(this, State.f6510d)).f6513b;
    }

    final void m11275a(SubjectObserver<T> subjectObserver) {
        State state;
        State b;
        do {
            state = this.f6502a;
            if (!state.f6512a) {
                b = state.m11278b(subjectObserver);
                if (b == state) {
                    return;
                }
            } else {
                return;
            }
        } while (!f6500b.compareAndSet(this, state, b));
    }
}
