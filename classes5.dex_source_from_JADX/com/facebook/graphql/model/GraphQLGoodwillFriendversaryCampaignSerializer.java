package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: graph_search_result */
public class GraphQLGoodwillFriendversaryCampaignSerializer extends JsonSerializer<GraphQLGoodwillFriendversaryCampaign> {
    public final void m7880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillFriendversaryCampaign__JsonHelper.m7882a(jsonGenerator, (GraphQLGoodwillFriendversaryCampaign) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillFriendversaryCampaign.class, new GraphQLGoodwillFriendversaryCampaignSerializer());
    }
}
