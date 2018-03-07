package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedHomeStoriesDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: html_source */
public final class GraphQLFeedHomeStories$Serializer extends JsonSerializer<GraphQLFeedHomeStories> {
    public final void m7456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) obj;
        GraphQLFeedHomeStoriesDeserializer.m4881a(graphQLFeedHomeStories.w_(), graphQLFeedHomeStories.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedHomeStories.class, new GraphQLFeedHomeStories$Serializer());
        FbSerializerProvider.a(GraphQLFeedHomeStories.class, new GraphQLFeedHomeStories$Serializer());
    }
}
