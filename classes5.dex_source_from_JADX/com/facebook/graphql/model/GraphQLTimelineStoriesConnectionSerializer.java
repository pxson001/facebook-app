package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNDEFINED_QPL_EVENT */
public class GraphQLTimelineStoriesConnectionSerializer extends JsonSerializer<GraphQLTimelineStoriesConnection> {
    public final void m22228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineStoriesConnection__JsonHelper.m22230a(jsonGenerator, (GraphQLTimelineStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineStoriesConnection.class, new GraphQLTimelineStoriesConnectionSerializer());
    }
}
