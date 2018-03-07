package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLApplicationDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_video_broadcast */
public final class GraphQLApplication$Serializer extends JsonSerializer<GraphQLApplication> {
    public final void m6584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLApplication graphQLApplication = (GraphQLApplication) obj;
        GraphQLApplicationDeserializer.m4581a(graphQLApplication.w_(), graphQLApplication.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLApplication.class, new GraphQLApplication$Serializer());
        FbSerializerProvider.a(GraphQLApplication.class, new GraphQLApplication$Serializer());
    }
}
