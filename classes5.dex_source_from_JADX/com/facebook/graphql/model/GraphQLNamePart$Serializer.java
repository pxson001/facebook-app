package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNamePartDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: extra_target_id */
public final class GraphQLNamePart$Serializer extends JsonSerializer<GraphQLNamePart> {
    public final void m9152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNamePart graphQLNamePart = (GraphQLNamePart) obj;
        GraphQLNamePartDeserializer.m5390a(graphQLNamePart.w_(), graphQLNamePart.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLNamePart.class, new GraphQLNamePart$Serializer());
        FbSerializerProvider.a(GraphQLNamePart.class, new GraphQLNamePart$Serializer());
    }
}
