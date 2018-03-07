package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: modified_time */
public class GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFanFavoriteEdge.class, new GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer());
    }

    public GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer() {
        a(GraphQLSportsDataMatchToFanFavoriteEdge.class);
    }

    public Object m21813a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSportsDataMatchToFanFavoriteEdge__JsonHelper.m21815a(jsonParser);
    }
}
