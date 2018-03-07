package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: install_messenger_not_now_button */
public final class GraphQLEvent$Serializer extends JsonSerializer<GraphQLEvent> {
    public final void m7117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEvent graphQLEvent = (GraphQLEvent) obj;
        GraphQLEventDeserializer.m4796b(graphQLEvent.w_(), graphQLEvent.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEvent.class, new GraphQLEvent$Serializer());
        FbSerializerProvider.a(GraphQLEvent.class, new GraphQLEvent$Serializer());
    }
}
