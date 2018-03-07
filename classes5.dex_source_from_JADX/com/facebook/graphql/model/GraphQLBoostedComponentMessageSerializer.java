package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_messenger_eligible */
public class GraphQLBoostedComponentMessageSerializer extends JsonSerializer<GraphQLBoostedComponentMessage> {
    public final void m6658a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBoostedComponentMessage__JsonHelper.m6660a(jsonGenerator, (GraphQLBoostedComponentMessage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBoostedComponentMessage.class, new GraphQLBoostedComponentMessageSerializer());
    }
}
