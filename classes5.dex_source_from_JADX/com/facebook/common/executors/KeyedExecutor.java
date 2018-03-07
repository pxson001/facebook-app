package com.facebook.common.executors;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: stacktrace-dump.txt */
public class KeyedExecutor {
    public static final Class<?> f2571a = KeyedExecutor.class;
    private static final ThreadLocal<AtomicInteger> f2572b = new C01671();
    private static volatile KeyedExecutor f2573g;
    private final ListeningExecutorService f2574c;
    private final MonotonicClock f2575d;
    @GuardedBy("this")
    private final Map<Object, TaskQueue> f2576e = Maps.c();
    @GuardedBy("this for writes")
    public final ConcurrentMap<Object, Task> f2577f = new MapMaker().g().l();

    /* compiled from: stacktrace-dump.txt */
    final class C01671 extends ThreadLocal<AtomicInteger> {
        C01671() {
        }

        protected final Object initialValue() {
            return new AtomicInteger(0);
        }
    }

    @NotThreadSafe
    /* compiled from: stacktrace-dump.txt */
    public class Task<T> implements Runnable {
        final Object f2565a;
        final Object f2566b;
        public final ListenableFutureTask<T> f2567c;

        private Task(Object obj, Object obj2, Callable<T> callable, String str, MonotonicClock monotonicClock) {
            TracedCallable a = TracedCallable.a(callable, KeyedExecutor.f2571a, monotonicClock);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            if (str != null) {
                stringBuilder.append(" (").append(str).append(')');
            }
            a.f = stringBuilder.toString();
            this.f2567c = ListenableFutureTask.a(a);
            this.f2565a = obj;
            this.f2566b = obj2;
        }

        public void run() {
            this.f2567c.run();
        }
    }

    @NotThreadSafe
    /* compiled from: stacktrace-dump.txt */
    class TaskQueue {
        final Object f2568a;
        final Queue<Task> f2569b = Lists.b();
        ListenableFuture<?> f2570c;

        TaskQueue(Object obj) {
            this.f2568a = obj;
        }
    }

    public static com.facebook.common.executors.KeyedExecutor m3677a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2573g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.KeyedExecutor.class;
        monitor-enter(r1);
        r0 = f2573g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3680b(r0);	 Catch:{ all -> 0x0035 }
        f2573g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2573g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.KeyedExecutor.a(com.facebook.inject.InjectorLike):com.facebook.common.executors.KeyedExecutor");
    }

    private static KeyedExecutor m3680b(InjectorLike injectorLike) {
        return new KeyedExecutor((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public KeyedExecutor(ExecutorService executorService, MonotonicClock monotonicClock) {
        this.f2574c = MoreExecutors.a(executorService);
        this.f2575d = monotonicClock;
    }

    public final synchronized <T> ListenableFuture<T> m3681a(Object obj, Object obj2, Callable<T> callable, String str) {
        Task task;
        TaskQueue taskQueue;
        TaskQueue taskQueue2 = (TaskQueue) this.f2576e.get(obj);
        if (taskQueue2 == null) {
            taskQueue2 = new TaskQueue(obj);
            this.f2576e.put(obj, taskQueue2);
            taskQueue = taskQueue2;
        } else {
            taskQueue = taskQueue2;
        }
        if (this.f2577f.containsKey(obj2)) {
            BLog.a(f2571a, "Already contains a callable for key " + obj2);
        }
        task = new Task(obj, obj2, callable, str, this.f2575d);
        this.f2577f.put(obj2, task);
        taskQueue.f2569b.add(task);
        m3678a(taskQueue);
        return task.f2567c;
    }

    private synchronized void m3678a(final TaskQueue taskQueue) {
        if (taskQueue.f2570c == null) {
            AtomicInteger atomicInteger = (AtomicInteger) f2572b.get();
            atomicInteger.incrementAndGet();
            try {
                if (taskQueue.f2569b.isEmpty()) {
                    this.f2576e.remove(taskQueue.f2568a);
                } else {
                    Executor a = atomicInteger.get() > 2 ? this.f2574c : MoreExecutors.a();
                    final Task task = (Task) taskQueue.f2569b.remove();
                    taskQueue.f2570c = this.f2574c.a(task);
                    taskQueue.f2570c.a(new Runnable(this) {
                        final /* synthetic */ KeyedExecutor f2564c;

                        public void run() {
                            KeyedExecutor.m3679a(this.f2564c, task, taskQueue);
                        }
                    }, a);
                }
            } finally {
                atomicInteger.decrementAndGet();
            }
        }
    }

    public static synchronized void m3679a(KeyedExecutor keyedExecutor, Task task, TaskQueue taskQueue) {
        synchronized (keyedExecutor) {
            taskQueue.f2570c = null;
            keyedExecutor.f2577f.remove(task.f2566b, task);
            keyedExecutor.m3678a(taskQueue);
        }
    }
}
