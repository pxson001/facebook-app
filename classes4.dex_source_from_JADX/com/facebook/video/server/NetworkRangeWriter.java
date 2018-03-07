package com.facebook.video.server;

import android.net.Uri;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.HeaderMap;
import com.facebook.ui.media.cache.Range;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.util.EntityUtils;

/* compiled from: page_data_fetch */
public class NetworkRangeWriter implements RangeWriter {
    private final HeaderGetterRequest[] f5479a = new HeaderGetterRequest[]{new ByteRangeHeaderGetterRequest(this), new HeadHeaderGetterRequest(this), new NaiveHeaderGetterRequest(this)};
    public final URL f5480b;
    private final LoggedInUserSessionManager f5481c;
    private ObjectMapper f5482d;
    public RequestPriority f5483e;
    public final CallerContext f5484f;
    public final DefaultNetworkProcessor f5485g;
    public final AbstractFbErrorReporter f5486h;
    private final Collection<FbHttpRequest<?>> f5487i = new ConcurrentLinkedQueue();

    /* compiled from: page_data_fetch */
    interface HeaderGetterRequest {
        FbHttpRequest<HeaderMap> mo527a();
    }

    /* compiled from: page_data_fetch */
    class ByteRangeHeaderGetterRequest implements HeaderGetterRequest {
        final /* synthetic */ NetworkRangeWriter f5488a;

        public ByteRangeHeaderGetterRequest(NetworkRangeWriter networkRangeWriter) {
            this.f5488a = networkRangeWriter;
        }

        public final FbHttpRequest<HeaderMap> mo527a() {
            HttpUriRequest httpGet = new HttpGet(this.f5488a.f5480b.toURI());
            httpGet.setHeader("Range", "bytes=0-1");
            NetworkRangeWriter.m5938a(this.f5488a, httpGet);
            HttpClientParams.setRedirecting(httpGet.getParams(), true);
            Builder newBuilder = FbHttpRequest.newBuilder();
            newBuilder.b = httpGet;
            Builder builder = newBuilder;
            builder.d = this.f5488a.f5484f;
            builder = builder;
            builder.c = "getHeadersForVideo-PARTIAL";
            builder = builder;
            builder.l = RequestPriority.INTERACTIVE;
            builder = builder;
            builder.g = new HeaderGetterResponseHandler(this.f5488a);
            builder = builder;
            builder.k = RequestIdempotency.RETRY_SAFE;
            return builder.a();
        }
    }

    /* compiled from: page_data_fetch */
    class HeadHeaderGetterRequest extends StandardHeaderGetterRequest {
        final /* synthetic */ NetworkRangeWriter f5489a;

        public HeadHeaderGetterRequest(NetworkRangeWriter networkRangeWriter) {
            this.f5489a = networkRangeWriter;
            super(networkRangeWriter);
        }

        protected final HttpRequestBase mo528b() {
            return new HttpHead(this.f5489a.f5480b.toURI());
        }
    }

    /* compiled from: page_data_fetch */
    abstract class StandardHeaderGetterRequest implements HeaderGetterRequest {
        final /* synthetic */ NetworkRangeWriter f5490b;

        protected abstract HttpRequestBase mo528b();

        public StandardHeaderGetterRequest(NetworkRangeWriter networkRangeWriter) {
            this.f5490b = networkRangeWriter;
        }

        public final FbHttpRequest<HeaderMap> mo527a() {
            HttpUriRequest b = mo528b();
            NetworkRangeWriter.m5938a(this.f5490b, b);
            HttpClientParams.setRedirecting(b.getParams(), true);
            Builder newBuilder = FbHttpRequest.newBuilder();
            newBuilder.b = b;
            newBuilder = newBuilder;
            newBuilder.d = this.f5490b.f5484f;
            newBuilder = newBuilder;
            newBuilder.c = "getHeadersForVideo-" + b.getMethod();
            Builder builder = newBuilder;
            builder.l = this.f5490b.f5483e;
            builder = builder;
            builder.g = new HeaderGetterResponseHandler(this.f5490b);
            builder = builder;
            builder.k = RequestIdempotency.RETRY_SAFE;
            return builder.a();
        }
    }

    /* compiled from: page_data_fetch */
    class NaiveHeaderGetterRequest extends StandardHeaderGetterRequest {
        final /* synthetic */ NetworkRangeWriter f5491a;

        public NaiveHeaderGetterRequest(NetworkRangeWriter networkRangeWriter) {
            this.f5491a = networkRangeWriter;
            super(networkRangeWriter);
        }

        protected final HttpRequestBase mo528b() {
            return new HttpGet(this.f5491a.f5480b.toURI());
        }
    }

    /* compiled from: page_data_fetch */
    class HeaderGetterResponseHandler implements ResponseHandler<HeaderMap> {
        final /* synthetic */ NetworkRangeWriter f5542a;
        private final String f5543b = HeaderGetterResponseHandler.class.getName();

        public HeaderGetterResponseHandler(NetworkRangeWriter networkRangeWriter) {
            this.f5542a = networkRangeWriter;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object handleResponse(org.apache.http.HttpResponse r7) {
            /*
            r6 = this;
            r4 = 0;
            r0 = 0;
            r1 = r7.getStatusLine();
            r1 = r1.getStatusCode();
            r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r1 != r2) goto L_0x0046;
        L_0x000f:
            r1 = "Content-Length";
            r1 = r7.getFirstHeader(r1);
            if (r1 == 0) goto L_0x002d;
        L_0x0017:
            r2 = r1.getValue();	 Catch:{ NumberFormatException -> 0x0039 }
            if (r2 == 0) goto L_0x002d;
        L_0x001d:
            r1 = r1.getValue();	 Catch:{ NumberFormatException -> 0x0039 }
            r1 = r1.trim();	 Catch:{ NumberFormatException -> 0x0039 }
            r2 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0039 }
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 > 0) goto L_0x0099;
        L_0x002d:
            r1 = r6.f5542a;	 Catch:{ NumberFormatException -> 0x0039 }
            r1 = r1.f5486h;	 Catch:{ NumberFormatException -> 0x0039 }
            r2 = r6.f5543b;	 Catch:{ NumberFormatException -> 0x0039 }
            r3 = "Resource length null";
            r1.a(r2, r3);	 Catch:{ NumberFormatException -> 0x0039 }
        L_0x0038:
            return r0;
        L_0x0039:
            r1 = move-exception;
            r1 = r6.f5542a;
            r1 = r1.f5486h;
            r2 = r6.f5543b;
            r3 = "Resource length NaN";
            r1.a(r2, r3);
            goto L_0x0038;
        L_0x0046:
            r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
            if (r1 != r2) goto L_0x00b8;
        L_0x004a:
            r1 = "Content-Range";
            r1 = r7.getFirstHeader(r1);
            if (r1 != 0) goto L_0x005e;
        L_0x0052:
            r1 = r6.f5542a;
            r1 = r1.f5486h;
            r2 = r6.f5543b;
            r3 = "Resource range null in partial response";
            r1.a(r2, r3);
            goto L_0x0038;
        L_0x005e:
            r2 = r1.getValue();
            r3 = 47;
            r2 = r2.lastIndexOf(r3);
            if (r2 >= 0) goto L_0x0083;
        L_0x006a:
            r2 = r6.f5542a;
            r2 = r2.f5486h;
            r3 = r6.f5543b;
            r4 = new java.lang.StringBuilder;
            r5 = "Resource length null in partial response: ";
            r4.<init>(r5);
            r1 = r4.append(r1);
            r1 = r1.toString();
            r2.a(r3, r1);
            goto L_0x0038;
        L_0x0083:
            r3 = r1.getValue();
            r2 = r2 + 1;
            r2 = r3.substring(r2);
            r2 = r2.trim();
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x009e }
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 <= 0) goto L_0x0038;
        L_0x0099:
            r0 = m5969b(r7);
            goto L_0x0038;
        L_0x009e:
            r2 = move-exception;
            r2 = r6.f5542a;
            r2 = r2.f5486h;
            r3 = r6.f5543b;
            r4 = new java.lang.StringBuilder;
            r5 = "Resource length NaN in partial response: ";
            r4.<init>(r5);
            r1 = r4.append(r1);
            r1 = r1.toString();
            r2.a(r3, r1);
            goto L_0x0038;
        L_0x00b8:
            r2 = r6.f5542a;
            r2 = r2.f5486h;
            r3 = r6.f5543b;
            r4 = new java.lang.StringBuilder;
            r5 = "Bad status code: ";
            r4.<init>(r5);
            r1 = r4.append(r1);
            r1 = r1.toString();
            r2.a(r3, r1);
            goto L_0x0038;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.NetworkRangeWriter.HeaderGetterResponseHandler.handleResponse(org.apache.http.HttpResponse):java.lang.Object");
        }

        private static HeaderMap m5969b(HttpResponse httpResponse) {
            HeaderMap headerMap = new HeaderMap();
            for (Header header : httpResponse.getAllHeaders()) {
                headerMap.put(header.getName(), header.getValue());
            }
            return headerMap;
        }
    }

    /* compiled from: page_data_fetch */
    class RangeReadResponseHandler implements ResponseHandler<Long> {
        final /* synthetic */ NetworkRangeWriter f5566a;
        private OutputStream f5567b;
        private IOException f5568c;
        private FbHttpRequest<Long> f5569d;

        public RangeReadResponseHandler(NetworkRangeWriter networkRangeWriter, OutputStream outputStream) {
            this.f5566a = networkRangeWriter;
            this.f5567b = outputStream;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 206) {
                HttpEntity entity = httpResponse.getEntity();
                InputStream content = entity.getContent();
                long contentLength = entity.getContentLength();
                try {
                    return Long.valueOf(ByteStreams.m11949a(new CheckedInputStream(content), this.f5567b));
                } catch (IOException e) {
                    this.f5568c = e;
                    this.f5566a.f5485g.c(this.f5569d);
                    return Long.valueOf(contentLength);
                }
            }
            throw new BadHttpResponse(statusCode, EntityUtils.toString(httpResponse.getEntity()));
        }

        public final IOException m5988a() {
            return this.f5568c;
        }

        public final void m5989a(FbHttpRequest<Long> fbHttpRequest) {
            this.f5569d = fbHttpRequest;
        }
    }

    @Inject
    public NetworkRangeWriter(URL url, RequestPriority requestPriority, CallerContext callerContext, DefaultNetworkProcessor defaultNetworkProcessor, AbstractFbErrorReporter abstractFbErrorReporter, LoggedInUserSessionManager loggedInUserSessionManager, ObjectMapper objectMapper) {
        this.f5480b = url;
        this.f5483e = requestPriority;
        if (callerContext == null) {
            this.f5484f = CallerContext.b(getClass(), "video");
        } else {
            this.f5484f = CallerContext.a(callerContext, "video");
        }
        this.f5485g = defaultNetworkProcessor;
        this.f5481c = loggedInUserSessionManager;
        this.f5482d = objectMapper;
        this.f5486h = abstractFbErrorReporter;
    }

    public final long mo525a(Range range, OutputStream outputStream) {
        ResponseHandler rangeReadResponseHandler = new RangeReadResponseHandler(this, outputStream);
        try {
            FbHttpRequest a = m5936a(range, rangeReadResponseHandler);
            rangeReadResponseHandler.m5989a(a);
            try {
                long longValue = ((Long) m5937a(a)).longValue();
                if (rangeReadResponseHandler.m5988a() == null) {
                    return longValue;
                }
                throw rangeReadResponseHandler.m5988a();
            } catch (Throwable e) {
                throw new NetworkAccessException("Error requesting data", e);
            }
        } catch (Throwable e2) {
            throw new IOException("Invalid url: " + this.f5480b, e2);
        }
    }

    private <T> T m5937a(FbHttpRequest<T> fbHttpRequest) {
        try {
            this.f5487i.add(fbHttpRequest);
            T b = this.f5485g.b(fbHttpRequest);
            return b;
        } finally {
            this.f5487i.remove(fbHttpRequest);
        }
    }

    private FbHttpRequest<Long> m5936a(Range range, ResponseHandler responseHandler) {
        HttpUriRequest httpGet = new HttpGet(this.f5480b.toURI());
        httpGet.setHeader("Range", "bytes=" + range.a + "-" + (range.b - 1));
        m5938a(this, httpGet);
        HttpClientParams.setRedirecting(httpGet.getParams(), true);
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.b = httpGet;
        Builder builder = newBuilder;
        builder.d = this.f5484f;
        builder = builder;
        builder.c = "rangeRequestForVideo";
        builder = builder;
        builder.q = true;
        builder = builder;
        builder.k = RequestIdempotency.RETRY_SAFE;
        builder = builder;
        builder.l = this.f5483e;
        builder = builder;
        builder.g = responseHandler;
        return builder.a();
    }

    public final FileMetadata mo526a() {
        HeaderGetterRequest[] headerGetterRequestArr = this.f5479a;
        int length = headerGetterRequestArr.length;
        int i = 0;
        while (i < length) {
            try {
                HeaderMap headerMap = (HeaderMap) m5937a(headerGetterRequestArr[i].mo527a());
                if (headerMap != null) {
                    return headerMap.m5971a();
                }
                i++;
            } catch (Throwable e) {
                throw new IOException("Invalid url: " + this.f5480b, e);
            } catch (Throwable e2) {
                throw new NetworkAccessException("Error reading headers", e2);
            }
        }
        throw new NoResourceLength(new IllegalStateException("Resource length failed 3 times: " + this.f5480b));
    }

    public static void m5938a(NetworkRangeWriter networkRangeWriter, HttpUriRequest httpUriRequest) {
        if (FacebookUriUtil.c(Uri.parse(httpUriRequest.getURI().toString()))) {
            String str;
            ViewerContext a = networkRangeWriter.f5481c.a();
            if (a == null) {
                str = null;
            } else {
                str = SessionCookie.m12037b(networkRangeWriter.f5482d, a.mSessionCookiesString);
            }
            if (str != null) {
                httpUriRequest.addHeader("Cookie", str);
            }
        }
    }
}
