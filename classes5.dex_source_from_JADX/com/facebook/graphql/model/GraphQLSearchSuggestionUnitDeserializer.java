package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mtouch_post_checkin_prompt */
public class GraphQLSearchSuggestionUnitDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionUnit.class, new GraphQLSearchSuggestionUnitDeserializer());
    }

    public GraphQLSearchSuggestionUnitDeserializer() {
        a(GraphQLSearchSuggestionUnit.class);
    }

    public Object m21606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSearchSuggestionUnit__JsonHelper.m21608a(jsonParser);
    }
}
