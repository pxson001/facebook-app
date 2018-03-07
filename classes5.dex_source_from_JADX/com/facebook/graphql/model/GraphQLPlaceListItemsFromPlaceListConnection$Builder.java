package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: WEATHER_FORECAST */
public class GraphQLPlaceListItemsFromPlaceListConnection$Builder extends Builder {
    public ImmutableList<GraphQLPlaceListItem> f12652d;

    public GraphQLPlaceListItemsFromPlaceListConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLPlaceListItemsFromPlaceListConnection$Builder);
    }

    public final GraphQLPlaceListItemsFromPlaceListConnection m20875a() {
        return new GraphQLPlaceListItemsFromPlaceListConnection(this);
    }
}
