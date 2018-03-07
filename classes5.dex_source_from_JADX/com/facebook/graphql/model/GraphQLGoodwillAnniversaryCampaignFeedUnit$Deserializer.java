package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: group_context_rows */
public class GraphQLGoodwillAnniversaryCampaignFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, new GraphQLGoodwillAnniversaryCampaignFeedUnit$Deserializer());
    }

    public Object m7788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer.m5000a(jsonParser, (short) 129);
        Object graphQLGoodwillAnniversaryCampaignFeedUnit = new GraphQLGoodwillAnniversaryCampaignFeedUnit();
        ((BaseModel) graphQLGoodwillAnniversaryCampaignFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGoodwillAnniversaryCampaignFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGoodwillAnniversaryCampaignFeedUnit).a();
        }
        return graphQLGoodwillAnniversaryCampaignFeedUnit;
    }
}
