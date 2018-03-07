package com.facebook.messaging.payment.sync;

import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.sync.model.PaymentsSyncPrefKeys;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.sync.SyncInitializationHandler;
import com.facebook.sync.SyncInitializationHandler.EnsureSyncTrigger;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncConnectionStateManager.QueueKey;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: frameTimestampBuffer */
public class PaymentsSyncInitializationHandler implements SyncInitializationHandler {
    private static volatile PaymentsSyncInitializationHandler f11431e;
    private final Provider<Boolean> f11432a;
    private final DefaultBlueServiceOperationFactory f11433b;
    private final Provider<ViewerContext> f11434c;
    private final SyncConnectionStateManager f11435d;

    public static com.facebook.messaging.payment.sync.PaymentsSyncInitializationHandler m11871a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11431e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.sync.PaymentsSyncInitializationHandler.class;
        monitor-enter(r1);
        r0 = f11431e;	 Catch:{ all -> 0x003a }
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
        r0 = m11872b(r0);	 Catch:{ all -> 0x0035 }
        f11431e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11431e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.PaymentsSyncInitializationHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.PaymentsSyncInitializationHandler");
    }

    private static PaymentsSyncInitializationHandler m11872b(InjectorLike injectorLike) {
        return new PaymentsSyncInitializationHandler(IdBasedProvider.a(injectorLike, 4184), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 372), SyncConnectionStateManager.m11887a(injectorLike));
    }

    @Inject
    public PaymentsSyncInitializationHandler(Provider<Boolean> provider, BlueServiceOperationFactory blueServiceOperationFactory, Provider<ViewerContext> provider2, SyncConnectionStateManager syncConnectionStateManager) {
        this.f11432a = provider;
        this.f11433b = blueServiceOperationFactory;
        this.f11435d = syncConnectionStateManager;
        this.f11434c = provider2;
    }

    public final boolean mo840a() {
        return ((Boolean) this.f11432a.get()).booleanValue();
    }

    public final ImmutableList<PrefKey> mo841b() {
        return ImmutableList.of(PaymentsSyncPrefKeys.f11443b);
    }

    public final ImmutableList<Integer> mo843c() {
        return ImmutableList.of(Integer.valueOf(1039));
    }

    @Nullable
    public final String mo844d() {
        return null;
    }

    public final void mo842b(EnsureSyncTrigger ensureSyncTrigger) {
        if (!this.f11435d.m11893a(QueueKey.a(((ViewerContext) this.f11434c.get()).mUserId, IrisQueueTypes.PAYMENTS_QUEUE_TYPE))) {
            mo839a(ensureSyncTrigger);
        }
    }

    public final void mo839a(EnsureSyncTrigger ensureSyncTrigger) {
        BlueServiceOperationFactoryDetour.a(this.f11433b, "ensure_payments_sync", new Bundle(), CallerContext.a(getClass()), -213026726).a(true).a();
    }

    public final void mo845e() {
    }
}
