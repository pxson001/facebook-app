package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: min_daily_budget */
public class GraphQLTrendingEntitiesEdgeDeserializer extends FbJsonDeserializer {
    public Object m22294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTrendingEntitiesEdge graphQLTrendingEntitiesEdge = new GraphQLTrendingEntitiesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTrendingEntitiesEdge = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLTrendingEntitiesEdge__JsonHelper.m22296a(graphQLTrendingEntitiesEdge, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLTrendingEntitiesEdge;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrendingEntitiesEdge.class, new GraphQLTrendingEntitiesEdgeDeserializer());
    }

    public GraphQLTrendingEntitiesEdgeDeserializer() {
        a(GraphQLTrendingEntitiesEdge.class);
    }
}
