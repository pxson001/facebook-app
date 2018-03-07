package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimelineStoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNDERAGE_FAN_REMOVAL */
public final class GraphQLTimelineStoriesConnection$Serializer extends JsonSerializer<GraphQLTimelineStoriesConnection> {
    public final void m22226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineStoriesConnection graphQLTimelineStoriesConnection = (GraphQLTimelineStoriesConnection) obj;
        GraphQLTimelineStoriesConnectionDeserializer.m6097a(graphQLTimelineStoriesConnection.w_(), graphQLTimelineStoriesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineStoriesConnection.class, new GraphQLTimelineStoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLTimelineStoriesConnection.class, new GraphQLTimelineStoriesConnection$Serializer());
    }
}
