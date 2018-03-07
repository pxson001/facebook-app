package com.facebook.reaction.analytics.perflog;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_comment_replies */
public class ReactionPerfLogger {
    private static volatile ReactionPerfLogger f14912b;
    public final QuickPerformanceLogger f14913a;

    public static com.facebook.reaction.analytics.perflog.ReactionPerfLogger m21357a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14912b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.analytics.perflog.ReactionPerfLogger.class;
        monitor-enter(r1);
        r0 = f14912b;	 Catch:{ all -> 0x003a }
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
        r0 = m21358b(r0);	 Catch:{ all -> 0x0035 }
        f14912b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14912b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.analytics.perflog.ReactionPerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.reaction.analytics.perflog.ReactionPerfLogger");
    }

    private static ReactionPerfLogger m21358b(InjectorLike injectorLike) {
        return new ReactionPerfLogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public ReactionPerfLogger(QuickPerformanceLogger quickPerformanceLogger) {
        this.f14913a = quickPerformanceLogger;
    }

    public final void m21360a(int i, String str, Surface surface) {
        int hashCode = str.hashCode();
        this.f14913a.mo478e(i, hashCode);
        this.f14913a.mo464b(i, hashCode, "surface:" + surface);
        this.f14913a.mo464b(i, hashCode, "reaction_session_id:" + str);
    }

    public final void m21363b(int i, String str, Surface surface) {
        m21360a(i, str, surface);
        this.f14913a.mo465b(i, str.hashCode(), "surface", surface.toString());
    }

    public final void m21359a(int i, String str) {
        this.f14913a.mo466b(i, str.hashCode(), (short) 2);
    }

    public final void m21362b(int i, String str) {
        this.f14913a.mo466b(i, str.hashCode(), (short) 3);
    }

    public final void m21364c(int i, String str) {
        this.f14913a.markerCancel(i, str.hashCode());
    }

    public final void m21361a(int i, String str, String str2) {
        this.f14913a.mo464b(i, str.hashCode(), str2);
    }
}
