package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Transfer-Encoding */
public class GraphQLTrueTopicFeedOptionSerializer extends JsonSerializer<GraphQLTrueTopicFeedOption> {
    public final void m22318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrueTopicFeedOption__JsonHelper.m22320a(jsonGenerator, (GraphQLTrueTopicFeedOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTrueTopicFeedOption.class, new GraphQLTrueTopicFeedOptionSerializer());
    }
}
