package com.facebook.places.suggestions;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.places.future.SimpleExecutor;
import javax.inject.Inject;

/* compiled from: section_name_server */
public class FetchPlaceDetailsRunner {
    public final SimpleExecutor f3622a;
    public final GraphQLQueryExecutor f3623b;

    @Inject
    public FetchPlaceDetailsRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f3622a = simpleExecutor;
        this.f3623b = graphQLQueryExecutor;
    }
}
