package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: non_specific_place_to_search */
public class GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class, new GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer());
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer() {
        a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class);
    }

    public Object m20666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPeopleYouMayInviteFeedUnitContactsEdge__JsonHelper.m20668a(jsonParser);
    }
}
