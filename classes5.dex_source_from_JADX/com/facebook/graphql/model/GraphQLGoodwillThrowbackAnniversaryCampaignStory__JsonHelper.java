package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: gps_points */
public final class GraphQLGoodwillThrowbackAnniversaryCampaignStory__JsonHelper {
    public static boolean m7925a(GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3930d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("anniversary_campaign".equals(str)) {
            GraphQLGoodwillAnniversaryCampaign a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7794a(FieldAccessQueryTracker.a(jsonParser, "anniversary_campaign"));
            }
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3931e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackAnniversaryCampaignStory, "anniversary_campaign", graphQLGoodwillThrowbackAnniversaryCampaignStory.a_, 0, true);
            return true;
        } else if ("color_palette".equals(str)) {
            GraphQLGoodwillThrowbackPermalinkColorPalette a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGoodwillThrowbackPermalinkColorPalette__JsonHelper.m8068a(FieldAccessQueryTracker.a(jsonParser, "color_palette"));
            }
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3932f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackAnniversaryCampaignStory, "color_palette", graphQLGoodwillThrowbackAnniversaryCampaignStory.B_(), 1, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3933g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackAnniversaryCampaignStory, "fetchTimeMs", graphQLGoodwillThrowbackAnniversaryCampaignStory.B_(), 2, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3934h = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackAnniversaryCampaignStory, "subtitle", graphQLGoodwillThrowbackAnniversaryCampaignStory.B_(), 3, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGoodwillThrowbackAnniversaryCampaignStory.f3935i = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackAnniversaryCampaignStory, "title", graphQLGoodwillThrowbackAnniversaryCampaignStory.B_(), 4, true);
            return true;
        }
    }
}
