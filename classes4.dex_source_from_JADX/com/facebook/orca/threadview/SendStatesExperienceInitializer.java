package com.facebook.orca.threadview;

import android.os.Bundle;
import com.facebook.common.init.INeedInit;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logcat_flash_logs */
public class SendStatesExperienceInitializer implements INeedInit {
    private static final Class<?> f8984a = SendStatesExperienceInitializer.class;
    private static volatile SendStatesExperienceInitializer f8985e;
    private final GatekeeperListenersImpl f8986b;
    public final DefaultBlueServiceOperationFactory f8987c;
    private OnGatekeeperChangeListener f8988d;

    /* compiled from: logcat_flash_logs */
    class C05371 extends OnGatekeeperChangeListener {
        final /* synthetic */ SendStatesExperienceInitializer f11158a;

        C05371(SendStatesExperienceInitializer sendStatesExperienceInitializer) {
            this.f11158a = sendStatesExperienceInitializer;
        }

        public final void m11610a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            if (gatekeeperStoreImpl.a(i, false)) {
                BlueServiceOperationFactoryDetour.a(this.f11158a.f8987c, "fetch_bootstrapping_delivery_receipts", new Bundle(), 1510804060).a(true).a();
            }
        }
    }

    public static com.facebook.orca.threadview.SendStatesExperienceInitializer m9310a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8985e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.threadview.SendStatesExperienceInitializer.class;
        monitor-enter(r1);
        r0 = f8985e;	 Catch:{ all -> 0x003a }
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
        r0 = m9311b(r0);	 Catch:{ all -> 0x0035 }
        f8985e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8985e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.SendStatesExperienceInitializer.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadview.SendStatesExperienceInitializer");
    }

    private static SendStatesExperienceInitializer m9311b(InjectorLike injectorLike) {
        return new SendStatesExperienceInitializer(GatekeeperListenersImplMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public SendStatesExperienceInitializer(GatekeeperListenersImpl gatekeeperListenersImpl, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f8986b = gatekeeperListenersImpl;
        this.f8987c = defaultBlueServiceOperationFactory;
    }

    public void init() {
        this.f8988d = new C05371(this);
        this.f8986b.a(this.f8988d, 204);
    }
}
