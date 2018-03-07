package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQL;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLModels.FetchTaggableActivitiesQueryModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher.VerbResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timeline_fetch_info_review */
public class FetchMinutiaeVerbsUnrankedGraphQLRequest {
    private final GraphQLQueryExecutor f1652a;
    public final MinutiaeGraphQLVerificationHelper f1653b;

    /* compiled from: timeline_fetch_info_review */
    class C01561 implements Function<GraphQLResult<FetchTaggableActivitiesQueryModel>, VerbResult> {
        final /* synthetic */ FetchMinutiaeVerbsUnrankedGraphQLRequest f1650a;

        C01561(FetchMinutiaeVerbsUnrankedGraphQLRequest fetchMinutiaeVerbsUnrankedGraphQLRequest) {
            this.f1650a = fetchMinutiaeVerbsUnrankedGraphQLRequest;
        }

        public Object apply(@Nullable Object obj) {
            VerbResult verbResult;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FetchMinutiaeVerbsUnrankedGraphQLRequest fetchMinutiaeVerbsUnrankedGraphQLRequest = this.f1650a;
            if (graphQLResult == null) {
                verbResult = null;
            } else {
                Builder builder = new Builder();
                for (MinutiaeTaggableActivity minutiaeVerbModelEdge : Iterables.c(((FetchTaggableActivitiesQueryModel) graphQLResult.e).a(), new C01572(fetchMinutiaeVerbsUnrankedGraphQLRequest))) {
                    builder.c(new MinutiaeVerbModelEdge(minutiaeVerbModelEdge));
                }
                verbResult = new VerbResult(builder.b(), graphQLResult.freshness);
            }
            return verbResult;
        }
    }

    /* compiled from: timeline_fetch_info_review */
    public class C01572 implements Predicate<MinutiaeTaggableActivityModel> {
        final /* synthetic */ FetchMinutiaeVerbsUnrankedGraphQLRequest f1651a;

        public C01572(FetchMinutiaeVerbsUnrankedGraphQLRequest fetchMinutiaeVerbsUnrankedGraphQLRequest) {
            this.f1651a = fetchMinutiaeVerbsUnrankedGraphQLRequest;
        }

        public boolean apply(@Nullable Object obj) {
            return this.f1651a.f1653b.m1681a((MinutiaeTaggableActivityModel) obj);
        }
    }

    public static FetchMinutiaeVerbsUnrankedGraphQLRequest m1670b(InjectorLike injectorLike) {
        return new FetchMinutiaeVerbsUnrankedGraphQLRequest(GraphQLQueryExecutor.a(injectorLike), MinutiaeGraphQLVerificationHelper.m1679b(injectorLike));
    }

    @Inject
    public FetchMinutiaeVerbsUnrankedGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, MinutiaeGraphQLVerificationHelper minutiaeGraphQLVerificationHelper) {
        this.f1652a = graphQLQueryExecutor;
        this.f1653b = minutiaeGraphQLVerificationHelper;
    }

    public final ListenableFuture<VerbResult> m1671a(GraphQlQueryParamSet graphQlQueryParamSet) {
        return Futures.a(this.f1652a.a(GraphQLRequest.a(FetchTaggableActivitiesGraphQL.a()).a(graphQlQueryParamSet).a(GraphQLCachePolicy.c)), new C01561(this), MoreExecutors.a());
    }
}
