package com.facebook.ui.images.fetch;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.images.base.UrlImageProcessor;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;
import com.facebook.ui.images.cache.ImageEncoder;
import com.facebook.ui.images.fetch.FetchImagePerfLogger.OperationResult;
import com.facebook.ui.images.fetch.FetchedImage.Builder;
import com.facebook.ui.images.fetch.FetchedImage.Error;
import com.facebook.ui.images.fetch.FetchedImage.Source;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import com.google.common.collect.Maps;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

@Singleton
@SuppressLint({"DeprecatedClass", "DeprecatedMethod"})
/* compiled from: recipientId */
public class DefaultFetchImageHandler {
    private static final Class<?> f12914a = DefaultFetchImageHandler.class;
    private static volatile DefaultFetchImageHandler f12915i;
    public final ImageCache f12916b;
    public final ImageEncoder f12917c;
    private final Lazy<ImageMediaDownloader> f12918d;
    public final FetchImagePerfLogger f12919e;
    public final ImageWriter f12920f;
    public final DataUsageCounters f12921g;
    private final UriLatchManager f12922h = new UriLatchManager(this);

    /* compiled from: recipientId */
    class FetchImageDownloadHandler implements DownloadResultResponseHandler<FetchedImage> {
        final /* synthetic */ DefaultFetchImageHandler f3566a;
        private final Uri f3567b;
        private final ImageCacheKey f3568c;
        @Nullable
        private final UrlImageProgressListener f3569d;
        private final FetchImageParams f3570e;

        public final /* bridge */ /* synthetic */ Object m3959a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            return m3958a(inputStream, j);
        }

        public FetchImageDownloadHandler(DefaultFetchImageHandler defaultFetchImageHandler, Uri uri, ImageCacheKey imageCacheKey, @Nullable UrlImageProgressListener urlImageProgressListener, FetchImageParams fetchImageParams) {
            this.f3566a = defaultFetchImageHandler;
            this.f3567b = uri;
            this.f3568c = imageCacheKey;
            this.f3569d = urlImageProgressListener;
            this.f3570e = fetchImageParams;
        }

        private FetchedImage m3958a(InputStream inputStream, long j) {
            FileBinaryResource a;
            long j2;
            IOException iOException;
            BinaryResource binaryResource;
            CachedImage cachedImage;
            if (this.f3569d != null) {
                this.f3569d.a(0);
            }
            BinaryResource binaryResource2 = null;
            String scheme = this.f3567b.getScheme();
            boolean equals = scheme.equals("file");
            long j3 = -1;
            if (equals) {
                a = FileBinaryResource.a(new File(this.f3567b.getPath()));
                j2 = j3;
                iOException = null;
            } else {
                InputStream progressAwareCountingInputStream = new ProgressAwareCountingInputStream(inputStream, new DownloadAndInsertIntoCacheProgressUpdate(this.f3569d, j));
                try {
                    binaryResource2 = m3957a(progressAwareCountingInputStream);
                    j3 = progressAwareCountingInputStream.m4039a();
                    if (this.f3569d != null) {
                        this.f3569d.a(60);
                        a = binaryResource2;
                        j2 = j3;
                        iOException = null;
                    } else {
                        a = binaryResource2;
                        j2 = j3;
                        iOException = null;
                    }
                } catch (IOException e) {
                    IOException iOException2;
                    if (this.f3569d != null) {
                        this.f3569d.a(60);
                        a = binaryResource2;
                        iOException2 = e;
                        j2 = j3;
                        iOException = iOException2;
                    } else {
                        a = binaryResource2;
                        iOException2 = e;
                        j2 = j3;
                        iOException = iOException2;
                    }
                } catch (Throwable th) {
                    if (this.f3569d != null) {
                        this.f3569d.a(60);
                    }
                }
            }
            if (j < 0) {
                j = j2;
            }
            if (this.f3570e.m13848f()) {
                binaryResource = a;
                cachedImage = null;
            } else {
                CachedImage cachedImage2;
                if (equals) {
                    MarkerConfig a2 = this.f3566a.f12919e.m13816a(this.f3570e.m13846a(), 5439497, "UrlImageBitmapFromFile");
                    cachedImage = this.f3566a.f12917c.m13759a(this.f3568c, new File(this.f3570e.m13846a().getPath()));
                    this.f3566a.f12919e.m13822a(a2, cachedImage != null);
                    cachedImage2 = cachedImage;
                } else {
                    cachedImage2 = (CachedImage) this.f3566a.f12916b.m13751c(this.f3568c);
                }
                if (this.f3569d != null) {
                    this.f3569d.a(80);
                }
                cachedImage = cachedImage2;
                binaryResource = null;
            }
            Object obj = ("http".equals(scheme) || "https".equals(scheme)) ? 1 : null;
            if (binaryResource == null && cachedImage == null) {
                if (iOException != null) {
                    throw iOException;
                }
                throw new UnknownLocalIOException();
            } else if (obj != null) {
                return FetchedImage.m13901a(this.f3568c).m13908a(binaryResource).m13909a(cachedImage).m13911a(Source.DOWNLOADED).m13907a(j).m13912a();
            } else {
                return FetchedImage.m13901a(this.f3568c).m13908a(binaryResource).m13909a(cachedImage).m13911a(Source.FETCHED_FROM_FILE_OR_CONTENT).m13912a();
            }
        }

        private BinaryResource m3957a(final InputStream inputStream) {
            try {
                BinaryResource a = this.f3566a.f12916b.m13739a(this.f3568c, new WriterCallback(this) {
                    final /* synthetic */ FetchImageDownloadHandler f3618b;

                    public final void mo259a(OutputStream outputStream) {
                        this.f3618b.f3566a.f12920f.m13831a(inputStream, outputStream);
                    }
                });
                return a;
            } finally {
                Closeables.a(inputStream);
            }
        }
    }

    /* compiled from: recipientId */
    public class UriLatchManager {
        public final /* synthetic */ DefaultFetchImageHandler f12934a;
        public final ConcurrentMap<Uri, CountDownLatch> f12935b = Maps.e();

        /* compiled from: recipientId */
        public class Latch {
            public final /* synthetic */ UriLatchManager f3563a;
            public final Uri f3564b;
            public final CountDownLatch f3565c;

            public Latch(UriLatchManager uriLatchManager, Uri uri, CountDownLatch countDownLatch) {
                this.f3563a = uriLatchManager;
                this.f3564b = uri;
                this.f3565c = countDownLatch;
            }
        }

        public UriLatchManager(DefaultFetchImageHandler defaultFetchImageHandler) {
            this.f12934a = defaultFetchImageHandler;
        }

        public static void m13832a(Latch latch) {
            if (latch != null && latch.f3563a.f12935b.remove(latch.f3564b, latch.f3565c)) {
                latch.f3565c.countDown();
            }
        }

        public final Latch m13833a(ImageCacheKey imageCacheKey) {
            Uri uri = imageCacheKey.f12976f;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            int i = 0;
            CountDownLatch countDownLatch2 = (CountDownLatch) this.f12935b.putIfAbsent(uri, countDownLatch);
            while (countDownLatch2 != null) {
                countDownLatch2.await();
                countDownLatch2 = (CountDownLatch) this.f12935b.putIfAbsent(uri, countDownLatch);
                i = 1;
            }
            if (i != 0) {
                this.f12934a.f12921g.a("IMAGE_PIPELINE_CONCURRENT_FETCHES", 1);
            }
            return new Latch(this, uri, countDownLatch);
        }
    }

    /* compiled from: recipientId */
    enum DownloadResultCode {
        SUCCESS,
        IO_EXCEPTION,
        DECODE_ERROR,
        NOT_FOUND,
        UNSUPPORTED_URI,
        FORBIDDEN,
        OTHER
    }

    public static com.facebook.ui.images.fetch.DefaultFetchImageHandler m13795a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12915i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.DefaultFetchImageHandler.class;
        monitor-enter(r1);
        r0 = f12915i;	 Catch:{ all -> 0x003a }
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
        r0 = m13801b(r0);	 Catch:{ all -> 0x0035 }
        f12915i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12915i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.DefaultFetchImageHandler.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.DefaultFetchImageHandler");
    }

    private static DefaultFetchImageHandler m13801b(InjectorLike injectorLike) {
        return new DefaultFetchImageHandler(ImageCache.m13718a(injectorLike), ImageEncoder.m13758b(injectorLike), IdBasedLazy.a(injectorLike, 3569), FetchImagePerfLogger.m13805a(injectorLike), ImageWriter.m13829b(injectorLike), DataUsageCounters.a(injectorLike));
    }

    @Inject
    public DefaultFetchImageHandler(ImageCache imageCache, ImageEncoder imageEncoder, Lazy<ImageMediaDownloader> lazy, FetchImagePerfLogger fetchImagePerfLogger, ImageWriter imageWriter, DataUsageCounters dataUsageCounters) {
        this.f12916b = imageCache;
        this.f12917c = imageEncoder;
        this.f12918d = lazy;
        this.f12919e = fetchImagePerfLogger;
        this.f12920f = imageWriter;
        this.f12921g = dataUsageCounters;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.ui.images.fetch.FetchedImage m13804a(com.facebook.ui.images.fetch.FetchImageRequest r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = "fetchImage";
        r3 = -1836844115; // 0xffffffff9283fbad float:-8.329305E-28 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r3);
        r3 = r6.m13837a();	 Catch:{ all -> 0x004a }
        r2 = r6.m13838b();	 Catch:{ all -> 0x004a }
        r4 = com.facebook.ui.images.fetch.FetchImageRequest.FetchSource.NETWORK_ONLY;	 Catch:{ all -> 0x004a }
        if (r2 == r4) goto L_0x001e;
    L_0x0016:
        r2 = r6.m13838b();	 Catch:{ all -> 0x004a }
        r4 = com.facebook.ui.images.fetch.FetchImageRequest.FetchSource.CACHE_ONLY;	 Catch:{ all -> 0x004a }
        if (r2 != r4) goto L_0x0052;
    L_0x001e:
        r2 = r0;
    L_0x001f:
        com.google.common.base.Preconditions.checkState(r2);	 Catch:{ all -> 0x004a }
        r2 = com.facebook.ui.images.fetch.DefaultFetchImageHandler.C06213.f13018a;	 Catch:{ all -> 0x004a }
        r4 = r6.m13838b();	 Catch:{ all -> 0x004a }
        r4 = r4.ordinal();	 Catch:{ all -> 0x004a }
        r2 = r2[r4];	 Catch:{ all -> 0x004a }
        switch(r2) {
            case 1: goto L_0x0054;
            case 2: goto L_0x006b;
            default: goto L_0x0031;
        };	 Catch:{ all -> 0x004a }
    L_0x0031:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x004a }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
        r2 = "unknown fetch type: ";
        r1.<init>(r2);	 Catch:{ all -> 0x004a }
        r2 = r6.m13838b();	 Catch:{ all -> 0x004a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r1 = r1.toString();	 Catch:{ all -> 0x004a }
        r0.<init>(r1);	 Catch:{ all -> 0x004a }
        throw r0;	 Catch:{ all -> 0x004a }
    L_0x004a:
        r0 = move-exception;
        r1 = 1775170138; // 0x69cef25a float:3.12729E25 double:8.770505807E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x0052:
        r2 = r1;
        goto L_0x001f;
    L_0x0054:
        r2 = r6.m13839c();	 Catch:{  }
        r3 = r3.m13848f();	 Catch:{  }
        if (r3 != 0) goto L_0x0069;
    L_0x005e:
        r0 = r5.m13798a(r6, r2, r0);	 Catch:{  }
        r1 = -1555941428; // 0xffffffffa34237cc float:-1.05285765E-17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0068:
        return r0;
    L_0x0069:
        r0 = r1;
        goto L_0x005e;
    L_0x006b:
        r0 = r3.m13848f();	 Catch:{  }
        if (r0 == 0) goto L_0x007c;
    L_0x0071:
        r0 = r5.m13803c(r6);	 Catch:{  }
        r1 = 818568514; // 0x30ca5d42 float:1.472394E-9 double:4.044265815E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0068;
    L_0x007c:
        r0 = r5.m13802b(r6);	 Catch:{  }
        r1 = 1071027254; // 0x3fd69436 float:1.676398 double:5.29157772E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.DefaultFetchImageHandler.a(com.facebook.ui.images.fetch.FetchImageRequest):com.facebook.ui.images.fetch.FetchedImage");
    }

    private FetchedImage m13802b(FetchImageRequest fetchImageRequest) {
        TracerDetour.a("fetchImageAndDecodeFromCache", -1287010136);
        try {
            FetchedImage a;
            FetchImageParams a2 = fetchImageRequest.m13837a();
            MediaCacheKey j = a2.m13849j();
            MarkerConfig a3 = this.f12919e.m13816a(a2.m13846a(), 5439495, "UrlImageParseImageFromCache");
            CachedImage cachedImage = (CachedImage) this.f12916b.m13751c(j);
            if (cachedImage != null) {
                this.f12919e.m13819a(a3, Source.CACHE.name());
                a = FetchedImage.m13901a(j).m13909a(cachedImage).m13911a(Source.CACHE).m13912a();
            } else {
                this.f12919e.m13819a(a3, OperationResult.FAILURE.toString());
                MediaCacheKey k = a2.m13850k();
                a3 = this.f12919e.m13816a(a2.m13846a(), 5439496, "UrlImageParseUnderlyingImageFromCache");
                cachedImage = (CachedImage) this.f12916b.m13751c(k);
                if (cachedImage == null) {
                    this.f12919e.m13819a(a3, OperationResult.FAILURE.toString());
                    a = FetchedImage.m13901a(j).m13911a(Source.NOT_IN_CACHE_NOT_DOWNLOADED).m13912a();
                    TracerDetour.a(782275340);
                } else {
                    this.f12919e.m13819a(a3, Source.UNDERLYING_IMAGE_IN_CACHE.name());
                    a = m13796a(a2, FetchedImage.m13901a(j).m13909a(cachedImage).m13911a(Source.UNDERLYING_IMAGE_IN_CACHE).m13912a());
                    TracerDetour.a(-1414986389);
                }
            }
            return a;
        } finally {
            TracerDetour.a(246154336);
        }
    }

    private void m13799a(FetchImageParams fetchImageParams, long j) {
        if (!fetchImageParams.f12958i) {
            this.f12916b.m13745a(fetchImageParams.m13850k(), j);
        }
    }

    private FetchedImage m13798a(FetchImageRequest fetchImageRequest, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger, boolean z) {
        TracerDetour.a("fetchImageFromNetwork", -570100492);
        try {
            FetchedImage a;
            FetchImageParams a2 = fetchImageRequest.m13837a();
            try {
                Latch a3 = this.f12922h.m13833a(a2.m13850k());
                try {
                    a = m13797a(fetchImageRequest, fbHttpRequestCancelTrigger);
                    if (z) {
                        a = m13796a(a2, a);
                    } else {
                        TracerDetour.a(-491234626);
                    }
                } finally {
                    UriLatchManager.m13832a(a3);
                }
            } catch (InterruptedException e) {
                a = FetchedImage.m13901a(a2.m13849j()).m13911a(Source.ERROR).m13910a(Error.DOWNLOAD_PIPELINE_ERROR).m13912a();
                TracerDetour.a(1482081982);
            }
            return a;
        } finally {
            TracerDetour.a(-1354122624);
        }
    }

    private FetchedImage m13796a(FetchImageParams fetchImageParams, FetchedImage fetchedImage) {
        MediaCacheKey j = fetchImageParams.m13849j();
        CachedImage c = fetchedImage.m13904c();
        if (c != null && c.mo943b() == ImageType.BITMAP) {
            UrlImageProcessor d = fetchImageParams.m13847d();
            if (d != null) {
                TracerDetour.a("Running processor", -2079032687);
                Object a;
                try {
                    MarkerConfig a2 = this.f12919e.m13816a(fetchImageParams.m13846a(), 5439494, "UrlImageProcessImage");
                    a = CachedImage.m13888a(d.a(c.mo941a()));
                    this.f12919e.m13819a(a2, null);
                    fetchedImage = FetchedImage.m13901a(j).m13909a(c).m13911a(fetchedImage.m13905e()).m13907a(fetchedImage.m13906f()).m13912a();
                    String a3 = d.a();
                    if (!(a3 == null || a3 == UrlImageProcessor.a)) {
                        TracerDetour.a("Inserting processed image into cache", -270217809);
                        try {
                            this.f12916b.m13741a(j, (Object) c);
                        } catch (IOException e) {
                        } finally {
                            TracerDetour.a(36403633);
                        }
                    }
                } finally {
                    a = 1741268048;
                    TracerDetour.a(1741268048);
                }
            }
        }
        return fetchedImage;
    }

    private FetchedImage m13803c(FetchImageRequest fetchImageRequest) {
        TracerDetour.a("fetchImageNoDecode", 1511561730);
        try {
            FetchedImage a;
            FetchImageParams a2 = fetchImageRequest.m13837a();
            ImageCacheKey j = a2.m13849j();
            BinaryResource d = this.f12916b.m13752d(j);
            if (d != null) {
                a = FetchedImage.m13901a(j).m13908a(d).m13911a(Source.CACHE).m13912a();
            } else {
                BinaryResource d2 = this.f12916b.m13752d(a2.m13850k());
                if (d2 != null) {
                    a = FetchedImage.m13901a(j).m13908a(d2).m13911a(Source.UNDERLYING_IMAGE_IN_CACHE).m13912a();
                    TracerDetour.a(-409568871);
                } else {
                    a = FetchedImage.m13901a(j).m13911a(Source.NOT_IN_CACHE_NOT_DOWNLOADED).m13912a();
                    TracerDetour.a(-1174296815);
                }
            }
            return a;
        } finally {
            TracerDetour.a(-516274779);
        }
    }

    private FetchedImage m13797a(FetchImageRequest fetchImageRequest, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger) {
        DownloadResultCode downloadResultCode;
        Throwable th;
        DownloadResultCode downloadResultCode2;
        FetchImageParams a = fetchImageRequest.m13837a();
        ImageCacheKey k = a.m13850k();
        if (this.f12916b.m13754f(k)) {
            return FetchedImage.m13901a(k).m13911a(Source.ERROR).m13910a(Error.PREV_FAILURE_RETRY_BLOCKED).m13912a();
        }
        Uri a2 = a.m13846a();
        MarkerConfig a3 = this.f12919e.m13816a(a.m13846a(), 5439493, "UrlImageDownloadAndInsertIntoCache");
        TracerDetour.a("Download image", 1578274827);
        try {
            FetchImageDownloadHandler fetchImageDownloadHandler = new FetchImageDownloadHandler(this, a2, k, fetchImageRequest.m13842f(), a);
            final ImageReferrer d = fetchImageRequest.m13840d();
            try {
                FetchedImage fetchedImage = (FetchedImage) ((ImageMediaDownloader) this.f12918d.get()).mo304a(new MediaDownloadRequest<FetchedImage>(this, a2, fetchImageDownloadHandler, fbHttpRequestCancelTrigger, fetchImageRequest.m13841e()) {
                    final /* synthetic */ DefaultFetchImageHandler f3572b;

                    public final HttpUriRequest mo288a() {
                        HttpUriRequest a = super.mo288a();
                        if (d != null) {
                            a.addHeader("Referer", d.a().toString());
                        }
                        return a;
                    }
                });
                DownloadResultCode downloadResultCode3 = DownloadResultCode.SUCCESS;
                TracerDetour.a(-1069570576);
                this.f12919e.m13819a(a3, downloadResultCode3 != null ? downloadResultCode3.toString() : null);
                return fetchedImage;
            } catch (IOException e) {
                DownloadResultContainer a4 = m13794a(k, e);
                downloadResultCode = a4.b;
                m13800a(a, downloadResultCode);
                FetchedImage fetchedImage2 = a4.a;
                TracerDetour.a(907214288);
                this.f12919e.m13819a(a3, downloadResultCode != null ? downloadResultCode.toString() : null);
                return fetchedImage2;
            } catch (Throwable th2) {
                th = th2;
                downloadResultCode2 = downloadResultCode;
                TracerDetour.a(-1529241012);
                this.f12919e.m13819a(a3, downloadResultCode2 == null ? null : downloadResultCode2.toString());
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            downloadResultCode2 = null;
            TracerDetour.a(-1529241012);
            if (downloadResultCode2 == null) {
            }
            this.f12919e.m13819a(a3, downloadResultCode2 == null ? null : downloadResultCode2.toString());
            throw th;
        }
    }

    private static DownloadResultContainer m13794a(ImageCacheKey imageCacheKey, IOException iOException) {
        DownloadResultCode downloadResultCode;
        Error error;
        Builder a = FetchedImage.m13901a(imageCacheKey);
        a.f13056d = Source.ERROR;
        Builder builder = a;
        if (!(iOException instanceof FileNotFoundException)) {
            if (!(iOException instanceof UnknownLocalIOException) && (iOException instanceof HttpResponseException)) {
                switch (((HttpResponseException) iOException).getStatusCode()) {
                    case 403:
                        downloadResultCode = DownloadResultCode.FORBIDDEN;
                        error = Error.DOWNLOAD_PIPELINE_ERROR;
                        break;
                    case 404:
                        downloadResultCode = DownloadResultCode.NOT_FOUND;
                        error = Error.DOWNLOAD_NOT_FOUND;
                        break;
                    default:
                        downloadResultCode = DownloadResultCode.OTHER;
                        error = Error.DOWNLOAD_PIPELINE_ERROR;
                        break;
                }
            }
            downloadResultCode = DownloadResultCode.IO_EXCEPTION;
            error = Error.DOWNLOAD_PIPELINE_ERROR;
        } else {
            downloadResultCode = DownloadResultCode.NOT_FOUND;
            error = Error.DOWNLOAD_NOT_FOUND;
        }
        builder.f13058f = error;
        return new DownloadResultContainer(builder.m13912a(), downloadResultCode);
    }

    private void m13800a(FetchImageParams fetchImageParams, DownloadResultCode downloadResultCode) {
        switch (downloadResultCode) {
            case NOT_FOUND:
                m13799a(fetchImageParams, 3600000);
                return;
            default:
                m13799a(fetchImageParams, 20000);
                return;
        }
    }
}
