package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pagelike_adder_for_reactivated_users */
public class GraphQLFaceBoxTagSuggestionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFaceBoxTagSuggestionsEdge.class, new GraphQLFaceBoxTagSuggestionsEdgeDeserializer());
    }

    public GraphQLFaceBoxTagSuggestionsEdgeDeserializer() {
        a(GraphQLFaceBoxTagSuggestionsEdge.class);
    }

    public Object m7448a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFaceBoxTagSuggestionsEdge__JsonHelper.m7450a(jsonParser);
    }
}
