package com.facebook.widget.images;

import android.graphics.drawable.Drawable;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractChainableFuture;
import com.facebook.common.futures.ChainableFutureCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.cache.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.ui.images.cache.ImageCacheKey.OptionsBuilder;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import com.facebook.ui.images.fetch.UrlImageFetchParams;
import com.facebook.ui.images.fetch.UrlImageFetcher;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: reply_type */
public class RemoteDrawableLoader extends AbstractDrawableLoader {
    private static volatile RemoteDrawableLoader f5830e;
    public final UrlImageFetcher f5831b;
    private final Executor f5832c;
    public final AutoFadeDrawableProvider f5833d;

    /* compiled from: reply_type */
    class FutureDrawable extends AbstractChainableFuture<Drawable> {
        final /* synthetic */ RemoteDrawableLoader f5828a;
        private ListenableFuture<Drawable> f5829b;

        public FutureDrawable(RemoteDrawableLoader remoteDrawableLoader, ListenableFuture<Drawable> listenableFuture) {
            this.f5828a = remoteDrawableLoader;
            this.f5829b = listenableFuture;
        }

        protected final void m8384a() {
            if (this.f5829b != null) {
                this.f5829b.cancel(false);
                this.f5829b = null;
            }
        }
    }

    public static com.facebook.widget.images.RemoteDrawableLoader m8385a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5830e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.widget.images.RemoteDrawableLoader.class;
        monitor-enter(r1);
        r0 = f5830e;	 Catch:{ all -> 0x003a }
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
        r0 = m8386b(r0);	 Catch:{ all -> 0x0035 }
        f5830e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5830e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.images.RemoteDrawableLoader.a(com.facebook.inject.InjectorLike):com.facebook.widget.images.RemoteDrawableLoader");
    }

    private static RemoteDrawableLoader m8386b(InjectorLike injectorLike) {
        return new RemoteDrawableLoader(UrlImageFetcher.m7876a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AutoFadeDrawableProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoFadeDrawableProvider.class), (DrawableFetchProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DrawableFetchProvider.class));
    }

    @Inject
    public RemoteDrawableLoader(UrlImageFetcher urlImageFetcher, Executor executor, AutoFadeDrawableProvider autoFadeDrawableProvider, DrawableFetchProvider drawableFetchProvider) {
        super(executor, drawableFetchProvider);
        this.f5831b = urlImageFetcher;
        this.f5832c = executor;
        this.f5833d = autoFadeDrawableProvider;
    }

    final ListenableFuture<Drawable> mo394c(final DrawableFetchRequest drawableFetchRequest) {
        ListenableFuture<Drawable> a;
        Drawable a2 = this.f5831b.m7880a(m8387f(drawableFetchRequest));
        if (a2 != null) {
            a = Futures.a(a2);
        } else {
            a = null;
        }
        ListenableFuture<Drawable> listenableFuture = a;
        if (listenableFuture != null) {
            return listenableFuture;
        }
        ListenableFuture listenableFuture2;
        if (this.f5741a.containsKey(drawableFetchRequest)) {
            listenableFuture2 = (ListenableFuture) this.f5741a.get(drawableFetchRequest);
        } else {
            listenableFuture2 = mo393a(drawableFetchRequest);
        }
        ListenableFuture listenableFuture3 = listenableFuture2;
        listenableFuture = new FutureDrawable(this, listenableFuture3);
        Futures.a(listenableFuture3, new ChainableFutureCallback<Drawable>(this, listenableFuture) {
            final /* synthetic */ RemoteDrawableLoader f5827b;

            public void onSuccess(Object obj) {
                obj = (Drawable) obj;
                if (obj != null) {
                    if (drawableFetchRequest.f5787h) {
                        AutoFadeDrawableProvider autoFadeDrawableProvider = this.f5827b.f5833d;
                        obj = new AutoFadeDrawable(Handler_ForUiThreadMethodAutoProvider.b(autoFadeDrawableProvider), drawableFetchRequest.f5780a, obj);
                    }
                    super.onSuccess(obj);
                }
            }
        }, this.f5832c);
        return listenableFuture;
    }

    public final ListenableFuture<Drawable> mo393a(DrawableFetchRequest drawableFetchRequest) {
        UrlImageFetchParams f = m8387f(drawableFetchRequest);
        Drawable a = this.f5831b.m7880a(f);
        if (a == null) {
            return this.f5831b.m7881b(f);
        }
        this.f5741a.remove(drawableFetchRequest);
        return Futures.a(a);
    }

    public static UrlImageFetchParams m8387f(DrawableFetchRequest drawableFetchRequest) {
        OptionsBuilder a = Options.newBuilder().a(drawableFetchRequest.f5783d, drawableFetchRequest.f5782c);
        a.d = DownscalingMethod.MaxScaleNonPowerOfTwo;
        Options f = a.f();
        Builder a2 = FetchImageParams.a(drawableFetchRequest.f5785f);
        a2.h = true;
        a2 = a2;
        a2.e = f;
        return new UrlImageFetchParams(a2.a(), null, null);
    }
}
