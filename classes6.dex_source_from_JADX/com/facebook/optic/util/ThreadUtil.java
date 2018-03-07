package com.facebook.optic.util;

import android.os.Handler;
import android.os.Looper;
import com.facebook.optic.Callback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: tags_user */
public class ThreadUtil {
    private static ThreadPoolExecutor f3350a = m4414d();
    private static final ThreadPoolExecutor f3351b = m4414d();
    public static final HashSet<FutureTask> f3352c = new HashSet();
    public static final HashSet<Runnable> f3353d = new HashSet();
    public static final Handler f3354e = new Handler(Looper.getMainLooper());

    /* compiled from: tags_user */
    final class C02081 implements Runnable {
        final /* synthetic */ FutureTask f3344a;
        final /* synthetic */ Callback f3345b;

        C02081(FutureTask futureTask, Callback callback) {
            this.f3344a = futureTask;
            this.f3345b = callback;
        }

        public final void run() {
            try {
                ThreadUtil.m4412b(this.f3345b, FutureDetour.a(this.f3344a, 1439567252));
            } catch (CancellationException e) {
            } catch (Exception e2) {
                ThreadUtil.m4411b(this.f3345b, e2);
            } finally {
                ThreadUtil.f3352c.remove(this.f3344a);
                ThreadUtil.f3353d.remove(this);
            }
        }
    }

    /* compiled from: tags_user */
    final class C02092 implements Runnable {
        final /* synthetic */ Callback f3346a;
        final /* synthetic */ Exception f3347b;

        C02092(Callback callback, Exception exception) {
            this.f3346a = callback;
            this.f3347b = exception;
        }

        public final void run() {
            this.f3346a.mo208a(this.f3347b);
        }
    }

    /* compiled from: tags_user */
    final class C02103 implements Runnable {
        final /* synthetic */ Callback f3348a;
        final /* synthetic */ Object f3349b;

        C02103(Callback callback, Object obj) {
            this.f3348a = callback;
            this.f3349b = obj;
        }

        public final void run() {
            this.f3348a.mo209a(this.f3349b);
        }
    }

    /* compiled from: tags_user */
    class FinalisableThreadPoolExecutor extends ThreadPoolExecutor {
        public FinalisableThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        protected void finalize() {
            super.finalize();
            shutdown();
        }
    }

    public static synchronized <T> void m4410a(FutureTask<T> futureTask, Callback<T> callback) {
        synchronized (ThreadUtil.class) {
            Runnable c02081 = new C02081(futureTask, callback);
            f3353d.add(c02081);
            ExecutorDetour.a(f3351b, c02081, -1505413092);
        }
    }

    public static synchronized void m4409a(FutureTask futureTask) {
        synchronized (ThreadUtil.class) {
            m4413b(futureTask, null);
        }
    }

    public static synchronized <T> void m4413b(FutureTask<T> futureTask, Callback<T> callback) {
        synchronized (ThreadUtil.class) {
            m4410a(futureTask, callback);
            f3352c.add(futureTask);
            ExecutorDetour.a(f3350a, futureTask, 1193467017);
        }
    }

    public static synchronized void m4407a() {
        synchronized (ThreadUtil.class) {
            if (m4415e()) {
                Iterator it = f3353d.iterator();
                while (it.hasNext()) {
                    f3351b.remove((Runnable) it.next());
                }
                f3353d.clear();
                it = f3352c.iterator();
                while (it.hasNext()) {
                    FutureTask futureTask = (FutureTask) it.next();
                    futureTask.cancel(false);
                    f3350a.remove(futureTask);
                }
                f3352c.clear();
                f3350a.shutdown();
                try {
                    f3350a.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                }
                f3350a = m4414d();
            } else {
                throw new RuntimeException("Background tasks may only be terminated on the UI thread");
            }
        }
    }

    private static synchronized ThreadPoolExecutor m4414d() {
        ThreadPoolExecutor finalisableThreadPoolExecutor;
        synchronized (ThreadUtil.class) {
            finalisableThreadPoolExecutor = new FinalisableThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        return finalisableThreadPoolExecutor;
    }

    private static boolean m4415e() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void m4408a(Runnable runnable) {
        HandlerDetour.a(f3354e, runnable, -2116828578);
    }

    public static <T> void m4411b(Callback<T> callback, Exception exception) {
        if (callback != null) {
            m4408a(new C02092(callback, exception));
        }
    }

    public static <T> void m4412b(Callback<T> callback, T t) {
        if (callback != null) {
            m4408a(new C02103(callback, t));
        }
    }
}
