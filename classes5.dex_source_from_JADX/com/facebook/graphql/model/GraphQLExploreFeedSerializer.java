package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: idempotenceToken */
public class GraphQLExploreFeedSerializer extends JsonSerializer<GraphQLExploreFeed> {
    public final void m7403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLExploreFeed__JsonHelper.m7405a(jsonGenerator, (GraphQLExploreFeed) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLExploreFeed.class, new GraphQLExploreFeedSerializer());
    }
}
