package com.facebook.api.prefetch;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: postSurveyAnswersParams */
public class GraphQLPrefetcher {
    public final GraphQLPrefetchController f9408a;
    public final GraphQLPrefetchPolicy f9409b;

    @Inject
    public GraphQLPrefetcher(GraphQLPrefetchController graphQLPrefetchController, @Assisted GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        this.f9408a = graphQLPrefetchController;
        this.f9409b = graphQLPrefetchPolicy;
    }

    public final void m14382a(GraphQLPrefetchPriority graphQLPrefetchPriority, String str) {
        this.f9408a.m14406a(this.f9409b, graphQLPrefetchPriority, str);
    }

    public final void m14383a(GraphQLFeedback graphQLFeedback) {
        this.f9408a.m14407a(this.f9409b, graphQLFeedback);
    }

    public final void m14384b(GraphQLFeedback graphQLFeedback) {
        this.f9408a.m14411b(this.f9409b, graphQLFeedback);
    }
}
