package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLRedirectionInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_ONLY */
public final class GraphQLRedirectionInfo$Serializer extends JsonSerializer<GraphQLRedirectionInfo> {
    public final void m21378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRedirectionInfo graphQLRedirectionInfo = (GraphQLRedirectionInfo) obj;
        GraphQLRedirectionInfoDeserializer.m5803b(graphQLRedirectionInfo.w_(), graphQLRedirectionInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLRedirectionInfo.class, new GraphQLRedirectionInfo$Serializer());
        FbSerializerProvider.a(GraphQLRedirectionInfo.class, new GraphQLRedirectionInfo$Serializer());
    }
}
