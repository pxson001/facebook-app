package com.facebook.sync.connection;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_add_streaming_reaction_subscribe */
public class SyncDeviceParamsFactory {
    private static volatile SyncDeviceParamsFactory f14481d;
    private final SyncParamsUtil f14482a;
    private final Provider<Boolean> f14483b;
    private final GatekeeperStoreImpl f14484c;

    public static com.facebook.sync.connection.SyncDeviceParamsFactory m18364a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14481d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.connection.SyncDeviceParamsFactory.class;
        monitor-enter(r1);
        r0 = f14481d;	 Catch:{ all -> 0x003a }
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
        r0 = m18365b(r0);	 Catch:{ all -> 0x0035 }
        f14481d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14481d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncDeviceParamsFactory.a(com.facebook.inject.InjectorLike):com.facebook.sync.connection.SyncDeviceParamsFactory");
    }

    private static SyncDeviceParamsFactory m18365b(InjectorLike injectorLike) {
        return new SyncDeviceParamsFactory(SyncParamsUtil.m18395a(injectorLike), IdBasedProvider.a(injectorLike, 4106), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SyncDeviceParamsFactory(SyncParamsUtil syncParamsUtil, Provider<Boolean> provider, GatekeeperStore gatekeeperStore) {
        this.f14482a = syncParamsUtil;
        this.f14483b = provider;
        this.f14484c = gatekeeperStore;
    }

    public final ObjectNode m18366a() {
        SyncParamsUtil syncParamsUtil = this.f14482a;
        int f = syncParamsUtil.f14502b.m9478f();
        int g = syncParamsUtil.f14502b.m9479g();
        int e = syncParamsUtil.f14502b.m9477e();
        int a = syncParamsUtil.f14502b.m9472a();
        int b = syncParamsUtil.f14502b.m9473b();
        syncParamsUtil.f14501a.edit().a(SyncParamsPrefKeys.m18393a(AttachmentImageType.FULL_SCREEN.persistentIndex), f).a(SyncParamsPrefKeys.m18394b(AttachmentImageType.FULL_SCREEN.persistentIndex), g).a(SyncParamsPrefKeys.m18393a(AttachmentImageType.LARGE_PREVIEW.persistentIndex), e).a(SyncParamsPrefKeys.m18394b(AttachmentImageType.LARGE_PREVIEW.persistentIndex), e).a(SyncParamsPrefKeys.m18393a(AttachmentImageType.MEDIUM_PREVIEW.persistentIndex), a).a(SyncParamsPrefKeys.m18394b(AttachmentImageType.MEDIUM_PREVIEW.persistentIndex), a).a(SyncParamsPrefKeys.m18393a(AttachmentImageType.SMALL_PREVIEW.persistentIndex), b).a(SyncParamsPrefKeys.m18394b(AttachmentImageType.SMALL_PREVIEW.persistentIndex), b).commit();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.c("image_sizes", this.f14482a.m18399b());
        if (((Boolean) this.f14483b.get()).booleanValue()) {
            objectNode.a("image_format", "WEBP");
        }
        objectNode.a("animated_image_format", "WEBP,GIF");
        objectNode.c("animated_image_sizes", this.f14482a.m18399b());
        if (this.f14484c.a(264) == TriState.YES) {
            objectNode.a("mini_preview", true);
        }
        return objectNode;
    }
}
