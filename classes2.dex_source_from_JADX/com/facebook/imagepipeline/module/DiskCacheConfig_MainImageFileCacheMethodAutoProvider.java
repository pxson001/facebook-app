package com.facebook.imagepipeline.module;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;

/* compiled from: outgoing_message_lifetime_ms */
public class DiskCacheConfig_MainImageFileCacheMethodAutoProvider extends AbstractProvider<DiskCacheConfig> {
    private static volatile DiskCacheConfig f10662a;

    public static com.facebook.cache.disk.DiskCacheConfig m15939a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10662a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.module.DiskCacheConfig_MainImageFileCacheMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f10662a;	 Catch:{ all -> 0x003a }
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
        r0 = m15940b(r0);	 Catch:{ all -> 0x0035 }
        f10662a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10662a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.module.DiskCacheConfig_MainImageFileCacheMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.cache.disk.DiskCacheConfig");
    }

    private static DiskCacheConfig m15940b(InjectorLike injectorLike) {
        return ImagePipelineModule.m15564a((Context) injectorLike.getInstance(Context.class), Factory.m9186a(injectorLike), DefaultCacheErrorLogger.m15941a(injectorLike), DiskCacheManager.m9192a(injectorLike), FbEntryEvictionComparatorSupplier.m15953a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), CacheDirExperimentMigrator.m15957a(injectorLike), CacheLocationDetails.m15961a(injectorLike));
    }

    public Object get() {
        return ImagePipelineModule.m15564a((Context) getInstance(Context.class), Factory.m9186a((InjectorLike) this), DefaultCacheErrorLogger.m15941a(this), DiskCacheManager.m9192a((InjectorLike) this), FbEntryEvictionComparatorSupplier.m15953a(this), QeInternalImplMethodAutoProvider.m3744a(this), CacheDirExperimentMigrator.m15957a((InjectorLike) this), CacheLocationDetails.m15961a((InjectorLike) this));
    }
}