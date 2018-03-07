package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unmatched second part of surrogate pair (0x */
public final class GraphQLSportsDataMatchData$Serializer extends JsonSerializer<GraphQLSportsDataMatchData> {
    public final void m21759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchData graphQLSportsDataMatchData = (GraphQLSportsDataMatchData) obj;
        GraphQLSportsDataMatchDataDeserializer.m5926a(graphQLSportsDataMatchData.w_(), graphQLSportsDataMatchData.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchData.class, new GraphQLSportsDataMatchData$Serializer());
        FbSerializerProvider.a(GraphQLSportsDataMatchData.class, new GraphQLSportsDataMatchData$Serializer());
    }
}
