package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to start a media-picker. */
public final class GraphQLStory$Serializer extends JsonSerializer<GraphQLStory> {
    public final void m21840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        GraphQLStoryDeserializer.m5966b(graphQLStory.w_(), graphQLStory.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStory.class, new GraphQLStory$Serializer());
        FbSerializerProvider.a(GraphQLStory.class, new GraphQLStory$Serializer());
    }
}
