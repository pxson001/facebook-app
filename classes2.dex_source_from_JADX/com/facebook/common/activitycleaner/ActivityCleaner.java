package com.facebook.common.activitycleaner;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.activity.IFbMainTabActivity;
import com.facebook.common.activitycleaner.ActivityStackManager.Entry;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.recycle.ViewPoolCleaner;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: quick_promotion_refresh */
public class ActivityCleaner implements MemoryTrimmable {
    private static final Class<?> f8326a = ActivityCleaner.class;
    private static volatile ActivityCleaner f8327j;
    private final Clock f8328b;
    private final int f8329c;
    private final boolean f8330d;
    private final FbSharedPreferences f8331e;
    public final ActivityStackManager f8332f;
    public final AnalyticsLogger f8333g;
    private final ExecutorService f8334h;
    private final QeAccessor f8335i;

    /* compiled from: quick_promotion_refresh */
    public class C03621 {
        public final /* synthetic */ ActivityCleaner f8344a;

        C03621(ActivityCleaner activityCleaner) {
            this.f8344a = activityCleaner;
        }
    }

    public static com.facebook.common.activitycleaner.ActivityCleaner m12845a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8327j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.activitycleaner.ActivityCleaner.class;
        monitor-enter(r1);
        r0 = f8327j;	 Catch:{ all -> 0x003a }
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
        r0 = m12848b(r0);	 Catch:{ all -> 0x0035 }
        f8327j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8327j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.activitycleaner.ActivityCleaner.a(com.facebook.inject.InjectorLike):com.facebook.common.activitycleaner.ActivityCleaner");
    }

    private static ActivityCleaner m12848b(InjectorLike injectorLike) {
        return new ActivityCleaner(SystemClockMethodAutoProvider.m1498a(injectorLike), VMMemoryInfoMethodAutoProvider.m2302a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), ActivityStackManager.m4298a(injectorLike), MemoryManager.m9807a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ActivityCleaner(Clock clock, VMMemoryInfo vMMemoryInfo, FbSharedPreferences fbSharedPreferences, ActivityStackManager activityStackManager, MemoryTrimmableRegistry memoryTrimmableRegistry, AnalyticsLogger analyticsLogger, ExecutorService executorService, QeAccessor qeAccessor) {
        this(clock, vMMemoryInfo, 8, fbSharedPreferences, activityStackManager, memoryTrimmableRegistry, analyticsLogger, executorService, qeAccessor);
    }

    @VisibleForTesting
    private ActivityCleaner(Clock clock, VMMemoryInfo vMMemoryInfo, int i, FbSharedPreferences fbSharedPreferences, ActivityStackManager activityStackManager, MemoryTrimmableRegistry memoryTrimmableRegistry, AnalyticsLogger analyticsLogger, ExecutorService executorService, QeAccessor qeAccessor) {
        this.f8328b = clock;
        this.f8330d = vMMemoryInfo.m2306a();
        if (this.f8330d) {
            i = 6;
        }
        this.f8329c = i;
        this.f8331e = fbSharedPreferences;
        this.f8332f = activityStackManager;
        memoryTrimmableRegistry.mo1390a(this);
        this.f8333g = analyticsLogger;
        this.f8332f.f2124l = new C03621(this);
        this.f8334h = executorService;
        this.f8335i = qeAccessor;
    }

    public final void m12851a(Activity activity) {
        m12849f(activity);
        this.f8332f.m4308f();
    }

    public final void m12853b(Activity activity) {
        ActivityStackManager activityStackManager = this.f8332f;
        Entry entry = (Entry) activityStackManager.f2116d.get(activity);
        if (entry == null) {
            entry = new Entry(activity);
            activityStackManager.f2116d.put(activity, entry);
            activityStackManager.f2114b.add(entry);
            activityStackManager.f2115c++;
        }
        entry.f8348c = this.f8328b.mo211a();
        m12846a(this, this.f8329c, activity);
        this.f8332f.m4308f();
    }

    public final void m12854c(Activity activity) {
        if (this.f8330d) {
            m12849f(activity);
            if (activity instanceof ViewPoolCleaner) {
                ((ViewPoolCleaner) activity).mo793e();
            }
        }
    }

    private void m12849f(Activity activity) {
        List g = this.f8332f.m4309g();
        if (activity instanceof ViewPoolCleaner) {
            int size = g.size() - 1;
            while (size >= 0) {
                Activity b = ((Entry) g.get(size)).m12860b();
                if (b == activity || !(b instanceof ViewPoolCleaner)) {
                    size--;
                } else {
                    ((ViewPoolCleaner) b).mo793e();
                    return;
                }
            }
        }
    }

    public static void m12846a(ActivityCleaner activityCleaner, @Nullable int i, Activity activity) {
        if (activityCleaner.f8331e.mo284a()) {
            Object obj;
            Object obj2;
            int h = activityCleaner.f8332f.m4310h() - i;
            List a = Lists.m1296a();
            for (Entry entry : activityCleaner.f8332f.m4309g()) {
                if (entry.m12860b() != null && m12850h(entry.m12860b())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            int i2 = h;
            Object obj3 = obj2;
            for (Entry entry2 : activityCleaner.f8332f.m4309g()) {
                if (i2 <= 0) {
                    break;
                } else if (obj3 != null) {
                    obj3 = null;
                } else {
                    Activity b = entry2.m12860b();
                    if (!(m12850h(b) || b == activity)) {
                        int i3;
                        if (b != null) {
                            a.add(b);
                            i3 = i2 - 1;
                        } else {
                            i3 = i2;
                        }
                        i2 = i3;
                    }
                }
            }
            activityCleaner.m12847a(a);
        }
    }

    @VisibleForTesting
    public final void m12855e(Activity activity) {
        if (this.f8331e.mo284a()) {
            List a = Lists.m1296a();
            for (Entry b : this.f8332f.m4309g()) {
                Activity b2 = b.m12860b();
                if (!(m12850h(b2) || b2 == activity)) {
                    a.add(b2);
                }
            }
            m12847a(a);
        }
    }

    private void m12847a(List<Activity> list) {
        for (Activity activity : list) {
            this.f8332f.m4304b(activity);
            activity.finish();
            HoneyClientEventFast a = this.f8333g.mo535a("activity_cleaned_by_cleaner", false);
            if (a.m17388a()) {
                a.m17385a("cleaned_activity", activity.getClass().getName());
                a.m17390b();
            }
            activity.getClass().getName();
        }
    }

    public static boolean m12850h(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity instanceof IFbMainTabActivity;
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        if (memoryTrimType == MemoryTrimType.OnAppBackgrounded) {
            if (this.f8335i.mo596a(ExperimentsForActivityCleanerModule.a, false)) {
                ExecutorDetour.a(this.f8334h, new 2(this, this.f8335i.mo572a(ExperimentsForActivityCleanerModule.b, 6)), -1473965320);
            } else {
                return;
            }
        }
        if (this.f8330d || memoryTrimType != MemoryTrimType.OnSystemLowMemoryWhileAppInForeground) {
            ExecutorDetour.a(this.f8334h, new 3(this), 682069377);
        }
    }
}
