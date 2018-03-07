package com.facebook.crudolib.netengine.fbhttp;

import com.facebook.crudolib.netengine.HttpEngineRequest$Builder;
import com.facebook.crudolib.netengine.HttpEngineRequestBody;
import com.facebook.crudolib.netengine.HttpHeaders;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.infer.annotation.Assertions;
import java.net.URI;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;

/* compiled from: TincanDeleteThread */
public class FbHttpEngineRequest extends FbHttpHeaders implements HttpHeaders {
    public final HttpUriRequest f24061a;
    public final HttpEngineRequestBody f24062b;
    private final FbHttpRequestCancelTrigger f24063c = new FbHttpRequestCancelTrigger();
    public final FbHttpEngineResponseHandler f24064d = new FbHttpEngineResponseHandler();
    public final FbHttpRequest<Void> f24065e;

    /* compiled from: TincanDeleteThread */
    public class Builder implements HttpEngineRequest$Builder {
        public String f24054a;
        public final HeaderGroup f24055b = new HeaderGroup();
        public String f24056c;
        public HttpEngineRequestBody f24057d;
        public String f24058e;

        public final HttpEngineRequest$Builder mo1109a(String str) {
            this.f24054a = str;
            return this;
        }

        public final HttpEngineRequest$Builder mo1111a(String str, String str2) {
            this.f24055b.addHeader(new BasicHeader(str, str2));
            return this;
        }

        public final HttpEngineRequest$Builder mo1114b(String str, String str2) {
            this.f24055b.updateHeader(new BasicHeader(str, str2));
            return this;
        }

        public final HttpEngineRequest$Builder mo1110a(String str, @Nullable HttpEngineRequestBody httpEngineRequestBody) {
            this.f24056c = str;
            this.f24057d = httpEngineRequestBody;
            return this;
        }

        public final HttpEngineRequest$Builder mo1113b(String str) {
            this.f24058e = str;
            return this;
        }

        public final FbHttpEngineRequest mo1112a() {
            return new FbHttpEngineRequest(this);
        }
    }

    public FbHttpEngineRequest(Builder builder) {
        Header[] allHeaders = builder.f24055b.getAllHeaders();
        HttpMessage a = m26008a(builder);
        a.setURI(URI.create(builder.f24058e));
        a.setHeaders(allHeaders);
        m26005a(a);
        this.f24061a = a;
        this.f24062b = builder.f24057d;
        com.facebook.http.common.FbHttpRequest.Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.c = builder.f24054a;
        newBuilder = newBuilder;
        newBuilder.b = this.f24061a;
        newBuilder = newBuilder;
        newBuilder.i = this.f24063c;
        newBuilder = newBuilder;
        newBuilder.g = this.f24064d;
        this.f24065e = newBuilder.a();
    }

    private static HttpRequestBase m26008a(Builder builder) {
        if (builder.f24056c.equalsIgnoreCase("GET")) {
            Assertions.a(builder.f24057d == null);
            return new HttpGet();
        } else if (builder.f24056c.equalsIgnoreCase("POST")) {
            Assertions.b(builder.f24057d);
            HttpRequestBase httpPost = new HttpPost();
            httpPost.setEntity(new CrudoNetEntityAdapter(builder.f24057d, builder.f24055b.getFirstHeader("Content-Encoding")));
            return httpPost;
        } else {
            throw new UnsupportedOperationException("method=" + builder.f24056c);
        }
    }
}
