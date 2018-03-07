package com.facebook.location.foreground;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.location.write.graphql.LocationMutationsModels.LocationUpdateMutationModel;

/* compiled from: Unknown drawerPosition  */
public class ForegroundLocationFrameworkResultWriter$1 extends AbstractDisposableFutureCallback<GraphQLResult<LocationUpdateMutationModel>> {
    final /* synthetic */ ForegroundLocationFrameworkResultWriter f10435a;

    public ForegroundLocationFrameworkResultWriter$1(ForegroundLocationFrameworkResultWriter foregroundLocationFrameworkResultWriter) {
        this.f10435a = foregroundLocationFrameworkResultWriter;
    }

    protected final void m10837a(Object obj) {
        this.f10435a.d.e();
        this.f10435a.g = null;
    }

    protected final void m10838a(Throwable th) {
        this.f10435a.d.a(th);
        this.f10435a.g = null;
    }
}
