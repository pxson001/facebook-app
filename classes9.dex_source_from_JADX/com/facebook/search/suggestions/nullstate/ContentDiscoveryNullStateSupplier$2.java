package com.facebook.search.suggestions.nullstate;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.search.model.nullstate.NullStateModuleData;
import java.util.Arrays;

/* compiled from: x-wap-profile */
class ContentDiscoveryNullStateSupplier$2 implements Runnable {
    final /* synthetic */ NullStateModuleData f176a;
    final /* synthetic */ CallerContext f177b;
    final /* synthetic */ ContentDiscoveryNullStateSupplier f178c;

    ContentDiscoveryNullStateSupplier$2(ContentDiscoveryNullStateSupplier contentDiscoveryNullStateSupplier, NullStateModuleData nullStateModuleData, CallerContext callerContext) {
        this.f178c = contentDiscoveryNullStateSupplier;
        this.f176a = nullStateModuleData;
        this.f177b = callerContext;
    }

    public void run() {
        ContentDiscoveryNullStateSupplier.a(this.f178c, Arrays.asList(new String[]{this.f176a.c()}), 0, this.f177b, GraphQLCachePolicy.c);
    }
}
