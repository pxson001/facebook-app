package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLProfileVideoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOD_FULLSCREEN */
public final class GraphQLProfileVideo$Serializer extends JsonSerializer<GraphQLProfileVideo> {
    public final void m21108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfileVideo graphQLProfileVideo = (GraphQLProfileVideo) obj;
        GraphQLProfileVideoDeserializer.m5724a(graphQLProfileVideo.w_(), graphQLProfileVideo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLProfileVideo.class, new GraphQLProfileVideo$Serializer());
        FbSerializerProvider.a(GraphQLProfileVideo.class, new GraphQLProfileVideo$Serializer());
    }
}
