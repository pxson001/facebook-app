package com.facebook.common.executors;

import android.os.SystemClock;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Functions.FunctionForMapNoDefault;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.NaturalOrdering;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: voip_sampling_rate */
public class DefaultConstrainedListeningExecutorService extends AbstractListeningExecutorService implements ConstrainedListeningExecutorService {
    private static final Class<?> f946b = DefaultConstrainedListeningExecutorService.class;
    public final String f947c;
    private final Executor f948d;
    public volatile int f949e;
    public final BlockingQueue<Runnable> f950f;
    public final BackgroundWorkLogger f951g;
    public final ConstrainedExecutorsStatusController f952h;
    private final int f953i;
    private final Executor f954j;
    private final Worker f955k;
    public final AtomicInteger f956l;
    private final AtomicInteger f957m;

    /* compiled from: voip_sampling_rate */
    class Worker implements Runnable {
        final /* synthetic */ DefaultConstrainedListeningExecutorService f959a;

        public Worker(DefaultConstrainedListeningExecutorService defaultConstrainedListeningExecutorService) {
            this.f959a = defaultConstrainedListeningExecutorService;
        }

        public void run() {
            long j;
            Object obj;
            Throwable th;
            int decrementAndGet;
            long j2 = 0;
            boolean z = false;
            try {
                Runnable runnable = (Runnable) this.f959a.f950f.poll();
                if (runnable != null) {
                    try {
                        j2 = SystemClock.uptimeMillis();
                        runnable.run();
                        z = true;
                    } catch (Throwable th2) {
                        j = j2;
                        obj = runnable;
                        th = th2;
                        if (obj != null) {
                            this.f959a.f952h;
                            if (ConstrainedExecutorsStatusController.m1910a()) {
                                this.f959a.f952h.m1912a(this.f959a, LoggingUtils.a(obj), SystemClock.uptimeMillis() - j, false);
                            }
                        }
                        decrementAndGet = this.f959a.f956l.decrementAndGet();
                        if (this.f959a.f950f.isEmpty()) {
                            DefaultConstrainedListeningExecutorService.m1920h(this.f959a);
                        } else {
                            DefaultConstrainedListeningExecutorService.f946b;
                            this.f959a.f947c;
                            Integer.valueOf(decrementAndGet);
                        }
                        throw th;
                    }
                }
                DefaultConstrainedListeningExecutorService.f946b;
                this.f959a.f947c;
                if (runnable != null) {
                    this.f959a.f952h;
                    if (ConstrainedExecutorsStatusController.m1910a()) {
                        this.f959a.f952h.m1912a(this.f959a, LoggingUtils.a(runnable), SystemClock.uptimeMillis() - j2, z);
                    }
                }
                int decrementAndGet2 = this.f959a.f956l.decrementAndGet();
                if (this.f959a.f950f.isEmpty()) {
                    DefaultConstrainedListeningExecutorService.f946b;
                    this.f959a.f947c;
                    Integer.valueOf(decrementAndGet2);
                    return;
                }
                DefaultConstrainedListeningExecutorService.m1920h(this.f959a);
            } catch (Throwable th3) {
                th = th3;
                j = 0;
                obj = null;
                if (obj != null) {
                    this.f959a.f952h;
                    if (ConstrainedExecutorsStatusController.m1910a()) {
                        this.f959a.f952h.m1912a(this.f959a, LoggingUtils.a(obj), SystemClock.uptimeMillis() - j, false);
                    }
                }
                decrementAndGet = this.f959a.f956l.decrementAndGet();
                if (this.f959a.f950f.isEmpty()) {
                    DefaultConstrainedListeningExecutorService.f946b;
                    this.f959a.f947c;
                    Integer.valueOf(decrementAndGet);
                } else {
                    DefaultConstrainedListeningExecutorService.m1920h(this.f959a);
                }
                throw th;
            }
        }
    }

    /* compiled from: voip_sampling_rate */
    class TaskCancelledHandler<T> implements Runnable {
        final /* synthetic */ DefaultConstrainedListeningExecutorService f1621a;
        private final ListenableFutureTask f1622b;

        public TaskCancelledHandler(DefaultConstrainedListeningExecutorService defaultConstrainedListeningExecutorService, ListenableFutureTask<T> listenableFutureTask) {
            this.f1621a = defaultConstrainedListeningExecutorService;
            this.f1622b = listenableFutureTask;
        }

        public void run() {
            if (this.f1622b.isCancelled()) {
                this.f1621a.f950f.remove(this.f1622b);
            }
        }
    }

    public DefaultConstrainedListeningExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f947c = str;
        this.f948d = executor;
        this.f949e = i;
        this.f951g = backgroundWorkLogger;
        this.f952h = constrainedExecutorsStatusController;
        this.f950f = blockingQueue;
        this.f953i = this.f950f.remainingCapacity();
        this.f954j = MoreExecutors.m1813a();
        this.f955k = new Worker(this);
        this.f956l = new AtomicInteger(0);
        this.f957m = new AtomicInteger(0);
    }

    public static DefaultConstrainedListeningExecutorService m1913a(String str, int i, int i2, Executor executor, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return new DefaultConstrainedListeningExecutorService(str, i, executor, new LinkedBlockingQueue(i2), backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.f950f.offer(m1915b(runnable))) {
            int size = this.f950f.size();
            int i = this.f957m.get();
            if (size > i && this.f957m.compareAndSet(i, size)) {
                Integer.valueOf(size);
            }
            m1920h(this);
        } else {
            throw new RejectedExecutionException(this.f947c + " queue is full, size=" + this.f950f.size() + ", tasks=" + m1919g());
        }
    }

    @VisibleForTesting
    private ImmutableMap<String, Integer> m1919g() {
        Map c = Maps.m838c();
        for (Runnable a : this.f950f) {
            String a2 = LoggingUtils.a(a);
            Integer num = (Integer) c.get(a2);
            if (num == null) {
                c.put(a2, Integer.valueOf(1));
            } else {
                c.put(a2, Integer.valueOf(num.intValue() + 1));
            }
        }
        return ImmutableSortedMap.m13030b(c, (Comparator) Preconditions.checkNotNull(NaturalOrdering.f22266a.m30182a((Function) new FunctionForMapNoDefault(c)).mo3241a().m30188b((Comparator) NaturalOrdering.f22266a)));
    }

    public final int mo299a() {
        return this.f950f.size();
    }

    public final int mo301b() {
        return this.f956l.get();
    }

    public final String m1926c() {
        return this.f947c;
    }

    protected final <T> ListenableFutureTask<T> mo302b(Runnable runnable, @Nullable T t) {
        return m1914a(super.mo302b(m1915b(runnable), t));
    }

    private Runnable m1915b(Runnable runnable) {
        return (!this.f951g.mo231a() || (runnable instanceof ListenableFutureTask) || (runnable instanceof LoggingRunnable) || (runnable instanceof Worker)) ? runnable : LoggingRunnable.m12548a(runnable, this.f951g, this.f947c);
    }

    protected final <T> ListenableFutureTask<T> mo303b(Callable<T> callable) {
        return m1914a(super.mo303b(LoggingCallable.m20280a(callable, this.f951g, this.f947c)));
    }

    private <T> ListenableFutureTask<T> m1914a(ListenableFutureTask<T> listenableFutureTask) {
        if (this.f953i != Integer.MAX_VALUE) {
            listenableFutureTask.mo223a(new TaskCancelledHandler(this, listenableFutureTask), this.f954j);
        }
        return listenableFutureTask;
    }

    public static void m1920h(DefaultConstrainedListeningExecutorService defaultConstrainedListeningExecutorService) {
        int i = defaultConstrainedListeningExecutorService.f956l.get();
        while (i < defaultConstrainedListeningExecutorService.f949e) {
            int i2 = i + 1;
            if (defaultConstrainedListeningExecutorService.f956l.compareAndSet(i, i2)) {
                Integer.valueOf(i2);
                Integer.valueOf(defaultConstrainedListeningExecutorService.f949e);
                ExecutorDetour.a(defaultConstrainedListeningExecutorService.f948d, defaultConstrainedListeningExecutorService.f955k, 911056284);
                return;
            }
            i = defaultConstrainedListeningExecutorService.f956l.get();
        }
    }

    public final void mo304d() {
        ArrayList a = Lists.m1297a(this.f950f.size());
        this.f950f.drainTo(a);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Runnable runnable = (Runnable) a.get(i);
            if (runnable instanceof Future) {
                ((Future) runnable).cancel(false);
            }
        }
    }

    public final void mo300a(int i) {
        Object obj = this.f949e != i ? 1 : null;
        this.f949e = i;
        if (obj != null) {
            m1920h(this);
        }
    }
}
