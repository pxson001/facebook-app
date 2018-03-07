package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unknown field type out. */
public class GraphQLSportsDataMatchToFanFavoriteConnectionSerializer extends JsonSerializer<GraphQLSportsDataMatchToFanFavoriteConnection> {
    public final void m21805a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchToFanFavoriteConnection__JsonHelper.m21807a(jsonGenerator, (GraphQLSportsDataMatchToFanFavoriteConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteConnection.class, new GraphQLSportsDataMatchToFanFavoriteConnectionSerializer());
    }
}
