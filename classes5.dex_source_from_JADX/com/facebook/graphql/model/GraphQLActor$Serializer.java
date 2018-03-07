package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLActorDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: latest.facebook.com */
public final class GraphQLActor$Serializer extends JsonSerializer<GraphQLActor> {
    public final void m6397a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLActor graphQLActor = (GraphQLActor) obj;
        GraphQLActorDeserializer.m4521b(graphQLActor.w_(), graphQLActor.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLActor.class, new GraphQLActor$Serializer());
        FbSerializerProvider.a(GraphQLActor.class, new GraphQLActor$Serializer());
    }
}
