package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_COWORKER_INVITE */
public class GraphQLPeopleYouMayInviteFeedUnitContactsEdgeSerializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> {
    public final void m20667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge__JsonHelper.m20669a(jsonGenerator, (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class, new GraphQLPeopleYouMayInviteFeedUnitContactsEdgeSerializer());
    }
}
