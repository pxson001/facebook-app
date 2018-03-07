package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: javascript */
public class GraphQLAllScheduledPostsConnectionSerializer extends JsonSerializer<GraphQLAllScheduledPostsConnection> {
    public final void m6527a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAllScheduledPostsConnection__JsonHelper.m6529a(jsonGenerator, (GraphQLAllScheduledPostsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAllScheduledPostsConnection.class, new GraphQLAllScheduledPostsConnectionSerializer());
    }
}
