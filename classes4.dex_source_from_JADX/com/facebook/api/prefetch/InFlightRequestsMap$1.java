package com.facebook.api.prefetch;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: sdk */
class InFlightRequestsMap$1 implements FutureCallback {
    final /* synthetic */ GraphQLPrefetchPolicy f2953a;
    final /* synthetic */ InFlightRequestsMap$RequestEntry f2954b;
    final /* synthetic */ InFlightRequestsMap f2955c;

    InFlightRequestsMap$1(InFlightRequestsMap inFlightRequestsMap, GraphQLPrefetchPolicy graphQLPrefetchPolicy, InFlightRequestsMap$RequestEntry inFlightRequestsMap$RequestEntry) {
        this.f2955c = inFlightRequestsMap;
        this.f2953a = graphQLPrefetchPolicy;
        this.f2954b = inFlightRequestsMap$RequestEntry;
    }

    public void onSuccess(Object obj) {
        InFlightRequestsMap.a(this.f2955c, this.f2953a, this.f2954b);
    }

    public void onFailure(Throwable th) {
        InFlightRequestsMap.a(this.f2955c, this.f2953a, this.f2954b);
    }
}
