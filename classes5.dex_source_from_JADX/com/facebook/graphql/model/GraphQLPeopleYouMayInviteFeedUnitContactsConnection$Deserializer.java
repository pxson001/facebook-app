package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WORK_INVITE_LINK_SIGNUP */
public class GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class, new GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Deserializer());
    }

    public Object m20648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5576a(jsonParser, (short) 333);
        Object graphQLPeopleYouMayInviteFeedUnitContactsConnection = new GraphQLPeopleYouMayInviteFeedUnitContactsConnection();
        ((BaseModel) graphQLPeopleYouMayInviteFeedUnitContactsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPeopleYouMayInviteFeedUnitContactsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPeopleYouMayInviteFeedUnitContactsConnection).a();
        }
        return graphQLPeopleYouMayInviteFeedUnitContactsConnection;
    }
}
