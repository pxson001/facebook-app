package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: normal_unfan */
public class GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class, new GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer());
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer() {
        a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class);
    }

    public Object m20650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPeopleYouMayInviteFeedUnitContactsConnection__JsonHelper.m20652a(jsonParser);
    }
}
