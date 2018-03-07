package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: modified_timestamp */
public class GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFanFavoriteConnection.class, new GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer());
    }

    public GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer() {
        a(GraphQLSportsDataMatchToFanFavoriteConnection.class);
    }

    public Object m21804a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSportsDataMatchToFanFavoriteConnection__JsonHelper.m21806a(jsonParser);
    }
}
