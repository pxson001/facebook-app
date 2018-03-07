package com.facebook.notifications.util;

import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQLModels.FetchFriendRequestJewelCountGraphQLModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: minutiae_object_picker_fetch_time_cached */
public class JewelCountHelper$2 implements FutureCallback<GraphQLResult<FetchFriendRequestJewelCountGraphQLModel>> {
    final /* synthetic */ JewelCountHelper f8868a;

    public JewelCountHelper$2(JewelCountHelper jewelCountHelper) {
        this.f8868a = jewelCountHelper;
    }

    public void onSuccess(@Nullable Object obj) {
        int i;
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((FetchFriendRequestJewelCountGraphQLModel) graphQLResult.e).a() == null) {
            i = 0;
        } else {
            i = ((FetchFriendRequestJewelCountGraphQLModel) graphQLResult.e).a().a();
        }
        JewelCountHelper.a(this.f8868a, Jewel.FRIEND_REQUESTS, i);
        this.f8868a.g.b(3473412, (short) 2);
    }

    public void onFailure(Throwable th) {
        this.f8868a.g.b(3473412, (short) 3);
    }
}
