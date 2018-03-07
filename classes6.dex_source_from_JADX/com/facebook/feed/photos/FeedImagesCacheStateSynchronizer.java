package com.facebook.feed.photos;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbImageCacheStateUpdateRequest;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mqtt_pricing_reset */
public class FeedImagesCacheStateSynchronizer {
    private static volatile FeedImagesCacheStateSynchronizer f10165f;
    public final DbFeedHomeStoriesHandler f10166a;
    public final ImagePipeline f10167b;
    public final ExecutorService f10168c;
    public final DefaultAndroidThreadUtil f10169d;
    public final FeedDbMutationService f10170e;

    /* compiled from: mqtt_pricing_reset */
    public class C06161 implements FutureCallback<Map<String, Boolean>> {
        final /* synthetic */ String f10161a;
        final /* synthetic */ FeedImagesCacheStateSynchronizer f10162b;

        public C06161(FeedImagesCacheStateSynchronizer feedImagesCacheStateSynchronizer, String str) {
            this.f10162b = feedImagesCacheStateSynchronizer;
            this.f10161a = str;
        }

        public void onSuccess(@Nullable Object obj) {
            Map map = (Map) obj;
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    this.f10162b.f10170e.a(new FeedDbImageCacheStateUpdateRequest(this.f10161a, (String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue() ? 1 : 0));
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: mqtt_pricing_reset */
    public class C06172 implements Function<List<Boolean>, Map<String, Boolean>> {
        final /* synthetic */ List f10163a;
        final /* synthetic */ FeedImagesCacheStateSynchronizer f10164b;

        public C06172(FeedImagesCacheStateSynchronizer feedImagesCacheStateSynchronizer, List list) {
            this.f10164b = feedImagesCacheStateSynchronizer;
            this.f10163a = list;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            List list = (List) obj;
            Map hashMap = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                hashMap.put(this.f10163a.get(i), list.get(i));
            }
            return hashMap;
        }
    }

    public static com.facebook.feed.photos.FeedImagesCacheStateSynchronizer m15840a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10165f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.photos.FeedImagesCacheStateSynchronizer.class;
        monitor-enter(r1);
        r0 = f10165f;	 Catch:{ all -> 0x003a }
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
        r0 = m15841b(r0);	 Catch:{ all -> 0x0035 }
        f10165f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10165f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.photos.FeedImagesCacheStateSynchronizer.a(com.facebook.inject.InjectorLike):com.facebook.feed.photos.FeedImagesCacheStateSynchronizer");
    }

    private static FeedImagesCacheStateSynchronizer m15841b(InjectorLike injectorLike) {
        return new FeedImagesCacheStateSynchronizer(DbFeedHomeStoriesHandler.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FeedDbMutationService.a(injectorLike));
    }

    @Inject
    public FeedImagesCacheStateSynchronizer(DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, ImagePipeline imagePipeline, ExecutorService executorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FeedDbMutationService feedDbMutationService) {
        this.f10166a = dbFeedHomeStoriesHandler;
        this.f10167b = imagePipeline;
        this.f10168c = executorService;
        this.f10169d = defaultAndroidThreadUtil;
        this.f10170e = feedDbMutationService;
    }
}
