package com.facebook.stickers.data;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.facebook.ui.media.fetch.MediaDownloadRequest.Scheme;
import com.facebook.ui.media.fetch.MediaDownloader;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pyml/ */
public class StickerMediaDownloader extends MediaDownloader {
    private static volatile StickerMediaDownloader f3977c;
    @Inject
    public GatekeeperStoreImpl f3978a;
    @Inject
    public ImagePipelineWrapper f3979b;

    public static com.facebook.stickers.data.StickerMediaDownloader m4465a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3977c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickerMediaDownloader.class;
        monitor-enter(r1);
        r0 = f3977c;	 Catch:{ all -> 0x003a }
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
        r0 = m4466b(r0);	 Catch:{ all -> 0x0035 }
        f3977c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3977c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickerMediaDownloader.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickerMediaDownloader");
    }

    private static StickerMediaDownloader m4466b(InjectorLike injectorLike) {
        StickerMediaDownloader stickerMediaDownloader = new StickerMediaDownloader((Context) injectorLike.getInstance(Context.class), FbHttpRequestProcessor.a(injectorLike), WebRequestCounters.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), TimeWindowThrottlingPolicy.a(injectorLike), NetworkDataLogUtils.a(injectorLike), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(injectorLike), ConnectionStatusLogger.a(injectorLike));
        ImagePipelineWrapper a = ImagePipelineWrapper.m4472a(injectorLike);
        stickerMediaDownloader.f3978a = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        stickerMediaDownloader.f3979b = a;
        return stickerMediaDownloader;
    }

    @Inject
    public StickerMediaDownloader(Context context, FbHttpRequestProcessor fbHttpRequestProcessor, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        super(context, fbHttpRequestProcessor, "sticker", webRequestCounters, analyticsLogger, timeWindowThrottlingPolicy, networkDataLogUtils, cdnHttpRequestHandler, connectionStatusLogger);
    }

    @Nullable
    public final <T> T mo304a(MediaDownloadRequest<T> mediaDownloadRequest) {
        boolean z = false;
        if (!(mediaDownloadRequest.f3575c == Scheme.CONTENT || mediaDownloadRequest.f3575c == Scheme.FILE || !this.f3978a.a(327, false))) {
            z = true;
        }
        if (z) {
            return m4467d(mediaDownloadRequest);
        }
        return super.mo304a((MediaDownloadRequest) mediaDownloadRequest);
    }

    private <T> T m4467d(MediaDownloadRequest<T> mediaDownloadRequest) {
        Throwable e;
        InputStream inputStream = null;
        DataSource a = this.f3979b.m4479a(ImageRequestBuilder.a(mediaDownloadRequest.m3962b()), mediaDownloadRequest.m3964f());
        try {
            CloseableReference closeableReference = (CloseableReference) Uninterruptibles.a(DataSourceToFutureAdapter.m7803a(a));
            if (closeableReference == null) {
                throw new IllegalStateException("Failed to download image request. Network might be down.");
            }
            PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
            try {
                mediaDownloadRequest.m3963e().a(pooledByteBufferInputStream, -1, CdnHeaderResponse.NO_HEADER);
                a.g();
                pooledByteBufferInputStream.close();
                return null;
            } catch (Exception e2) {
                e = e2;
                inputStream = pooledByteBufferInputStream;
                try {
                    throw new IOException(e);
                } catch (Throwable th) {
                    e = th;
                    a.g();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                inputStream = pooledByteBufferInputStream;
                a.g();
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            throw new IOException(e);
        }
    }
}
