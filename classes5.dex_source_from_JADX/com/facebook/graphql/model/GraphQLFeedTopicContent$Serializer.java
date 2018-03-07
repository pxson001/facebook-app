package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedTopicContentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hovercard */
public final class GraphQLFeedTopicContent$Serializer extends JsonSerializer<GraphQLFeedTopicContent> {
    public final void m7462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedTopicContent graphQLFeedTopicContent = (GraphQLFeedTopicContent) obj;
        GraphQLFeedTopicContentDeserializer.m4884a(graphQLFeedTopicContent.w_(), graphQLFeedTopicContent.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedTopicContent.class, new GraphQLFeedTopicContent$Serializer());
        FbSerializerProvider.a(GraphQLFeedTopicContent.class, new GraphQLFeedTopicContent$Serializer());
    }
}
