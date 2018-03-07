package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_INTERNAL_SCRIPT */
public class GraphQLPeopleYouMayInviteFeedUnitContactsConnectionSerializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnitContactsConnection> {
    public final void m20651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection__JsonHelper.m20653a(jsonGenerator, (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection.class, new GraphQLPeopleYouMayInviteFeedUnitContactsConnectionSerializer());
    }
}
