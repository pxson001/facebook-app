package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_picker */
public class GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdditionalSuggestedPostAdItemsEdge.class, new GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer());
    }

    public GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer() {
        a(GraphQLAdditionalSuggestedPostAdItemsEdge.class);
    }

    public Object m6460a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAdditionalSuggestedPostAdItemsEdge__JsonHelper.m6462a(jsonParser);
    }
}
