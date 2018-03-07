package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: is_ask_friends_enabled */
public class GraphQLCommentPlaceInfoToPlaceListItemsConnection$Builder extends Builder {
    public ImmutableList<GraphQLPlaceListItem> f3478d;

    public GraphQLCommentPlaceInfoToPlaceListItemsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLCommentPlaceInfoToPlaceListItemsConnection$Builder);
    }

    public final GraphQLCommentPlaceInfoToPlaceListItemsConnection m6805a() {
        return new GraphQLCommentPlaceInfoToPlaceListItemsConnection(this);
    }
}
