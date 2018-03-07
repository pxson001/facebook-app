package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to create a thumbnail */
public class GraphQLStoryInsightsSerializer extends JsonSerializer<GraphQLStoryInsights> {
    public final void m21878a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryInsights__JsonHelper.m21880a(jsonGenerator, (GraphQLStoryInsights) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryInsights.class, new GraphQLStoryInsightsSerializer());
    }
}
