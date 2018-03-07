package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_suggest_group_friends */
public class GraphQLPlaceSuggestionInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceSuggestionInfo.class, new GraphQLPlaceSuggestionInfoDeserializer());
    }

    public GraphQLPlaceSuggestionInfoDeserializer() {
        a(GraphQLPlaceSuggestionInfo.class);
    }

    public Object m20916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceSuggestionInfo__JsonHelper.m20918a(jsonParser);
    }
}
