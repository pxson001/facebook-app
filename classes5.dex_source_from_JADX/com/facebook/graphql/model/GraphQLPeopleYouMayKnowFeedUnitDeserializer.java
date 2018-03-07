package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no_link */
public class GraphQLPeopleYouMayKnowFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit = new GraphQLPeopleYouMayKnowFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPeopleYouMayKnowFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPeopleYouMayKnowFeedUnit__JsonHelper.m20690a(graphQLPeopleYouMayKnowFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPeopleYouMayKnowFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayKnowFeedUnit.class, new GraphQLPeopleYouMayKnowFeedUnitDeserializer());
    }

    public GraphQLPeopleYouMayKnowFeedUnitDeserializer() {
        a(GraphQLPeopleYouMayKnowFeedUnit.class);
    }
}
