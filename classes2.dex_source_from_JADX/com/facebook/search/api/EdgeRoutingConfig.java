package com.facebook.search.api;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import org.apache.http.message.BasicHeader;

/* compiled from: interstitial_invalidated_by_min_delay_time */
public class EdgeRoutingConfig {
    @Inject
    public QeAccessor f19652a;

    public static EdgeRoutingConfig m27381b(InjectorLike injectorLike) {
        EdgeRoutingConfig edgeRoutingConfig = new EdgeRoutingConfig();
        edgeRoutingConfig.f19652a = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        return edgeRoutingConfig;
    }

    public final <T> void m27382a(Caller caller, GraphQLRequest<T> graphQLRequest) {
        if (m27380a(caller)) {
            graphQLRequest.f7089g = ImmutableList.of(new BasicHeader("X-FB-Search-Edge-Routing", "LATENCY"));
        }
    }

    public static EdgeRoutingConfig m27379a(InjectorLike injectorLike) {
        return m27381b(injectorLike);
    }

    public final void m27383a(Caller caller, ApiRequestBuilder apiRequestBuilder) {
        if (m27380a(caller)) {
            apiRequestBuilder.m12130a(ImmutableList.of(new BasicHeader("X-FB-Search-Edge-Routing", "LATENCY")));
        }
    }

    private boolean m27380a(Caller caller) {
        switch (1.a[caller.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f19652a.mo596a(ExperimentsForSearchAbTestModule.aI, false);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f19652a.mo596a(ExperimentsForSearchAbTestModule.aH, false);
            case 3:
                return this.f19652a.mo596a(ExperimentsForSearchAbTestModule.aG, false);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f19652a.mo596a(ExperimentsForSearchAbTestModule.aE, false);
            case 5:
                return this.f19652a.mo596a(ExperimentsForSearchAbTestModule.aF, false);
            default:
                return false;
        }
    }
}
