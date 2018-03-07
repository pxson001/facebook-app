package rx.internal.operators;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observable$Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.SubscriptionIndexedRingBuffer;

/* compiled from: boosted_post */
public class OperatorMerge<T> implements Observable$Operator<T, Observable<? extends T>> {
    private final boolean f7769a = false;

    /* compiled from: boosted_post */
    final class InnerSubscriber<T> extends Subscriber<T> {
        static final AtomicIntegerFieldUpdater<InnerSubscriber> f7744e = AtomicIntegerFieldUpdater.newUpdater(InnerSubscriber.class, "d");
        public int f7745a;
        final MergeSubscriber<T> f7746b;
        final MergeProducer<T> f7747c;
        volatile int f7748d;
        int f7749f = 0;
        final int f7750g = ((int) (((double) this.f7751h.f7856f) * 0.7d));
        public final RxRingBuffer f7751h = RxRingBuffer.m14006d();

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, MergeProducer<T> mergeProducer) {
            this.f7746b = mergeSubscriber;
            this.f7747c = mergeProducer;
            a(this.f7751h);
            a((long) this.f7751h.f7856f);
        }

        public final void m13914a(T t) {
            m13909a(t, false);
        }

        public final void m13915a(Throwable th) {
            if (f7744e.compareAndSet(this, 0, 1)) {
                MergeSubscriber.m13918a(this.f7746b, th, false);
            }
        }

        public final void N_() {
            if (f7744e.compareAndSet(this, 0, 1)) {
                m13909a(null, true);
            }
        }

        private void m13909a(T t, boolean z) {
            int i;
            boolean z2;
            boolean z3 = true;
            if (this.f7746b.m13926g()) {
                try {
                    int i2;
                    this.f7749f += m13913g(this);
                    if (this.f7747c == null) {
                        if (z) {
                            this.f7746b.m13934a(this);
                            i2 = 0;
                        } else {
                            try {
                                this.f7746b.f7757b.a(t);
                            } catch (Throwable th) {
                                m13915a(OnErrorThrowable.m13877a(th, t));
                            }
                            this.f7749f++;
                            i2 = 0;
                        }
                    } else if (this.f7747c.f7754c <= 0 || this.f7751h.m14011g() != 0) {
                        i2 = 1;
                    } else if (z) {
                        this.f7746b.m13934a(this);
                        i2 = 0;
                    } else {
                        try {
                            this.f7746b.f7757b.a(t);
                        } catch (Throwable th2) {
                            m13915a(OnErrorThrowable.m13877a(th2, t));
                        }
                        this.f7749f++;
                        MergeProducer.f7752a.decrementAndGet(this.f7747c);
                        i2 = 0;
                    }
                    boolean g = this.f7746b.m13924f();
                    if (this.f7749f > this.f7750g) {
                        a((long) this.f7749f);
                        this.f7749f = 0;
                    }
                    i = i2;
                    z2 = g;
                } catch (Throwable th3) {
                    this.f7746b.m13924f();
                }
            } else {
                z2 = false;
                i = 1;
            }
            if (i != 0) {
                m13910b(t, z);
            } else {
                z3 = z2;
            }
            if (z3) {
                MergeSubscriber.m13928h(this.f7746b);
            }
        }

        private void m13910b(T t, boolean z) {
            if (z) {
                try {
                    this.f7751h.m14010e();
                    return;
                } catch (Throwable e) {
                    m13915a(e);
                    return;
                }
            }
            this.f7751h.m14007a(t);
        }

        private int m13911e() {
            int i = 0;
            long j = this.f7747c.f7754c;
            for (int i2 = 0; ((long) i2) < j; i2++) {
                Object i3 = this.f7751h.m14013i();
                if (i3 == null) {
                    break;
                }
                if (NotificationLite.b(i3)) {
                    this.f7746b.m13934a(this);
                } else {
                    try {
                        if (!RxRingBuffer.m14005a(i3, this.f7746b.f7757b)) {
                            i++;
                        }
                    } catch (Throwable th) {
                        m13915a(OnErrorThrowable.m13877a(th, i3));
                    }
                }
            }
            MergeProducer.f7752a.getAndAdd(this.f7747c, (long) (-i));
            return i;
        }

        private int m13912f() {
            int i = 0;
            while (true) {
                Object i2 = this.f7751h.m14013i();
                if (i2 == null) {
                    return i;
                }
                if (NotificationLite.b(i2)) {
                    this.f7746b.m13934a(this);
                } else {
                    try {
                        if (!RxRingBuffer.m14005a(i2, this.f7746b.f7757b)) {
                            i++;
                        }
                    } catch (Throwable th) {
                        m13915a(OnErrorThrowable.m13877a(th, i2));
                    }
                }
            }
        }

        public static int m13913g(InnerSubscriber innerSubscriber) {
            if (innerSubscriber.f7747c != null) {
                return innerSubscriber.m13911e();
            }
            return innerSubscriber.m13912f();
        }
    }

    /* compiled from: boosted_post */
    final class MergeProducer<T> implements Producer {
        static final AtomicLongFieldUpdater<MergeProducer> f7752a = AtomicLongFieldUpdater.newUpdater(MergeProducer.class, "c");
        private final MergeSubscriber<T> f7753b;
        public volatile long f7754c = 0;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.f7753b = mergeSubscriber;
        }

        public final void mo1024a(long j) {
            if (this.f7754c != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE) {
                    this.f7754c = Long.MAX_VALUE;
                    return;
                }
                f7752a.getAndAdd(this, j);
                if (MergeSubscriber.m13928h(this.f7753b)) {
                    Object obj = null;
                    synchronized (this.f7753b) {
                        if (this.f7753b.f7761f == 0 && this.f7753b.f7766k != null && this.f7753b.f7766k.m14012h()) {
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        MergeSubscriber.m13931k(this.f7753b);
                    }
                }
            }
        }
    }

    /* compiled from: boosted_post */
    final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        final NotificationLite<T> f7756a = NotificationLite.a;
        final Subscriber<? super T> f7757b;
        int f7758c = 0;
        final Func1<InnerSubscriber<T>, Boolean> f7759d = new C08801(this);
        public final MergeProducer<T> f7760e;
        public int f7761f;
        private boolean f7762g;
        private final boolean f7763h;
        private ConcurrentLinkedQueue<Throwable> f7764i;
        private volatile SubscriptionIndexedRingBuffer<InnerSubscriber<T>> f7765j;
        public RxRingBuffer f7766k = null;
        private int f7767l = 0;
        private boolean f7768m = false;

        /* compiled from: boosted_post */
        class C08801 implements Func1<InnerSubscriber<T>, Boolean> {
            final /* synthetic */ MergeSubscriber f7755a;

            C08801(MergeSubscriber mergeSubscriber) {
                this.f7755a = mergeSubscriber;
            }

            public final Object mo611a(Object obj) {
                InnerSubscriber innerSubscriber = (InnerSubscriber) obj;
                if (innerSubscriber.f7751h != null) {
                    long j = this.f7755a.f7760e.f7754c;
                    int g = InnerSubscriber.m13913g(innerSubscriber) + 0;
                    if (g > 0) {
                        g += innerSubscriber.f7749f;
                        innerSubscriber.f7749f = 0;
                        innerSubscriber.a((long) g);
                    }
                    if (((long) g) == j) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }

        public final void m13932a(Object obj) {
            Observable observable = (Observable) obj;
            if (observable instanceof ScalarSynchronousObservable) {
                m13919a((ScalarSynchronousObservable) observable);
            } else if (observable != null && !c()) {
                synchronized (this) {
                    this.f7761f++;
                }
                m13920b(observable);
            }
        }

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z) {
            super(subscriber);
            this.f7757b = subscriber;
            this.f7760e = new MergeProducer(this);
            this.f7763h = z;
            subscriber.a(this);
            subscriber.a(this.f7760e);
        }

        public final void m13935d() {
            a((long) RxRingBuffer.f7850c);
        }

        private void m13920b(Observable<? extends T> observable) {
            if (this.f7765j == null) {
                this.f7765j = new SubscriptionIndexedRingBuffer();
                a(this.f7765j);
            }
            MergeProducer mergeProducer = null;
            if (this.f7760e.f7754c != Long.MAX_VALUE) {
                mergeProducer = this.f7760e;
            }
            Subscription innerSubscriber = new InnerSubscriber(this, mergeProducer);
            innerSubscriber.f7745a = this.f7765j.m14019a(innerSubscriber);
            observable.a(innerSubscriber);
            a(1);
        }

        private void m13919a(ScalarSynchronousObservable<? extends T> scalarSynchronousObservable) {
            if (this.f7760e.f7754c == Long.MAX_VALUE) {
                m13921b((ScalarSynchronousObservable) scalarSynchronousObservable);
            } else {
                m13922c(scalarSynchronousObservable);
            }
        }

        private void m13921b(ScalarSynchronousObservable<? extends T> scalarSynchronousObservable) {
            Object d = scalarSynchronousObservable.m14017d();
            if (m13926g()) {
                try {
                    this.f7757b.a(d);
                } finally {
                    if (m13924f()) {
                        m13928h(this);
                    }
                    a(1);
                }
            } else {
                m13923e();
                try {
                    this.f7766k.m14007a(d);
                } catch (Throwable e) {
                    m13933a(e);
                }
            }
        }

        private void m13922c(ScalarSynchronousObservable<? extends T> scalarSynchronousObservable) {
            if (m13926g()) {
                try {
                    if (this.f7760e.f7754c > 0) {
                        this.f7757b.a(scalarSynchronousObservable.m14017d());
                        MergeProducer.f7752a.decrementAndGet(this.f7760e);
                        if (m13924f()) {
                            m13928h(this);
                        }
                        a(1);
                        return;
                    } else if (m13924f()) {
                        m13928h(this);
                    }
                } catch (Throwable th) {
                    if (m13924f()) {
                        m13928h(this);
                    }
                    if (null != null) {
                        a(1);
                    }
                }
            }
            m13923e();
            try {
                this.f7766k.m14007a(scalarSynchronousObservable.m14017d());
            } catch (Throwable e) {
                m13933a(e);
            }
        }

        private void m13923e() {
            if (this.f7766k == null) {
                this.f7766k = RxRingBuffer.m14006d();
                a(this.f7766k);
            }
        }

        private synchronized boolean m13924f() {
            boolean z = false;
            synchronized (this) {
                this.f7768m = false;
                if (this.f7767l != 0) {
                    z = true;
                }
            }
            return z;
        }

        private synchronized boolean m13926g() {
            boolean z = false;
            synchronized (this) {
                if (this.f7768m) {
                    this.f7767l++;
                } else {
                    this.f7768m = true;
                    this.f7767l = 0;
                    z = true;
                }
            }
            return z;
        }

        public static boolean m13928h(MergeSubscriber mergeSubscriber) {
            int j;
            Throwable th;
            while (mergeSubscriber.m13926g()) {
                boolean f;
                try {
                    j = mergeSubscriber.m13930j();
                    try {
                        mergeSubscriber.m13929i();
                        f = mergeSubscriber.m13924f();
                        if (j > 0) {
                            mergeSubscriber.a((long) j);
                            continue;
                        }
                        if (!f) {
                            return true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    j = 0;
                    th = th4;
                }
            }
            return false;
            f = mergeSubscriber.m13924f();
            if (j > 0) {
                mergeSubscriber.a((long) j);
            }
            if (!f) {
                return true;
            }
            throw th;
        }

        private void m13929i() {
            if (this.f7765j != null) {
                this.f7758c = this.f7765j.m14020a(this.f7759d, this.f7758c);
            }
        }

        private int m13930j() {
            int i = 0;
            if (this.f7766k != null) {
                long j = this.f7760e.f7754c;
                if (j < 0) {
                    while (true) {
                        Object i2 = this.f7766k.m14013i();
                        if (i2 == null) {
                            break;
                        }
                        NotificationLite.a(this.f7757b, i2);
                        i++;
                    }
                } else if (j > 0) {
                    int i3 = 0;
                    while (((long) i3) < j) {
                        Object i4 = this.f7766k.m14013i();
                        if (i4 == null) {
                            break;
                        }
                        NotificationLite.a(this.f7757b, i4);
                        i3++;
                        i++;
                    }
                    MergeProducer.f7752a.getAndAdd(this.f7760e, (long) (-i));
                }
            }
            return i;
        }

        public final void m13933a(Throwable th) {
            if (!this.f7762g) {
                this.f7762g = true;
                m13918a(this, th, true);
            }
        }

        public static void m13918a(MergeSubscriber mergeSubscriber, Throwable th, boolean z) {
            if (mergeSubscriber.f7763h) {
                synchronized (mergeSubscriber) {
                    if (mergeSubscriber.f7764i == null) {
                        mergeSubscriber.f7764i = new ConcurrentLinkedQueue();
                    }
                }
                mergeSubscriber.f7764i.add(th);
                Object obj = null;
                synchronized (mergeSubscriber) {
                    if (!z) {
                        mergeSubscriber.f7761f--;
                    }
                    if ((mergeSubscriber.f7761f == 0 && mergeSubscriber.f7762g) || mergeSubscriber.f7761f < 0) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    m13931k(mergeSubscriber);
                    return;
                }
                return;
            }
            mergeSubscriber.f7757b.a(th);
        }

        public final void N_() {
            Object obj = null;
            synchronized (this) {
                this.f7762g = true;
                if (this.f7761f == 0 && (this.f7766k == null || this.f7766k.m14012h())) {
                    obj = 1;
                }
            }
            if (obj != null) {
                m13931k(this);
            }
        }

        final void m13934a(InnerSubscriber<T> innerSubscriber) {
            Object obj = null;
            synchronized (this) {
                this.f7761f--;
                if (this.f7761f == 0 && this.f7762g) {
                    obj = 1;
                }
            }
            this.f7765j.m14021a(innerSubscriber.f7745a);
            if (obj != null) {
                m13931k(this);
            }
        }

        public static void m13931k(MergeSubscriber mergeSubscriber) {
            m13928h(mergeSubscriber);
            if (mergeSubscriber.f7763h) {
                Collection collection;
                synchronized (mergeSubscriber) {
                    collection = mergeSubscriber.f7764i;
                }
                if (collection == null || collection.isEmpty()) {
                    mergeSubscriber.f7757b.N_();
                    return;
                } else if (collection.size() == 1) {
                    mergeSubscriber.f7757b.a((Throwable) collection.poll());
                    return;
                } else {
                    mergeSubscriber.f7757b.a(new CompositeException(collection, (byte) 0));
                    return;
                }
            }
            mergeSubscriber.f7757b.N_();
        }
    }

    public final Object mo611a(Object obj) {
        return new MergeSubscriber((Subscriber) obj, this.f7769a);
    }
}
