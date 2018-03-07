package com.facebook.analytics.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.IAnalyticsService;
import com.facebook.analytics.IAnalyticsService.Stub.Proxy;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.service.AnalyticsService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: updateResource */
public class AnalyticsEventSender {
    public static final Class<?> f479a = AnalyticsEventSender.class;
    private static final String f480b = (f479a.getSimpleName() + "_BIND_FAILED");
    private static final String f481c = (f479a.getSimpleName() + "_REMOTE_EXCEPTION");
    private static volatile AnalyticsEventSender f482r;
    private final Context f483d;
    private final Clock f484e;
    private final ScheduledExecutorService f485f;
    public final FbSharedPreferences f486g;
    private final DefaultAndroidThreadUtil f487h;
    private final AbstractFbErrorReporter f488i;
    private final DefaultUserInteractionController f489j;
    private final AnalyticsPreferencesListener f490k;
    private final SendRunnable f491l;
    private final Object f492m = new Object();
    @GuardedBy("mStateSync")
    private final List<HoneyAnalyticsEvent> f493n;
    @GuardedBy("mStateSync")
    private long f494o = -1;
    @GuardedBy("mStateSync")
    private long f495p;
    @GuardedBy("mStateSync")
    private boolean f496q = false;

    /* compiled from: updateResource */
    public class AnalyticsPreferencesListener implements OnSharedPreferenceChangeListener, Runnable {
        public final /* synthetic */ AnalyticsEventSender f497a;

        public AnalyticsPreferencesListener(AnalyticsEventSender analyticsEventSender) {
            this.f497a = analyticsEventSender;
        }

        public void run() {
            this.f497a.f486g.a(AnalyticsPrefKeys.c, this);
            this.f497a.m793a();
        }

        public final void m796a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f497a.m793a();
        }
    }

    /* compiled from: updateResource */
    class SendRunnable implements Runnable {
        final /* synthetic */ AnalyticsEventSender f498a;

        public void run() {
            Class cls = AnalyticsEventSender.f479a;
            AnalyticsEventSender.m792h(this.f498a);
        }

        public SendRunnable(AnalyticsEventSender analyticsEventSender) {
            this.f498a = analyticsEventSender;
        }
    }

    /* compiled from: updateResource */
    class AnalyticsServiceConnection implements ServiceConnection {
        private final SettableFuture<IAnalyticsService> f1130a = SettableFuture.f();

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IAnalyticsService iAnalyticsService;
            Class cls = AnalyticsEventSender.f479a;
            SettableFuture settableFuture = this.f1130a;
            if (iBinder == null) {
                iAnalyticsService = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.analytics.IAnalyticsService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IAnalyticsService)) {
                    iAnalyticsService = new Proxy(iBinder);
                } else {
                    iAnalyticsService = (IAnalyticsService) queryLocalInterface;
                }
            }
            FutureDetour.a(settableFuture, iAnalyticsService, 561206005);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Class cls = AnalyticsEventSender.f479a;
        }

        public final ListenableFuture<IAnalyticsService> m1394a() {
            return this.f1130a;
        }
    }

    /* compiled from: updateResource */
    class AnalyticsConnectionCallback implements FutureCallback<IAnalyticsService> {
        final /* synthetic */ AnalyticsEventSender f1131a;
        private final ServiceConnection f1132b;

        public void onFailure(Throwable th) {
            Class cls = AnalyticsEventSender.f479a;
            AnalyticsEventSender.m787b(this.f1131a, this.f1132b);
        }

        public void onSuccess(Object obj) {
            IAnalyticsService iAnalyticsService = (IAnalyticsService) obj;
            Class cls = AnalyticsEventSender.f479a;
            this.f1131a.m795a(iAnalyticsService);
            AnalyticsEventSender.m787b(this.f1131a, this.f1132b);
        }

        public AnalyticsConnectionCallback(AnalyticsEventSender analyticsEventSender, ServiceConnection serviceConnection) {
            this.f1131a = analyticsEventSender;
            this.f1132b = serviceConnection;
        }
    }

    public static com.facebook.analytics.client.AnalyticsEventSender m784a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f482r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.client.AnalyticsEventSender.class;
        monitor-enter(r1);
        r0 = f482r;	 Catch:{ all -> 0x003a }
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
        r0 = m786b(r0);	 Catch:{ all -> 0x0035 }
        f482r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f482r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.client.AnalyticsEventSender.a(com.facebook.inject.InjectorLike):com.facebook.analytics.client.AnalyticsEventSender");
    }

    private static AnalyticsEventSender m786b(InjectorLike injectorLike) {
        return new AnalyticsEventSender((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultUserInteractionController.a(injectorLike));
    }

    @Inject
    public AnalyticsEventSender(Context context, Clock clock, ScheduledExecutorService scheduledExecutorService, FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, DefaultUserInteractionController defaultUserInteractionController) {
        this.f483d = context;
        this.f484e = clock;
        this.f485f = scheduledExecutorService;
        this.f486g = fbSharedPreferences;
        this.f487h = defaultAndroidThreadUtil;
        this.f488i = abstractFbErrorReporter;
        this.f489j = defaultUserInteractionController;
        this.f490k = new AnalyticsPreferencesListener(this);
        this.f491l = new SendRunnable(this);
        this.f493n = Lists.a();
        this.f495p = 5000;
        this.f486g.a(this.f490k);
        this.f494o = this.f484e.a() + this.f495p;
    }

    public final void m794a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        synchronized (this.f492m) {
            this.f493n.add(honeyAnalyticsEvent);
            Integer.valueOf(this.f493n.size());
        }
        m791g();
    }

    @VisibleForTesting
    private long m788d() {
        long j;
        synchronized (this.f492m) {
            j = this.f494o + this.f495p;
        }
        return j;
    }

    @VisibleForTesting
    private long m789e() {
        return Math.max(0, m788d() - this.f484e.a());
    }

    private void m790f() {
        synchronized (this.f492m) {
            this.f494o = this.f484e.a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    private void m791g() {
        /*
        r6 = this;
        r1 = r6.f492m;
        monitor-enter(r1);
        r0 = r6.f493n;	 Catch:{ all -> 0x002a }
        r0 = r0.size();	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002a }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.f496q;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0028;
    L_0x0011:
        r2 = r6.m789e();	 Catch:{ all -> 0x002a }
        java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x002a }
        r0 = 1;
        r6.f496q = r0;	 Catch:{ all -> 0x002a }
        r0 = r6.f485f;	 Catch:{ all -> 0x002a }
        r2 = r6.f491l;	 Catch:{ all -> 0x002a }
        r4 = r6.m789e();	 Catch:{ all -> 0x002a }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x002a }
        r0.schedule(r2, r4, r3);	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r1);	 Catch:{ all -> 0x002a }
        goto L_0x000c;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.client.AnalyticsEventSender.g():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m792h(com.facebook.analytics.client.AnalyticsEventSender r4) {
        /*
        r1 = r4.f492m;	 Catch:{ all -> 0x0051 }
        monitor-enter(r1);	 Catch:{ all -> 0x0051 }
        r0 = r4.f493n;	 Catch:{ all -> 0x004e }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x004e }
        if (r0 == 0) goto L_0x001a;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x004e }
        r1 = r4.f492m;
        monitor-enter(r1);
        r4.m790f();	 Catch:{ all -> 0x0017 }
        r0 = 0;
        r4.f496q = r0;	 Catch:{ all -> 0x0017 }
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        throw r0;
    L_0x001a:
        monitor-exit(r1);	 Catch:{  }
        r0 = r4.f487h;	 Catch:{  }
        r0.b();	 Catch:{  }
        r0 = r4.f489j;	 Catch:{  }
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.a(r2);	 Catch:{  }
        r0 = new com.facebook.analytics.client.AnalyticsEventSender$AnalyticsServiceConnection;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r1 = new com.facebook.analytics.client.AnalyticsEventSender$AnalyticsConnectionCallback;	 Catch:{  }
        r1.<init>(r4, r0);	 Catch:{  }
        r2 = r4.m785a(r0);	 Catch:{  }
        if (r2 == 0) goto L_0x005d;
    L_0x0037:
        r0 = r0.m1394a();	 Catch:{  }
        r2 = r4.f485f;	 Catch:{  }
        com.google.common.util.concurrent.Futures.a(r0, r1, r2);	 Catch:{  }
    L_0x0040:
        r1 = r4.f492m;
        monitor-enter(r1);
        r4.m790f();	 Catch:{ all -> 0x004b }
        r0 = 0;
        r4.f496q = r0;	 Catch:{ all -> 0x004b }
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        goto L_0x0016;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        throw r0;
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0051:
        r0 = move-exception;
        r1 = r4.f492m;
        monitor-enter(r1);
        r4.m790f();	 Catch:{ all -> 0x0067 }
        r2 = 0;
        r4.f496q = r2;	 Catch:{ all -> 0x0067 }
        monitor-exit(r1);	 Catch:{ all -> 0x0067 }
        throw r0;
    L_0x005d:
        r0 = r4.f488i;	 Catch:{  }
        r1 = f480b;	 Catch:{  }
        r2 = "Failed to bind to service.";
        r0.a(r1, r2);	 Catch:{  }
        goto L_0x0040;
    L_0x0067:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.client.AnalyticsEventSender.h(com.facebook.analytics.client.AnalyticsEventSender):void");
    }

    @VisibleForTesting
    final void m795a(IAnalyticsService iAnalyticsService) {
        this.f487h.b();
        this.f489j.a(5000);
        synchronized (this.f492m) {
            Integer.valueOf(this.f493n.size());
            ImmutableList copyOf = ImmutableList.copyOf(this.f493n);
            this.f493n.clear();
        }
        try {
            if (!copyOf.isEmpty()) {
                for (List a : Lists.a(copyOf, 50)) {
                    iAnalyticsService.mo85a(a);
                }
            }
            Integer.valueOf(copyOf.size());
        } catch (Throwable e) {
            this.f488i.a(f481c, "Failed to send events.", e);
        }
    }

    private boolean m785a(ServiceConnection serviceConnection) {
        return ServiceConnectionDetour.a(this.f483d, new Intent(this.f483d, AnalyticsService.class), serviceConnection, 37, 477405105);
    }

    public static void m787b(AnalyticsEventSender analyticsEventSender, ServiceConnection serviceConnection) {
        ServiceConnectionDetour.a(analyticsEventSender.f483d, serviceConnection, 818833293);
    }

    @VisibleForTesting
    public final void m793a() {
        long a = this.f486g.a(AnalyticsPrefKeys.c, 5000);
        synchronized (this.f492m) {
            if (a >= 5000) {
                this.f495p = 5000;
            } else {
                this.f495p = a;
            }
            Long.valueOf(this.f495p);
        }
    }
}
