package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_by_page */
public class GraphQLCelebrationsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m6745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit = new GraphQLCelebrationsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLCelebrationsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLCelebrationsFeedUnit__JsonHelper.m6759a(graphQLCelebrationsFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLCelebrationsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCelebrationsFeedUnit.class, new GraphQLCelebrationsFeedUnitDeserializer());
    }

    public GraphQLCelebrationsFeedUnitDeserializer() {
        a(GraphQLCelebrationsFeedUnit.class);
    }
}
