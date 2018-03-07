package com.facebook.photos.consumptiongallery;

import android.support.v4.util.LruCache;
import com.facebook.auth.privacy.IHaveUserData;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: status_update_ipb */
public class ConsumptionPhotoCache implements IHaveUserData {
    private static volatile ConsumptionPhotoCache f2084b;
    private final LruCache<Long, ConsumptionPhoto> f2085a = new LruCache(75);

    public static com.facebook.photos.consumptiongallery.ConsumptionPhotoCache m2290a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f2084b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.consumptiongallery.ConsumptionPhotoCache.class;
        monitor-enter(r1);
        r0 = f2084b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m2292b();	 Catch:{ all -> 0x0034 }
        f2084b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2084b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.consumptiongallery.ConsumptionPhotoCache.a(com.facebook.inject.InjectorLike):com.facebook.photos.consumptiongallery.ConsumptionPhotoCache");
    }

    private static ConsumptionPhotoCache m2292b() {
        return new ConsumptionPhotoCache();
    }

    @Nullable
    public final synchronized ConsumptionPhoto m2293a(long j) {
        return (ConsumptionPhoto) this.f2085a.a(Long.valueOf(j));
    }

    public final synchronized void m2294a(ConsumptionPhoto consumptionPhoto) {
        Preconditions.checkNotNull(consumptionPhoto);
        this.f2085a.a(Long.valueOf(consumptionPhoto.e()), consumptionPhoto);
    }

    private synchronized void m2291a() {
        this.f2085a.a();
    }

    public synchronized void clearUserData() {
        m2291a();
    }
}
