package com.facebook.analytics.reporters.periodic;

import android.os.Build.VERSION;
import android.os.Debug;
import com.facebook.analytics.ClassInstancesToCheck;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.STATICDI_MULTIBIND_PROVIDER$ClassInstancesToCheck;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_action_menu_report_page */
public class ClassInstancesPeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static final Class<?> f1898a = ClassInstancesPeriodicReporter.class;
    private static volatile ClassInstancesPeriodicReporter f1899d;
    private final Set<ClassInstancesToCheck> f1900b;
    private final AppStateManager f1901c;

    public static com.facebook.analytics.reporters.periodic.ClassInstancesPeriodicReporter m2581a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1899d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.reporters.periodic.ClassInstancesPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f1899d;	 Catch:{ all -> 0x003a }
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
        r0 = m2583b(r0);	 Catch:{ all -> 0x0035 }
        f1899d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1899d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.periodic.ClassInstancesPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.reporters.periodic.ClassInstancesPeriodicReporter");
    }

    private static ClassInstancesPeriodicReporter m2583b(InjectorLike injectorLike) {
        return new ClassInstancesPeriodicReporter(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ClassInstancesToCheck(injectorLike)), AppStateManager.a(injectorLike));
    }

    @Inject
    public ClassInstancesPeriodicReporter(Set<ClassInstancesToCheck> set, AppStateManager appStateManager) {
        this.f1900b = set;
        this.f1901c = appStateManager;
    }

    public final HoneyAnalyticsEvent m2584a(long j, String str) {
        return m2580a();
    }

    private HoneyAnalyticsEvent m2580a() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("class_instances");
        return m2582a(honeyClientEvent) ? honeyClientEvent : null;
    }

    private boolean m2582a(HoneyClientEvent honeyClientEvent) {
        if (VERSION.SDK_INT < 14) {
            return false;
        }
        if (this.f1901c.l()) {
            return false;
        }
        System.gc();
        Class cls = Debug.class;
        for (ClassInstancesToCheck a : this.f1900b) {
            for (Entry entry : a.m2531a().entrySet()) {
                Class cls2 = (Class) entry.getKey();
                int intValue = ((Integer) entry.getValue()).intValue();
                try {
                    try {
                        long longValue = ((Long) cls.getDeclaredMethod("countInstancesOfClass", new Class[]{Class.class}).invoke(null, new Object[]{cls2})).longValue();
                        if (longValue > ((long) intValue)) {
                            honeyClientEvent.a(cls2.getName(), longValue);
                            return true;
                        }
                    } catch (Throwable e) {
                        BLog.b(f1898a, e, "Class invocation exception for %s", new Object[]{cls2});
                    } catch (Throwable e2) {
                        BLog.b(f1898a, e2, "Class illegal access exception for %s", new Object[]{cls2});
                    }
                } catch (NoSuchMethodException e3) {
                    return false;
                }
            }
        }
        return false;
    }
}
