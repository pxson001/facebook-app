package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_unknown_suggest_edits */
public class GraphQLSearchSuggestionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionsEdge.class, new GraphQLSearchSuggestionsEdgeDeserializer());
    }

    public GraphQLSearchSuggestionsEdgeDeserializer() {
        a(GraphQLSearchSuggestionsEdge.class);
    }

    public Object m21624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSearchSuggestionsEdge__JsonHelper.m21626a(jsonParser);
    }
}
