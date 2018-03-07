package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: grantedScopes */
public class GraphQLGoodwillThrowbackAnniversaryCampaignStorySerializer extends JsonSerializer<GraphQLGoodwillThrowbackAnniversaryCampaignStory> {
    public final void m7924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackAnniversaryCampaignStory.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory.m7919k() != null) {
            jsonGenerator.a("anniversary_campaign");
            GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7795a(jsonGenerator, graphQLGoodwillThrowbackAnniversaryCampaignStory.m7919k(), true);
        }
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory.m7920l() != null) {
            jsonGenerator.a("color_palette");
            GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8069a(jsonGenerator, graphQLGoodwillThrowbackAnniversaryCampaignStory.m7920l(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillThrowbackAnniversaryCampaignStory.T_());
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory.m7921m() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackAnniversaryCampaignStory.m7921m(), true);
        }
        if (graphQLGoodwillThrowbackAnniversaryCampaignStory.m7922n() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackAnniversaryCampaignStory.m7922n(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, new GraphQLGoodwillThrowbackAnniversaryCampaignStorySerializer());
    }
}
