package com.facebook.notifications.util;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.protocol.FetchMessengerJewelCountsGraphQLModels.FetchMessengerJewelCountsModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: minutiae_object_picker_fetch_time_cached */
public class JewelCountHelper$3 implements FutureCallback<GraphQLResult<FetchMessengerJewelCountsModel>> {
    final /* synthetic */ JewelCountHelper f8869a;

    public JewelCountHelper$3(JewelCountHelper jewelCountHelper) {
        this.f8869a = jewelCountHelper;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        int a = (graphQLResult == null || graphQLResult.e == null || ((FetchMessengerJewelCountsModel) graphQLResult.e).m10027a() == null) ? 0 : this.f8869a.h.a() ? ((FetchMessengerJewelCountsModel) graphQLResult.e).m10027a().m10019a() : ((FetchMessengerJewelCountsModel) graphQLResult.e).m10027a().m10023j();
        JewelCountHelper.a(this.f8869a, Jewel.INBOX, a);
    }

    public void onFailure(Throwable th) {
    }
}
