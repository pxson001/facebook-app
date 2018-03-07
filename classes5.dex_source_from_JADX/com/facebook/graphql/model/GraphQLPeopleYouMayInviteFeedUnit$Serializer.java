package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_MANAGER_GROUP */
public final class GraphQLPeopleYouMayInviteFeedUnit$Serializer extends JsonSerializer<GraphQLPeopleYouMayInviteFeedUnit> {
    public final void m20645a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) obj;
        GraphQLPeopleYouMayInviteFeedUnitDeserializer.m5583a(graphQLPeopleYouMayInviteFeedUnit.w_(), graphQLPeopleYouMayInviteFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnit.class, new GraphQLPeopleYouMayInviteFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPeopleYouMayInviteFeedUnit.class, new GraphQLPeopleYouMayInviteFeedUnit$Serializer());
    }
}
