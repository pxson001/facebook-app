package com.facebook.search.suggestions.nullstate;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.search.model.nullstate.NullStateModuleData;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: friend_list_privacy_options */
class SearchNullStateModuleLoader$1 implements Function<GraphQLResult<NullStateModuleQueryModel>, NullStateModuleData> {
    final /* synthetic */ SearchNullStateModuleLoader f11408a;

    SearchNullStateModuleLoader$1(SearchNullStateModuleLoader searchNullStateModuleLoader) {
        this.f11408a = searchNullStateModuleLoader;
    }

    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        NullStateModuleData a = this.f11408a.a.a(((NullStateModuleQueryModel) graphQLResult.e).m11808a());
        a.f11781b = graphQLResult.clientTimeMs;
        return a;
    }
}
