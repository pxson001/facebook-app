package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendversary_campaign */
public class GraphQLGreetingCardSlideSerializer extends JsonSerializer<GraphQLGreetingCardSlide> {
    public final void m8349a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardSlide__JsonHelper.m8351a(jsonGenerator, (GraphQLGreetingCardSlide) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardSlide.class, new GraphQLGreetingCardSlideSerializer());
    }
}
