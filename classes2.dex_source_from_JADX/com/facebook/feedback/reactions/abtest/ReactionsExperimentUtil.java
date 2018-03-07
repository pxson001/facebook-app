package com.facebook.feedback.reactions.abtest;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved/?section_name=%s&referer=%s */
public class ReactionsExperimentUtil {
    private static volatile ReactionsExperimentUtil f6213d;
    public final Context f6214a;
    public final QeAccessor f6215b;
    public final GatekeeperStoreImpl f6216c;

    /* compiled from: saved/?section_name=%s&referer=%s */
    public enum InputDockAssetType {
        IMAGE(false),
        VECTOR_STATIC(true),
        VECTOR_ANIMATED_ALWAYS(true),
        VECTOR_ANIMATED_SELECTED(true);
        
        public final boolean isVectorBased;

        private InputDockAssetType(boolean z) {
            this.isVectorBased = z;
        }
    }

    public static com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil m10410a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6213d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil.class;
        monitor-enter(r1);
        r0 = f6213d;	 Catch:{ all -> 0x003a }
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
        r0 = m10411b(r0);	 Catch:{ all -> 0x0035 }
        f6213d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6213d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil");
    }

    private static ReactionsExperimentUtil m10411b(InjectorLike injectorLike) {
        return new ReactionsExperimentUtil((Context) injectorLike.getInstance(Context.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ReactionsExperimentUtil(Context context, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6214a = context;
        this.f6215b = qeAccessor;
        this.f6216c = gatekeeperStoreImpl;
    }

    public final void m10412e() {
        this.f6215b.mo588a(Liveness.Live, ExperimentsForReactionsTestModule.f21691h);
    }

    public final boolean m10413g() {
        return this.f6215b.mo596a(ExperimentsForReactionsTestModule.f21684a, false);
    }

    public final boolean m10414h() {
        return this.f6215b.mo596a(ExperimentsForReactionsTestModule.f21685b, false);
    }

    public final boolean m10415i() {
        return this.f6215b.mo596a(ExperimentsForReactionsTestModule.f21692i, false);
    }

    public final InputDockAssetType m10416j() {
        Object obj = (VERSION.SDK_INT < 18 || YearClass.m30095a(this.f6214a) < 2014 || m10418m()) ? null : 1;
        return obj != null ? InputDockAssetType.VECTOR_ANIMATED_ALWAYS : InputDockAssetType.IMAGE;
    }

    public final boolean m10417k() {
        return m10416j().isVectorBased && this.f6215b.mo596a(ExperimentsForReactionsTestModule.f21687d, false);
    }

    public final boolean m10418m() {
        return this.f6215b.mo596a(ExperimentsForReactionsTestModule.f21689f, false);
    }
}
