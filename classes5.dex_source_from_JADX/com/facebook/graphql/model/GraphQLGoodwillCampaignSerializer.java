package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gray_acc */
public class GraphQLGoodwillCampaignSerializer extends JsonSerializer<GraphQLGoodwillCampaign> {
    public final void m7850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillCampaign__JsonHelper.m7852a(jsonGenerator, (GraphQLGoodwillCampaign) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillCampaign.class, new GraphQLGoodwillCampaignSerializer());
    }
}
