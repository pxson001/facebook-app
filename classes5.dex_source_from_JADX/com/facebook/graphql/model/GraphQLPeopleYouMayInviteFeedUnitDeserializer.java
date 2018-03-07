package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: non-null operationType */
public class GraphQLPeopleYouMayInviteFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20670a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = new GraphQLPeopleYouMayInviteFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPeopleYouMayInviteFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPeopleYouMayInviteFeedUnit__JsonHelper.m20672a(graphQLPeopleYouMayInviteFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPeopleYouMayInviteFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnit.class, new GraphQLPeopleYouMayInviteFeedUnitDeserializer());
    }

    public GraphQLPeopleYouMayInviteFeedUnitDeserializer() {
        a(GraphQLPeopleYouMayInviteFeedUnit.class);
    }
}
