package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_tab */
public class GraphQLGreetingCardTemplateThemeSerializer extends JsonSerializer<GraphQLGreetingCardTemplateTheme> {
    public final void m8370a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardTemplateTheme__JsonHelper.m8372a(jsonGenerator, (GraphQLGreetingCardTemplateTheme) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardTemplateTheme.class, new GraphQLGreetingCardTemplateThemeSerializer());
    }
}
