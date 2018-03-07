package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryInsightsDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to create thumbnail bitmap. */
public final class GraphQLStoryInsights$Serializer extends JsonSerializer<GraphQLStoryInsights> {
    public final void m21876a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryInsights graphQLStoryInsights = (GraphQLStoryInsights) obj;
        GraphQLStoryInsightsDeserializer.m5975a(graphQLStoryInsights.w_(), graphQLStoryInsights.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryInsights.class, new GraphQLStoryInsights$Serializer());
        FbSerializerProvider.a(GraphQLStoryInsights.class, new GraphQLStoryInsights$Serializer());
    }
}
