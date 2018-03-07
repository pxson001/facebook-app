package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.model.nullstate.NullStateModuleData;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: friend_ids */
class ContentDiscoveryNullStateSupplier$1 implements FutureCallback<NullStateModuleData> {
    final /* synthetic */ CallerContext f11409a;
    final /* synthetic */ ContentDiscoveryNullStateSupplier f11410b;

    ContentDiscoveryNullStateSupplier$1(ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, CallerContext callerContext) {
        this.f11410b = contentDiscoveryNullStateSupplier;
        this.f11409a = callerContext;
    }

    public void onSuccess(@Nullable Object obj) {
        NullStateModuleData nullStateModuleData = (NullStateModuleData) obj;
        synchronized (this) {
            long j;
            ContentDiscoveryNullStateSupplier.a(this.f11410b, this.f11410b.g.a());
            ContentDiscoveryNullStateSupplier.a(this.f11410b, nullStateModuleData);
            ContentDiscoveryNullStateSupplier.a(this.f11410b, null);
            if (this.f11409a != null) {
                j = this.f11410b.i;
            } else {
                j = this.f11410b.j;
            }
            if (this.f11410b.h - nullStateModuleData.m12369f() > j) {
                ContentDiscoveryNullStateSupplier.a(this.f11410b, this.f11410b.f, 10, this.f11409a, GraphQLCachePolicy.c);
            } else {
                ContentDiscoveryNullStateSupplier.a(this.f11410b, this.f11409a, nullStateModuleData);
            }
        }
    }

    public synchronized void onFailure(Throwable th) {
        this.f11410b.a.a(GraphSearchError.FETCH_NULL_STATE_MODULES_FAIL, th);
        ContentDiscoveryNullStateSupplier.a(this.f11410b, null);
    }
}
