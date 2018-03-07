package com.facebook.dialtone.services;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: [] */
public class DialtonePhotoCapReminder$1 extends AbstractDisposableFutureCallback<GraphQLResult<FetchDialtonePhotoQuotaModel>> {
    final /* synthetic */ DialtonePhotoCapReminder f11881a;

    public DialtonePhotoCapReminder$1(DialtonePhotoCapReminder dialtonePhotoCapReminder) {
        this.f11881a = dialtonePhotoCapReminder;
    }

    protected final void m19935a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((FetchDialtonePhotoQuotaModel) graphQLResult.e).m19921a() == null) {
            ((AbstractFbErrorReporter) this.f11881a.g.get()).a("dialtone", "photo cap result is null");
        } else {
            DialtonePhotoCapReminder.a(this.f11881a, ((FetchDialtonePhotoQuotaModel) graphQLResult.e).m19921a());
        }
    }

    protected final void m19936a(Throwable th) {
        ((AbstractFbErrorReporter) this.f11881a.g.get()).a("dialtone", "photo cap result fetch failed", th);
    }
}
