package com.facebook.registration.logging;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: language_switcher_activity_no_suggestions */
public class RegistrationPerfLogger {
    private static volatile RegistrationPerfLogger f8898b;
    public final PerformanceLogger f8899a;

    public static com.facebook.registration.logging.RegistrationPerfLogger m8873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8898b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.registration.logging.RegistrationPerfLogger.class;
        monitor-enter(r1);
        r0 = f8898b;	 Catch:{ all -> 0x003a }
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
        r0 = m8874b(r0);	 Catch:{ all -> 0x0035 }
        f8898b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8898b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.registration.logging.RegistrationPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.registration.logging.RegistrationPerfLogger");
    }

    private static RegistrationPerfLogger m8874b(InjectorLike injectorLike) {
        return new RegistrationPerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public RegistrationPerfLogger(PerformanceLogger performanceLogger) {
        this.f8899a = performanceLogger;
    }

    public final void m8877b() {
        this.f8899a.a(4194305, "AccountCreationTime", null, "result", "success");
    }

    public final void m8876a(String str, boolean z) {
        String concat;
        if (z) {
            concat = str.concat("_background");
        } else {
            concat = str;
        }
        PerformanceLogger performanceLogger = this.f8899a;
        MarkerConfig markerConfig = new MarkerConfig(4194306, "RegistrationStepValidationTime");
        markerConfig.e = str;
        MarkerConfig b = markerConfig.a("step_info", concat).b();
        b.n = true;
        performanceLogger.a(b, true);
    }

    public final void m8875a(String str) {
        this.f8899a.a(4194306, "RegistrationStepValidationTime", str);
    }

    public final void m8878b(String str) {
        this.f8899a.c(4194306, "RegistrationStepValidationTime", str);
    }

    public final void m8879h() {
        this.f8899a.f(4194307, "RegistrationLoginTime");
    }
}
