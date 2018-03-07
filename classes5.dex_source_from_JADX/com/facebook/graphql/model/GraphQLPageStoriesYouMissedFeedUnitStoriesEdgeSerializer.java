package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: emotions */
public class GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeSerializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> {
    public final void m9543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStoriesYouMissedFeedUnitStoriesEdge__JsonHelper.m9545a(jsonGenerator, (GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class, new GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeSerializer());
    }
}
