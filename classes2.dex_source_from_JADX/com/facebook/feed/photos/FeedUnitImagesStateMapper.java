package com.facebook.feed.photos;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: prefetch_batch_id */
public class FeedUnitImagesStateMapper {
    private static volatile FeedUnitImagesStateMapper f9273c;
    private final FeedImagesCacheStateMapper f9274a;
    @GuardedBy("this")
    private final SetMultimap<String, FeedUnitImageRequest> f9275b = HashMultimap.m10690u();

    public static com.facebook.feed.photos.FeedUnitImagesStateMapper m14210a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9273c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.photos.FeedUnitImagesStateMapper.class;
        monitor-enter(r1);
        r0 = f9273c;	 Catch:{ all -> 0x003a }
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
        r0 = m14213b(r0);	 Catch:{ all -> 0x0035 }
        f9273c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9273c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.photos.FeedUnitImagesStateMapper.a(com.facebook.inject.InjectorLike):com.facebook.feed.photos.FeedUnitImagesStateMapper");
    }

    private static FeedUnitImagesStateMapper m14213b(InjectorLike injectorLike) {
        return new FeedUnitImagesStateMapper(FeedImagesCacheStateMapper.m14216a(injectorLike));
    }

    @Inject
    public FeedUnitImagesStateMapper(FeedImagesCacheStateMapper feedImagesCacheStateMapper) {
        this.f9274a = feedImagesCacheStateMapper;
    }

    public final synchronized void m14215a(DraweeController draweeController, String str, Uri uri) {
        Preconditions.checkNotNull(draweeController, "Controller cannot be null");
        Preconditions.checkArgument(draweeController instanceof AbstractDraweeController, "Controller must be AbstractDraweeController");
        Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str), "Invalid feed unit id");
        Preconditions.checkNotNull(uri, "Image uri cannot be null");
        FeedUnitImageRequest b = m14212b(str, uri);
        if (b == null) {
            b = m14209a(str, uri);
        }
        ((AbstractDraweeController) draweeController).m20741a(b.m29798b());
    }

    public final synchronized int m14214a(String str) {
        int i = 0;
        synchronized (this) {
            Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str), "Invalid feed unit id");
            if (this.f9275b.mo414f(str)) {
                i = this.f9275b.mo1474a(str).size();
                int b = m14211b(str);
                if (b == i) {
                    i = 3;
                } else if (b == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
            }
        }
        return i;
    }

    private synchronized FeedUnitImageRequest m14209a(String str, Uri uri) {
        Object feedUnitImageRequest;
        feedUnitImageRequest = new FeedUnitImageRequest(uri, str);
        this.f9275b.mo431a((Object) str, feedUnitImageRequest);
        this.f9274a.m14221a(str, uri.toString());
        return feedUnitImageRequest;
    }

    private synchronized FeedUnitImageRequest m14212b(String str, Uri uri) {
        FeedUnitImageRequest feedUnitImageRequest;
        for (FeedUnitImageRequest feedUnitImageRequest2 : this.f9275b.mo1474a(str)) {
            if (feedUnitImageRequest2.m29797a().equals(uri)) {
                break;
            }
        }
        feedUnitImageRequest2 = null;
        return feedUnitImageRequest2;
    }

    private synchronized int m14211b(String str) {
        int i;
        i = 0;
        for (FeedUnitImageRequest c : this.f9275b.mo1474a(str)) {
            int i2;
            if (c.m29799c() == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
