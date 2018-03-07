package com.facebook.common.userinteraction;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: wcdma_info */
public class DefaultUserInteractionController {
    private static final Class<?> f892a = DefaultUserInteractionController.class;
    private static volatile DefaultUserInteractionController f893m;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AndroidThreadUtil> f894b = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MonotonicClock> f895c = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f896d = UltralightRuntime.f368b;
    public final ActivityListener f897e = new ActivityListener(this);
    @GuardedBy("mInteractingStateLock")
    public final WeakHashMap<View, Long> f898f = new WeakHashMap();
    @GuardedBy("mListenerLock")
    private final WeakHashMap<UserInteractionListener, Boolean> f899g = new WeakHashMap();
    private Handler f900h = new Handler(Looper.getMainLooper(), new C00541(this));
    @GuardedBy("mInteractingStateLock")
    private boolean f901i;
    public Object f902j = new Object();
    private Object f903k = new Object();
    private List<UserInteractionListener> f904l = Lists.m1296a();

    /* compiled from: wcdma_info */
    public class ActivityListener extends AbstractFbActivityListener {
        final /* synthetic */ DefaultUserInteractionController f905a;

        public ActivityListener(DefaultUserInteractionController defaultUserInteractionController) {
            this.f905a = defaultUserInteractionController;
        }

        public final void mo242d(Activity activity) {
            synchronized (this.f905a.f902j) {
                Iterator it = this.f905a.f898f.keySet().iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    if (view.getContext() == activity) {
                        new StringBuilder("View ").append(view).append(" was still marked as interacting when its corresponding Activity was paused");
                        it.remove();
                    }
                }
            }
            DefaultUserInteractionController.m1751f(this.f905a);
        }
    }

    /* compiled from: wcdma_info */
    class C00541 implements Callback {
        final /* synthetic */ DefaultUserInteractionController f906a;

        C00541(DefaultUserInteractionController defaultUserInteractionController) {
            this.f906a = defaultUserInteractionController;
        }

        public boolean handleMessage(Message message) {
            DefaultUserInteractionController.m1751f(this.f906a);
            return true;
        }
    }

    public static com.facebook.common.userinteraction.DefaultUserInteractionController m1747a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f893m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.userinteraction.DefaultUserInteractionController.class;
        monitor-enter(r1);
        r0 = f893m;	 Catch:{ all -> 0x003a }
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
        r0 = m1748b(r0);	 Catch:{ all -> 0x0035 }
        f893m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f893m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.userinteraction.DefaultUserInteractionController.a(com.facebook.inject.InjectorLike):com.facebook.common.userinteraction.DefaultUserInteractionController");
    }

    private static DefaultUserInteractionController m1748b(InjectorLike injectorLike) {
        DefaultUserInteractionController defaultUserInteractionController = new DefaultUserInteractionController();
        com.facebook.inject.Lazy a = IdBasedLazy.m1808a(injectorLike, 517);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.m1810b(injectorLike, 601);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.m1810b(injectorLike, 494);
        defaultUserInteractionController.f894b = a;
        defaultUserInteractionController.f895c = b;
        defaultUserInteractionController.f896d = b2;
        return defaultUserInteractionController;
    }

    public final void m1754a(UserInteractionListener userInteractionListener) {
        synchronized (this.f903k) {
            this.f899g.put(userInteractionListener, Boolean.valueOf(true));
        }
        userInteractionListener.mo353a(m1757b());
    }

    public final void m1756b(UserInteractionListener userInteractionListener) {
        synchronized (this.f903k) {
            this.f899g.remove(userInteractionListener);
        }
    }

    public final void m1753a(View view) {
        ((DefaultAndroidThreadUtil) this.f894b.get()).m1649a();
        synchronized (this.f902j) {
            this.f898f.put(view, Long.valueOf(((MonotonicClock) this.f895c.get()).now()));
            Integer.valueOf(this.f898f.size());
        }
        m1751f(this);
    }

    public final void m1755b(View view) {
        ((DefaultAndroidThreadUtil) this.f894b.get()).m1649a();
        synchronized (this.f902j) {
            this.f898f.remove(view);
            Integer.valueOf(this.f898f.size());
        }
        m1750e();
    }

    public final boolean m1757b() {
        boolean z;
        synchronized (this.f902j) {
            z = !this.f898f.isEmpty();
        }
        return z;
    }

    public final void m1758c() {
        m1752a(10000);
    }

    public final void m1752a(long j) {
        ((DefaultAndroidThreadUtil) this.f894b.get()).m1655b();
        Semaphore semaphore = new Semaphore(0);
        UserInteractionListener 2 = new 2(this, semaphore);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            m1754a(2);
            if (!semaphore.tryAcquire(j, TimeUnit.MILLISECONDS)) {
                m1749d();
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis > 10) {
                new StringBuilder("User interaction blocked data processing for ").append(currentTimeMillis).append(" ms.");
            }
            m1756b(2);
        } catch (Throwable e) {
            BLog.b(f892a, "Exception when the user interaction to be finished.", e);
        }
    }

    private void m1749d() {
        long now = ((MonotonicClock) this.f895c.get()).now();
        WeakHashMap weakHashMap = new WeakHashMap();
        synchronized (this.f902j) {
            weakHashMap.putAll(this.f898f);
        }
        List list = null;
        for (Entry entry : weakHashMap.entrySet()) {
            if (now - ((Long) entry.getValue()).longValue() >= 60000) {
                if (r2 == null) {
                    list = Lists.m1306b();
                }
                list.add(entry.getKey());
                ((AbstractFbErrorReporter) this.f896d.get()).m2340a("DefaultUserInteractionController", "View " + ((View) entry.getKey()).getClass().getName() + " may not have ended it's user interaction event");
            }
        }
        if (r2 != null) {
            synchronized (this.f902j) {
                for (View remove : r2) {
                    this.f898f.remove(remove);
                }
                Integer.valueOf(this.f898f.size());
            }
            m1750e();
        }
    }

    private void m1750e() {
        synchronized (this.f902j) {
            if (m1757b() != this.f901i) {
                this.f900h.sendEmptyMessageDelayed(0, 100);
            }
        }
    }

    public static void m1751f(DefaultUserInteractionController defaultUserInteractionController) {
        boolean z = false;
        ((DefaultAndroidThreadUtil) defaultUserInteractionController.f894b.get()).m1649a();
        synchronized (defaultUserInteractionController.f902j) {
            boolean b = defaultUserInteractionController.m1757b();
            if (b != defaultUserInteractionController.f901i) {
                defaultUserInteractionController.f901i = b;
                boolean z2 = b;
                b = true;
                z = z2;
            } else {
                b = false;
            }
        }
        if (b) {
            defaultUserInteractionController.f904l.clear();
            synchronized (defaultUserInteractionController.f903k) {
                for (UserInteractionListener add : defaultUserInteractionController.f899g.keySet()) {
                    defaultUserInteractionController.f904l.add(add);
                }
            }
            for (UserInteractionListener add2 : defaultUserInteractionController.f904l) {
                add2.mo353a(z);
            }
            defaultUserInteractionController.f904l.clear();
        }
    }
}
