package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: from_cta */
public class GraphQLGreetingCardSerializer extends JsonSerializer<GraphQLGreetingCard> {
    public final void m8330a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCard__JsonHelper.m8377a(jsonGenerator, (GraphQLGreetingCard) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCard.class, new GraphQLGreetingCardSerializer());
    }
}
