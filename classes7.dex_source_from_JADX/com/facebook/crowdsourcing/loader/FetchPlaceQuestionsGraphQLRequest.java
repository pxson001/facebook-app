package com.facebook.crowdsourcing.loader;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueries.FBCrowdsourcingPlaceQuestionsQueryString;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesInterfaces.FBCrowdsourcingPlaceQuestionsQuery;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED */
public class FetchPlaceQuestionsGraphQLRequest {
    private final GraphQLQueryExecutor f17428a;
    private final ListeningExecutorService f17429b;

    /* compiled from: com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED */
    class C14341 implements Function<GraphQLResult<FBCrowdsourcingPlaceQuestionsQueryModel>, FBCrowdsourcingPlaceQuestionsQuery> {
        final /* synthetic */ FetchPlaceQuestionsGraphQLRequest f17427a;

        C14341(FetchPlaceQuestionsGraphQLRequest fetchPlaceQuestionsGraphQLRequest) {
            this.f17427a = fetchPlaceQuestionsGraphQLRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return graphQLResult == null ? null : (FBCrowdsourcingPlaceQuestionsQueryModel) graphQLResult.e;
        }
    }

    @Inject
    public FetchPlaceQuestionsGraphQLRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f17428a = graphQLQueryExecutor;
        this.f17429b = listeningExecutorService;
    }

    public final ListenableFuture<FBCrowdsourcingPlaceQuestionsQuery> m21332a(String str, long j, String str2, int i) {
        GraphQlQueryString fBCrowdsourcingPlaceQuestionsQueryString = new FBCrowdsourcingPlaceQuestionsQueryString();
        fBCrowdsourcingPlaceQuestionsQueryString.a("page_id", str).a("field_type", Long.valueOf(j)).a("question_context", str2).a("question_count", Integer.valueOf(i));
        return Futures.a(this.f17428a.a(GraphQLRequest.a(fBCrowdsourcingPlaceQuestionsQueryString)), new C14341(this), this.f17429b);
    }
}
