package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTopicCustomizationStoryDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UFIFeedbackQuery */
public final class GraphQLTopicCustomizationStory$Serializer extends JsonSerializer<GraphQLTopicCustomizationStory> {
    public final void m22260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopicCustomizationStory graphQLTopicCustomizationStory = (GraphQLTopicCustomizationStory) obj;
        GraphQLTopicCustomizationStoryDeserializer.m6112a(graphQLTopicCustomizationStory.w_(), graphQLTopicCustomizationStory.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTopicCustomizationStory.class, new GraphQLTopicCustomizationStory$Serializer());
        FbSerializerProvider.a(GraphQLTopicCustomizationStory.class, new GraphQLTopicCustomizationStory$Serializer());
    }
}
