package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_owner_authored_stories */
public final class GraphQLFundraiserPersonToCharityDonorsConnection$Serializer extends JsonSerializer<GraphQLFundraiserPersonToCharityDonorsConnection> {
    public final void m7726a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection = (GraphQLFundraiserPersonToCharityDonorsConnection) obj;
        GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4986a(graphQLFundraiserPersonToCharityDonorsConnection.w_(), graphQLFundraiserPersonToCharityDonorsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserPersonToCharityDonorsConnection.class, new GraphQLFundraiserPersonToCharityDonorsConnection$Serializer());
        FbSerializerProvider.a(GraphQLFundraiserPersonToCharityDonorsConnection.class, new GraphQLFundraiserPersonToCharityDonorsConnection$Serializer());
    }
}
