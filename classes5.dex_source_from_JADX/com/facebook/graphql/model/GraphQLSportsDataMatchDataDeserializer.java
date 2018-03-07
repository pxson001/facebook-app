package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: more_bar_menu */
public class GraphQLSportsDataMatchDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchData.class, new GraphQLSportsDataMatchDataDeserializer());
    }

    public GraphQLSportsDataMatchDataDeserializer() {
        a(GraphQLSportsDataMatchData.class);
    }

    public Object m21760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSportsDataMatchData__JsonHelper.m21786a(jsonParser);
    }
}
