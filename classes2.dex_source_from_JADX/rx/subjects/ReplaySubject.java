package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager.SubjectObserver;

/* compiled from: rtc_conferencing_peer_to_peer_can_receive */
public final class ReplaySubject<T> extends Subject<T, T> {
    final ReplayState<T, ?> f6482b;
    final SubjectSubscriptionManager<T> f6483c;

    /* compiled from: rtc_conferencing_peer_to_peer_can_receive */
    public final class UnboundedReplayState<T> {
        public static final AtomicIntegerFieldUpdater<UnboundedReplayState> f6492b = AtomicIntegerFieldUpdater.newUpdater(UnboundedReplayState.class, "a");
        volatile int f6493a;
        private final NotificationLite<T> f6494c = NotificationLite.f6497a;
        public final ArrayList<Object> f6495d;
        public volatile boolean f6496e;

        public final void m11267a(SubjectObserver<? super T> subjectObserver) {
            Integer num = (Integer) subjectObserver.f6517d;
            if (num != null) {
                subjectObserver.f6517d = Integer.valueOf(m11265a(num, subjectObserver).intValue());
                return;
            }
            throw new IllegalStateException("failed to find lastEmittedLink for: " + subjectObserver);
        }

        public UnboundedReplayState(int i) {
            this.f6495d = new ArrayList(i);
        }

        public final void m11266a(Throwable th) {
            if (!this.f6496e) {
                this.f6496e = true;
                this.f6495d.add(NotificationLite.m11269a(th));
                f6492b.getAndIncrement(this);
            }
        }

        public final Integer m11265a(Integer num, SubjectObserver<? super T> subjectObserver) {
            int intValue = num.intValue();
            while (intValue < this.f6493a) {
                NotificationLite.m11271a(subjectObserver, this.f6495d.get(intValue));
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
    }

    /* compiled from: rtc_conferencing_peer_to_peer_can_receive */
    final class C02931 implements Action1<SubjectObserver<T>> {
        final /* synthetic */ UnboundedReplayState f6519a;

        C02931(UnboundedReplayState unboundedReplayState) {
            this.f6519a = unboundedReplayState;
        }

        public final void mo1602a(Object obj) {
            SubjectObserver subjectObserver = (SubjectObserver) obj;
            subjectObserver.f6517d = Integer.valueOf(this.f6519a.m11265a(Integer.valueOf(0), subjectObserver).intValue());
        }
    }

    /* compiled from: rtc_conferencing_peer_to_peer_can_receive */
    final class C02942 implements Action1<SubjectObserver<T>> {
        final /* synthetic */ UnboundedReplayState f6520a;

        C02942(UnboundedReplayState unboundedReplayState) {
            this.f6520a = unboundedReplayState;
        }

        public final void mo1602a(Object obj) {
            SubjectObserver subjectObserver = (SubjectObserver) obj;
            Integer num = (Integer) subjectObserver.f6517d;
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.f6520a.m11265a(num, subjectObserver);
        }
    }

    public static <T> ReplaySubject<T> m11235d() {
        return m11233a(16);
    }

    public static <T> ReplaySubject<T> m11233a(int i) {
        UnboundedReplayState unboundedReplayState = new UnboundedReplayState(i);
        Object subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.f6505f = new C02931(unboundedReplayState);
        subjectSubscriptionManager.f6507h = new C02942(unboundedReplayState);
        return new ReplaySubject(subjectSubscriptionManager, subjectSubscriptionManager, unboundedReplayState);
    }

    private ReplaySubject(OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, ReplayState<T, ?> replayState) {
        super(onSubscribe);
        this.f6483c = subjectSubscriptionManager;
        this.f6482b = replayState;
    }

    public final void mo1598a(T t) {
        if (this.f6483c.f6504e) {
            UnboundedReplayState unboundedReplayState = this.f6482b;
            if (!unboundedReplayState.f6496e) {
                unboundedReplayState.f6495d.add(NotificationLite.m11268a((Object) t));
                UnboundedReplayState.f6492b.getAndIncrement(unboundedReplayState);
            }
            for (SubjectObserver subjectObserver : this.f6483c.f6502a.f6513b) {
                if (m11234a(subjectObserver)) {
                    subjectObserver.mo1598a((Object) t);
                }
            }
        }
    }

    public final void mo1599a(Throwable th) {
        if (this.f6483c.f6504e) {
            this.f6482b.m11266a(th);
            List list = null;
            SubjectSubscriptionManager subjectSubscriptionManager = this.f6483c;
            NotificationLite.m11270a();
            for (SubjectObserver subjectObserver : subjectSubscriptionManager.m11276b(NotificationLite.m11269a(th))) {
                try {
                    if (m11234a(subjectObserver)) {
                        subjectObserver.mo1599a(th);
                    }
                } catch (Throwable th2) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(th2);
                }
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                Exceptions.a((Throwable) list.get(0));
                return;
            }
            throw new CompositeException(list);
        }
    }

    public final void N_() {
        if (this.f6483c.f6504e) {
            UnboundedReplayState unboundedReplayState = this.f6482b;
            if (!unboundedReplayState.f6496e) {
                unboundedReplayState.f6496e = true;
                unboundedReplayState.f6495d.add(NotificationLite.f6498b);
                UnboundedReplayState.f6492b.getAndIncrement(unboundedReplayState);
            }
            SubjectSubscriptionManager subjectSubscriptionManager = this.f6483c;
            NotificationLite notificationLite = NotificationLite.f6497a;
            for (SubjectObserver subjectObserver : subjectSubscriptionManager.m11276b(NotificationLite.f6498b)) {
                if (m11234a(subjectObserver)) {
                    subjectObserver.N_();
                }
            }
        }
    }

    private boolean m11234a(SubjectObserver<? super T> subjectObserver) {
        if (subjectObserver.f6516c) {
            return true;
        }
        subjectObserver.f6516c = true;
        this.f6482b.m11267a((SubjectObserver) subjectObserver);
        subjectObserver.f6517d = null;
        return false;
    }
}
