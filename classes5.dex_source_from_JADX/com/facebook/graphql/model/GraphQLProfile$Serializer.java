package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLProfileDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOIP_CALL */
public final class GraphQLProfile$Serializer extends JsonSerializer<GraphQLProfile> {
    public final void m21097a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfile graphQLProfile = (GraphQLProfile) obj;
        GraphQLProfileDeserializer.m5721b(graphQLProfile.w_(), graphQLProfile.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLProfile.class, new GraphQLProfile$Serializer());
        FbSerializerProvider.a(GraphQLProfile.class, new GraphQLProfile$Serializer());
    }
}
