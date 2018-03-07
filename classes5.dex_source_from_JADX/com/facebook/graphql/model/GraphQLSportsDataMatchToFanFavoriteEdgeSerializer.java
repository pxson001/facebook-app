package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unknown calling package name '%s'. */
public class GraphQLSportsDataMatchToFanFavoriteEdgeSerializer extends JsonSerializer<GraphQLSportsDataMatchToFanFavoriteEdge> {
    public final void m21814a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchToFanFavoriteEdge__JsonHelper.m21816a(jsonGenerator, (GraphQLSportsDataMatchToFanFavoriteEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteEdge.class, new GraphQLSportsDataMatchToFanFavoriteEdgeSerializer());
    }
}
