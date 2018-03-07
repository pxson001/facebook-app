package com.facebook.feed.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryCacheAdapter.17;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLModels.AggregatedStorySubstoryQueryModel.AllSubstoriesModel;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLPageInfo.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: application/x-quicktime-tx3g */
public class AggregatedSubstoriesFetcher$2 extends AbstractDisposableFutureCallback<AllSubstoriesModel> {
    final /* synthetic */ GraphQLStory f19153a;
    final /* synthetic */ FutureCallback f19154b;
    final /* synthetic */ AggregatedSubstoriesFetcher f19155c;

    public AggregatedSubstoriesFetcher$2(AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher, GraphQLStory graphQLStory, FutureCallback futureCallback) {
        this.f19155c = aggregatedSubstoriesFetcher;
        this.f19153a = graphQLStory;
        this.f19154b = futureCallback;
    }

    protected final void m22684a(Object obj) {
        AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) obj;
        if (allSubstoriesModel != null) {
            GraphQLPageInfo k = StoryHierarchyHelper.a(this.f19153a).k();
            if (k != null) {
                boolean j;
                String a;
                ImmutableList a2 = allSubstoriesModel.a();
                Builder a3 = Builder.a(k);
                if (allSubstoriesModel.j() != null) {
                    j = allSubstoriesModel.j().j();
                } else {
                    j = false;
                }
                a3.f = j;
                a3 = a3;
                if (allSubstoriesModel.j() != null) {
                    a = allSubstoriesModel.j().a();
                } else {
                    a = null;
                }
                a3.e = a;
                k = a3.a();
                int k2 = allSubstoriesModel.k();
                FeedStoryMutator feedStoryMutator = this.f19155c.c;
                GraphQLStory graphQLStory = this.f19153a;
                GraphQLSubstoriesConnection a4 = StoryHierarchyHelper.a(graphQLStory);
                GraphQLStory.Builder a5 = GraphQLStory.Builder.a(graphQLStory);
                GraphQLSubstoriesConnection.Builder a6 = GraphQLSubstoriesConnection.Builder.a(a4);
                a6.e = ImmutableList.builder().b(a4.j()).b(a2).b();
                GraphQLSubstoriesConnection.Builder builder = a6;
                builder.f = k;
                builder = builder;
                builder.g = k2;
                a5.g = builder.a();
                GraphQLStory.Builder builder2 = a5;
                builder2.F = feedStoryMutator.i.a();
                GraphQLStory a7 = builder2.a();
                AggregatedSubstoriesFetcher.a(this.f19155c, new 17(this.f19155c.b, this.f19153a.c(), a7));
                this.f19154b.onSuccess(a7);
            }
        }
    }

    protected final void m22685a(Throwable th) {
        this.f19154b.onFailure(th);
    }
}
