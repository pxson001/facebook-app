package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: null delegate */
public class GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20587a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = new GraphQLPaginatedGroupsYouShouldJoinFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPaginatedGroupsYouShouldJoinFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPaginatedGroupsYouShouldJoinFeedUnit__JsonHelper.m20610a(graphQLPaginatedGroupsYouShouldJoinFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPaginatedGroupsYouShouldJoinFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer());
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer() {
        a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class);
    }
}
