package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_to_remove */
public class GraphQLGreetingCardTemplateSerializer extends JsonSerializer<GraphQLGreetingCardTemplate> {
    public final void m8362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardTemplate__JsonHelper.m8374a(jsonGenerator, (GraphQLGreetingCardTemplate) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardTemplate.class, new GraphQLGreetingCardTemplateSerializer());
    }
}
