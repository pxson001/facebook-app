package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_recommendation_info */
public class GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdditionalSuggestedPostAdItemsConnection.class, new GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer());
    }

    public GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer() {
        a(GraphQLAdditionalSuggestedPostAdItemsConnection.class);
    }

    public Object m6451a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAdditionalSuggestedPostAdItemsConnection__JsonHelper.m6453a(jsonParser);
    }
}
