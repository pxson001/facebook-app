package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_chaining */
public class GraphQLNotificationStoriesEdgeSerializer extends JsonSerializer<GraphQLNotificationStoriesEdge> {
    public final void m9388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNotificationStoriesEdge__JsonHelper.m9390a(jsonGenerator, (GraphQLNotificationStoriesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNotificationStoriesEdge.class, new GraphQLNotificationStoriesEdgeSerializer());
    }
}
