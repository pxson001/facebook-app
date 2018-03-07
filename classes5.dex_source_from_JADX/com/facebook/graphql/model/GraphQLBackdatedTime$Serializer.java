package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLBackdatedTimeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_persistent */
public final class GraphQLBackdatedTime$Serializer extends JsonSerializer<GraphQLBackdatedTime> {
    public final void m6630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBackdatedTime graphQLBackdatedTime = (GraphQLBackdatedTime) obj;
        GraphQLBackdatedTimeDeserializer.m4607a(graphQLBackdatedTime.w_(), graphQLBackdatedTime.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLBackdatedTime.class, new GraphQLBackdatedTime$Serializer());
        FbSerializerProvider.a(GraphQLBackdatedTime.class, new GraphQLBackdatedTime$Serializer());
    }
}
