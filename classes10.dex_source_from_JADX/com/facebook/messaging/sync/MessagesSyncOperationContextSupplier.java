package com.facebook.messaging.sync;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.sync.model.thrift.SyncPayload;
import com.facebook.sync.service.SyncOperationParamsUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: propertyToUpdate */
public class MessagesSyncOperationContextSupplier {
    private static volatile MessagesSyncOperationContextSupplier f4269d;
    private final SyncOperationParamsUtil f4270a;
    private final Provider<ViewerContext> f4271b;
    private final Provider<DbThreadsPropertyUtil> f4272c;

    public static com.facebook.messaging.sync.MessagesSyncOperationContextSupplier m3898a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4269d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.MessagesSyncOperationContextSupplier.class;
        monitor-enter(r1);
        r0 = f4269d;	 Catch:{ all -> 0x003a }
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
        r0 = m3899b(r0);	 Catch:{ all -> 0x0035 }
        f4269d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4269d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.MessagesSyncOperationContextSupplier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.MessagesSyncOperationContextSupplier");
    }

    private static MessagesSyncOperationContextSupplier m3899b(InjectorLike injectorLike) {
        return new MessagesSyncOperationContextSupplier(SyncOperationParamsUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 372), IdBasedProvider.a(injectorLike, 7808));
    }

    @Inject
    MessagesSyncOperationContextSupplier(SyncOperationParamsUtil syncOperationParamsUtil, Provider<ViewerContext> provider, Provider<DbThreadsPropertyUtil> provider2) {
        this.f4270a = syncOperationParamsUtil;
        this.f4271b = provider;
        this.f4272c = provider2;
    }

    public final Long m3900a(SyncPayload syncPayload) {
        return syncPayload.queueEntityId == null ? Long.valueOf(Long.parseLong(((ViewerContext) this.f4271b.get()).mUserId)) : syncPayload.queueEntityId;
    }
}
