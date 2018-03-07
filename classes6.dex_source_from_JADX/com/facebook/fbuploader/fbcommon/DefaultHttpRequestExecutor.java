package com.facebook.fbuploader.fbcommon;

import com.facebook.fbuploader.HttpRequestExecutor$HttpRequestHandle;
import com.facebook.fbuploader.HttpRequestExecutor$HttpRequestResponseHandler;
import com.facebook.fbuploader.HttpRequestExecutor$Method;
import com.facebook.fbuploader.HttpRequestExecutor$RequestBody;
import com.facebook.fbuploader.UploadFailureException;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.HttpWireCallback;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.apache.http.client.HttpResponseException;

/* compiled from: neko_di_install_routed_to_google_play */
public class DefaultHttpRequestExecutor {
    private final ListeningExecutorService f10098a;
    public final AbstractSingleMethodRunner f10099b;
    public Map<HttpRequestExecutor$HttpRequestHandle, ListenableFuture<String>> f10100c = new HashMap();

    /* compiled from: neko_di_install_routed_to_google_play */
    class ProgressListener implements ApiMethodProgressListener, HttpWireCallback {
        private long f10095a;
        private boolean f10096b = false;
        private final HttpRequestExecutor$HttpRequestResponseHandler f10097c;

        public ProgressListener(long j, HttpRequestExecutor$HttpRequestResponseHandler httpRequestExecutor$HttpRequestResponseHandler) {
            this.f10095a = j;
            this.f10097c = httpRequestExecutor$HttpRequestResponseHandler;
        }

        public final void m15783a(long j, long j2) {
            if (!this.f10096b) {
                int i = (int) (j - this.f10095a);
                this.f10095a = j;
                this.f10097c.mo1034a(i);
            }
        }

        public final void m15781a() {
            this.f10096b = true;
        }

        public final void m15782a(long j) {
            this.f10097c.mo1034a((int) j);
        }
    }

    public DefaultHttpRequestExecutor(ListeningExecutorService listeningExecutorService, AbstractSingleMethodRunner abstractSingleMethodRunner) {
        this.f10098a = listeningExecutorService;
        this.f10099b = abstractSingleMethodRunner;
    }

    public final HttpRequestExecutor$HttpRequestHandle m15785a(HttpRequestExecutor$Method httpRequestExecutor$Method, Map<String, String> map, URI uri, @Nullable HttpRequestExecutor$RequestBody httpRequestExecutor$RequestBody, final HttpRequestExecutor$HttpRequestResponseHandler httpRequestExecutor$HttpRequestResponseHandler) {
        Callable callable = null;
        HttpRequestExecutor$HttpRequestHandle httpRequestExecutor$HttpRequestHandle = new HttpRequestExecutor$HttpRequestHandle();
        String a = m15784a(uri);
        if (Strings.isNullOrEmpty(a)) {
            httpRequestExecutor$HttpRequestResponseHandler.mo1032a(new UploadFailureException("Invalid or non-Facebook URI: " + uri.toString() + " (Non-Retriable)"), false);
            return null;
        }
        switch (httpRequestExecutor$Method) {
            case GET:
                final ResumableUploadGetMethod resumableUploadGetMethod = new ResumableUploadGetMethod();
                final ResumableUploadGetParams resumableUploadGetParams = new ResumableUploadGetParams(a);
                final ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
                callable = new Callable<String>(this) {
                    final /* synthetic */ DefaultHttpRequestExecutor f10086d;

                    public Object call() {
                        return (String) this.f10086d.f10099b.a(resumableUploadGetMethod, resumableUploadGetParams, apiMethodRunnerParams);
                    }
                };
                break;
            case POST:
                if (httpRequestExecutor$RequestBody != null) {
                    final ResumableUploadPostMethod resumableUploadPostMethod = new ResumableUploadPostMethod();
                    final ResumableUploadPostParams resumableUploadPostParams = new ResumableUploadPostParams(a, httpRequestExecutor$RequestBody.f10060a.m15740a(), (int) (httpRequestExecutor$RequestBody.f10060a.m15741b() + httpRequestExecutor$RequestBody.f10061b), (int) (httpRequestExecutor$RequestBody.f10060a.m15742c() - httpRequestExecutor$RequestBody.f10061b), map);
                    final ApiMethodRunnerParams apiMethodRunnerParams2 = new ApiMethodRunnerParams();
                    apiMethodRunnerParams2.a = new ProgressListener(httpRequestExecutor$RequestBody.f10060a.m15741b(), httpRequestExecutor$HttpRequestResponseHandler);
                    Object c06112 = new Callable<String>(this) {
                        final /* synthetic */ DefaultHttpRequestExecutor f10090d;

                        public Object call() {
                            return (String) this.f10090d.f10099b.a(resumableUploadPostMethod, resumableUploadPostParams, apiMethodRunnerParams2);
                        }
                    };
                    break;
                }
                httpRequestExecutor$HttpRequestResponseHandler.mo1032a(new UploadFailureException("No POST body"), false);
                return null;
        }
        final ListenableFuture a2 = this.f10098a.a(callable);
        this.f10100c.put(httpRequestExecutor$HttpRequestHandle, a2);
        Futures.a(a2, new FutureCallback<String>(this) {
            final /* synthetic */ DefaultHttpRequestExecutor f10093c;

            public void onSuccess(@Nullable Object obj) {
                String str = (String) obj;
                if (a2.isCancelled()) {
                    httpRequestExecutor$HttpRequestResponseHandler.mo1031a();
                } else {
                    httpRequestExecutor$HttpRequestResponseHandler.mo1033a(str);
                }
            }

            public void onFailure(Throwable th) {
                if (a2.isCancelled()) {
                    httpRequestExecutor$HttpRequestResponseHandler.mo1031a();
                    return;
                }
                Exception exception = (Exception) th;
                boolean z = exception instanceof HttpResponseException ? ((HttpResponseException) exception).getStatusCode() != 400 : true;
                httpRequestExecutor$HttpRequestResponseHandler.mo1032a(exception, z);
            }
        }, this.f10098a);
        return httpRequestExecutor$HttpRequestHandle;
    }

    private static String m15784a(URI uri) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("facebook.com/");
        if (indexOf < 0) {
            return "";
        }
        return uri2.substring(indexOf + 13);
    }
}
