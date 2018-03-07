package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_suggestion_netego */
public class GraphQLActivityTemplateTokenDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLActivityTemplateToken.class, new GraphQLActivityTemplateTokenDeserializer());
    }

    public GraphQLActivityTemplateTokenDeserializer() {
        a(GraphQLActivityTemplateToken.class);
    }

    public Object m6392a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLActivityTemplateToken__JsonHelper.m6394a(jsonParser);
    }
}
