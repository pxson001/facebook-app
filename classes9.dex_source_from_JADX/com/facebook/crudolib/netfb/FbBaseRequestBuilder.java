package com.facebook.crudolib.netfb;

import android.net.Uri.Builder;
import com.facebook.crudolib.net.AppRequest;
import com.facebook.crudolib.net.CancelTrigger;
import com.facebook.crudolib.net.RequestBuilder;
import com.facebook.crudolib.netengine.HttpEngineRequestBody;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.annotation.Nullable;

/* compiled from: TimelineInfoReviewAdapter.no_valid_data */
public class FbBaseRequestBuilder {
    public final RequestBuilder f24092a;
    private final EndpointSelector f24093b;
    private final ParamsCollectionMap f24094c;
    @Nullable
    public String f24095d;
    @Nullable
    public String f24096e;
    @Nullable
    public String f24097f;
    @Nullable
    private String f24098g;
    public boolean f24099h;

    /* compiled from: TimelineInfoReviewAdapter.no_valid_data */
    class CompressingRequestBodyWrapper extends RequestBodyWrapper {
        public CompressingRequestBodyWrapper(HttpEngineRequestBody httpEngineRequestBody) {
            super(httpEngineRequestBody);
        }

        public final long mo1123a() {
            return -1;
        }

        public final void mo1126a(OutputStream outputStream) {
            OutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                m26039d().mo1126a(gZIPOutputStream);
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    public FbBaseRequestBuilder(ParamsCollectionPool paramsCollectionPool, RequestBuilder requestBuilder, EndpointSelector endpointSelector) {
        this.f24092a = requestBuilder;
        this.f24093b = endpointSelector;
        this.f24094c = paramsCollectionPool.b();
    }

    public final FbBaseRequestBuilder m26044a(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        this.f24094c.a(str, str2);
        return this;
    }

    public final FbBaseRequestBuilder m26043a(String str, ParamsCollection paramsCollection) {
        if (paramsCollection == null) {
            throw new IllegalArgumentException("valueSubBody cannot be null");
        }
        this.f24094c.a(str, paramsCollection);
        return this;
    }

    public final CancelTrigger m26042a() {
        if (this.f24095d == null) {
            throw new IllegalArgumentException("Must set method");
        } else if (this.f24096e == null || this.f24097f == null) {
            throw new IllegalArgumentException("Must set tier and uriPath (maybe you should be using a helper like FbGraphQLRequestBuilder?)");
        } else {
            HttpEngineRequestBody httpEngineRequestBody;
            if (this.f24097f.startsWith("method/")) {
                m26044a("method", this.f24097f.substring(7));
            } else {
                m26044a("method", this.f24095d);
            }
            RequestBuilder requestBuilder = this.f24092a;
            requestBuilder.f24036d.mo1113b(new Builder().scheme(this.f24093b.mo1121a()).authority(this.f24093b.mo1122a(this.f24096e)).path(this.f24097f).build().toString());
            if (this.f24098g != null) {
                this.f24092a.m25972a("If-None-Match", this.f24098g);
            }
            this.f24094c.f();
            HttpEngineRequestBody paramsFormEncodedBody = new ParamsFormEncodedBody(this.f24094c);
            if (this.f24099h) {
                httpEngineRequestBody = paramsFormEncodedBody;
            } else {
                this.f24092a.m25972a("Content-Encoding", "gzip");
                httpEngineRequestBody = new CompressingRequestBodyWrapper(paramsFormEncodedBody);
            }
            this.f24092a.f24036d.mo1110a("POST", httpEngineRequestBody);
            requestBuilder = this.f24092a;
            return requestBuilder.f24033a.m25969a(new AppRequest(requestBuilder.f24035c));
        }
    }
}
