package com.facebook.photos.mediafetcher;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediafetcher.query.PaginatedMediaQuery;

/* compiled from: groups_landing_updates */
public class PaginatedGraphQLFetcherProvider extends AbstractAssistedProvider<PaginatedGraphQLFetcher> {
    public final <GRAPHQL_RESULT_TYPE, PAGE_RESULT_TYPE> PaginatedGraphQLFetcher<GRAPHQL_RESULT_TYPE, PAGE_RESULT_TYPE> m29269a(PaginatedMediaQuery paginatedMediaQuery) {
        return new PaginatedGraphQLFetcher(paginatedMediaQuery, DefaultAndroidThreadUtil.m1646b((InjectorLike) this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(this), GraphQLSubscriptionHolder.m14626b((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this));
    }
}
