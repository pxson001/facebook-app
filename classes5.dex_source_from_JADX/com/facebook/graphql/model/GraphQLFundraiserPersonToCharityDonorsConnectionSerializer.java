package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_names */
public class GraphQLFundraiserPersonToCharityDonorsConnectionSerializer extends JsonSerializer<GraphQLFundraiserPersonToCharityDonorsConnection> {
    public final void m7728a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserPersonToCharityDonorsConnection__JsonHelper.m7730a(jsonGenerator, (GraphQLFundraiserPersonToCharityDonorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserPersonToCharityDonorsConnection.class, new GraphQLFundraiserPersonToCharityDonorsConnectionSerializer());
    }
}
