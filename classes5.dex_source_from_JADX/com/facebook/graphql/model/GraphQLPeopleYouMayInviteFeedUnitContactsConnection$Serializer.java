package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_INVITE_LINK_SIGNUP */
public final class GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Serializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnitContactsConnection> {
    public final void m20649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) obj;
        GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5577a(graphQLPeopleYouMayInviteFeedUnitContactsConnection.w_(), graphQLPeopleYouMayInviteFeedUnitContactsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class, new GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Serializer());
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class, new GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Serializer());
    }
}
