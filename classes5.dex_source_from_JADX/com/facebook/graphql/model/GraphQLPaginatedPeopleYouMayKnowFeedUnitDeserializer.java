package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: not_going */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = new GraphQLPaginatedPeopleYouMayKnowFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPaginatedPeopleYouMayKnowFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPaginatedPeopleYouMayKnowFeedUnit__JsonHelper.m20632a(graphQLPaginatedPeopleYouMayKnowFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer());
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer() {
        a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class);
    }
}
