package com.facebook.backgroundworklog.performanceobserver;

import android.app.Service;
import android.content.Intent;
import com.facebook.backgroundworklog.observer.BackgroundWorkObserver;
import com.facebook.backgroundworklog.observer.OnBackgroundWorkObservedChanged;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: using */
public class PerformanceBackgroundWorkObserver implements BackgroundWorkObserver {
    private static final Class<?> f1394a = PerformanceBackgroundWorkObserver.class;
    private static volatile PerformanceBackgroundWorkObserver f1395m;
    private final Object f1396b = new Object();
    private final Lazy<PerformanceLogger> f1397c;
    private final MonotonicClock f1398d;
    private final XConfigReader f1399e;
    @IsBackgroundWorkPerformanceMetricsEnabled
    private final Provider<TriState> f1400f;
    @GuardedBy("this")
    private WeakReference<OnBackgroundWorkObservedChanged> f1401g;
    private volatile double f1402h = -1.0d;
    private volatile long f1403i = -1;
    private volatile TriState f1404j;
    @GuardedBy("this")
    private ArrayList<String> f1405k;
    @GuardedBy("this")
    private ArrayList<ArrayList<MarkerConfig>> f1406l;

    public static com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver m2659a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1395m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver.class;
        monitor-enter(r1);
        r0 = f1395m;	 Catch:{ all -> 0x003a }
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
        r0 = m2668b(r0);	 Catch:{ all -> 0x0035 }
        f1395m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1395m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver.a(com.facebook.inject.InjectorLike):com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver");
    }

    private static PerformanceBackgroundWorkObserver m2668b(InjectorLike injectorLike) {
        return new PerformanceBackgroundWorkObserver(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2952), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), XConfigReader.m2681a(injectorLike), IdBasedProvider.m1811a(injectorLike, 644));
    }

    @Inject
    public PerformanceBackgroundWorkObserver(Lazy<PerformanceLogger> lazy, MonotonicClock monotonicClock, XConfigReader xConfigReader, Provider<TriState> provider) {
        this.f1397c = lazy;
        this.f1398d = monotonicClock;
        this.f1399e = xConfigReader;
        this.f1400f = provider;
        this.f1404j = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo238a() {
        /*
        r8 = this;
        r7 = 0;
        r6 = 0;
        r0 = r8.m2666a(r6);
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = r6;
    L_0x0009:
        return r0;
    L_0x000a:
        monitor-enter(r8);
        r0 = r8.f1406l;	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x0012;
    L_0x000f:
        monitor-exit(r8);	 Catch:{ all -> 0x007e }
        r0 = r6;
        goto L_0x0009;
    L_0x0012:
        r5 = r6;
        r1 = r6;
    L_0x0014:
        r0 = r8.f1406l;	 Catch:{ all -> 0x007e }
        r0 = r0.size();	 Catch:{ all -> 0x007e }
        if (r5 >= r0) goto L_0x0064;
    L_0x001c:
        r0 = r8.f1406l;	 Catch:{ all -> 0x007e }
        r0 = r0.get(r5);	 Catch:{ all -> 0x007e }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x007e }
        r3 = r6;
        r4 = r1;
    L_0x0026:
        r1 = r0.size();	 Catch:{ all -> 0x007e }
        if (r3 >= r1) goto L_0x004e;
    L_0x002c:
        r1 = r8.f1397c;	 Catch:{ all -> 0x007e }
        r1 = r1.get();	 Catch:{ all -> 0x007e }
        r1 = (com.facebook.performancelogger.PerformanceLogger) r1;	 Catch:{ all -> 0x007e }
        r2 = r0.get(r3);	 Catch:{ all -> 0x007e }
        r2 = (com.facebook.performancelogger.MarkerConfig) r2;	 Catch:{ all -> 0x007e }
        r1 = r1.mo396e(r2);	 Catch:{ all -> 0x007e }
        if (r1 == 0) goto L_0x0047;
    L_0x0040:
        r1 = 1;
        r2 = r1;
        r1 = r3;
    L_0x0043:
        r3 = r1 + 1;
        r4 = r2;
        goto L_0x0026;
    L_0x0047:
        r0.remove(r3);	 Catch:{ all -> 0x007e }
        r1 = r3 + -1;
        r2 = r4;
        goto L_0x0043;
    L_0x004e:
        r0 = r0.isEmpty();	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x0083;
    L_0x0054:
        r0 = r8.f1405k;	 Catch:{ all -> 0x007e }
        r0.remove(r5);	 Catch:{ all -> 0x007e }
        r0 = r8.f1406l;	 Catch:{ all -> 0x007e }
        r0.remove(r5);	 Catch:{ all -> 0x007e }
        r0 = r5 + -1;
    L_0x0060:
        r5 = r0 + 1;
        r1 = r4;
        goto L_0x0014;
    L_0x0064:
        r0 = r8.f1405k;	 Catch:{ all -> 0x007e }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x0081;
    L_0x006c:
        r0 = 0;
        r8.f1405k = r0;	 Catch:{ all -> 0x007e }
        r0 = 0;
        r8.f1406l = r0;	 Catch:{ all -> 0x007e }
        r0 = r8.m2667b();	 Catch:{ all -> 0x007e }
    L_0x0076:
        monitor-exit(r8);	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x007c;
    L_0x0079:
        r0.mo366a();
    L_0x007c:
        r0 = r1;
        goto L_0x0009;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{  }
        throw r0;
    L_0x0081:
        r0 = r7;
        goto L_0x0076;
    L_0x0083:
        r0 = r5;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver.a():boolean");
    }

    public final void mo237a(OnBackgroundWorkObservedChanged onBackgroundWorkObservedChanged) {
        synchronized (this) {
            this.f1401g = new WeakReference(onBackgroundWorkObservedChanged);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo232a(int r6, java.lang.String r7, java.lang.Object r8) {
        /*
        r5 = this;
        r0 = 1;
        if (r6 == r0) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        r0 = r5.m2666a(r0);
        if (r0 == 0) goto L_0x0003;
    L_0x000a:
        r1 = r5.mo238a();
        r0 = 0;
        monitor-enter(r5);
        r2 = r5.m2663a(r8);	 Catch:{ all -> 0x001c }
        r3 = r2.isEmpty();	 Catch:{ all -> 0x001c }
        if (r3 == 0) goto L_0x001f;
    L_0x001a:
        monitor-exit(r5);	 Catch:{ all -> 0x001c }
        goto L_0x0003;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x001c }
        throw r0;
    L_0x001f:
        r3 = r5.f1405k;	 Catch:{  }
        if (r3 != 0) goto L_0x0033;
    L_0x0023:
        r3 = new java.util.ArrayList;	 Catch:{  }
        r4 = 1;
        r3.<init>(r4);	 Catch:{  }
        r5.f1405k = r3;	 Catch:{  }
        r3 = new java.util.ArrayList;	 Catch:{  }
        r4 = 1;
        r3.<init>(r4);	 Catch:{  }
        r5.f1406l = r3;	 Catch:{  }
    L_0x0033:
        r3 = r5.f1405k;	 Catch:{  }
        r3.add(r7);	 Catch:{  }
        r3 = r5.f1406l;	 Catch:{  }
        r3.add(r2);	 Catch:{  }
        java.lang.Integer.valueOf(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0046;
    L_0x0042:
        r0 = r5.m2667b();	 Catch:{  }
    L_0x0046:
        monitor-exit(r5);	 Catch:{  }
        if (r0 == 0) goto L_0x0003;
    L_0x0049:
        r0.mo366a();
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver.a(int, java.lang.String, java.lang.Object):void");
    }

    private ArrayList<MarkerConfig> m2663a(Object obj) {
        Preconditions.checkArgument(obj instanceof List, "Must be list of marker configs");
        List list = (List) obj;
        boolean z = !list.isEmpty() && (list.get(0) instanceof MarkerConfig);
        Preconditions.checkArgument(z, "Must be non-empty list of marker configs");
        int size = list.size();
        ArrayList<MarkerConfig> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            MarkerConfig markerConfig = (MarkerConfig) list.get(i);
            if (((PerformanceLogger) this.f1397c.get()).mo396e(markerConfig)) {
                arrayList.add(markerConfig);
            }
        }
        return arrayList;
    }

    private OnBackgroundWorkObservedChanged m2667b() {
        synchronized (this) {
            WeakReference weakReference = this.f1401g;
        }
        if (weakReference == null) {
            return null;
        }
        return (OnBackgroundWorkObservedChanged) weakReference.get();
    }

    public final void mo233a(long j, Intent intent, Class<?> cls) {
        if (!m2665a(j) && mo238a()) {
            m2664a(5767169, "BackgroundWorkHandleBroadcast", m2671c(cls) + "/" + m2660a(intent), j);
        }
    }

    public final void mo236a(long j, String str, Object obj) {
        if (!m2665a(j) && mo238a()) {
            m2664a(5767170, "GeneralBackgroundWorkFromLogger", m2662a(str, obj), j);
        }
    }

    private static String m2662a(String str, Object obj) {
        if (str == null) {
            str = "NO_TYPE";
        }
        return str + "/" + (obj != null ? obj.toString() : "NO_NAME");
    }

    public final void mo234a(long j, Class<? extends Service> cls) {
        if (!m2665a(j) && mo238a()) {
            m2664a(5767171, "BackgroundWorkServiceOnCreate", m2671c(cls), j);
        }
    }

    public final void mo235a(long j, Class<? extends Service> cls, Intent intent) {
        if (!m2665a(j) && mo238a()) {
            String c = m2671c(cls);
            m2664a(5767172, "BackgroundWorkServiceOnStart", c + "/" + m2660a(intent), j);
        }
    }

    public final void mo239b(long j, Class<? extends Service> cls) {
        if (!m2665a(j) && mo238a()) {
            m2664a(5767173, "BackgroundWorkServiceOnDestroy", m2671c(cls), j);
        }
    }

    private boolean m2666a(boolean z) {
        if (m2669b(z)) {
            synchronized (this.f1396b) {
                if (m2669b(z)) {
                    this.f1404j = (TriState) this.f1400f.get();
                }
            }
        }
        return this.f1404j.asBoolean(false);
    }

    private boolean m2669b(boolean z) {
        return this.f1404j == null || (z && this.f1404j == TriState.UNSET);
    }

    private boolean m2665a(long j) {
        return this.f1398d.now() - j < m2672d();
    }

    private String m2661a(String str) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this) {
            if (this.f1405k != null) {
                stringBuilder2 = Joiner.on('|').skipNulls().appendTo(stringBuilder2, this.f1405k);
            }
            stringBuilder = stringBuilder2.append('@').append(str).toString();
        }
        return stringBuilder;
    }

    private double m2670c() {
        if (this.f1402h == -1.0d) {
            synchronized (this.f1396b) {
                if (this.f1402h == -1.0d) {
                    this.f1402h = 0.01d * ((double) this.f1399e.m2683a(BackgroundWorkObserverXConfig.d, 100));
                }
            }
        }
        return this.f1402h;
    }

    private long m2672d() {
        if (this.f1403i == -1) {
            synchronized (this.f1396b) {
                if (this.f1403i == -1) {
                    this.f1403i = this.f1399e.m2684a(BackgroundWorkObserverXConfig.c, 200);
                }
            }
        }
        return this.f1403i;
    }

    private void m2664a(int i, String str, String str2, long j) {
        String str3 = "ThreadId#" + Thread.currentThread().getId();
        Long.valueOf(this.f1398d.now() - j);
        MarkerConfig markerConfig = new MarkerConfig(i, str);
        markerConfig.f1696e = str3;
        markerConfig = markerConfig.m3386a("CauseInfo", m2661a(str2)).m3380a(m2670c());
        MarkerConfig markerConfig2 = new MarkerConfig(markerConfig);
        PerformanceLogger performanceLogger = (PerformanceLogger) this.f1397c.get();
        markerConfig.f1698g = j;
        performanceLogger.mo391c(markerConfig);
        ((PerformanceLogger) this.f1397c.get()).mo387b(markerConfig2);
    }

    public static String m2671c(Class<?> cls) {
        return cls != null ? cls.getName() : "NO_CLASS";
    }

    public static String m2660a(Intent intent) {
        if (intent == null) {
            return "NO_INTENT";
        }
        String action = intent.getAction();
        if (action == null) {
            return "NO_ACTION";
        }
        return action;
    }
}
