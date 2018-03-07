package com.facebook.places.create.home;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.places.future.SimpleExecutor;
import javax.inject.Inject;

/* compiled from: card_form_submitted */
public class HomeFetchRunner {
    public SimpleExecutor f18344a;
    public GraphQLQueryExecutor f18345b;

    @Inject
    public HomeFetchRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18344a = simpleExecutor;
        this.f18345b = graphQLQueryExecutor;
    }
}
