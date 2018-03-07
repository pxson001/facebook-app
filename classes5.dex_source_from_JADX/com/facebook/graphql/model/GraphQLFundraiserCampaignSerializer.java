package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: guest_list_edit_guest_rsvp */
public class GraphQLFundraiserCampaignSerializer extends JsonSerializer<GraphQLFundraiserCampaign> {
    public final void m7667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserCampaign__JsonHelper.m7669a(jsonGenerator, (GraphQLFundraiserCampaign) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserCampaign.class, new GraphQLFundraiserCampaignSerializer());
    }
}
