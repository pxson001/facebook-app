package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: from_get_offer_dialog */
public final class GraphQLGreetingCardPromotionFeedUnit__JsonHelper {
    public static boolean m8329a(GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGreetingCardPromotionFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "cache_id", graphQLGreetingCardPromotionFeedUnit.a_, 0, false);
            return true;
        } else if ("caption".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "caption"));
            }
            graphQLGreetingCardPromotionFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "caption", graphQLGreetingCardPromotionFeedUnit.B_(), 1, true);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "debug_info", graphQLGreetingCardPromotionFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGreetingCardPromotionFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "fetchTimeMs", graphQLGreetingCardPromotionFeedUnit.B_(), 3, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "hideable_token", graphQLGreetingCardPromotionFeedUnit.B_(), 4, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLGreetingCardPromotionFeedUnit.j = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "negative_feedback_actions", graphQLGreetingCardPromotionFeedUnit.B_(), 5, true);
            return true;
        } else if ("prefilled_greeting_card".equals(str)) {
            GraphQLGreetingCard a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGreetingCard__JsonHelper.m8376a(FieldAccessQueryTracker.a(jsonParser, "prefilled_greeting_card"));
            }
            graphQLGreetingCardPromotionFeedUnit.k = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "prefilled_greeting_card", graphQLGreetingCardPromotionFeedUnit.B_(), 6, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLGreetingCardPromotionFeedUnit.l = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "privacy_scope", graphQLGreetingCardPromotionFeedUnit.B_(), 7, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "short_term_cache_key", graphQLGreetingCardPromotionFeedUnit.B_(), 8, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLGreetingCardPromotionFeedUnit.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "subtitle", graphQLGreetingCardPromotionFeedUnit.B_(), 9, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGreetingCardPromotionFeedUnit.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "title", graphQLGreetingCardPromotionFeedUnit.B_(), 10, true);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "local_last_negative_feedback_action_type", graphQLGreetingCardPromotionFeedUnit.B_(), 11, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCardPromotionFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "local_story_visibility", graphQLGreetingCardPromotionFeedUnit.B_(), 12, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLGreetingCardPromotionFeedUnit.r = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardPromotionFeedUnit, "local_story_visible_height", graphQLGreetingCardPromotionFeedUnit.B_(), 13, false);
            return true;
        }
    }
}
