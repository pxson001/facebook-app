package com.facebook.feedback.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: source_module_role */
public class InlineReplyExpansionExperimentUtil {
    private static volatile InlineReplyExpansionExperimentUtil f4275b;
    public final QeAccessor f4276a;

    public static com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil m7911a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4275b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil.class;
        monitor-enter(r1);
        r0 = f4275b;	 Catch:{ all -> 0x003a }
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
        r0 = m7912b(r0);	 Catch:{ all -> 0x0035 }
        f4275b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4275b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil");
    }

    private static InlineReplyExpansionExperimentUtil m7912b(InjectorLike injectorLike) {
        return new InlineReplyExpansionExperimentUtil(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public InlineReplyExpansionExperimentUtil(QeAccessor qeAccessor) {
        this.f4276a = qeAccessor;
    }

    public final boolean m7913a() {
        return this.f4276a.mo596a(ExperimentsForFeedbackTestModule.f6841s, false);
    }

    public final boolean m7914b() {
        return m7913a() && this.f4276a.mo596a(ExperimentsForFeedbackTestModule.f6840r, false);
    }

    public final boolean m7915c() {
        return m7913a() && this.f4276a.mo596a(ExperimentsForFeedbackTestModule.f6839q, false);
    }
}
