package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: U2U_ANSWER_FEEDBACK */
public class GraphQLTopicFeedOptionSerializer extends JsonSerializer<GraphQLTopicFeedOption> {
    public final void m22274a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopicFeedOption__JsonHelper.m22276a(jsonGenerator, (GraphQLTopicFeedOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTopicFeedOption.class, new GraphQLTopicFeedOptionSerializer());
    }
}
