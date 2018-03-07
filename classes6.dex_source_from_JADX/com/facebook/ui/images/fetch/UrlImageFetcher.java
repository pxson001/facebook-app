package com.facebook.ui.images.fetch;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.facebook.ui.images.fetch.FetchedImage.Builder;
import com.facebook.ui.images.fetch.FetchedImage.Source;
import com.facebook.ui.images.fetch.ImageFetcher.Operation;
import com.facebook.ui.images.fetch.ImageFetcher.Operation.C03051;
import com.facebook.ui.images.fetch.ImageFetcher.Operation.C03062;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
@ThreadSafe
/* compiled from: search_time */
public class UrlImageFetcher {
    private static volatile UrlImageFetcher f5142e;
    private final ImageFetcher f5143a;
    public final ImageCache f5144b;
    public final FeatureAwareImageAccessLogger f5145c;
    public final Resources f5146d;

    /* compiled from: search_time */
    class C03071 implements Function<FetchedImage, Drawable> {
        final /* synthetic */ UrlImageFetcher f5139a;

        C03071(UrlImageFetcher urlImageFetcher) {
            this.f5139a = urlImageFetcher;
        }

        public Object apply(Object obj) {
            CachedImage cachedImage = ((FetchedImage) obj).c;
            return cachedImage != null ? cachedImage.a(this.f5139a.f5146d) : null;
        }
    }

    public static com.facebook.ui.images.fetch.UrlImageFetcher m7876a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5142e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.UrlImageFetcher.class;
        monitor-enter(r1);
        r0 = f5142e;	 Catch:{ all -> 0x003a }
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
        r0 = m7877b(r0);	 Catch:{ all -> 0x0035 }
        f5142e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5142e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.UrlImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.UrlImageFetcher");
    }

    private static UrlImageFetcher m7877b(InjectorLike injectorLike) {
        return new UrlImageFetcher(ImageFetcher.m7873a(injectorLike), ImageCache.a(injectorLike), FeatureAwareImageAccessLogger.m7865a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UrlImageFetcher(ImageFetcher imageFetcher, ImageCache imageCache, FeatureAwareImageAccessLogger featureAwareImageAccessLogger, Resources resources) {
        this.f5143a = imageFetcher;
        this.f5144b = imageCache;
        this.f5145c = featureAwareImageAccessLogger;
        this.f5146d = resources;
    }

    public final ListenableFuture<Drawable> m7881b(UrlImageFetchParams urlImageFetchParams) {
        return Futures.a(m7878c(urlImageFetchParams), new C03071(this), MoreExecutors.a());
    }

    private ListenableFuture<FetchedImage> m7878c(final UrlImageFetchParams urlImageFetchParams) {
        ListenableFuture<FetchedImage> e = m7879e(urlImageFetchParams);
        Futures.a(e, new FutureCallback<FetchedImage>(this) {
            final /* synthetic */ UrlImageFetcher f5141b;

            public void onSuccess(Object obj) {
                FetchedImage fetchedImage = (FetchedImage) obj;
                if (!fetchedImage.g) {
                    this.f5141b.f5145c.m7869a(urlImageFetchParams.m7875a(), fetchedImage);
                }
            }

            public void onFailure(Throwable th) {
            }
        });
        return e;
    }

    public final Drawable m7880a(UrlImageFetchParams urlImageFetchParams) {
        ImageCacheKey j = urlImageFetchParams.f5136a.j();
        String a = urlImageFetchParams.m7875a();
        CachedImage cachedImage = (CachedImage) this.f5144b.a(j);
        if (cachedImage != null) {
            Builder a2 = FetchedImage.a(j);
            a2.c = cachedImage;
            a2 = a2;
            a2.d = Source.MEMORY_CACHE;
            this.f5145c.m7869a(a, a2.a());
        } else {
            cachedImage = null;
        }
        CachedImage cachedImage2 = cachedImage;
        if (cachedImage2 != null) {
            return cachedImage2.a(this.f5146d);
        }
        return null;
    }

    private ListenableFuture<FetchedImage> m7879e(UrlImageFetchParams urlImageFetchParams) {
        String str;
        CallerContext a;
        Operation operation = new Operation(this.f5143a, urlImageFetchParams);
        SettableFuture f = SettableFuture.f();
        Futures.a(f, new C03062(operation, f), MoreExecutors.a());
        operation.f5129d = f;
        operation.f5128c = operation.f5126a.f5134c.a(operation.f5127b.f5136a.a, 0, 0);
        UrlImageFetchParams urlImageFetchParams2 = operation.f5127b;
        if (urlImageFetchParams2.f5138c != null) {
            str = urlImageFetchParams2.f5138c.b;
        } else {
            str = null;
        }
        if (str == null) {
            Class cls = operation.getClass();
            String a2 = operation.f5127b.m7875a();
            String str2 = operation.f5127b.m7875a().toString();
            UrlImageFetchParams urlImageFetchParams3 = operation.f5127b;
            a = CallerContext.a(cls, a2, str2, urlImageFetchParams3.f5138c != null ? urlImageFetchParams3.f5138c.d() : "unknown");
        } else {
            a = operation.f5127b.f5138c;
        }
        Preconditions.checkState(operation.f5130e == null, "Active future must be null before submitting for another");
        ImageReferrer imageReferrer = new ImageReferrer(operation.f5126a.f5135d, ImmutableList.of(operation.f5127b.m7875a()));
        FetchImageExecutor fetchImageExecutor = operation.f5126a.f5133b;
        FetchImageRequestBuilder fetchImageRequestBuilder = new FetchImageRequestBuilder(operation.f5127b.f5136a);
        fetchImageRequestBuilder.d = imageReferrer;
        FetchImageRequestBuilder fetchImageRequestBuilder2 = fetchImageRequestBuilder;
        fetchImageRequestBuilder2.f = operation.f5127b.f5137b;
        operation.f5130e = fetchImageExecutor.a(fetchImageRequestBuilder2.a(a).g());
        Futures.a(operation.f5130e, new C03051(operation), MoreExecutors.a());
        return operation.f5129d;
    }
}
