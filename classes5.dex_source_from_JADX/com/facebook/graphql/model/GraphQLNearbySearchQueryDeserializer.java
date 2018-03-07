package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogPhrase */
public class GraphQLNearbySearchQueryDeserializer extends FbJsonDeserializer {
    public Object m9218a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNearbySearchQuery graphQLNearbySearchQuery = new GraphQLNearbySearchQuery();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNearbySearchQuery = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLNearbySearchQuery__JsonHelper.m9220a(graphQLNearbySearchQuery, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLNearbySearchQuery;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNearbySearchQuery.class, new GraphQLNearbySearchQueryDeserializer());
    }

    public GraphQLNearbySearchQueryDeserializer() {
        a(GraphQLNearbySearchQuery.class);
    }
}
