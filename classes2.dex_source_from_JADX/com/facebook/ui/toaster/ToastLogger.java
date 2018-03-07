package com.facebook.ui.toaster;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: succeed_on_third_try */
public class ToastLogger {
    private static volatile ToastLogger f3876c;
    private final AnalyticsLogger f3877a;
    private final AbstractFbErrorReporter f3878b;

    public static com.facebook.ui.toaster.ToastLogger m6457a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3876c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.toaster.ToastLogger.class;
        monitor-enter(r1);
        r0 = f3876c;	 Catch:{ all -> 0x003a }
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
        r0 = m6458b(r0);	 Catch:{ all -> 0x0035 }
        f3876c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3876c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.toaster.ToastLogger.a(com.facebook.inject.InjectorLike):com.facebook.ui.toaster.ToastLogger");
    }

    private static ToastLogger m6458b(InjectorLike injectorLike) {
        return new ToastLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ToastLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3877a = analyticsLogger;
        this.f3878b = abstractFbErrorReporter;
    }

    public final void m6459a(CharSequence charSequence, String str, String str2, String str3, boolean z) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("error");
        String charSequence2 = charSequence.toString();
        honeyClientEvent.m5090b("message", charSequence2);
        honeyClientEvent.f3102f = SafeUUIDGenerator.m2795a().toString();
        if (str2 != null) {
            honeyClientEvent.f3101e = str2;
        }
        if (str != null) {
            honeyClientEvent.f3100d = str;
        }
        if (str3 != null) {
            honeyClientEvent.f3099c = str3;
        }
        this.f3877a.mo526a(honeyClientEvent);
        if (z) {
            this.f3878b.m2340a(str3 + ":toast", charSequence2);
        }
    }
}
