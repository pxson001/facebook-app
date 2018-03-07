package com.facebook.feedplugins.articlechaining.protocol;

import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutation.ArticleHideSuggestionMutationString;
import com.facebook.graphql.calls.ArticleHideSuggestionInputData;
import com.facebook.graphql.calls.ArticleHideSuggestionInputData.Reason;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest.Builder;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: network_info_req_bw_egress_std_dev */
public class ArticleHideSuggestionMutator {
    GraphQLQueryExecutor f12518a;

    public static ArticleHideSuggestionMutator m18604a(InjectorLike injectorLike) {
        return new ArticleHideSuggestionMutator(GraphQLQueryExecutor.m10435a(injectorLike));
    }

    @Inject
    public ArticleHideSuggestionMutator(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f12518a = graphQLQueryExecutor;
    }

    public final void m18606a(String str) {
        m18605a(str, Reason.NUMBER_6);
    }

    public final void m18607b(String str) {
        m18605a(str, Reason.NUMBER_7);
    }

    private void m18605a(String str, Reason reason) {
        ArticleHideSuggestionInputData articleHideSuggestionInputData = new ArticleHideSuggestionInputData();
        articleHideSuggestionInputData.m11397a("article_id", str);
        GraphQlCallInput graphQlCallInput = articleHideSuggestionInputData;
        graphQlCallInput.m11395a("reason", (Enum) reason);
        MutationRequest a = GraphQLRequest.m11588a((ArticleHideSuggestionMutationString) new ArticleHideSuggestionMutationString().m11310a("input", graphQlCallInput));
        GraphQLQueryExecutor graphQLQueryExecutor = this.f12518a;
        Builder a2 = new Builder().a(a);
        a2.d = TimeUnit.DAYS.toMillis(1);
        PendingRequest.Builder builder = a2;
        builder.f = 100;
        graphQLQueryExecutor.m10450a((PendingGraphQlMutationRequest) builder.a(), OfflineQueryBehavior.b);
    }
}
