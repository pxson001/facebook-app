package com.facebook.saved.common.data;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLModels.FetchRecentSaveInfoGraphQLModel;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQLModels.FetchRecentSaveInfoGraphQLModel.SaverInfoModel.RecentSaveInfoModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: fetch_end */
class RecentSaveInfo$1 implements FutureCallback<GraphQLResult<FetchRecentSaveInfoGraphQLModel>> {
    final /* synthetic */ RecentSaveInfo f14405a;

    RecentSaveInfo$1(RecentSaveInfo recentSaveInfo) {
        this.f14405a = recentSaveInfo;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult != null && graphQLResult.e != null && ((FetchRecentSaveInfoGraphQLModel) graphQLResult.e).m18309a() != null) {
            RecentSaveInfoModel a = ((FetchRecentSaveInfoGraphQLModel) graphQLResult.e).m18309a().m18305a();
            if (a != null) {
                RecentSaveInfo.a(this.f14405a, a.m18301j(), RecentSaveTimeframe.convertString(a.m18298a().name()));
            }
        }
    }

    public void onFailure(Throwable th) {
    }
}
