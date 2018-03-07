package com.facebook.checkin.socialsearch.map;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;

/* compiled from: delivery_receipt_rendered */
public class PlaceListFetcher {
    public final GraphQLQueryExecutor f15108a;
    private final GraphQLStoryHelper f15109b;
    public final GraphQLImageHelper f15110c;

    @Inject
    public PlaceListFetcher(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper) {
        this.f15108a = graphQLQueryExecutor;
        this.f15109b = graphQLStoryHelper;
        this.f15110c = graphQLImageHelper;
    }
}
