package com.facebook.messaging.audio.playback;

import android.net.Uri;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.KeyedExecutor;
import com.facebook.common.executors.KeyedExecutor.Task;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.HttpResponseException;

@Singleton
/* compiled from: order_history */
public class FetchAudioExecutor {
    private static final Class<?> f8083a = FetchAudioExecutor.class;
    private static volatile FetchAudioExecutor f8084f;
    public final AudioCache f8085b;
    private final AudioUriCache f8086c;
    private final AudioMediaDownloader f8087d;
    private final KeyedExecutor f8088e;

    /* compiled from: order_history */
    class AudioResponseHandler implements DownloadResultResponseHandler<Uri> {
        final /* synthetic */ FetchAudioExecutor f8081a;
        private final AudioCacheKey f8082b;

        public AudioResponseHandler(FetchAudioExecutor fetchAudioExecutor, AudioCacheKey audioCacheKey) {
            this.f8081a = fetchAudioExecutor;
            this.f8082b = audioCacheKey;
        }

        public final Object m8334a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            try {
                this.f8081a.f8085b.a(this.f8082b, inputStream);
                Object e = this.f8081a.f8085b.e(this.f8082b);
                return e;
            } finally {
                inputStream.close();
            }
        }
    }

    public static com.facebook.messaging.audio.playback.FetchAudioExecutor m8335a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8084f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.audio.playback.FetchAudioExecutor.class;
        monitor-enter(r1);
        r0 = f8084f;	 Catch:{ all -> 0x003a }
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
        r0 = m8337b(r0);	 Catch:{ all -> 0x0035 }
        f8084f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8084f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.playback.FetchAudioExecutor.a(com.facebook.inject.InjectorLike):com.facebook.messaging.audio.playback.FetchAudioExecutor");
    }

    private static FetchAudioExecutor m8337b(InjectorLike injectorLike) {
        return new FetchAudioExecutor(AudioCache.m8300a(injectorLike), AudioUriCache.m8332a(injectorLike), KeyedExecutor.a(injectorLike), AudioMediaDownloader.m8326a(injectorLike));
    }

    @Inject
    public FetchAudioExecutor(AudioCache audioCache, AudioUriCache audioUriCache, KeyedExecutor keyedExecutor, AudioMediaDownloader audioMediaDownloader) {
        this.f8085b = audioCache;
        this.f8086c = audioUriCache;
        this.f8087d = audioMediaDownloader;
        this.f8088e = keyedExecutor;
    }

    public final ListenableFuture<Uri> m8339a(final FetchAudioParams fetchAudioParams) {
        ListenableFutureTask listenableFutureTask;
        AudioCacheKey b = fetchAudioParams.m8341b();
        Task task = (Task) this.f8088e.f.get(b);
        if (task != null) {
            listenableFutureTask = task.c;
        } else {
            listenableFutureTask = null;
        }
        ListenableFuture<Uri> listenableFuture = listenableFutureTask;
        if (listenableFuture != null && !listenableFuture.isCancelled()) {
            return listenableFuture;
        }
        Callable c09091 = new Callable<Uri>(this) {
            final /* synthetic */ FetchAudioExecutor f8080b;

            public Object call() {
                return FetchAudioExecutor.m8336b(this.f8080b, fetchAudioParams);
            }
        };
        String str = "audio-message-" + Math.abs(b.f8032a.hashCode() % 3);
        new StringBuilder("Create async task for downloading ").append(str);
        return this.f8088e.a(str, b, c09091, fetchAudioParams.f8089a.toString());
    }

    public static Uri m8336b(FetchAudioExecutor fetchAudioExecutor, FetchAudioParams fetchAudioParams) {
        AudioCacheKey b = fetchAudioParams.m8341b();
        Uri e = fetchAudioExecutor.f8085b.e(b);
        if (e != null) {
            fetchAudioExecutor.f8086c.m8333a(fetchAudioParams.f8089a, e);
            return e;
        }
        new StringBuilder("Miss to hit the audio cache. Start downloading ").append(b.f8032a);
        e = fetchAudioExecutor.m8338c(fetchAudioParams);
        fetchAudioExecutor.f8086c.m8333a(fetchAudioParams.f8089a, e);
        return e;
    }

    private Uri m8338c(FetchAudioParams fetchAudioParams) {
        AudioCacheKey b = fetchAudioParams.m8341b();
        if (this.f8085b.f(b)) {
            throw new IOException("Fetching " + b.m8307c() + " was failed recently. Waiting for retrying.");
        }
        MediaDownloadRequest mediaDownloadRequest = new MediaDownloadRequest(fetchAudioParams.m8340a(), new AudioResponseHandler(this, b), CallerContext.b(getClass(), "audio_download"));
        TracerDetour.a("Download audio", 163384498);
        try {
            Uri uri = (Uri) this.f8087d.a(mediaDownloadRequest);
            TracerDetour.a(-2046249400);
            return uri;
        } catch (HttpResponseException e) {
            this.f8085b.a(b, 3600000);
            throw e;
        } catch (IOException e2) {
            this.f8085b.a(b, 20000);
            throw e2;
        } catch (Throwable th) {
            TracerDetour.a(-2119817418);
        }
    }
}
