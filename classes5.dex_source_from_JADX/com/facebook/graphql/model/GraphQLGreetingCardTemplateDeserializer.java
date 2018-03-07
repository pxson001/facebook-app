package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: package= */
public class GraphQLGreetingCardTemplateDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardTemplate.class, new GraphQLGreetingCardTemplateDeserializer());
    }

    public GraphQLGreetingCardTemplateDeserializer() {
        a(GraphQLGreetingCardTemplate.class);
    }

    public Object m8361a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCardTemplate__JsonHelper.m8373a(jsonParser);
    }
}
