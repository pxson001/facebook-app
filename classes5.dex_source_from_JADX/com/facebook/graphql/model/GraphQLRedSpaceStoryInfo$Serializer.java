package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLRedSpaceStoryInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_PLAY */
public final class GraphQLRedSpaceStoryInfo$Serializer extends JsonSerializer<GraphQLRedSpaceStoryInfo> {
    public final void m21372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRedSpaceStoryInfo graphQLRedSpaceStoryInfo = (GraphQLRedSpaceStoryInfo) obj;
        GraphQLRedSpaceStoryInfoDeserializer.m5798a(graphQLRedSpaceStoryInfo.w_(), graphQLRedSpaceStoryInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLRedSpaceStoryInfo.class, new GraphQLRedSpaceStoryInfo$Serializer());
        FbSerializerProvider.a(GraphQLRedSpaceStoryInfo.class, new GraphQLRedSpaceStoryInfo$Serializer());
    }
}
