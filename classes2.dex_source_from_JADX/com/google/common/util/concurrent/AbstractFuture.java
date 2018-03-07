package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import sun.misc.Unsafe;

@GwtCompatible
/* compiled from: whitelist_type */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    private static final boolean f780a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger f781b = Logger.getLogger(AbstractFuture.class.getName());
    public static final AtomicHelper f782c;
    private static final Object f783d = new Object();
    public volatile Object f784e;
    public volatile Listener f785f;
    public volatile Waiter f786g;

    /* compiled from: whitelist_type */
    public abstract class TrustedFuture<V> extends AbstractFuture<V> {
        TrustedFuture() {
        }
    }

    /* compiled from: whitelist_type */
    final class UnsafeAtomicHelper extends AtomicHelper {
        static final Unsafe f787a;
        static final long f788b;
        static final long f789c;
        static final long f790d;
        static final long f791e;
        static final long f792f;

        /* compiled from: whitelist_type */
        final class C00521 implements PrivilegedExceptionAction<Unsafe> {
            C00521() {
            }

            public final Object run() {
                Class cls = Unsafe.class;
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (cls.isInstance(obj)) {
                        return (Unsafe) cls.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException e) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new C00521());
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            }
            try {
                Class cls = AbstractFuture.class;
                f789c = unsafe.objectFieldOffset(cls.getDeclaredField("waiters"));
                f788b = unsafe.objectFieldOffset(cls.getDeclaredField("listeners"));
                f790d = unsafe.objectFieldOffset(cls.getDeclaredField("value"));
                f791e = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("b"));
                f792f = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("c"));
                f787a = unsafe;
            } catch (Throwable e3) {
                throw Throwables.propagate(e3);
            }
        }

        final void mo225a(Waiter waiter, Thread thread) {
            f787a.putObject(waiter, f791e, thread);
        }

        final void mo224a(Waiter waiter, Waiter waiter2) {
            f787a.putObject(waiter, f792f, waiter2);
        }

        final boolean mo227a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return f787a.compareAndSwapObject(abstractFuture, f789c, waiter, waiter2);
        }

        final boolean mo226a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return f787a.compareAndSwapObject(abstractFuture, f788b, listener, listener2);
        }

        final boolean mo228a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return f787a.compareAndSwapObject(abstractFuture, f790d, obj, obj2);
        }
    }

    /* compiled from: whitelist_type */
    public abstract class AtomicHelper {
        abstract void mo224a(Waiter waiter, Waiter waiter2);

        abstract void mo225a(Waiter waiter, Thread thread);

        public abstract boolean mo226a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        public abstract boolean mo227a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract boolean mo228a(AbstractFuture<?> abstractFuture, Object obj, Object obj2);
    }

    /* compiled from: whitelist_type */
    final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<Waiter, Thread> f793a;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f794b;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f795c;
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f796d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f797e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            this.f793a = atomicReferenceFieldUpdater;
            this.f794b = atomicReferenceFieldUpdater2;
            this.f795c = atomicReferenceFieldUpdater3;
            this.f796d = atomicReferenceFieldUpdater4;
            this.f797e = atomicReferenceFieldUpdater5;
        }

        final void mo225a(Waiter waiter, Thread thread) {
            this.f793a.lazySet(waiter, thread);
        }

        final void mo224a(Waiter waiter, Waiter waiter2) {
            this.f794b.lazySet(waiter, waiter2);
        }

        final boolean mo227a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return this.f795c.compareAndSet(abstractFuture, waiter, waiter2);
        }

        final boolean mo226a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return this.f796d.compareAndSet(abstractFuture, listener, listener2);
        }

        final boolean mo228a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f797e.compareAndSet(abstractFuture, obj, obj2);
        }
    }

    /* compiled from: whitelist_type */
    public final class Waiter {
        public static final Waiter f798a = new Waiter((byte) 0);
        @Nullable
        public volatile Thread f799b;
        @Nullable
        volatile Waiter f800c;

        private Waiter(byte b) {
        }

        Waiter() {
            AbstractFuture.f782c.mo225a(this, Thread.currentThread());
        }

        final void m1583a(Waiter waiter) {
            AbstractFuture.f782c.mo224a(this, waiter);
        }
    }

    /* compiled from: whitelist_type */
    public final class Listener {
        public static final Listener f801a = new Listener(null, null);
        final Runnable f802b;
        final Executor f803c;
        @Nullable
        Listener f804d;

        Listener(Runnable runnable, Executor executor) {
            this.f802b = runnable;
            this.f803c = executor;
        }
    }

    /* compiled from: whitelist_type */
    final class SetFuture implements Runnable {
        final ListenableFuture<? extends V> f811a;
        final /* synthetic */ AbstractFuture f812b;

        SetFuture(AbstractFuture abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f812b = abstractFuture;
            this.f811a = listenableFuture;
        }

        public final void run() {
            if (this.f812b.f784e == this) {
                AbstractFuture.m1556a(this.f812b, this.f811a, this);
            }
        }
    }

    /* compiled from: whitelist_type */
    final class Cancellation {
        final boolean f813a;
        @Nullable
        final Throwable f814b;

        Cancellation(boolean z, @Nullable Throwable th) {
            this.f813a = z;
            this.f814b = th;
        }
    }

    /* compiled from: whitelist_type */
    public final class Failure {
        static final Failure f815a = new Failure(new 1("Failure occurred while trying to finish a future."));
        public final Throwable f816b;

        Failure(Throwable th) {
            this.f816b = (Throwable) Preconditions.checkNotNull(th);
        }
    }

    static {
        AtomicHelper unsafeAtomicHelper;
        Throwable th;
        try {
            unsafeAtomicHelper = new UnsafeAtomicHelper();
        } catch (Throwable th2) {
            f781b.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            f781b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
            unsafeAtomicHelper = new SynchronizedHelper();
        }
        f782c = unsafeAtomicHelper;
    }

    private void m1555a(Waiter waiter) {
        waiter.f799b = null;
        while (true) {
            Waiter waiter2 = this.f786g;
            if (waiter2 != Waiter.f798a) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f800c;
                    if (waiter2.f799b == null) {
                        if (waiter3 != null) {
                            waiter3.f800c = waiter4;
                            if (waiter3.f799b == null) {
                            }
                        } else if (f782c.mo227a(this, waiter2, waiter4)) {
                        }
                        waiter2 = waiter3;
                    }
                    waiter3 = waiter2;
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    protected AbstractFuture() {
    }

    public V get(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f784e;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return m1557b(obj);
        }
        long nanoTime;
        long j2;
        if (toNanos > 0) {
            nanoTime = System.nanoTime() + toNanos;
        } else {
            nanoTime = 0;
        }
        Object obj2;
        if (toNanos >= 1000) {
            Waiter waiter = this.f786g;
            if (waiter != Waiter.f798a) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.m1583a(waiter);
                    if (f782c.mo227a(this, waiter, waiter2)) {
                        j2 = toNanos;
                        do {
                            LockSupport.parkNanos(this, j2);
                            if (Thread.interrupted()) {
                                m1555a(waiter2);
                                throw new InterruptedException();
                            }
                            obj2 = this.f784e;
                            if (((obj2 != null ? 1 : 0) & (!(obj2 instanceof SetFuture) ? 1 : 0)) != 0) {
                                return m1557b(obj2);
                            }
                            j2 = nanoTime - System.nanoTime();
                        } while (j2 >= 1000);
                        m1555a(waiter2);
                    } else {
                        waiter = this.f786g;
                    }
                } while (waiter != Waiter.f798a);
            }
            return m1557b(this.f784e);
        }
        j2 = toNanos;
        while (j2 > 0) {
            obj2 = this.f784e;
            if (((obj2 != null ? 1 : 0) & (!(obj2 instanceof SetFuture) ? 1 : 0)) != 0) {
                return m1557b(obj2);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            j2 = nanoTime - System.nanoTime();
        }
        throw new TimeoutException();
    }

    public V get() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f784e;
        if (((obj != null ? 1 : 0) & (!(obj instanceof SetFuture) ? 1 : 0)) != 0) {
            return m1557b(obj);
        }
        Waiter waiter = this.f786g;
        if (waiter != Waiter.f798a) {
            Waiter waiter2 = new Waiter();
            do {
                waiter2.m1583a(waiter);
                if (f782c.mo227a(this, waiter, waiter2)) {
                    Object obj2;
                    int i;
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m1555a(waiter2);
                            throw new InterruptedException();
                        }
                        obj2 = this.f784e;
                        if (obj2 != null) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } while ((i & (!(obj2 instanceof SetFuture) ? 1 : 0)) == 0);
                    return m1557b(obj2);
                }
                waiter = this.f786g;
            } while (waiter != Waiter.f798a);
        }
        return m1557b(this.f784e);
    }

    private static V m1557b(Object obj) {
        if (obj instanceof Cancellation) {
            throw m1554a("Task was cancelled.", ((Cancellation) obj).f814b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f816b);
        } else if (obj == f783d) {
            return null;
        } else {
            return obj;
        }
    }

    public boolean isDone() {
        int i = 1;
        Object obj = this.f784e;
        int i2 = obj != null ? 1 : 0;
        if (obj instanceof SetFuture) {
            i = 0;
        }
        return i2 & i;
    }

    public boolean isCancelled() {
        return this.f784e instanceof Cancellation;
    }

    public boolean cancel(boolean z) {
        Object obj = this.f784e;
        if (((obj == null ? 1 : 0) | (obj instanceof SetFuture)) != 0) {
            Throwable cancellationException;
            if (f780a) {
                cancellationException = new CancellationException("Future.cancel() was called.");
            } else {
                cancellationException = null;
            }
            Object cancellation = new Cancellation(z, cancellationException);
            Object obj2 = obj;
            while (!f782c.mo228a(this, obj2, cancellation)) {
                obj2 = this.f784e;
                if (!(obj2 instanceof SetFuture)) {
                }
            }
            if (z) {
                mo2679a();
            }
            m1559g();
            if (!(obj2 instanceof SetFuture)) {
                return true;
            }
            ((SetFuture) obj2).f811a.cancel(z);
            return true;
        }
        return false;
    }

    protected void mo2679a() {
    }

    public final boolean m1565b() {
        Object obj = this.f784e;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f813a;
    }

    public void mo223a(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        Listener listener = this.f785f;
        if (listener != Listener.f801a) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f804d = listener;
                if (!f782c.mo226a(this, listener, listener2)) {
                    listener = this.f785f;
                } else {
                    return;
                }
            } while (listener != Listener.f801a);
        }
        m1558b(runnable, executor);
    }

    public boolean mo221a(@Nullable V v) {
        if (v == null) {
            Object obj = f783d;
        }
        if (!f782c.mo228a(this, null, obj)) {
            return false;
        }
        m1559g();
        return true;
    }

    public boolean mo222a(Throwable th) {
        if (!f782c.mo228a(this, null, new Failure((Throwable) Preconditions.checkNotNull(th)))) {
            return false;
        }
        m1559g();
        return true;
    }

    @Beta
    protected boolean mo220a(ListenableFuture<? extends V> listenableFuture) {
        Object setFuture;
        Preconditions.checkNotNull(listenableFuture);
        Object obj = this.f784e;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                return m1556a(this, listenableFuture, null);
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (f782c.mo228a(this, null, setFuture)) {
                try {
                    listenableFuture.mo223a(setFuture, MoreExecutors.m1816c());
                } catch (Throwable th) {
                    obj = Failure.f815a;
                }
                return true;
            }
            obj = this.f784e;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f813a);
        }
        return false;
        f782c.mo228a(this, setFuture, obj);
        return true;
    }

    public static boolean m1556a(AbstractFuture abstractFuture, ListenableFuture listenableFuture, Object obj) {
        Object obj2;
        if (listenableFuture instanceof TrustedFuture) {
            obj2 = ((AbstractFuture) listenableFuture).f784e;
        } else {
            try {
                obj2 = Uninterruptibles.m1584a((Future) listenableFuture);
                if (obj2 == null) {
                    obj2 = f783d;
                }
            } catch (ExecutionException e) {
                obj2 = new Failure(e.getCause());
            } catch (Throwable e2) {
                obj2 = new Cancellation(false, e2);
            } catch (Throwable e22) {
                obj2 = new Failure(e22);
            }
        }
        if (!f782c.mo228a(abstractFuture, obj, obj2)) {
            return false;
        }
        abstractFuture.m1559g();
        return true;
    }

    void mo2651c() {
    }

    private void m1559g() {
        Listener listener;
        Waiter waiter;
        do {
            waiter = this.f786g;
        } while (!f782c.mo227a(this, waiter, Waiter.f798a));
        for (Waiter waiter2 = waiter; waiter2 != null; waiter2 = waiter2.f800c) {
            Thread thread = waiter2.f799b;
            if (thread != null) {
                waiter2.f799b = null;
                LockSupport.unpark(thread);
            }
        }
        do {
            listener = this.f785f;
        } while (!f782c.mo226a(this, listener, Listener.f801a));
        Listener listener2 = listener;
        Listener listener3 = null;
        while (listener2 != null) {
            Listener listener4 = listener2.f804d;
            listener2.f804d = listener3;
            listener3 = listener2;
            listener2 = listener4;
        }
        while (listener3 != null) {
            m1558b(listener3.f802b, listener3.f803c);
            listener3 = listener3.f804d;
        }
        mo2651c();
    }

    private static void m1558b(Runnable runnable, Executor executor) {
        try {
            ExecutorDetour.a(executor, runnable, 1385640313);
        } catch (Throwable e) {
            f781b.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    static final CancellationException m1554a(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
