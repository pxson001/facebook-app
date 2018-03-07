package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMediaDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb4a_profile_more */
public final class GraphQLMedia$Serializer extends JsonSerializer<GraphQLMedia> {
    public final void m9013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMedia graphQLMedia = (GraphQLMedia) obj;
        GraphQLMediaDeserializer.m5342b(graphQLMedia.w_(), graphQLMedia.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMedia.class, new GraphQLMedia$Serializer());
        FbSerializerProvider.a(GraphQLMedia.class, new GraphQLMedia$Serializer());
    }
}
