package com.facebook.crudolib.netfb;

import com.facebook.crudolib.net.CompositeResponseInterceptor;
import com.facebook.crudolib.net.CrudoNet;
import com.facebook.crudolib.net.RequestBuilder;
import com.facebook.crudolib.net.RequestFactory;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngine;
import com.facebook.crudolib.netmodule.CrudoNetModule.C29132;
import com.facebook.crudolib.netmodule.RequestMapperHack;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

/* compiled from: TimelineDBEvictionLogout */
public class FbRequestFactory {
    public final RequestFactory f24109a;
    public final ParamsCollectionPool f24110b;
    public final EndpointSelector f24111c;
    public final RequestMapperHack f24112d;
    public final boolean f24113e;

    /* compiled from: TimelineDBEvictionLogout */
    public class Builder {
        final com.facebook.crudolib.net.RequestFactory.Builder f24104a;
        @Nullable
        public C29132 f24105b;
        @Nullable
        public EndpointSelector f24106c;
        @Nullable
        public RequestMapperHack f24107d;
        boolean f24108e;

        public Builder(RequestFactory requestFactory) {
            this.f24104a = new com.facebook.crudolib.net.RequestFactory.Builder(requestFactory);
        }
    }

    public FbRequestFactory(Builder builder) {
        com.facebook.crudolib.net.RequestFactory.Builder builder2 = builder.f24104a;
        if (builder.f24105b != null) {
            builder2.f24038b.m25965a(new OAuthRequestMutator(builder.f24105b));
        }
        this.f24111c = m26048a(builder.f24106c);
        this.f24112d = (RequestMapperHack) Assertions.b(builder.f24107d);
        builder2.f24040d = CompositeResponseInterceptor.m25967a(new FbApiErrorInterceptor(), builder2.f24040d);
        this.f24109a = builder.f24104a.m25973b();
        this.f24110b = ParamsCollectionPool.a();
        this.f24113e = builder.f24108e;
    }

    private static EndpointSelector m26048a(@Nullable EndpointSelector endpointSelector) {
        return endpointSelector != null ? endpointSelector : new DefaultEndpointSelector();
    }

    public final FbGraphQLRequestBuilder m26049a(int i) {
        String str = "get";
        String b = this.f24112d.m26078b(i);
        ParamsCollectionPool paramsCollectionPool = this.f24110b;
        RequestFactory requestFactory = this.f24109a;
        FbHttpEngine fbHttpEngine = requestFactory.f24042a.f24029a;
        com.facebook.crudolib.netengine.fbhttp.FbHttpEngineRequest.Builder builder = new com.facebook.crudolib.netengine.fbhttp.FbHttpEngineRequest.Builder();
        builder.mo1109a(b);
        CrudoNet crudoNet = requestFactory.f24042a;
        com.facebook.crudolib.net.AppRequest.Builder builder2 = new com.facebook.crudolib.net.AppRequest.Builder(builder);
        builder2.f24008b = b;
        com.facebook.crudolib.net.AppRequest.Builder builder3 = builder2;
        builder3.f24009c = requestFactory.f24046e;
        builder3 = builder3;
        builder3.f24010d = requestFactory.f24044c;
        FbBaseRequestBuilder fbBaseRequestBuilder = new FbBaseRequestBuilder(paramsCollectionPool, new RequestBuilder(crudoNet, requestFactory, builder3), this.f24111c);
        if (this.f24113e) {
            fbBaseRequestBuilder.f24099h = true;
        }
        FbBaseRequestBuilder fbBaseRequestBuilder2 = fbBaseRequestBuilder;
        String a = this.f24112d.m26077a(i);
        fbBaseRequestBuilder2.f24095d = str;
        return new FbGraphQLRequestBuilder(this.f24110b, i, a, fbBaseRequestBuilder2);
    }
}
