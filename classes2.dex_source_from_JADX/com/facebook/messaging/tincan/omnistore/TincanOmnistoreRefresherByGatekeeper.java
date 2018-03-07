package com.facebook.messaging.tincan.omnistore;

import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponentManager;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: toggle_availability */
public class TincanOmnistoreRefresherByGatekeeper {
    private static volatile TincanOmnistoreRefresherByGatekeeper f15511c;
    private final OmnistoreComponentManager f15512a;
    private final List<OmnistoreComponent> f15513b = new ArrayList();

    @Singleton
    /* compiled from: toggle_availability */
    public class GatekeeperListenerRegistration extends INeedInitForGatekeepersListenerRegistration<TincanOmnistoreRefresherByGatekeeper> {
        private static volatile GatekeeperListenerRegistration f2451b;

        public static com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.GatekeeperListenerRegistration m4660a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2451b;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.GatekeeperListenerRegistration.class;
            monitor-enter(r1);
            r0 = f2451b;	 Catch:{ all -> 0x003a }
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
            r0 = m4661b(r0);	 Catch:{ all -> 0x0035 }
            f2451b = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2451b;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.GatekeeperListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper$GatekeeperListenerRegistration");
        }

        private static GatekeeperListenerRegistration m4661b(InjectorLike injectorLike) {
            return new GatekeeperListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2741));
        }

        protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
            ((TincanOmnistoreRefresherByGatekeeper) obj).m22129a();
        }

        @Inject
        public GatekeeperListenerRegistration(Lazy<TincanOmnistoreRefresherByGatekeeper> lazy) {
            super((Lazy) lazy, 339);
        }
    }

    public static com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper m22127a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15511c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.class;
        monitor-enter(r1);
        r0 = f15511c;	 Catch:{ all -> 0x003a }
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
        r0 = m22128b(r0);	 Catch:{ all -> 0x0035 }
        f15511c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15511c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper");
    }

    private static TincanOmnistoreRefresherByGatekeeper m22128b(InjectorLike injectorLike) {
        return new TincanOmnistoreRefresherByGatekeeper(OmnistoreComponentManager.m4528x77537f3(injectorLike));
    }

    @Inject
    public TincanOmnistoreRefresherByGatekeeper(OmnistoreComponentManager omnistoreComponentManager) {
        this.f15512a = omnistoreComponentManager;
    }

    public final synchronized void m22130a(OmnistoreComponent omnistoreComponent) {
        Preconditions.checkArgument(!this.f15513b.contains(omnistoreComponent));
        this.f15513b.add(omnistoreComponent);
    }

    public final synchronized void m22129a() {
        for (OmnistoreComponent checkComponentSubscription : this.f15513b) {
            this.f15512a.checkComponentSubscription(checkComponentSubscription);
        }
    }
}
