package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: VIDEO_ADS_FOR_COMMERCIAL_BREAK */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder extends Builder {
    public ImmutableList<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> f12951d;
    @Nullable
    public GraphQLPageInfo f12952e;

    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder);
    }

    public static GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder m21511a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder graphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder = new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder();
        graphQLSaleGroupsNearYouFeedUnitGroupsConnection.h();
        graphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder.f12951d = graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a();
        graphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder.f12952e = graphQLSaleGroupsNearYouFeedUnitGroupsConnection.j();
        Builder.a(graphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder, graphQLSaleGroupsNearYouFeedUnitGroupsConnection);
        return graphQLSaleGroupsNearYouFeedUnitGroupsConnection$Builder;
    }

    public final GraphQLSaleGroupsNearYouFeedUnitGroupsConnection m21512a() {
        return new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection(this);
    }
}
