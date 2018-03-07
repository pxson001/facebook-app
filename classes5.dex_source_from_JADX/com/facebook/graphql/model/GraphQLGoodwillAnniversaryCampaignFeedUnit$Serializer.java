package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_context_rows */
public final class GraphQLGoodwillAnniversaryCampaignFeedUnit$Serializer extends JsonSerializer<GraphQLGoodwillAnniversaryCampaignFeedUnit> {
    public final void m7789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) obj;
        GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer.m5001a(graphQLGoodwillAnniversaryCampaignFeedUnit.w_(), graphQLGoodwillAnniversaryCampaignFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, new GraphQLGoodwillAnniversaryCampaignFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, new GraphQLGoodwillAnniversaryCampaignFeedUnit$Serializer());
    }
}
