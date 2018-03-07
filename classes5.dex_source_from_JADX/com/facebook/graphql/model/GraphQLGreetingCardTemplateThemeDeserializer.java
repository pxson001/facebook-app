package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: owning_page */
public class GraphQLGreetingCardTemplateThemeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardTemplateTheme.class, new GraphQLGreetingCardTemplateThemeDeserializer());
    }

    public GraphQLGreetingCardTemplateThemeDeserializer() {
        a(GraphQLGreetingCardTemplateTheme.class);
    }

    public Object m8369a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCardTemplateTheme__JsonHelper.m8371a(jsonParser);
    }
}
