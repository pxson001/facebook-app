package com.facebook.ui.images.fetch;

import com.facebook.common.futures.SharedFutureHolder.SharedFuture;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.images.fetch.FetchedImage.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
@ThreadSafe
/* compiled from: seat_type */
public class ImageFetcher {
    private static final Class<?> f5131a = ImageFetcher.class;
    private static volatile ImageFetcher f5132e;
    public final FetchImageExecutor f5133b;
    public final FetchImagePerfLogger f5134c;
    public final String f5135d;

    /* compiled from: seat_type */
    public class Operation {
        public final /* synthetic */ ImageFetcher f5126a;
        public final UrlImageFetchParams f5127b;
        public MarkerConfig f5128c;
        public SettableFuture<FetchedImage> f5129d;
        public ListenableFuture<FetchedImage> f5130e;

        /* compiled from: seat_type */
        public class C03051 implements FutureCallback<FetchedImage> {
            final /* synthetic */ Operation f5123a;

            public C03051(Operation operation) {
                this.f5123a = operation;
            }

            public void onSuccess(Object obj) {
                obj = (FetchedImage) obj;
                if (this.f5123a.f5130e != null && (this.f5123a.f5130e instanceof SharedFuture) && ((SharedFuture) this.f5123a.f5130e).a) {
                    Builder builder = new Builder(obj);
                    builder.g = true;
                    obj = builder.a();
                }
                Operation.m7872c(this.f5123a);
                if (this.f5123a.f5127b.f5137b != null) {
                    this.f5123a.f5127b.f5137b.m8404a(90);
                }
                FutureDetour.a(this.f5123a.f5129d, obj, -964817601);
            }

            public void onFailure(Throwable th) {
                Operation.m7872c(this.f5123a);
                this.f5123a.f5129d.a(th);
            }
        }

        /* compiled from: seat_type */
        public class C03062 implements FutureCallback<FetchedImage> {
            final /* synthetic */ SettableFuture f5124a;
            final /* synthetic */ Operation f5125b;

            public C03062(Operation operation, SettableFuture settableFuture) {
                this.f5125b = operation;
                this.f5124a = settableFuture;
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f5124a.isCancelled()) {
                    Operation operation = this.f5125b;
                    ListenableFuture listenableFuture = operation.f5130e;
                    operation.f5130e = null;
                    if (listenableFuture != null) {
                        listenableFuture.cancel(false);
                    }
                }
            }
        }

        public Operation(ImageFetcher imageFetcher, UrlImageFetchParams urlImageFetchParams) {
            this.f5126a = imageFetcher;
            this.f5127b = urlImageFetchParams;
        }

        public static void m7872c(Operation operation) {
            operation.f5130e = null;
            if (operation.f5126a.f5134c.a(operation.f5128c)) {
                operation.f5128c = null;
            }
        }
    }

    public static com.facebook.ui.images.fetch.ImageFetcher m7873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5132e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.ImageFetcher.class;
        monitor-enter(r1);
        r0 = f5132e;	 Catch:{ all -> 0x003a }
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
        r0 = m7874b(r0);	 Catch:{ all -> 0x0035 }
        f5132e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5132e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.ImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.ImageFetcher");
    }

    private static ImageFetcher m7874b(InjectorLike injectorLike) {
        return new ImageFetcher(FetchImageExecutor.a(injectorLike), FetchImagePerfLogger.a(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class));
    }

    @Inject
    public ImageFetcher(FetchImageExecutor fetchImageExecutor, FetchImagePerfLogger fetchImagePerfLogger, PlatformAppConfig platformAppConfig) {
        this.f5133b = fetchImageExecutor;
        this.f5134c = fetchImagePerfLogger;
        this.f5135d = platformAppConfig.c();
    }
}
