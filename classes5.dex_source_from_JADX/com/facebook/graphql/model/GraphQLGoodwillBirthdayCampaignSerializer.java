package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: groupItemCoverPhoto */
public class GraphQLGoodwillBirthdayCampaignSerializer extends JsonSerializer<GraphQLGoodwillBirthdayCampaign> {
    public final void m7818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillBirthdayCampaign graphQLGoodwillBirthdayCampaign = (GraphQLGoodwillBirthdayCampaign) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillBirthdayCampaign.m7802j() != null) {
            jsonGenerator.a("campaign_owner");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGoodwillBirthdayCampaign.m7802j(), true);
        }
        if (graphQLGoodwillBirthdayCampaign.m7803k() != null) {
            jsonGenerator.a("id", graphQLGoodwillBirthdayCampaign.m7803k());
        }
        if (graphQLGoodwillBirthdayCampaign.m7804l() != null) {
            jsonGenerator.a("posting_actors");
            C0344xcce9d9af.m7817a(jsonGenerator, graphQLGoodwillBirthdayCampaign.m7804l(), true);
        }
        if (graphQLGoodwillBirthdayCampaign.m7805m() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillBirthdayCampaign.m7805m(), true);
        }
        if (graphQLGoodwillBirthdayCampaign.m7806n() != null) {
            jsonGenerator.a("url", graphQLGoodwillBirthdayCampaign.m7806n());
        }
        jsonGenerator.a("image_overlays");
        if (graphQLGoodwillBirthdayCampaign.m7807o() != null) {
            jsonGenerator.d();
            for (GraphQLImageOverlay graphQLImageOverlay : graphQLGoodwillBirthdayCampaign.m7807o()) {
                if (graphQLImageOverlay != null) {
                    GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, graphQLImageOverlay, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaign.class, new GraphQLGoodwillBirthdayCampaignSerializer());
    }
}
