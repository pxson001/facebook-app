package com.facebook.video.downloadmanager;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.video.downloadmanager.DownloadManager.C13851;
import java.io.File;
import java.net.URI;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;

@Singleton
/* compiled from: connection_manager_bandwidth_quality */
public class VideoDownloadHandler {
    private static final String f18722a = VideoDownloadHandler.class.getName();
    private static volatile VideoDownloadHandler f18723c;
    private final FbHttpRequestProcessor f18724b;

    /* compiled from: connection_manager_bandwidth_quality */
    class HttpResponseHandler implements ResponseHandler<Long> {
        final /* synthetic */ VideoDownloadHandler f18716a;
        private final File f18717b;
        private final String f18718c;
        private final C13851 f18719d;
        private Future f18720e;
        private Exception f18721f;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object handleResponse(org.apache.http.HttpResponse r14) {
            /*
            r13 = this;
            r1 = 0;
            r10 = 206; // 0xce float:2.89E-43 double:1.02E-321;
            r0 = r13.f18717b;
            r4 = r0.length();
            r0 = r14.getStatusLine();	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r0 = r0.getStatusCode();	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r0 == r2) goto L_0x005e;
        L_0x0015:
            if (r0 == r10) goto L_0x005e;
        L_0x0017:
            com.facebook.video.downloadmanager.VideoDownloadHandler.f18722a;	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r2 = new java.io.IOException;	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r6 = "Invalid HTTP Status code ";
            r3.<init>(r6);	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r0 = r3.append(r0);	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r0 = r0.toString();	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            r2.<init>(r0);	 Catch:{ Exception -> 0x0032, all -> 0x010c }
            throw r2;	 Catch:{ Exception -> 0x0032, all -> 0x010c }
        L_0x0032:
            r0 = move-exception;
            r2 = r0;
            r3 = r1;
            r12 = r1;
            r0 = r4;
            r4 = r12;
        L_0x0038:
            r5 = r13.m27462a();	 Catch:{ all -> 0x0121 }
            if (r5 != 0) goto L_0x0047;
        L_0x003e:
            r5 = r13.f18716a;	 Catch:{ all -> 0x0121 }
            r6 = r13.f18718c;	 Catch:{ all -> 0x0121 }
            r7 = r13.f18719d;	 Catch:{ all -> 0x0121 }
            com.facebook.video.downloadmanager.VideoDownloadHandler.m27470a(r6, r2, r7);	 Catch:{ all -> 0x0121 }
        L_0x0047:
            r13.f18721f = r2;	 Catch:{ all -> 0x0121 }
            if (r4 == 0) goto L_0x004e;
        L_0x004b:
            r4.close();
        L_0x004e:
            if (r3 == 0) goto L_0x0053;
        L_0x0050:
            r3.close();
        L_0x0053:
            com.facebook.video.downloadmanager.VideoDownloadHandler.f18722a;
            java.lang.Long.valueOf(r0);
            r0 = java.lang.Long.valueOf(r0);
            return r0;
        L_0x005e:
            r6 = r14.getEntity();	 Catch:{  }
            r7 = r6.getContent();	 Catch:{  }
            r2 = r6.getContentLength();	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r8 = r13.f18717b;	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r8 = r8.length();	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r2 = r2 + r8;
            com.facebook.video.downloadmanager.VideoDownloadHandler.f18722a;	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r8 = r6.getContentLength();	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r8 = r13.f18717b;	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r8 = r8.exists();	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            if (r8 == 0) goto L_0x00d7;
        L_0x0089:
            if (r0 != r10) goto L_0x00d7;
        L_0x008b:
            r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r0 = r13.f18717b;	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
            r6 = 1;
            r8.<init>(r0, r6);	 Catch:{ Exception -> 0x0125, all -> 0x0119 }
        L_0x0093:
            r0 = r13.f18716a;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r1 = r13.f18718c;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r6 = r13.f18719d;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            com.facebook.video.downloadmanager.VideoDownloadHandler.m27469a(r1, r2, r4, r6);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r9 = new byte[r0];	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            com.facebook.video.downloadmanager.VideoDownloadHandler.f18722a;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r10 = r2 - r4;
            r0 = java.lang.Math.min(r0, r10);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = (int) r0;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
        L_0x00ad:
            if (r0 <= 0) goto L_0x00e7;
        L_0x00af:
            r1 = 0;
            r0 = r7.read(r9, r1, r0);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r1 = -1;
            if (r0 == r1) goto L_0x00e7;
        L_0x00b7:
            r1 = 0;
            r8.write(r9, r1, r0);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = (long) r0;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r4 = r4 + r0;
            r0 = r13.f18716a;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r1 = r13.f18718c;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r6 = r13.f18719d;	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            com.facebook.video.downloadmanager.VideoDownloadHandler.m27469a(r1, r2, r4, r6);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = r13.m27462a();	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            if (r0 != 0) goto L_0x00e7;
        L_0x00cc:
            r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r10 = r2 - r4;
            r0 = java.lang.Math.min(r0, r10);	 Catch:{ Exception -> 0x0135, all -> 0x011e }
            r0 = (int) r0;
            goto L_0x00ad;
        L_0x00d7:
            r2 = new java.io.FileOutputStream;	 Catch:{  }
            r0 = r13.f18717b;	 Catch:{  }
            r2.<init>(r0);	 Catch:{  }
            r0 = r6.getContentLength();	 Catch:{ Exception -> 0x012d, all -> 0x011b }
            r4 = 0;
            r8 = r2;
            r2 = r0;
            goto L_0x0093;
        L_0x00e7:
            r0 = r4;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 == 0) goto L_0x0102;
        L_0x00ec:
            r2 = r13.m27462a();	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            if (r2 != 0) goto L_0x0102;
        L_0x00f2:
            r2 = r13.f18716a;	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            r3 = r13.f18718c;	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            r4 = new java.io.IOException;	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            r5 = "Unexpected end of stream";
            r4.<init>(r5);	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            r5 = r13.f18719d;	 Catch:{ Exception -> 0x013c, all -> 0x011e }
            com.facebook.video.downloadmanager.VideoDownloadHandler.m27470a(r3, r4, r5);	 Catch:{ Exception -> 0x013c, all -> 0x011e }
        L_0x0102:
            r8.close();
            if (r7 == 0) goto L_0x0053;
        L_0x0107:
            r7.close();
            goto L_0x0053;
        L_0x010c:
            r0 = move-exception;
            r7 = r1;
        L_0x010e:
            if (r1 == 0) goto L_0x0113;
        L_0x0110:
            r1.close();
        L_0x0113:
            if (r7 == 0) goto L_0x0118;
        L_0x0115:
            r7.close();
        L_0x0118:
            throw r0;
        L_0x0119:
            r0 = move-exception;
            goto L_0x010e;
        L_0x011b:
            r0 = move-exception;
            r1 = r2;
            goto L_0x010e;
        L_0x011e:
            r0 = move-exception;
            r1 = r8;
            goto L_0x010e;
        L_0x0121:
            r0 = move-exception;
            r7 = r3;
            r1 = r4;
            goto L_0x010e;
        L_0x0125:
            r0 = move-exception;
            r2 = r0;
            r3 = r7;
            r12 = r1;
            r0 = r4;
            r4 = r12;
            goto L_0x0038;
        L_0x012d:
            r0 = move-exception;
            r3 = r7;
            r12 = r0;
            r0 = r4;
            r4 = r2;
            r2 = r12;
            goto L_0x0038;
        L_0x0135:
            r0 = move-exception;
            r2 = r0;
            r3 = r7;
            r0 = r4;
            r4 = r8;
            goto L_0x0038;
        L_0x013c:
            r2 = move-exception;
            r3 = r7;
            r4 = r8;
            goto L_0x0038;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.VideoDownloadHandler.HttpResponseHandler.handleResponse(org.apache.http.HttpResponse):java.lang.Object");
        }

        public HttpResponseHandler(VideoDownloadHandler videoDownloadHandler, String str, File file, C13851 c13851) {
            this.f18716a = videoDownloadHandler;
            this.f18717b = file;
            this.f18718c = str;
            this.f18719d = c13851;
        }

        public final void m27463a(Future future) {
            this.f18720e = future;
        }

        private boolean m27462a() {
            return this.f18720e != null && this.f18720e.isCancelled();
        }
    }

    public static com.facebook.video.downloadmanager.VideoDownloadHandler m27464a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18723c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.VideoDownloadHandler.class;
        monitor-enter(r1);
        r0 = f18723c;	 Catch:{ all -> 0x003a }
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
        r0 = m27471b(r0);	 Catch:{ all -> 0x0035 }
        f18723c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18723c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.VideoDownloadHandler.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.VideoDownloadHandler");
    }

    private static VideoDownloadHandler m27471b(InjectorLike injectorLike) {
        return new VideoDownloadHandler(FbHttpRequestProcessor.a(injectorLike));
    }

    private static void m27469a(String str, long j, long j2, C13851 c13851) {
        try {
            c13851.m27401a(str, j, j2);
        } catch (Throwable e) {
            BLog.b(f18722a, "Exception notifiying status ", e);
        }
    }

    private static void m27470a(String str, Exception exception, C13851 c13851) {
        try {
            c13851.m27402a(str, exception);
        } catch (Throwable e) {
            BLog.b(f18722a, "Exception notifiying error ", e);
        }
    }

    private static void m27468a(File file, HttpGet httpGet) {
        if (file.exists()) {
            httpGet.setHeader("Range", "bytes=" + file.length() + "-");
        }
    }

    public final HttpFutureWrapper m27472a(Uri uri, String str, File file, C13851 c13851) {
        try {
            HttpUriRequest httpGet = new HttpGet(URI.create(uri.toString()));
            m27468a(file, httpGet);
            HttpClientParams.setRedirecting(httpGet.getParams(), true);
            Object httpResponseHandler = new HttpResponseHandler(this, str, file, c13851);
            HttpFutureWrapper b = this.f18724b.b(FbHttpRequest.newBuilder().a(httpGet).a(CallerContext.a(getClass())).a(VideoDownloadHandler.class.getSimpleName()).a(true).a(RequestIdempotency.RETRY_SAFE).a(RequestPriority.NON_INTERACTIVE).a(httpResponseHandler).a());
            httpResponseHandler.m27463a(b.a());
            return b;
        } catch (Throwable e) {
            BLog.b(f18722a, "Exception in starting http request ", e);
            m27470a(str, e, c13851);
            return null;
        }
    }

    @Inject
    public VideoDownloadHandler(FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f18724b = fbHttpRequestProcessor;
    }
}
