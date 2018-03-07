package com.facebook.controller.connectioncontroller;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: otherUserFbId */
class ConnectionControllerImpl$2 extends AbstractDisposableFutureCallback<GraphQLResult<TResponseModel>> {
    final /* synthetic */ ConnectionLocation f8542a;
    final /* synthetic */ ConnectionOrder f8543b;
    final /* synthetic */ ConnectionFetchOperation f8544c;
    final /* synthetic */ ConnectionControllerImpl f8545d;

    ConnectionControllerImpl$2(ConnectionControllerImpl connectionControllerImpl, ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, ConnectionFetchOperation connectionFetchOperation) {
        this.f8545d = connectionControllerImpl;
        this.f8542a = connectionLocation;
        this.f8543b = connectionOrder;
        this.f8544c = connectionFetchOperation;
    }

    protected final void m12346a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        long b = graphQLResult.b();
        try {
            this.f8545d.j.a(this.f8542a, this.f8543b, this.f8545d.h.a(graphQLResult), b, graphQLResult.a() == DataFreshnessResult.FROM_SERVER);
        } catch (Throwable th) {
            Throwable runtimeException = new RuntimeException("Error in extracting GraphQL result!", th);
            this.f8545d.g.b("ConnectionController", runtimeException);
            onFailure(runtimeException);
        }
    }

    protected final void m12347a(final Throwable th) {
        HandlerDetour.a(this.f8545d.c, new Runnable(this) {
            final /* synthetic */ ConnectionControllerImpl$2 f8541b;

            public void run() {
                this.f8541b.f8545d.i.a(this.f8541b.f8542a, this.f8541b.f8543b, th);
                this.f8541b.f8545d.a.remove(this.f8541b.f8544c);
            }
        }, 1136325197);
    }
}
