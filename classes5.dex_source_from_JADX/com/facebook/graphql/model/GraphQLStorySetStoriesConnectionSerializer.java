package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_SEE_ALL_REVIEWS */
public class GraphQLStorySetStoriesConnectionSerializer extends JsonSerializer<GraphQLStorySetStoriesConnection> {
    public final void m21912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySetStoriesConnection__JsonHelper.m21914a(jsonGenerator, (GraphQLStorySetStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySetStoriesConnection.class, new GraphQLStorySetStoriesConnectionSerializer());
    }
}
