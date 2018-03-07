package com.facebook.analytics;

import android.content.res.Resources;
import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: subscribed_all */
public class InteractionLogger {
    private static final Class<?> f3901a = InteractionLogger.class;
    private static volatile InteractionLogger f3902f;
    public final AnalyticsLogger f3903b;
    public final NavigationLogger f3904c;
    private final DataUsageCounters f3905d;
    public Resources f3906e;

    public static com.facebook.analytics.InteractionLogger m6498a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3902f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.InteractionLogger.class;
        monitor-enter(r1);
        r0 = f3902f;	 Catch:{ all -> 0x003a }
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
        r0 = m6501b(r0);	 Catch:{ all -> 0x0035 }
        f3902f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3902f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.InteractionLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.InteractionLogger");
    }

    private static InteractionLogger m6501b(InjectorLike injectorLike) {
        return new InteractionLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NavigationLogger.m5475a(injectorLike), DataUsageCounters.m2584a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public InteractionLogger(AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, DataUsageCounters dataUsageCounters, Resources resources) {
        this.f3903b = analyticsLogger;
        this.f3904c = navigationLogger;
        this.f3905d = dataUsageCounters;
        this.f3906e = resources;
    }

    public final void m6505a(String str, String str2) {
        m6509b(str, "button", str2);
    }

    public final void m6506a(String str, String str2, String str3) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.f3101e = str;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3100d = str2;
        honeyClientEvent = honeyClientEvent;
        if (str3 != null) {
            honeyClientEvent.f3099c = str3;
        }
        this.f3903b.mo526a(honeyClientEvent);
    }

    public final void m6509b(String str, String str2, @Nullable String str3) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.f3101e = str;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3100d = str2;
        honeyClientEvent = honeyClientEvent;
        if (str3 != null) {
            honeyClientEvent.f3099c = str3;
        }
        this.f3903b.mo526a(honeyClientEvent);
    }

    public static HoneyClientEvent m6499a(ContentFlags contentFlags, String str, String str2, long j) {
        HoneyAnalyticsEvent a = new HoneyClientEvent("content").m5083a("flags", contentFlags.getValue());
        a.f3112e = j;
        if (str != null) {
            a.f3099c = str;
        }
        if (str2 != null) {
            a.f3102f = str2;
        }
        return a;
    }

    public final void m6504a(ContentFlags contentFlags, String str, String str2) {
        this.f3903b.mo526a(m6499a(contentFlags, str, str2, -1));
    }

    public final void m6502a() {
        this.f3904c.m5521e();
    }

    public final void m6507a(boolean z) {
        this.f3905d.m2591a(z ? "progress_spinner_modal" : "progress_spinner_non_modal", 1);
    }

    public final void m6503a(long j) {
        if (j > 0) {
            this.f3905d.m2591a("progress_spinner_time", j);
        }
    }

    public final boolean m6508a(long j, View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        m6503a(j);
        return true;
    }

    public static boolean m6500a(View view) {
        return view.getVisibility() != 0;
    }
}
