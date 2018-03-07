package com.facebook.feedback.reactions.api;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQL.FetchFeedbackReactionsVectorDataQueryString;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: gsm_lac */
public class FeedbackReactionsVectorAssetFetcher {
    public final GraphQLQueryExecutor f21467a;
    public final Executor f21468b;
    public ListenableFuture<ImmutableList<ReactionInfosModel>> f21469c;

    public static FeedbackReactionsVectorAssetFetcher m29183b(InjectorLike injectorLike) {
        return new FeedbackReactionsVectorAssetFetcher(GraphQLQueryExecutor.m10435a(injectorLike), C0055x2995691a.m1881a(injectorLike));
    }

    @Inject
    public FeedbackReactionsVectorAssetFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f21467a = graphQLQueryExecutor;
        this.f21468b = executorService;
    }

    public final ListenableFuture<AnimationModel> m29184a(int i) {
        if (this.f21469c == null) {
            this.f21469c = Futures.m2450a(this.f21467a.m10446a(GraphQLRequest.m11587a((TypedGraphQlQueryString) new FetchFeedbackReactionsVectorDataQueryString()).m11590a(86400).m11594a(GraphQLCachePolicy.f7109a)), new 2(this), this.f21468b);
        }
        return Futures.m2450a(this.f21469c, new 1(this, i), this.f21468b);
    }
}
