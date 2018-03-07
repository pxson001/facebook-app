package com.facebook.livephotos.downloader;

import android.net.Uri;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ImageOffUiThreadExecutorMethodAutoProvider;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.livephotos.DiskStorageCache_LivePhotosFileCacheMethodAutoProvider;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pending_js_calls_instance */
public class LivePhotosPrefetcher {
    public static final String f6649a = LivePhotosPrefetcher.class.getSimpleName();
    public static final CallerContext f6650b = CallerContext.a(LivePhotosPrefetcher.class);
    private static volatile LivePhotosPrefetcher f6651g;
    public ListeningExecutorService f6652c;
    public Lazy<LivePhotosMediaDownloader> f6653d;
    public final DiskStorageCache f6654e;
    public final Map<String, HttpFutureWrapper<String>> f6655f = Collections.synchronizedMap(new HashMap());

    /* compiled from: pending_js_calls_instance */
    public class C06061 implements Callable<String> {
        final /* synthetic */ String f6637a;
        final /* synthetic */ LivePhotosPrefetcher f6638b;

        public C06061(LivePhotosPrefetcher livePhotosPrefetcher, String str) {
            this.f6638b = livePhotosPrefetcher;
            this.f6637a = str;
        }

        public Object call() {
            return LivePhotosPrefetcher.m8558b(this.f6638b.f6654e.a(new LivePhotoCacheKey(this.f6637a)));
        }
    }

    /* compiled from: pending_js_calls_instance */
    public class C06072 implements AsyncFunction<String, String> {
        final /* synthetic */ String f6639a;
        final /* synthetic */ boolean f6640b;
        final /* synthetic */ LivePhotosPrefetcher f6641c;

        public C06072(LivePhotosPrefetcher livePhotosPrefetcher, String str, boolean z) {
            this.f6641c = livePhotosPrefetcher;
            this.f6639a = str;
            this.f6640b = z;
        }

        public final ListenableFuture m8553a(Object obj) {
            String str = (String) obj;
            if (str != null) {
                String str2 = LivePhotosPrefetcher.f6649a;
                return Futures.a(str);
            }
            MediaDownloadRequest mediaDownloadRequest = new MediaDownloadRequest(Uri.parse(this.f6639a), new PrefetchResponseHandler(this.f6641c, this.f6639a), LivePhotosPrefetcher.f6650b, this.f6640b ? RequestPriority.INTERACTIVE : RequestPriority.NON_INTERACTIVE);
            str2 = LivePhotosPrefetcher.f6649a;
            HttpFutureWrapper b = ((LivePhotosMediaDownloader) this.f6641c.f6653d.get()).b(mediaDownloadRequest);
            this.f6641c.f6655f.put(this.f6639a, b);
            return b.b;
        }
    }

    /* compiled from: pending_js_calls_instance */
    public class C06083 implements Runnable {
        final /* synthetic */ String f6642a;
        final /* synthetic */ LivePhotosPrefetcher f6643b;

        public C06083(LivePhotosPrefetcher livePhotosPrefetcher, String str) {
            this.f6643b = livePhotosPrefetcher;
            this.f6642a = str;
        }

        public void run() {
            this.f6643b.f6655f.remove(this.f6642a);
        }
    }

    /* compiled from: pending_js_calls_instance */
    class PrefetchResponseHandler implements DownloadResultResponseHandler<String> {
        final /* synthetic */ LivePhotosPrefetcher f6646a;
        private final String f6647b = PrefetchResponseHandler.class.getSimpleName();
        private String f6648c;

        public PrefetchResponseHandler(LivePhotosPrefetcher livePhotosPrefetcher, String str) {
            this.f6646a = livePhotosPrefetcher;
            this.f6648c = str;
        }

        public final Object m8555a(final InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            try {
                Object b = LivePhotosPrefetcher.m8558b(this.f6646a.f6654e.a(new LivePhotoCacheKey(this.f6648c), new WriterCallback(this) {
                    final /* synthetic */ PrefetchResponseHandler f6645b;

                    public final void m8554a(OutputStream outputStream) {
                        ByteStreams.a(inputStream, outputStream);
                    }
                }));
                return b;
            } finally {
                inputStream.close();
            }
        }
    }

    public static com.facebook.livephotos.downloader.LivePhotosPrefetcher m8556a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6651g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.livephotos.downloader.LivePhotosPrefetcher.class;
        monitor-enter(r1);
        r0 = f6651g;	 Catch:{ all -> 0x003a }
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
        r0 = m8557b(r0);	 Catch:{ all -> 0x0035 }
        f6651g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6651g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.downloader.LivePhotosPrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.livephotos.downloader.LivePhotosPrefetcher");
    }

    private static LivePhotosPrefetcher m8557b(InjectorLike injectorLike) {
        return new LivePhotosPrefetcher(ListeningExecutorService_ImageOffUiThreadExecutorMethodAutoProvider.a(injectorLike), DiskStorageCache_LivePhotosFileCacheMethodAutoProvider.m8523a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7412));
    }

    @Inject
    public LivePhotosPrefetcher(ListeningExecutorService listeningExecutorService, DiskStorageCache diskStorageCache, Lazy<LivePhotosMediaDownloader> lazy) {
        this.f6652c = listeningExecutorService;
        this.f6653d = lazy;
        this.f6654e = diskStorageCache;
    }

    public static String m8558b(BinaryResource binaryResource) {
        if (binaryResource == null || !(binaryResource instanceof FileBinaryResource)) {
            return null;
        }
        return ((FileBinaryResource) binaryResource).a.getAbsolutePath();
    }
}
