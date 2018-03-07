package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: employer_context */
public class GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionSerializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnitStoriesConnection> {
    public final void m9534a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStoriesYouMissedFeedUnitStoriesConnection__JsonHelper.m9536a(jsonGenerator, (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class, new GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionSerializer());
    }
}
