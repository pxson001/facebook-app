package com.facebook.ui.images.fetch;

import com.facebook.common.executors.C0616xcb01da24;
import com.facebook.common.executors.C0617xdb937838;
import com.facebook.common.executors.ImageCacheRequestExecutor;
import com.facebook.common.executors.ImageNetworkRequestExecutor;
import com.facebook.common.executors.TracedCallable;
import com.facebook.common.futures.SharedFutureHolder;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.http.common.FetchImageExecutorQueueTime;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.facebook.ui.images.fetch.FetchImageRequest.FetchSource;
import com.facebook.ui.images.fetch.FetchedImage.Builder;
import com.facebook.ui.images.fetch.FetchedImage.Error;
import com.facebook.ui.images.fetch.FetchedImage.Source;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
@ThreadSafe
/* compiled from: recipient_count */
public class FetchImageExecutor {
    private static final Class<?> f12860a = FetchImageExecutor.class;
    private static volatile FetchImageExecutor f12861j;
    private final ImageCache f12862b;
    @ImageCacheRequestExecutor
    private final ListeningExecutorService f12863c;
    @ImageNetworkRequestExecutor
    public final ListeningExecutorService f12864d;
    public final DefaultFetchImageHandler f12865e;
    public final MonotonicClock f12866f;
    public final FetchImageExecutorQueueTime f12867g;
    @GuardedBy("this")
    public final Map<ImageCacheKey, SharedFutureHolder<FetchedImage>> f12868h = Maps.c();
    @GuardedBy("this")
    public final SetMultimap<String, ImageCacheKey> f12869i;

    /* compiled from: recipient_count */
    public class C01664 implements FutureCallback<FetchedImage> {
        final /* synthetic */ ListenableFuture f3560a;
        final /* synthetic */ FetchImageRequest f3561b;
        final /* synthetic */ FetchImageExecutor f3562c;

        public C01664(FetchImageExecutor fetchImageExecutor, ListenableFuture listenableFuture, FetchImageRequest fetchImageRequest) {
            this.f3562c = fetchImageExecutor;
            this.f3560a = listenableFuture;
            this.f3561b = fetchImageRequest;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            if (this.f3560a.isCancelled()) {
                this.f3561b.f12940c.a = true;
            }
        }
    }

    public static com.facebook.ui.images.fetch.FetchImageExecutor m13712a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12861j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.FetchImageExecutor.class;
        monitor-enter(r1);
        r0 = f12861j;	 Catch:{ all -> 0x003a }
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
        r0 = m13714b(r0);	 Catch:{ all -> 0x0035 }
        f12861j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12861j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.FetchImageExecutor.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.FetchImageExecutor");
    }

    private static FetchImageExecutor m13714b(InjectorLike injectorLike) {
        return new FetchImageExecutor(ImageCache.m13718a(injectorLike), C0616xcb01da24.m13790a(injectorLike), C0617xdb937838.m13792a(injectorLike), DefaultFetchImageHandler.m13795a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FetchImageExecutorQueueTime.m13835a(injectorLike));
    }

    public static Callable m13713a(FetchImageExecutor fetchImageExecutor, Class cls, final FetchImageRequest fetchImageRequest, final long j) {
        String uri = fetchImageRequest.f12938a.f12950a.toString();
        Callable a = TracedCallable.m13858a(new Callable<FetchedImage>(fetchImageExecutor) {
            final /* synthetic */ FetchImageExecutor f12993c;

            public Object call() {
                if (j != -1) {
                    this.f12993c.f12867g.f12937a.set(Long.valueOf(this.f12993c.f12866f.now() - j));
                }
                return this.f12993c.f12865e.m13804a(fetchImageRequest);
            }
        }, cls, fetchImageExecutor.f12866f);
        a.f12999f = uri;
        return a;
    }

    @Nullable
    private ListenableFuture<FetchedImage> m13715b(FetchImageRequest fetchImageRequest) {
        FetchImageParams fetchImageParams = fetchImageRequest.f12938a;
        UrlImageProgressListener urlImageProgressListener = fetchImageRequest.f12943f;
        MediaCacheKey j = fetchImageParams.m13849j();
        if (this.f12862b.m13754f(j)) {
            Builder a = FetchedImage.m13901a(j);
            a.f13056d = Source.ERROR;
            a = a;
            a.f13058f = Error.PREV_FAILURE_RETRY_BLOCKED;
            return Futures.a(a.m13912a());
        }
        if (!fetchImageParams.f12956g) {
            CachedImage cachedImage = (CachedImage) this.f12862b.m13742a(j);
            if (urlImageProgressListener != null) {
                urlImageProgressListener.a(0);
            }
            if (cachedImage != null) {
                Builder a2 = FetchedImage.m13901a(j);
                a2.f13055c = cachedImage;
                a = a2;
                a.f13056d = Source.MEMORY_CACHE;
                return Futures.a(a.m13912a());
            }
        }
        return null;
    }

    @Inject
    public FetchImageExecutor(ImageCache imageCache, @ImageCacheRequestExecutor ListeningExecutorService listeningExecutorService, @ImageNetworkRequestExecutor ListeningExecutorService listeningExecutorService2, DefaultFetchImageHandler defaultFetchImageHandler, MonotonicClock monotonicClock, FetchImageExecutorQueueTime fetchImageExecutorQueueTime) {
        this.f12862b = imageCache;
        this.f12863c = listeningExecutorService;
        this.f12864d = listeningExecutorService2;
        this.f12865e = defaultFetchImageHandler;
        this.f12866f = monotonicClock;
        this.f12867g = fetchImageExecutorQueueTime;
        this.f12869i = HashMultimap.u();
    }

    private ListenableFuture<FetchedImage> m13716c(final FetchImageRequest fetchImageRequest) {
        UrlImageProgressListener urlImageProgressListener = fetchImageRequest.f12943f;
        ListeningExecutorService listeningExecutorService = this.f12863c;
        FetchImageRequestBuilder a = FetchImageRequest.m13836a(fetchImageRequest);
        a.f12945b = FetchSource.CACHE_ONLY;
        ListenableFuture a2 = listeningExecutorService.a(m13713a(this, ImageCacheRequestExecutor.class, a.m13844g(), -1));
        if (urlImageProgressListener != null) {
            a2.a(new 2(this, urlImageProgressListener), MoreExecutors.a());
        }
        return Futures.b(a2, new AsyncFunction<FetchedImage, FetchedImage>(this) {
            final /* synthetic */ FetchImageExecutor f13007b;

            public final ListenableFuture m13869a(Object obj) {
                Object obj2;
                FetchedImage fetchedImage = (FetchedImage) obj;
                Object obj3 = null;
                if (fetchImageRequest.f12938a.f12956g) {
                    obj2 = fetchedImage.f13047b != null ? 1 : null;
                } else if (fetchedImage.f13048c != null) {
                    int i = 1;
                } else {
                    obj2 = null;
                }
                if (fetchImageRequest.f12939b == FetchSource.CACHE_ONLY || fetchImageRequest.f12938a.f12957h) {
                    obj3 = 1;
                }
                if (obj2 != null || r2 != null) {
                    return Futures.a(fetchedImage);
                }
                FetchImageRequestBuilder a = FetchImageRequest.m13836a(fetchImageRequest);
                a.f12946c = new FbHttpRequestCancelTrigger();
                a = a;
                a.f12945b = FetchSource.NETWORK_ONLY;
                FetchImageRequest g = a.m13844g();
                ListenableFuture a2 = this.f13007b.f12864d.a(FetchImageExecutor.m13713a(this.f13007b, ImageNetworkRequestExecutor.class, g, this.f13007b.f12866f.now()));
                Futures.a(a2, new C01664(this.f13007b, a2, g));
                return a2;
            }
        });
    }

    public final ListenableFuture<FetchedImage> m13717a(FetchImageRequest fetchImageRequest) {
        boolean z = true;
        ImageReferrer d = fetchImageRequest.m13840d();
        FetchImageParams a = fetchImageRequest.m13837a();
        a.m13849j();
        if (d != null) {
            d.a();
        }
        ListenableFuture<FetchedImage> b = m13715b(fetchImageRequest);
        if (b != null) {
            return b;
        }
        SharedFutureHolder sharedFutureHolder;
        final ImageCacheKey j = a.m13849j();
        final String uri = a.m13846a().toString();
        ListenableFuture listenableFuture = null;
        synchronized (this) {
            this.f12869i.a(uri, j);
            Iterable a2 = this.f12869i.a(uri);
            if (a2.size() > 1) {
                BLog.a(f12860a, "Redundant fetch for url=" + uri + "; cacheKeys=" + Iterables.c(a2));
            }
            sharedFutureHolder = (SharedFutureHolder) this.f12868h.get(j);
            if (sharedFutureHolder == null) {
                listenableFuture = m13716c(fetchImageRequest);
                sharedFutureHolder = new SharedFutureHolder(listenableFuture);
                this.f12868h.put(j, sharedFutureHolder);
                z = false;
            }
        }
        if (listenableFuture != null) {
            listenableFuture.a(new Runnable(this) {
                final /* synthetic */ FetchImageExecutor f13013c;

                public void run() {
                    synchronized (this.f13013c) {
                        this.f13013c.f12868h.remove(j);
                        this.f13013c.f12869i.c(uri, j);
                    }
                }
            }, MoreExecutors.a());
        }
        return sharedFutureHolder.m13870a(z);
    }
}
