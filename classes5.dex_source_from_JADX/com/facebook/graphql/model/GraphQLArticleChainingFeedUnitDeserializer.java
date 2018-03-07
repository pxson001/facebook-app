package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pivotal_topics */
public class GraphQLArticleChainingFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m6602a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit = new GraphQLArticleChainingFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLArticleChainingFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLArticleChainingFeedUnit__JsonHelper.m6604a(graphQLArticleChainingFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLArticleChainingFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLArticleChainingFeedUnit.class, new GraphQLArticleChainingFeedUnitDeserializer());
    }

    public GraphQLArticleChainingFeedUnitDeserializer() {
        a(GraphQLArticleChainingFeedUnit.class);
    }
}
