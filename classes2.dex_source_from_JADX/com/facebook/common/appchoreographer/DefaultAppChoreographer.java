package com.facebook.common.appchoreographer;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.TriState;
import com.facebook.debug.tracer.Tracer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.systrace.Systrace;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: weigher requires maximumWeight */
public class DefaultAppChoreographer {
    private static final Class<?> f844a = DefaultAppChoreographer.class;
    private static volatile DefaultAppChoreographer f845x;
    public final DefaultAndroidThreadUtil f846b;
    private final Handler f847c;
    private final DefaultUserInteractionController f848d;
    private final Clock f849e;
    private final Provider<Boolean> f850f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AppStateManager> f851g = UltralightRuntime.f368b;
    @Inject
    @Lazy
    @BackgroundExecutorService
    public com.facebook.inject.Lazy<ExecutorService> f852h = UltralightRuntime.f368b;
    @Inject
    @Lazy
    @ForUiThread
    public com.facebook.inject.Lazy<ExecutorService> f853i = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f854j = UltralightRuntime.f368b;
    public final ReentrantLock f855k;
    public final Condition f856l;
    private final Condition f857m;
    private final AtomicInteger f858n;
    @GuardedBy("mLock")
    private final PriorityQueue<Task<?>> f859o;
    @GuardedBy("mLock")
    private final WeakHashMap<ListenableFuture<?>, Long> f860p;
    @GuardedBy("writes guarded by mLock")
    private volatile Stage f861q = Stage.START;
    @GuardedBy("mLock")
    private boolean f862r;
    @GuardedBy("mLock")
    private boolean f863s;
    @GuardedBy("mLock")
    private boolean f864t;
    @GuardedBy("mLock")
    private int f865u;
    @GuardedBy("mLock")
    private boolean f866v;
    @GuardedBy("mLock")
    private UserInteractionListener f867w;

    /* compiled from: weigher requires maximumWeight */
    enum Stage {
        START,
        APPLICATION_INITIALIZING,
        APPLICATION_LOADING,
        APPLICATION_LOADED
    }

    /* compiled from: weigher requires maximumWeight */
    class TaskPriorityComparator implements Comparator<Task<?>> {
        TaskPriorityComparator() {
        }

        public int compare(Object obj, Object obj2) {
            Task task = (Task) obj;
            Task task2 = (Task) obj2;
            if (task.f1255b.ordinal() < task2.f1255b.ordinal()) {
                return -1;
            }
            if (task.f1255b.ordinal() > task2.f1255b.ordinal()) {
                return 1;
            }
            if (task.f1258e < task2.f1258e) {
                return -1;
            }
            if (task.f1258e > task2.f1258e) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: weigher requires maximumWeight */
    class Task<V> {
        final ListenableFutureTask<V> f1254a;
        final AppChoreographer$Priority f1255b;
        final ExecutorService f1256c;
        final String f1257d;
        final int f1258e;

        Task(ListenableFutureTask<V> listenableFutureTask, AppChoreographer$Priority appChoreographer$Priority, ExecutorService executorService, String str, int i) {
            this.f1254a = listenableFutureTask;
            this.f1255b = appChoreographer$Priority;
            this.f1256c = executorService;
            this.f1257d = str;
            this.f1258e = i;
        }
    }

    /* compiled from: weigher requires maximumWeight */
    class C00816 extends AbstractDisposableFutureCallback<T> {
        final /* synthetic */ DefaultAppChoreographer f1259a;

        C00816(DefaultAppChoreographer defaultAppChoreographer) {
            this.f1259a = defaultAppChoreographer;
        }

        protected final void mo347a(@Nullable T t) {
        }

        protected final void mo348a(Throwable th) {
        }

        protected final void mo349a(CancellationException cancellationException) {
            this.f1259a.f855k.lock();
            try {
                this.f1259a.f866v = true;
                this.f1259a.f856l.signalAll();
            } finally {
                this.f1259a.f855k.unlock();
            }
        }
    }

    /* compiled from: weigher requires maximumWeight */
    /* synthetic */ class C00848 {
        static final /* synthetic */ int[] f1267a = new int[Stage.values().length];
        static final /* synthetic */ int[] f1268b = new int[AppChoreographer$ThreadType.values().length];

        static {
            try {
                f1268b[AppChoreographer$ThreadType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1268b[AppChoreographer$ThreadType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1267a[Stage.START.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1267a[Stage.APPLICATION_INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1267a[Stage.APPLICATION_LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1267a[Stage.APPLICATION_LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: weigher requires maximumWeight */
    class C00881 implements UserInteractionListener {
        final /* synthetic */ DefaultAppChoreographer f1273a;

        C00881(DefaultAppChoreographer defaultAppChoreographer) {
            this.f1273a = defaultAppChoreographer;
        }

        public final void mo353a(boolean z) {
            DefaultAppChoreographer.m1629g(this.f1273a);
        }
    }

    /* compiled from: weigher requires maximumWeight */
    class C00892 implements Runnable {
        final /* synthetic */ DefaultAppChoreographer f1274a;

        C00892(DefaultAppChoreographer defaultAppChoreographer) {
            this.f1274a = defaultAppChoreographer;
        }

        public void run() {
            DefaultAppChoreographer.m1631i(this.f1274a);
        }
    }

    /* compiled from: weigher requires maximumWeight */
    class C00903 implements Runnable {
        final /* synthetic */ DefaultAppChoreographer f1275a;

        /* compiled from: weigher requires maximumWeight */
        class C03861 implements IdleHandler {
            final /* synthetic */ C00903 f8834a;

            C03861(C00903 c00903) {
                this.f8834a = c00903;
            }

            public boolean queueIdle() {
                this.f8834a.f1275a.m1644f();
                return true;
            }
        }

        C00903(DefaultAppChoreographer defaultAppChoreographer) {
            this.f1275a = defaultAppChoreographer;
        }

        public void run() {
            this.f1275a.f846b.m1649a();
            MessageQueue myQueue = Looper.myQueue();
            if (myQueue != null) {
                myQueue.addIdleHandler(new C03861(this));
            }
        }
    }

    public static com.facebook.common.appchoreographer.DefaultAppChoreographer m1621a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f845x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.appchoreographer.DefaultAppChoreographer.class;
        monitor-enter(r1);
        r0 = f845x;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1628b(r0);	 Catch:{ all -> 0x0035 }
        f845x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f845x;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appchoreographer.DefaultAppChoreographer.a(com.facebook.inject.InjectorLike):com.facebook.common.appchoreographer.DefaultAppChoreographer");
    }

    private static DefaultAppChoreographer m1628b(InjectorLike injectorLike) {
        DefaultAppChoreographer defaultAppChoreographer = new DefaultAppChoreographer(DefaultAndroidThreadUtil.m1646b(injectorLike), Handler_ForUiThreadMethodAutoProvider.m1701b(injectorLike), DefaultUserInteractionController.m1747a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3976));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.m1810b(injectorLike, 476);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 3832);
        com.facebook.inject.Lazy b3 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863);
        com.facebook.inject.Lazy b4 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 494);
        defaultAppChoreographer.f851g = b;
        defaultAppChoreographer.f852h = b2;
        defaultAppChoreographer.f853i = b3;
        defaultAppChoreographer.f854j = b4;
        return defaultAppChoreographer;
    }

    @Inject
    public DefaultAppChoreographer(AndroidThreadUtil androidThreadUtil, Handler handler, UserInteractionController userInteractionController, Clock clock, Provider<Boolean> provider) {
        this.f846b = androidThreadUtil;
        this.f859o = new PriorityQueue(100, new TaskPriorityComparator());
        this.f860p = new WeakHashMap();
        this.f855k = new ReentrantLock();
        this.f856l = this.f855k.newCondition();
        this.f857m = this.f855k.newCondition();
        this.f858n = new AtomicInteger();
        this.f847c = handler;
        this.f848d = userInteractionController;
        this.f849e = clock;
        this.f850f = provider;
        Systrace.b(8, "AppChoreographer Stage", hashCode());
        Systrace.a(8, "AppChoreographer Stage", hashCode(), Stage.START.name());
    }

    public final void m1642d() {
        this.f855k.lock();
        try {
            this.f867w = new C00881(this);
            this.f848d.m1754a(this.f867w);
            m1625a(Stage.APPLICATION_INITIALIZING);
            ThreadInitDetour.a(new C00892(this), "AppChoreographer", -162981890).start();
            HandlerDetour.a(this.f847c, new C00903(this), -2081403738);
        } finally {
            this.f855k.unlock();
        }
    }

    public final void m1643e() {
        m1625a(Stage.APPLICATION_LOADING);
    }

    public final ListenableFutureTask<?> m1634a(String str, Runnable runnable, AppChoreographer$Priority appChoreographer$Priority, AppChoreographer$ThreadType appChoreographer$ThreadType) {
        return m1623a(str, m1622a(runnable, appChoreographer$Priority, str), appChoreographer$Priority, m1624a(appChoreographer$ThreadType));
    }

    public final ListenableFutureTask<?> m1635a(String str, Runnable runnable, AppChoreographer$Priority appChoreographer$Priority, ExecutorService executorService) {
        return m1623a(str, m1622a(runnable, appChoreographer$Priority, str), appChoreographer$Priority, executorService);
    }

    public final <T> ListenableFutureTask<T> m1636a(String str, Callable<T> callable, AppChoreographer$Priority appChoreographer$Priority, AppChoreographer$ThreadType appChoreographer$ThreadType) {
        return m1623a(str, ListenableFutureTask.m2437a(new 4(this, appChoreographer$Priority, str, callable)), appChoreographer$Priority, m1624a(appChoreographer$ThreadType));
    }

    private ListenableFutureTask<Void> m1622a(final Runnable runnable, final AppChoreographer$Priority appChoreographer$Priority, final String str) {
        return ListenableFutureTask.m2436a(new Runnable(this) {
            final /* synthetic */ DefaultAppChoreographer f1252d;

            public void run() {
                TracerDetour.a("AppChoreographer(p%s)/%s", new Object[]{Integer.valueOf(appChoreographer$Priority.ordinal()), str}, 674558007);
                LoomLogger.a(LoomLoggerDetour.a(-428261046), String.valueOf(appChoreographer$Priority.ordinal()), str);
                try {
                    runnable.run();
                } finally {
                    TracerDetour.a(-145884603);
                }
            }
        }, null);
    }

    private <T> ListenableFutureTask<T> m1623a(String str, ListenableFutureTask<T> listenableFutureTask, AppChoreographer$Priority appChoreographer$Priority, ExecutorService executorService) {
        this.f855k.lock();
        try {
            this.f859o.add(new Task(listenableFutureTask, appChoreographer$Priority, executorService, str, this.f858n.incrementAndGet()));
            Futures.m2458a((ListenableFuture) listenableFutureTask, new C00816(this), MoreExecutors.m1813a());
            if (m1626a(appChoreographer$Priority, false)) {
                this.f856l.signalAll();
            }
            this.f855k.unlock();
            return listenableFutureTask;
        } catch (Throwable th) {
            this.f855k.unlock();
        }
    }

    private void m1625a(Stage stage) {
        boolean z = true;
        this.f855k.lock();
        try {
            Systrace.a(8, "AppChoreographer Stage", hashCode(), stage.name());
            switch (C00848.f1267a[this.f861q.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (stage != Stage.APPLICATION_INITIALIZING) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (stage != Stage.APPLICATION_LOADING) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    break;
                case 3:
                    if (stage != Stage.APPLICATION_LOADED) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    Systrace.c(8, "AppChoreographer Stage", hashCode());
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    ((AbstractFbErrorReporter) this.f854j.get()).m2340a("DefaultAppChoreographer_Already_Loaded", "AppChoreographer already loaded. Requested stage = " + stage);
                    this.f855k.unlock();
                    return;
                default:
                    throw new IllegalArgumentException();
            }
            Stage stage2 = this.f861q;
            Tracer.m888d("AppChoreographer moving from %s to %s", new Object[]{this.f861q, stage});
            this.f861q = stage;
            this.f856l.signalAll();
        } finally {
            this.f855k.unlock();
        }
    }

    public final <T> void m1637a(ListenableFuture<T> listenableFuture) {
        this.f855k.lock();
        try {
            this.f860p.put(listenableFuture, Long.valueOf(this.f849e.mo211a()));
            listenableFuture.mo223a(new 7(this, listenableFuture), (Executor) this.f853i.get());
            this.f862r = true;
            this.f856l.signalAll();
        } finally {
            this.f855k.unlock();
        }
    }

    public final <T> void m1639b(ListenableFuture<T> listenableFuture) {
        this.f855k.lock();
        try {
            this.f846b.m1649a();
            this.f860p.remove(listenableFuture);
            m1630h();
            this.f856l.signalAll();
        } finally {
            this.f855k.unlock();
        }
    }

    public static void m1629g(DefaultAppChoreographer defaultAppChoreographer) {
        defaultAppChoreographer.f855k.lock();
        try {
            defaultAppChoreographer.f856l.signalAll();
        } finally {
            defaultAppChoreographer.f855k.unlock();
        }
    }

    public final boolean m1638a() {
        boolean z = true;
        if (this.f861q != Stage.APPLICATION_LOADED) {
            this.f855k.lock();
            try {
                m1630h();
                if (this.f861q != Stage.APPLICATION_LOADED) {
                    z = false;
                }
                this.f855k.unlock();
            } catch (Throwable th) {
                this.f855k.unlock();
            }
        }
        return z;
    }

    public final boolean m1640b() {
        this.f855k.lock();
        try {
            m1633k();
            boolean z = !this.f860p.isEmpty();
            this.f855k.unlock();
            return z;
        } catch (Throwable th) {
            this.f855k.unlock();
        }
    }

    public final boolean m1641c() {
        return ((AppStateManager) this.f851g.get()).m2260h();
    }

    @VisibleForTesting
    final void m1644f() {
        this.f855k.lock();
        try {
            m1630h();
            if (this.f861q == Stage.APPLICATION_LOADED && !this.f863s) {
                this.f863s = true;
                this.f856l.signalAll();
            }
            this.f855k.unlock();
        } catch (Throwable th) {
            this.f855k.unlock();
        }
    }

    @GuardedBy("mLock")
    private void m1630h() {
        if (this.f861q == Stage.APPLICATION_LOADING) {
            m1633k();
            if (this.f860p.isEmpty()) {
                int i;
                if (this.f862r) {
                    Tracer.m885b("AppChoreographer: Advancing to loaded because UI is no longer loading");
                    i = 1;
                } else if (TriState.YES == ((AppStateManager) this.f851g.get()).m2263k()) {
                    Tracer.m885b("AppChoreographer: Advancing to loaded because app is backgrounded");
                    i = 1;
                } else if (((AppStateManager) this.f851g.get()).m2258d() > 5000) {
                    Tracer.m885b("AppChoreographer: Advancing to loaded because exceeded time threshold");
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    m1625a(Stage.APPLICATION_LOADED);
                } else {
                    this.f847c.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1631i(com.facebook.common.appchoreographer.DefaultAppChoreographer r5) {
        /*
        r0 = r5.f846b;
        r0.m1655b();
    L_0x0005:
        r1 = 0;
        com.facebook.systrace.SystraceMetadata.c();	 Catch:{ InterruptedException -> 0x0025, IncompatibleClassChangeError -> 0x0082 }
        r1 = r5.m1632j();	 Catch:{ InterruptedException -> 0x0025, IncompatibleClassChangeError -> 0x0082 }
        r0 = r1.f1256c;	 Catch:{ InterruptedException -> 0x0025, IncompatibleClassChangeError -> 0x004c }
        r2 = r1.f1254a;	 Catch:{ InterruptedException -> 0x0025, IncompatibleClassChangeError -> 0x004c }
        r3 = 72653211; // 0x454999b float:2.4991012E-36 double:3.58954556E-316;
        r0 = com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r0, r2, r3);	 Catch:{ InterruptedException -> 0x0025, IncompatibleClassChangeError -> 0x004c }
        r2 = 824286760; // 0x31219e28 float:2.3518485E-9 double:4.072517704E-315;
        com.facebook.tools.dextr.runtime.detour.FutureDetour.a(r0, r2);	 Catch:{ ExecutionException -> 0x0032 }
        r0 = r5.f847c;	 Catch:{  }
        r2 = 0;
        r0.sendEmptyMessage(r2);	 Catch:{  }
        goto L_0x0005;
    L_0x0025:
        r0 = move-exception;
        r1 = java.lang.Thread.currentThread();
        r1.interrupt();
        r0 = com.google.common.base.Throwables.propagate(r0);
        throw r0;
    L_0x0032:
        r3 = move-exception;
        r0 = r1.f1257d;	 Catch:{  }
        if (r0 == 0) goto L_0x006a;
    L_0x0037:
        r0 = r1.f1257d;	 Catch:{  }
        r2 = r0;
    L_0x003a:
        r0 = r5.f854j;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.common.errorreporting.AbstractFbErrorReporter) r0;	 Catch:{  }
        r4 = "fb_task_description";
        r0.mo345c(r4, r2);	 Catch:{  }
        r0 = com.google.common.base.Throwables.propagate(r3);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x004c:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x004f:
        if (r0 == 0) goto L_0x0072;
    L_0x0051:
        r1 = r0.f1257d;
        if (r1 == 0) goto L_0x006e;
    L_0x0055:
        r0 = r0.f1257d;
        r1 = r0;
    L_0x0058:
        r0 = r5.f854j;
        r0 = r0.get();
        r0 = (com.facebook.common.errorreporting.AbstractFbErrorReporter) r0;
        r3 = "fb_task_description";
        r0.mo345c(r3, r1);
    L_0x0065:
        r0 = com.google.common.base.Throwables.propagate(r2);
        throw r0;
    L_0x006a:
        r0 = "Null description";
        r2 = r0;
        goto L_0x003a;
    L_0x006e:
        r0 = "Null description";
        r1 = r0;
        goto L_0x0058;
    L_0x0072:
        r0 = r5.f854j;
        r0 = r0.get();
        r0 = (com.facebook.common.errorreporting.AbstractFbErrorReporter) r0;
        r1 = "fb_task_description";
        r3 = "Null task";
        r0.mo345c(r1, r3);
        goto L_0x0065;
    L_0x0082:
        r0 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appchoreographer.DefaultAppChoreographer.i(com.facebook.common.appchoreographer.DefaultAppChoreographer):void");
    }

    private boolean m1626a(AppChoreographer$Priority appChoreographer$Priority, boolean z) {
        switch (C00848.f1267a[this.f861q.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (appChoreographer$Priority == AppChoreographer$Priority.STARTUP_INITIALIZATION) {
                    return true;
                }
                break;
            case 3:
                if (appChoreographer$Priority.ordinal() <= AppChoreographer$Priority.APPLICATION_LOADING.ordinal()) {
                    return true;
                }
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                if (appChoreographer$Priority.ordinal() <= AppChoreographer$Priority.APPLICATION_LOADING.ordinal()) {
                    return true;
                }
                m1633k();
                if (this.f848d.m1757b() || !this.f860p.isEmpty()) {
                    return false;
                }
                if (appChoreographer$Priority == AppChoreographer$Priority.APPLICATION_LOADED_HIGH_PRIORITY) {
                    return true;
                }
                if (this.f863s) {
                    return ((Boolean) this.f850f.get()).booleanValue();
                }
                this.f847c.sendEmptyMessage(0);
                return false;
        }
        return false;
    }

    private Task<?> m1632j() {
        this.f855k.lock();
        while (true) {
            try {
                Task task;
                if (this.f866v) {
                    Iterator it = this.f859o.iterator();
                    while (it.hasNext()) {
                        task = (Task) it.next();
                        if (task != null && task.f1254a.isCancelled()) {
                            it.remove();
                        }
                    }
                    this.f866v = false;
                }
                task = (Task) this.f859o.peek();
                if (task != null) {
                    if (!task.f1254a.isCancelled()) {
                        this.f865u++;
                        if (m1626a(task.f1255b, true)) {
                            break;
                        }
                    }
                    this.f859o.remove();
                }
                this.f863s = false;
                this.f864t = true;
                this.f857m.signalAll();
                this.f856l.await();
                this.f864t = false;
                this.f857m.signalAll();
            } finally {
                this.f855k.unlock();
            }
        }
        this.f863s = false;
        Task<?> task2 = (Task) this.f859o.remove();
        return task2;
    }

    @GuardedBy("mLock")
    private void m1633k() {
        if (!this.f860p.isEmpty()) {
            long a = this.f849e.mo211a();
            Iterator it = this.f860p.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (a - ((Long) entry.getValue()).longValue() >= 60000) {
                    entry.getKey();
                    it.remove();
                }
            }
        }
    }

    private ExecutorService m1624a(AppChoreographer$ThreadType appChoreographer$ThreadType) {
        switch (C00848.f1268b[appChoreographer$ThreadType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (ExecutorService) this.f852h.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (ExecutorService) this.f853i.get();
            default:
                throw new IllegalStateException("Unknown thread type " + appChoreographer$ThreadType);
        }
    }
}
