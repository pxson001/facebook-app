package com.facebook.tigon.httpclientadapter;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.proxygen.LigerSamplePolicy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tigon.iface.TigonLigerRequestInfoImpl;
import com.facebook.tigon.iface.TigonPriorityData;
import com.facebook.tigon.iface.TigonPriorityQueueRequestTypeInfoImpl;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonRequestBuilder;
import com.facebook.tigon.iface.TigonRequestLayers;
import com.facebook.tigon.iface.TigonRequestLayers.LayerInfo;
import com.facebook.tigon.iface.TigonSamplingConfigInfoImpl;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: notification_connection_controller_scroll_perf */
public class TigonFbRequestBuilder {
    static final Class<TigonFbRequestBuilder> f4928a = TigonFbRequestBuilder.class;
    private final String f4929b;
    private final Executor f4930c;
    private final QeAccessor f4931d;

    @Inject
    public TigonFbRequestBuilder(String str, Executor executor, QeAccessor qeAccessor) {
        this.f4929b = str;
        this.f4930c = executor;
        this.f4931d = qeAccessor;
    }

    private static void m6227a(int i, TigonRequestBuilder tigonRequestBuilder, Header header) {
        tigonRequestBuilder.a(header.getName(), header.getValue());
    }

    final TigonHttpEntityBodyProvider m6230a(HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity.getContentLength() >= ((long) this.f4931d.a(ExperimentsForTigonHttpClientAdapterIfaceModule.c, Integer.MAX_VALUE))) {
                return new TigonHttpEntityBodyProvider(entity, this.f4930c);
            }
        }
        return null;
    }

    static DirectByteBufferOutputStream m6229b(HttpRequest httpRequest) {
        if (!(httpRequest instanceof HttpEntityEnclosingRequest)) {
            return null;
        }
        HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
        long contentLength = entity.getContentLength();
        Preconditions.checkArgument(contentLength <= 2147483647L, "Unexpected request length while extracting body: %d", new Object[]{Long.valueOf(contentLength)});
        if (contentLength == 0) {
            return null;
        }
        DirectByteBufferOutputStream directByteBufferOutputStream = contentLength < 0 ? new DirectByteBufferOutputStream() : new DirectByteBufferOutputStream((int) contentLength);
        entity.writeTo(directByteBufferOutputStream);
        return directByteBufferOutputStream;
    }

    final TigonRequest m6231a(int i, HttpUriRequest httpUriRequest, String str, CallerContext callerContext, RequestPriority requestPriority, boolean z, RequestIdempotency requestIdempotency) {
        int i2;
        boolean z2 = true;
        TigonHttpClientAdapterImpl.m6237a(i, "request", httpUriRequest.getRequestLine());
        TigonRequestBuilder tigonRequestBuilder = new TigonRequestBuilder();
        tigonRequestBuilder.a = httpUriRequest.getMethod();
        TigonRequestBuilder tigonRequestBuilder2 = tigonRequestBuilder;
        tigonRequestBuilder2.b = httpUriRequest.getURI().toASCIIString();
        tigonRequestBuilder2.d = new TigonPriorityData(requestPriority.getNumericValue(), 0);
        for (Header a : httpUriRequest.getAllHeaders()) {
            m6227a(i, tigonRequestBuilder, a);
        }
        if (httpUriRequest.getFirstHeader("Host") == null) {
            tigonRequestBuilder.a("Host", httpUriRequest.getURI().getHost());
        }
        if (httpUriRequest.getFirstHeader("User-Agent") == null) {
            tigonRequestBuilder.a("User-Agent", this.f4929b);
        }
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            if (entity.isChunked() || entity.getContentLength() < 0) {
                tigonRequestBuilder.a("Transfer-Encoding", "chunked");
            } else {
                tigonRequestBuilder.a("Content-Length", String.valueOf(entity.getContentLength()));
            }
            if (entity.getContentEncoding() != null) {
                m6227a(i, tigonRequestBuilder, entity.getContentEncoding());
            }
            if (entity.getContentType() != null) {
                m6227a(i, tigonRequestBuilder, entity.getContentType());
            }
        }
        m6228a(tigonRequestBuilder, z, str);
        tigonRequestBuilder.a(TigonRequestLayers.c, new FacebookLoggingInfoWithCallerContext(str, callerContext));
        if (new LigerSamplePolicy(this.f4931d.a(ExperimentsForHttpQeModule.aC, 10000), false).isFlowTimeSampled()) {
            i2 = 3;
        } else {
            i2 = 1;
        }
        tigonRequestBuilder.a(TigonRequestLayers.i, new TigonSamplingConfigInfoImpl(i2));
        LayerInfo layerInfo = TigonRequestLayers.e;
        if (requestIdempotency != RequestIdempotency.RETRY_SAFE) {
            z2 = false;
        }
        tigonRequestBuilder.a(layerInfo, new TigonLigerRequestInfoImpl(z2));
        return tigonRequestBuilder.a();
    }

    private static void m6228a(TigonRequestBuilder tigonRequestBuilder, boolean z, String str) {
        if (str != null) {
            int i = 0;
            if (z) {
                i = 1;
            }
            if ("image".equals(str)) {
                i = 3;
            } else if ("rangeRequestForVideo".equals(str) || "getVideo-1RT".equals(str)) {
                i = 5;
            }
            if (i != 0) {
                tigonRequestBuilder.a(TigonRequestLayers.f, new TigonPriorityQueueRequestTypeInfoImpl(i));
            }
        }
    }
}
