package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hourly_limit_kb */
public class GraphQLFeedTopicContentSerializer extends JsonSerializer<GraphQLFeedTopicContent> {
    public final void m7464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedTopicContent__JsonHelper.m7466a(jsonGenerator, (GraphQLFeedTopicContent) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedTopicContent.class, new GraphQLFeedTopicContentSerializer());
    }
}
