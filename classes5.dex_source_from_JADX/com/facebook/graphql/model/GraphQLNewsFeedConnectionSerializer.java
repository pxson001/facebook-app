package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: events_calendar_subscriber_count */
public class GraphQLNewsFeedConnectionSerializer extends JsonSerializer<GraphQLNewsFeedConnection> {
    public final void m9254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNewsFeedConnection__JsonHelper.m9256a(jsonGenerator, (GraphQLNewsFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNewsFeedConnection.class, new GraphQLNewsFeedConnectionSerializer());
    }
}
