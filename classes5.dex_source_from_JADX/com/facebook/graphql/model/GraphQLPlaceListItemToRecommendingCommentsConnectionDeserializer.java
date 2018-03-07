package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_gender */
public class GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItemToRecommendingCommentsConnection.class, new GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer());
    }

    public GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer() {
        a(GraphQLPlaceListItemToRecommendingCommentsConnection.class);
    }

    public Object m20868a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceListItemToRecommendingCommentsConnection__JsonHelper.m20870a(jsonParser);
    }
}
