package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: frequency */
public class GraphQLGroupTopStoriesFeedUnitStoriesEdgeSerializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnitStoriesEdge> {
    public final void m8514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupTopStoriesFeedUnitStoriesEdge__JsonHelper.m8516a(jsonGenerator, (GraphQLGroupTopStoriesFeedUnitStoriesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class, new GraphQLGroupTopStoriesFeedUnitStoriesEdgeSerializer());
    }
}
