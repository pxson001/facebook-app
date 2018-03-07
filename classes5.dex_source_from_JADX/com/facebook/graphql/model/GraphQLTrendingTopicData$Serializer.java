package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTrendingTopicDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TrendingEntitiesEdge */
public final class GraphQLTrendingTopicData$Serializer extends JsonSerializer<GraphQLTrendingTopicData> {
    public final void m22298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrendingTopicData graphQLTrendingTopicData = (GraphQLTrendingTopicData) obj;
        GraphQLTrendingTopicDataDeserializer.m6129a(graphQLTrendingTopicData.w_(), graphQLTrendingTopicData.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTrendingTopicData.class, new GraphQLTrendingTopicData$Serializer());
        FbSerializerProvider.a(GraphQLTrendingTopicData.class, new GraphQLTrendingTopicData$Serializer());
    }
}
