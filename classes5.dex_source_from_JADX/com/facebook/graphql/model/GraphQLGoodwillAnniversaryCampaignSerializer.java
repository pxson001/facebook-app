package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_commerce_mobile_landing_page */
public class GraphQLGoodwillAnniversaryCampaignSerializer extends JsonSerializer<GraphQLGoodwillAnniversaryCampaign> {
    public final void m7793a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7795a(jsonGenerator, (GraphQLGoodwillAnniversaryCampaign) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaign.class, new GraphQLGoodwillAnniversaryCampaignSerializer());
    }
}
