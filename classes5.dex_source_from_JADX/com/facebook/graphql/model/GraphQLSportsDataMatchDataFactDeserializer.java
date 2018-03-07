package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mood_page */
public class GraphQLSportsDataMatchDataFactDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchDataFact.class, new GraphQLSportsDataMatchDataFactDeserializer());
    }

    public GraphQLSportsDataMatchDataFactDeserializer() {
        a(GraphQLSportsDataMatchDataFact.class);
    }

    public Object m21780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSportsDataMatchDataFact__JsonHelper.m21782a(jsonParser);
    }
}
