package com.facebook.components.fb.logger;

import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: generic_list */
public class QPLComponentsLogger {
    private static volatile QPLComponentsLogger f22667b;
    private final QuickPerformanceLogger f22668a;

    public static com.facebook.components.fb.logger.QPLComponentsLogger m30609a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22667b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.logger.QPLComponentsLogger.class;
        monitor-enter(r1);
        r0 = f22667b;	 Catch:{ all -> 0x003a }
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
        r0 = m30610b(r0);	 Catch:{ all -> 0x0035 }
        f22667b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22667b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.logger.QPLComponentsLogger.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.logger.QPLComponentsLogger");
    }

    private static QPLComponentsLogger m30610b(InjectorLike injectorLike) {
        return new QPLComponentsLogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public QPLComponentsLogger(QuickPerformanceLogger quickPerformanceLogger) {
        this.f22668a = quickPerformanceLogger;
        this.f22668a.mo463b(9043969, 200);
        this.f22668a.mo463b(9043970, 200);
        this.f22668a.mo463b(9043971, 200);
        this.f22668a.mo463b(9043972, 200);
        this.f22668a.mo463b(9043973, 200);
        this.f22668a.mo463b(9043974, 200);
        this.f22668a.mo463b(9043975, 200);
    }

    public final void m30612a(int i, Object obj) {
        this.f22668a.mo478e(m30608a(i), obj.hashCode());
    }

    public final void m30614a(int i, Object obj, String str, String str2) {
        this.f22668a.mo442a(m30608a(i), obj.hashCode(), str, str2);
    }

    public final void m30613a(int i, Object obj, int i2) {
        this.f22668a.mo466b(m30608a(i), obj.hashCode(), m30611b(i2));
    }

    public final void m30615b(int i, Object obj, String str, String str2) {
        this.f22668a.mo465b(m30608a(i), obj.hashCode(), str, str2);
    }

    private static int m30608a(int i) {
        switch (i) {
            case 0:
                return 9043970;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 9043971;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 9043972;
            case 3:
                return 9043969;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 9043973;
            case 5:
                return 9043974;
            case 6:
                return 9043975;
            default:
                throw new IllegalArgumentException("No QPL event to match id = " + i);
        }
    }

    private static short m30611b(int i) {
        switch (i) {
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return (short) 2;
            default:
                throw new IllegalArgumentException("No QPL action to match id = " + i);
        }
    }
}
