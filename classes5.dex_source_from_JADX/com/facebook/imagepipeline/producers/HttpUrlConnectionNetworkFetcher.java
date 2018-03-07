package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetchProducer.1;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: TOPIC_PROFESSIONAL_SERVICES */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    private final ExecutorService f13766a;

    @com.facebook.common.internal.VisibleForTesting
    final void m23122b(com.facebook.imagepipeline.producers.FetchState r4, com.facebook.imagepipeline.producers.NetworkFetchProducer.1 r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r1 = 0;
        r0 = r4.e();	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r2 = 5;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r1 = r3.m23119a(r0, r2);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
    L_0x000c:
        r0 = r1.getInputStream();	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r2 = -1;	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        r5.a(r0, r2);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
    L_0x0014:
        if (r1 == 0) goto L_0x0019;
    L_0x0016:
        r1.disconnect();
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        r5.a(r0);	 Catch:{ IOException -> 0x001a, all -> 0x0024 }
        if (r1 == 0) goto L_0x0019;
    L_0x0020:
        r1.disconnect();
        goto L_0x0019;
    L_0x0024:
        r0 = move-exception;
        if (r1 == 0) goto L_0x002a;
    L_0x0027:
        r1.disconnect();
    L_0x002a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.b(com.facebook.imagepipeline.producers.FetchState, com.facebook.imagepipeline.producers.NetworkFetchProducer$1):void");
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
    }

    @VisibleForTesting
    private HttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        this.f13766a = executorService;
    }

    public final FetchState m23120a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    public final void m23121a(final FetchState fetchState, final 1 1) {
        final Future a = ExecutorDetour.a(this.f13766a, new Runnable(this) {
            final /* synthetic */ HttpUrlConnectionNetworkFetcher f13762c;

            public void run() {
                this.f13762c.m23122b(fetchState, 1);
            }
        }, -110057960);
        fetchState.b.a(new BaseProducerContextCallbacks(this) {
            final /* synthetic */ HttpUrlConnectionNetworkFetcher f13765c;

            public final void m23117a() {
                if (a.cancel(false)) {
                    1.a();
                }
            }
        });
    }

    private HttpURLConnection m23119a(Uri uri, int i) {
        Object obj;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return httpURLConnection;
        }
        switch (responseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            String headerField = httpURLConnection.getHeaderField("Location");
            httpURLConnection.disconnect();
            Uri parse = headerField == null ? null : Uri.parse(headerField);
            headerField = uri.getScheme();
            if (i > 0 && parse != null && !parse.getScheme().equals(headerField)) {
                return m23119a(parse, i - 1);
            }
            throw new IOException(i == 0 ? m23118a("URL %s follows too many redirects", uri.toString()) : m23118a("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        httpURLConnection.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{uri.toString(), Integer.valueOf(responseCode)}));
    }

    private static String m23118a(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
