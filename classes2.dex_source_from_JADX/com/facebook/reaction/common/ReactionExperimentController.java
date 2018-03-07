package com.facebook.reaction.common;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.abtest.ExperimentsForReactionAbtestModule;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_hscroll_ads_in_feed_fetch */
public class ReactionExperimentController {
    private static volatile ReactionExperimentController f14883c;
    public final GatekeeperStoreImpl f14884a;
    public final QeAccessor f14885b;

    public static com.facebook.reaction.common.ReactionExperimentController m21318a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14883c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.common.ReactionExperimentController.class;
        monitor-enter(r1);
        r0 = f14883c;	 Catch:{ all -> 0x003a }
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
        r0 = m21319b(r0);	 Catch:{ all -> 0x0035 }
        f14883c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14883c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.common.ReactionExperimentController.a(com.facebook.inject.InjectorLike):com.facebook.reaction.common.ReactionExperimentController");
    }

    private static ReactionExperimentController m21319b(InjectorLike injectorLike) {
        return new ReactionExperimentController(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ReactionExperimentController(GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        this.f14884a = gatekeeperStoreImpl;
        this.f14885b = qeAccessor;
    }

    public final boolean m21320a() {
        return this.f14885b.mo596a(ExperimentsForReactionAbtestModule.f13566c, false);
    }

    public final boolean m21321d() {
        return this.f14884a.m2189a(1069, false);
    }

    public final boolean m21322e() {
        return this.f14884a.m2189a(1070, false);
    }

    public final boolean m21323g() {
        return this.f14884a.m2189a(1076, false);
    }

    public final boolean m21324h() {
        return this.f14884a.m2189a(1072, false);
    }

    public final boolean m21325i() {
        return this.f14884a.m2189a(887, false);
    }

    public final boolean m21326j() {
        return this.f14884a.m2189a(712, false);
    }

    public final boolean m21327k() {
        return this.f14884a.m2189a(713, false);
    }

    public final boolean m21328m() {
        return this.f14884a.m2189a(1073, false);
    }

    public final boolean m21329o() {
        return this.f14884a.m2189a(1075, false);
    }

    public final boolean m21330p() {
        return this.f14884a.m2189a(1077, false);
    }
}
