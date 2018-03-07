package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_regex */
public class GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class, new GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer());
    }

    public GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer() {
        a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class);
    }

    public Object m6808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCommentPlaceInfoToPlaceListItemsConnection__JsonHelper.m6810a(jsonParser);
    }
}
