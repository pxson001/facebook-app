package com.facebook.messaging.sync;

import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.sync.SyncInitializationHandler.EnsureSyncTrigger;
import com.facebook.sync.connection.SyncConnectionHandler.ConnectionFreshness;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncConnectionStateManager.QueueKey;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.service.SyncOperationParamsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fragment_loaded */
public class SingleEntityMessagesSyncInitializationHandler implements MessagesSyncInitializationHandler {
    private static volatile SingleEntityMessagesSyncInitializationHandler f11444h;
    private final Provider<Boolean> f11445b;
    private final DefaultBlueServiceOperationFactory f11446c;
    private final SyncOperationParamsUtil f11447d;
    private final Provider<ViewerContext> f11448e;
    public ListenableFuture<OperationResult> f11449f;
    private SyncConnectionStateManager f11450g;

    public static com.facebook.messaging.sync.SingleEntityMessagesSyncInitializationHandler m11896a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11444h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.SingleEntityMessagesSyncInitializationHandler.class;
        monitor-enter(r1);
        r0 = f11444h;	 Catch:{ all -> 0x003a }
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
        r0 = m11897b(r0);	 Catch:{ all -> 0x0035 }
        f11444h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11444h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.SingleEntityMessagesSyncInitializationHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.SingleEntityMessagesSyncInitializationHandler");
    }

    private static SingleEntityMessagesSyncInitializationHandler m11897b(InjectorLike injectorLike) {
        return new SingleEntityMessagesSyncInitializationHandler(DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4075), SyncOperationParamsUtil.m11907a(injectorLike), IdBasedProvider.a(injectorLike, 372), SyncConnectionStateManager.m11887a(injectorLike));
    }

    @Inject
    public SingleEntityMessagesSyncInitializationHandler(BlueServiceOperationFactory blueServiceOperationFactory, Provider<Boolean> provider, SyncOperationParamsUtil syncOperationParamsUtil, Provider<ViewerContext> provider2, SyncConnectionStateManager syncConnectionStateManager) {
        this.f11446c = blueServiceOperationFactory;
        this.f11445b = provider;
        this.f11447d = syncOperationParamsUtil;
        this.f11450g = syncConnectionStateManager;
        this.f11448e = provider2;
    }

    public final ImmutableList<PrefKey> mo841b() {
        return RegularImmutableList.a;
    }

    public final boolean mo840a() {
        return ((Boolean) this.f11445b.get()).booleanValue();
    }

    public final ImmutableList<Integer> mo843c() {
        return ImmutableList.of(Integer.valueOf(950), Integer.valueOf(348), Integer.valueOf(349));
    }

    @Nullable
    public final String mo844d() {
        return a;
    }

    public final void mo842b(EnsureSyncTrigger ensureSyncTrigger) {
        if (!this.f11450g.m11893a(QueueKey.a(((ViewerContext) this.f11448e.get()).mUserId, IrisQueueTypes.MESSAGES_QUEUE_TYPE))) {
            mo839a(ensureSyncTrigger);
        }
    }

    public final void mo839a(EnsureSyncTrigger ensureSyncTrigger) {
        Bundle a;
        if (ensureSyncTrigger != EnsureSyncTrigger.NORMAL) {
            a = SyncOperationParamsUtil.m11905a(ConnectionFreshness.REFRESH_CONNECTION);
        } else {
            a = new Bundle();
        }
        BlueServiceOperationFactoryDetour.a(this.f11446c, "ensure_sync", a, CallerContext.a(getClass()), -1456556438).a(true).a();
    }

    public final void mo845e() {
        if (this.f11449f == null) {
            this.f11449f = BlueServiceOperationFactoryDetour.a(this.f11446c, "ensure_sync", SyncOperationParamsUtil.m11905a(ConnectionFreshness.REFRESH_CONNECTION), CallerContext.a(getClass()), -1034611415).a(true).a();
            this.f11449f.a(new 1(this), MoreExecutors.a());
        }
    }
}
