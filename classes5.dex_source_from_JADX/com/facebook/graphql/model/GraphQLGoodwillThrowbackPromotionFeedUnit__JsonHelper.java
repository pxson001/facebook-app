package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: getProcessStats */
public final class GraphQLGoodwillThrowbackPromotionFeedUnit__JsonHelper {
    public static boolean m8102a(GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillThrowbackPromotionFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("accent_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "accent_image"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "accent_image", graphQLGoodwillThrowbackPromotionFeedUnit.a_, 0, true);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "action_links", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 1, true);
            return true;
        } else if ("additional_accent_images".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLImage a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "additional_accent_images"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "additional_accent_images", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 2, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "cache_id", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 3, false);
            return true;
        } else if ("call_to_action".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "call_to_action"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "call_to_action", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 4, true);
            return true;
        } else if ("campaigns".equals(str)) {
            GraphQLGoodwillThrowbackPromotedCampaignsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGoodwillThrowbackPromotedCampaignsConnection__JsonHelper.m8077a(FieldAccessQueryTracker.a(jsonParser, "campaigns"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.j = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "campaigns", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 5, true);
            return true;
        } else if ("color_palette".equals(str)) {
            GraphQLGoodwillThrowbackPromotionColorPalette a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGoodwillThrowbackPromotionColorPalette__JsonHelper.m8096a(FieldAccessQueryTracker.a(jsonParser, "color_palette"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.k = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "color_palette", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 6, true);
            return true;
        } else if ("content_summary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "content_summary"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "content_summary", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 7, true);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "debug_info", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 8, false);
            return true;
        } else if ("favicon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "favicon"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "favicon", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 9, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGoodwillThrowbackPromotionFeedUnit.o = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "fetchTimeMs", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 10, false);
            return true;
        } else if ("full_width_accent_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "full_width_accent_image"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "full_width_accent_image", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 11, true);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "hideable_token", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 12, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "id", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 13, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.s = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "negative_feedback_actions", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 14, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.t = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "privacy_scope", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 15, true);
            return true;
        } else if ("promoted_stories".equals(str)) {
            GraphQLGoodwillThrowbackPromotedStoriesConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLGoodwillThrowbackPromotedStoriesConnection__JsonHelper.m8086a(FieldAccessQueryTracker.a(jsonParser, "promoted_stories"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.u = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "promoted_stories", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 16, true);
            return true;
        } else if ("render_style".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.v = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "render_style", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 17, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.w = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "short_term_cache_key", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 19, false);
            return true;
        } else if ("throwbackPromotionActionLinks".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "throwbackPromotionActionLinks"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "throwbackPromotionActionLinks", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 20, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "title", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 21, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "titleForSummary", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 22, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.A = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "tracking", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 23, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.B = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "url", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 24, false);
            return true;
        } else if ("years_ago".equals(str)) {
            graphQLGoodwillThrowbackPromotionFeedUnit.C = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "years_ago", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 25, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.D = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "local_last_negative_feedback_action_type", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 26, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackPromotionFeedUnit.E = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "local_story_visibility", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 27, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLGoodwillThrowbackPromotionFeedUnit.F = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotionFeedUnit, "local_story_visible_height", graphQLGoodwillThrowbackPromotionFeedUnit.B_(), 28, false);
            return true;
        }
    }
}
