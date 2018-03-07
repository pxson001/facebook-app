package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFundraiserCampaignDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: guest_status */
public final class GraphQLFundraiserCampaign$Serializer extends JsonSerializer<GraphQLFundraiserCampaign> {
    public final void m7665a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserCampaign graphQLFundraiserCampaign = (GraphQLFundraiserCampaign) obj;
        GraphQLFundraiserCampaignDeserializer.m4974a(graphQLFundraiserCampaign.w_(), graphQLFundraiserCampaign.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserCampaign.class, new GraphQLFundraiserCampaign$Serializer());
        FbSerializerProvider.a(GraphQLFundraiserCampaign.class, new GraphQLFundraiserCampaign$Serializer());
    }
}
