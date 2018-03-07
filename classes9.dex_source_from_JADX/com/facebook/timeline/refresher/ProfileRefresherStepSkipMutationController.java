package com.facebook.timeline.refresher;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: unpublished_fbid */
public class ProfileRefresherStepSkipMutationController {
    public GraphQLQueryExecutor f1035a;

    public static ProfileRefresherStepSkipMutationController m1050b(InjectorLike injectorLike) {
        return new ProfileRefresherStepSkipMutationController(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public ProfileRefresherStepSkipMutationController(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1035a = graphQLQueryExecutor;
    }
}
