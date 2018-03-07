package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLExternalUrlDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: icon_dominant_color */
public final class GraphQLExternalUrl$Serializer extends JsonSerializer<GraphQLExternalUrl> {
    public final void m7426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) obj;
        GraphQLExternalUrlDeserializer.m4869a(graphQLExternalUrl.w_(), graphQLExternalUrl.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLExternalUrl.class, new GraphQLExternalUrl$Serializer());
        FbSerializerProvider.a(GraphQLExternalUrl.class, new GraphQLExternalUrl$Serializer());
    }
}
