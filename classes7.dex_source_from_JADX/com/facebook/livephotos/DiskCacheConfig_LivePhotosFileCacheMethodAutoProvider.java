package com.facebook.livephotos;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: photo upload error */
public class DiskCacheConfig_LivePhotosFileCacheMethodAutoProvider extends AbstractProvider<DiskCacheConfig> {
    private static volatile DiskCacheConfig f6594a;

    public static com.facebook.cache.disk.DiskCacheConfig m8521a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6594a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.livephotos.DiskCacheConfig_LivePhotosFileCacheMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f6594a;	 Catch:{ all -> 0x003a }
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
        r0 = m8522b(r0);	 Catch:{ all -> 0x0035 }
        f6594a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6594a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.DiskCacheConfig_LivePhotosFileCacheMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.cache.disk.DiskCacheConfig");
    }

    private static DiskCacheConfig m8522b(InjectorLike injectorLike) {
        return LivePhotosModule.m8546a((Context) injectorLike.getInstance(Context.class), Factory.a(injectorLike), DiskCacheManager.a(injectorLike));
    }

    public Object get() {
        return LivePhotosModule.m8546a((Context) getInstance(Context.class), Factory.a(this), DiskCacheManager.a(this));
    }
}
