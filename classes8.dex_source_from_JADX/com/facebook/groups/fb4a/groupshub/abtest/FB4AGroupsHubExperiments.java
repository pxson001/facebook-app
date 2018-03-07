package com.facebook.groups.fb4a.groupshub.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: failed to switch camera */
public class FB4AGroupsHubExperiments {
    private static volatile FB4AGroupsHubExperiments f13857d;
    private final GatekeeperStoreImpl f13858a;
    public final QeAccessor f13859b;
    private final Provider<Boolean> f13860c;

    public static com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments m15493a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13857d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments.class;
        monitor-enter(r1);
        r0 = f13857d;	 Catch:{ all -> 0x003a }
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
        r0 = m15494b(r0);	 Catch:{ all -> 0x0035 }
        f13857d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13857d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments.a(com.facebook.inject.InjectorLike):com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments");
    }

    private static FB4AGroupsHubExperiments m15494b(InjectorLike injectorLike) {
        return new FB4AGroupsHubExperiments(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3967));
    }

    @Inject
    FB4AGroupsHubExperiments(GatekeeperStore gatekeeperStore, QeAccessor qeAccessor, Provider<Boolean> provider) {
        this.f13858a = gatekeeperStore;
        this.f13859b = qeAccessor;
        this.f13860c = provider;
    }

    public final boolean m15495b() {
        return ((Boolean) this.f13860c.get()).booleanValue() && (this.f13858a.a(671, false) || this.f13859b.a(Liveness.Live, ExperimentsForFB4AGroupsHubAbtestModule.f13854c, false));
    }

    public final boolean m15496c() {
        return this.f13859b.a(Liveness.Live, ExperimentsForFB4AGroupsHubAbtestModule.f13852a, false);
    }

    public final boolean m15497d() {
        return ((Boolean) this.f13860c.get()).booleanValue() && this.f13859b.a(Liveness.Live, ExperimentsForFB4AGroupsHubAbtestModule.f13856e, false);
    }

    public final boolean m15498f() {
        return m15496c() && m15497d() && this.f13859b.a(Liveness.Live, ExperimentsForFB4AGroupsHubAbtestModule.f13853b, false);
    }
}
