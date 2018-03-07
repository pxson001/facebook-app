package com.facebook.photos.upload.progresspage;

import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: getRating */
public class MediaUploadActivityReceiver {
    private static volatile MediaUploadActivityReceiver f13952g;
    public final PendingStoryStore f13953a;
    public final Lazy<CompostPendingPostStore> f13954b;
    public final Lazy<RecentlyUploadedStoryStore> f13955c;
    public final Lazy<CompostDraftStoryStore> f13956d;
    public final ComposerActivityBroadcaster f13957e;
    private final QeAccessor f13958f;

    public static com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver m21679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13952g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver.class;
        monitor-enter(r1);
        r0 = f13952g;	 Catch:{ all -> 0x003a }
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
        r0 = m21680b(r0);	 Catch:{ all -> 0x0035 }
        f13952g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13952g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver");
    }

    private static MediaUploadActivityReceiver m21680b(InjectorLike injectorLike) {
        return new MediaUploadActivityReceiver(PendingStoryStore.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9452), IdBasedSingletonScopeProvider.b(injectorLike, 5274), IdBasedSingletonScopeProvider.b(injectorLike, 5273), ComposerActivityBroadcaster.m11633a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaUploadActivityReceiver(PendingStoryStore pendingStoryStore, Lazy<CompostPendingPostStore> lazy, Lazy<RecentlyUploadedStoryStore> lazy2, Lazy<CompostDraftStoryStore> lazy3, ComposerActivityBroadcaster composerActivityBroadcaster, QeAccessor qeAccessor) {
        this.f13953a = pendingStoryStore;
        this.f13954b = lazy;
        this.f13955c = lazy2;
        this.f13956d = lazy3;
        this.f13957e = composerActivityBroadcaster;
        this.f13958f = qeAccessor;
    }

    public final boolean m21681a() {
        return this.f13958f.a(ExperimentsForCompostAbTestModule.f8107z, false);
    }
}
