package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTopicDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UFILastFeedbackQuery */
public final class GraphQLTopic$Serializer extends JsonSerializer<GraphQLTopic> {
    public final void m22258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopic graphQLTopic = (GraphQLTopic) obj;
        GraphQLTopicDeserializer.m6117b(graphQLTopic.w_(), graphQLTopic.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTopic.class, new GraphQLTopic$Serializer());
        FbSerializerProvider.a(GraphQLTopic.class, new GraphQLTopic$Serializer());
    }
}
