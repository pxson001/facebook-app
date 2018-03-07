package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_data_bar_menu */
public class GraphQLTaggableActivitySuggestionsEdgeDeserializer extends FbJsonDeserializer {
    public Object m22079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge = new GraphQLTaggableActivitySuggestionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTaggableActivitySuggestionsEdge = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLTaggableActivitySuggestionsEdge__JsonHelper.m22081a(graphQLTaggableActivitySuggestionsEdge, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLTaggableActivitySuggestionsEdge;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivitySuggestionsEdge.class, new GraphQLTaggableActivitySuggestionsEdgeDeserializer());
    }

    public GraphQLTaggableActivitySuggestionsEdgeDeserializer() {
        a(GraphQLTaggableActivitySuggestionsEdge.class);
    }
}
