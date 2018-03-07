package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_HOME_INLINE */
public final class GraphQLResearchPollFeedUnit__JsonHelper {
    public static boolean m21403a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLResearchPollFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("ad_impression".equals(str)) {
            GraphQLSponsoredData a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "ad_impression"));
            }
            graphQLResearchPollFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "ad_impression", graphQLResearchPollFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "cache_id", graphQLResearchPollFeedUnit.B_(), 1, false);
            return true;
        } else if ("checkbox_question_prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "checkbox_question_prompt", graphQLResearchPollFeedUnit.B_(), 2, false);
            return true;
        } else if ("confirmation_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "confirmation_text", graphQLResearchPollFeedUnit.B_(), 3, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "debug_info", graphQLResearchPollFeedUnit.B_(), 4, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLResearchPollFeedUnit.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "fetchTimeMs", graphQLResearchPollFeedUnit.B_(), 5, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "hideable_token", graphQLResearchPollFeedUnit.B_(), 6, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "id", graphQLResearchPollFeedUnit.B_(), 7, false);
            return true;
        } else if ("initial_card_prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "initial_card_prompt", graphQLResearchPollFeedUnit.B_(), 8, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLResearchPollFeedUnit.n = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "negative_feedback_actions", graphQLResearchPollFeedUnit.B_(), 9, true);
            return true;
        } else if ("privacy_disclaimer".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "privacy_disclaimer", graphQLResearchPollFeedUnit.B_(), 10, false);
            return true;
        } else if ("radio_question_prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "radio_question_prompt", graphQLResearchPollFeedUnit.B_(), 11, false);
            return true;
        } else if ("research_poll".equals(str)) {
            GraphQLResearchPollSurvey a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLResearchPollSurvey__JsonHelper.m21489a(FieldAccessQueryTracker.a(jsonParser, "research_poll"));
            }
            graphQLResearchPollFeedUnit.q = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "research_poll", graphQLResearchPollFeedUnit.B_(), 12, true);
            return true;
        } else if ("see_results_prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "see_results_prompt", graphQLResearchPollFeedUnit.B_(), 13, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "short_term_cache_key", graphQLResearchPollFeedUnit.B_(), 15, false);
            return true;
        } else if ("should_auto_open".equals(str)) {
            graphQLResearchPollFeedUnit.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "should_auto_open", graphQLResearchPollFeedUnit.B_(), 16, false);
            return true;
        } else if ("should_auto_submit".equals(str)) {
            graphQLResearchPollFeedUnit.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "should_auto_submit", graphQLResearchPollFeedUnit.B_(), 17, false);
            return true;
        } else if ("sponsored_label".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "sponsored_label", graphQLResearchPollFeedUnit.B_(), 18, false);
            return true;
        } else if ("submit_answer_prompt".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.w = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "submit_answer_prompt", graphQLResearchPollFeedUnit.B_(), 19, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLResearchPollFeedUnit.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "title", graphQLResearchPollFeedUnit.B_(), 20, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLResearchPollFeedUnit.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "titleForSummary", graphQLResearchPollFeedUnit.B_(), 21, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.z = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "tracking", graphQLResearchPollFeedUnit.B_(), 22, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.A = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "url", graphQLResearchPollFeedUnit.B_(), 23, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.B = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "local_last_negative_feedback_action_type", graphQLResearchPollFeedUnit.B_(), 24, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLResearchPollFeedUnit.C = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "local_story_visibility", graphQLResearchPollFeedUnit.B_(), 25, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLResearchPollFeedUnit.D = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollFeedUnit, "local_story_visible_height", graphQLResearchPollFeedUnit.B_(), 26, false);
            return true;
        }
    }
}
