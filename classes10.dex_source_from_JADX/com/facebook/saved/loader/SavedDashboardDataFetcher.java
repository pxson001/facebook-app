package com.facebook.saved.loader;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.helper.SavedItemHelper;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQL.FetchSavedItemsGraphQLString;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.FetchSavedItemsGraphQLModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intent_result_num_recipients */
public class SavedDashboardDataFetcher {
    private final ListeningExecutorService f9210a;
    private final GraphQLQueryExecutor f9211b;
    public final SavedItemHelper f9212c;
    private final FetchVideoChannelParamBuilderUtil f9213d;
    private final int f9214e;

    /* compiled from: intent_result_num_recipients */
    class C13981 implements Function<GraphQLResult<FetchSavedItemsGraphQLModel>, SavedDashboardPaginatedSavedItems> {
        final /* synthetic */ SavedDashboardDataFetcher f9209a;

        C13981(SavedDashboardDataFetcher savedDashboardDataFetcher) {
            this.f9209a = savedDashboardDataFetcher;
        }

        public Object apply(@Nullable Object obj) {
            return this.f9209a.f9212c.m9175a((GraphQLResult) obj);
        }
    }

    public static SavedDashboardDataFetcher m9222b(InjectorLike injectorLike) {
        return new SavedDashboardDataFetcher(ResourcesMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), SavedItemHelper.m9171a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike));
    }

    @Inject
    public SavedDashboardDataFetcher(Resources resources, ListeningExecutorService listeningExecutorService, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, SavedItemHelper savedItemHelper, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil) {
        this.f9210a = listeningExecutorService;
        this.f9211b = graphQLQueryExecutor;
        this.f9212c = savedItemHelper;
        this.f9213d = fetchVideoChannelParamBuilderUtil;
        this.f9214e = GraphQLImageHelper.a(resources.getDimensionPixelSize(2131432254)).intValue();
    }

    public final ListenableFuture<SavedDashboardPaginatedSavedItems> m9223a(Optional<GraphQLSavedDashboardSectionType> optional, Optional<String> optional2) {
        return m9221a(optional, optional2, GraphQLCachePolicy.d);
    }

    private ListenableFuture<SavedDashboardPaginatedSavedItems> m9221a(Optional<GraphQLSavedDashboardSectionType> optional, Optional<String> optional2, GraphQLCachePolicy graphQLCachePolicy) {
        GraphQlQueryString fetchSavedItemsGraphQLString = new FetchSavedItemsGraphQLString();
        fetchSavedItemsGraphQLString.a("first_count", "10").a("saved_item_pic_width", String.valueOf(this.f9214e)).a("saved_item_pic_height", String.valueOf(this.f9214e)).a("section_type", ImmutableList.of(((GraphQLSavedDashboardSectionType) optional.or(GraphQLSavedDashboardSectionType.ALL)).toString())).a("after_cursor", (String) optional2.orNull());
        this.f9213d.a(fetchSavedItemsGraphQLString, EntryPointInputVideoChannelEntryPoint.SAVED_STORY);
        return Futures.a(this.f9211b.a(GraphQLRequest.a(fetchSavedItemsGraphQLString).a(graphQLCachePolicy).a(2592000)), new C13981(this), this.f9210a);
    }

    public final ListenableFuture<SavedDashboardPaginatedSavedItems> m9224b(Optional<GraphQLSavedDashboardSectionType> optional, Optional<String> optional2) {
        return m9221a(optional, optional2, GraphQLCachePolicy.b);
    }
}
