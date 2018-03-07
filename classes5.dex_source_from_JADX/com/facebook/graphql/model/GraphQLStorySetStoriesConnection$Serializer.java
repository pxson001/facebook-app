package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStorySetStoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_SETTING */
public final class GraphQLStorySetStoriesConnection$Serializer extends JsonSerializer<GraphQLStorySetStoriesConnection> {
    public final void m21910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection = (GraphQLStorySetStoriesConnection) obj;
        GraphQLStorySetStoriesConnectionDeserializer.m5987a(graphQLStorySetStoriesConnection.w_(), graphQLStorySetStoriesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySetStoriesConnection.class, new GraphQLStorySetStoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLStorySetStoriesConnection.class, new GraphQLStorySetStoriesConnection$Serializer());
    }
}
