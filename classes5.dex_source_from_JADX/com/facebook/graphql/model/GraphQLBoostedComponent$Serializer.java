package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLBoostedComponentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_on_sale */
public final class GraphQLBoostedComponent$Serializer extends JsonSerializer<GraphQLBoostedComponent> {
    public final void m6636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBoostedComponent graphQLBoostedComponent = (GraphQLBoostedComponent) obj;
        GraphQLBoostedComponentDeserializer.m4613a(graphQLBoostedComponent.w_(), graphQLBoostedComponent.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLBoostedComponent.class, new GraphQLBoostedComponent$Serializer());
        FbSerializerProvider.a(GraphQLBoostedComponent.class, new GraphQLBoostedComponent$Serializer());
    }
}
