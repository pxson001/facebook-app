package com.facebook.feed.photos;

import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbImageCacheStateUpdateRequest;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbStoryImageUrlAddRequest;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefetch.PrefetchParams;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: prefetch */
public class FeedImagesCacheStateMapper {
    private static volatile FeedImagesCacheStateMapper f9276c;
    public final FeedDbMutationService f9277a;
    private final Map<String, FeedImage> f9278b = new HashMap();

    /* compiled from: prefetch */
    class FeedImage {
        public final String f21882a;
        public final String f21883b;
        private int f21884c = 0;

        public FeedImage(String str, String str2) {
            this.f21882a = str;
            this.f21883b = str2;
        }
    }

    public static com.facebook.feed.photos.FeedImagesCacheStateMapper m14216a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9276c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.photos.FeedImagesCacheStateMapper.class;
        monitor-enter(r1);
        r0 = f9276c;	 Catch:{ all -> 0x003a }
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
        r0 = m14218b(r0);	 Catch:{ all -> 0x0035 }
        f9276c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9276c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.photos.FeedImagesCacheStateMapper.a(com.facebook.inject.InjectorLike):com.facebook.feed.photos.FeedImagesCacheStateMapper");
    }

    private static FeedImagesCacheStateMapper m14218b(InjectorLike injectorLike) {
        return new FeedImagesCacheStateMapper(FeedDbMutationService.m9091a(injectorLike));
    }

    @Inject
    public FeedImagesCacheStateMapper(FeedDbMutationService feedDbMutationService) {
        this.f9277a = feedDbMutationService;
    }

    public final synchronized void m14221a(String str, String str2) {
        Preconditions.checkArgument(!StringUtil.m3589a((CharSequence) str), "Invalid feed unit id");
        Preconditions.checkNotNull(str2, "Image url cannot be null");
        this.f9278b.put(str2, new FeedImage(str, str2));
        m14219b(str, str2);
    }

    public final synchronized void m14220a(PrefetchParams prefetchParams, boolean z) {
        m14222a(prefetchParams.m29725c(), z);
    }

    public final synchronized void m14222a(String str, boolean z) {
        FeedImage feedImage = (FeedImage) this.f9278b.get(str);
        if (feedImage != null) {
            m14217a(feedImage, z);
        }
    }

    private void m14217a(FeedImage feedImage, boolean z) {
        this.f9277a.m9112a(new FeedDbImageCacheStateUpdateRequest(feedImage.f21882a, feedImage.f21883b, z ? 1 : 0));
    }

    private void m14219b(String str, String str2) {
        this.f9277a.m9112a(new FeedDbStoryImageUrlAddRequest(str, str2));
    }
}
