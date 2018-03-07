package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TouchDelayRunnable */
public class GraphQLTrueTopicFeedOptionsConnectionSerializer extends JsonSerializer<GraphQLTrueTopicFeedOptionsConnection> {
    public final void m22327a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrueTopicFeedOptionsConnection__JsonHelper.m22329a(jsonGenerator, (GraphQLTrueTopicFeedOptionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsConnection.class, new GraphQLTrueTopicFeedOptionsConnectionSerializer());
    }
}
