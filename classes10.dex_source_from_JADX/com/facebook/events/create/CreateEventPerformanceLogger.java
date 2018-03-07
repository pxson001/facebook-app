package com.facebook.events.create;

import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: contact_upload_upsell_not_now */
public class CreateEventPerformanceLogger {
    private static volatile CreateEventPerformanceLogger f16040c;
    public final MarkerConfig f16041a;
    public final PerformanceLogger f16042b;

    public static com.facebook.events.create.CreateEventPerformanceLogger m16442a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16040c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.create.CreateEventPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f16040c;	 Catch:{ all -> 0x003a }
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
        r0 = m16443b(r0);	 Catch:{ all -> 0x0035 }
        f16040c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16040c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.create.CreateEventPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.create.CreateEventPerformanceLogger");
    }

    private static CreateEventPerformanceLogger m16443b(InjectorLike injectorLike) {
        return new CreateEventPerformanceLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public CreateEventPerformanceLogger(PerformanceLogger performanceLogger) {
        this.f16042b = performanceLogger;
        MarkerConfig a = new MarkerConfig(393232, "CreateEventTTI").a(new String[]{"event_composer", "event_permalink"});
        a.n = true;
        this.f16041a = a;
    }

    public final void m16444a() {
        this.f16042b.c(this.f16041a);
    }

    public final void m16445b() {
        this.f16042b.d(this.f16041a);
    }
}
