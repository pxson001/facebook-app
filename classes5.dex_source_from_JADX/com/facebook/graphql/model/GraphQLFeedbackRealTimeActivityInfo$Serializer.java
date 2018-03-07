package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedbackRealTimeActivityInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hideStory */
public final class GraphQLFeedbackRealTimeActivityInfo$Serializer extends JsonSerializer<GraphQLFeedbackRealTimeActivityInfo> {
    public final void m7502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackRealTimeActivityInfo graphQLFeedbackRealTimeActivityInfo = (GraphQLFeedbackRealTimeActivityInfo) obj;
        GraphQLFeedbackRealTimeActivityInfoDeserializer.m4909a(graphQLFeedbackRealTimeActivityInfo.w_(), graphQLFeedbackRealTimeActivityInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityInfo.class, new GraphQLFeedbackRealTimeActivityInfo$Serializer());
        FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityInfo.class, new GraphQLFeedbackRealTimeActivityInfo$Serializer());
    }
}
