package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hideAttachment */
public class GraphQLFeedbackRealTimeActivityInfoSerializer extends JsonSerializer<GraphQLFeedbackRealTimeActivityInfo> {
    public final void m7504a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackRealTimeActivityInfo__JsonHelper.m7506a(jsonGenerator, (GraphQLFeedbackRealTimeActivityInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityInfo.class, new GraphQLFeedbackRealTimeActivityInfoSerializer());
    }
}
