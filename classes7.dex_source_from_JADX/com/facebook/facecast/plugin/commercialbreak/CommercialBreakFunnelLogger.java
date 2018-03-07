package com.facebook.facecast.plugin.commercialbreak;

import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.funnellogger.PayloadBundle;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: blendFunc */
public class CommercialBreakFunnelLogger {
    private static volatile CommercialBreakFunnelLogger f18572f;
    public final FunnelLoggerImpl f18573a;
    @Nullable
    public String f18574b;
    public long f18575c;
    public long f18576d = -1;
    public int f18577e;

    public static com.facebook.facecast.plugin.commercialbreak.CommercialBreakFunnelLogger m22189a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18572f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecast.plugin.commercialbreak.CommercialBreakFunnelLogger.class;
        monitor-enter(r1);
        r0 = f18572f;	 Catch:{ all -> 0x003a }
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
        r0 = m22190b(r0);	 Catch:{ all -> 0x0035 }
        f18572f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18572f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.plugin.commercialbreak.CommercialBreakFunnelLogger.a(com.facebook.inject.InjectorLike):com.facebook.facecast.plugin.commercialbreak.CommercialBreakFunnelLogger");
    }

    private static CommercialBreakFunnelLogger m22190b(InjectorLike injectorLike) {
        return new CommercialBreakFunnelLogger(FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public CommercialBreakFunnelLogger(FunnelLoggerImpl funnelLoggerImpl) {
        this.f18573a = funnelLoggerImpl;
    }

    public final void m22192b() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_eligible", null, m22191j());
    }

    public final void m22193c() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_initiate", null, m22191j());
    }

    public final void m22194d() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_confirm", null, m22191j());
    }

    public final void m22195e() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_cancel", null, m22191j());
    }

    public final void m22196f() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_pre_countdown_cancel", null, m22191j());
    }

    public final void m22197g() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_start", null, m22191j());
    }

    public final void m22198h() {
        this.f18573a.a(FunnelRegistry.C, "commercial_break_end", null, m22191j());
        this.f18576d = this.f18575c;
        this.f18577e++;
    }

    private PayloadBundle m22191j() {
        PayloadBundle a = PayloadBundle.a().a("video_id", this.f18574b).a("video_timestamp_ms", this.f18575c).a("last_break_timestamp_ms", this.f18576d);
        int i = this.f18577e;
        a.a.a("number_of_breaks", i);
        return a;
    }
}
