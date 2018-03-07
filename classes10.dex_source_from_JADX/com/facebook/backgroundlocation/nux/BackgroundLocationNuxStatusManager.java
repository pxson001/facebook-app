package com.facebook.backgroundlocation.nux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.nux.status.UpdateNuxStatusParams;
import com.facebook.nux.status.UpdateNuxStatusParams.Status;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: double[] */
public class BackgroundLocationNuxStatusManager {
    public static final Class<?> f14767a = BackgroundLocationNuxStatusManager.class;
    private static volatile BackgroundLocationNuxStatusManager f14768f;
    private final DefaultBlueServiceOperationFactory f14769b;
    public final Context f14770c;
    public final FacebookOnlyIntentActionFactory f14771d;
    private final ExecutorService f14772e;

    /* compiled from: double[] */
    class C20681 implements Function<OperationResult, Boolean> {
        final /* synthetic */ BackgroundLocationNuxStatusManager f14766a;

        C20681(BackgroundLocationNuxStatusManager backgroundLocationNuxStatusManager) {
            this.f14766a = backgroundLocationNuxStatusManager;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                BLog.b(BackgroundLocationNuxStatusManager.f14767a, "Null result from updating NUX status");
                return Boolean.valueOf(false);
            }
            BackgroundLocationNuxStatusManager backgroundLocationNuxStatusManager = this.f14766a;
            backgroundLocationNuxStatusManager.f14770c.sendBroadcast(new Intent(backgroundLocationNuxStatusManager.f14771d.a("NEARBY_FRIENDS_SETTINGS_CHANGED_ACTION")));
            return Boolean.valueOf(operationResult.b);
        }
    }

    public static com.facebook.backgroundlocation.nux.BackgroundLocationNuxStatusManager m15132a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14768f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.nux.BackgroundLocationNuxStatusManager.class;
        monitor-enter(r1);
        r0 = f14768f;	 Catch:{ all -> 0x003a }
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
        r0 = m15134b(r0);	 Catch:{ all -> 0x0035 }
        f14768f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14768f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.nux.BackgroundLocationNuxStatusManager.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.nux.BackgroundLocationNuxStatusManager");
    }

    private static BackgroundLocationNuxStatusManager m15134b(InjectorLike injectorLike) {
        return new BackgroundLocationNuxStatusManager(DefaultBlueServiceOperationFactory.b(injectorLike), (Context) injectorLike.getInstance(Context.class), FacebookOnlyIntentActionFactory.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationNuxStatusManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, ExecutorService executorService) {
        this.f14769b = defaultBlueServiceOperationFactory;
        this.f14770c = context;
        this.f14771d = facebookOnlyIntentActionFactory;
        this.f14772e = executorService;
    }

    public final ListenableFuture<Boolean> m15136a(BackgroundLocationNuxStep backgroundLocationNuxStep, String str) {
        Preconditions.checkNotNull(backgroundLocationNuxStep);
        Preconditions.checkNotNull(str);
        return m15133a(backgroundLocationNuxStep, Status.COMPLETE, ImmutableBiMap.b("privacy", str));
    }

    public final ListenableFuture<Boolean> m15135a(BackgroundLocationNuxStep backgroundLocationNuxStep) {
        Preconditions.checkNotNull(backgroundLocationNuxStep);
        return m15133a(backgroundLocationNuxStep, Status.SKIPPED, RegularImmutableBiMap.a);
    }

    private ListenableFuture<Boolean> m15133a(BackgroundLocationNuxStep backgroundLocationNuxStep, Status status, ImmutableMap<String, String> immutableMap) {
        UpdateNuxStatusParams updateNuxStatusParams = new UpdateNuxStatusParams("location_upsell_wizard", "1631", backgroundLocationNuxStep.name(), status, immutableMap);
        Bundle bundle = new Bundle();
        bundle.putParcelable("updateNuxStatusParams", updateNuxStatusParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f14769b, "update_nux_status", bundle, -1917546893).a(), new C20681(this), this.f14772e);
    }
}
