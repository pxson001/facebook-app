package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: group_commerce_suggested_groups_card */
public final class GraphQLGoodwillAnniversaryCampaignFeedUnit__JsonHelper {
    public static boolean m7792a(GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillAnniversaryCampaignFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("anniversary_campaign".equals(str)) {
            GraphQLGoodwillAnniversaryCampaign a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGoodwillAnniversaryCampaign__JsonHelper.m7794a(FieldAccessQueryTracker.a(jsonParser, "anniversary_campaign"));
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "anniversary_campaign", graphQLGoodwillAnniversaryCampaignFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "cache_id", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "debug_info", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGoodwillAnniversaryCampaignFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "fetchTimeMs", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 3, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "hideable_token", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 4, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.j = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "negative_feedback_actions", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 5, true);
            return true;
        } else if ("render_style".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "render_style", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 6, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "short_term_cache_key", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 7, false);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "tracking", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 8, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "local_last_negative_feedback_action_type", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 9, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaignFeedUnit.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "local_story_visibility", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 10, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLGoodwillAnniversaryCampaignFeedUnit.p = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaignFeedUnit, "local_story_visible_height", graphQLGoodwillAnniversaryCampaignFeedUnit.B_(), 11, false);
            return true;
        }
    }
}
