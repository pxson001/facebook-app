package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: WIZARD_SEARCH_PYMK */
public final class GraphQLPeopleYouMayKnowFeedUnit__JsonHelper {
    public static boolean m20690a(GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit, String str, JsonParser jsonParser) {
        long j = 0;
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLPeopleYouMayKnowFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
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
            graphQLPeopleYouMayKnowFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "action_links", graphQLPeopleYouMayKnowFeedUnit.a_, 0, true);
            return true;
        } else if ("actors".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a2 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "actors"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPeopleYouMayKnowFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "actors", graphQLPeopleYouMayKnowFeedUnit.B_(), 1, true);
            return true;
        } else if ("attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "attachments"));
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
            graphQLPeopleYouMayKnowFeedUnit.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "attachments", graphQLPeopleYouMayKnowFeedUnit.B_(), 2, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "cache_id", graphQLPeopleYouMayKnowFeedUnit.B_(), 3, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLPeopleYouMayKnowFeedUnit.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "creation_time", graphQLPeopleYouMayKnowFeedUnit.B_(), 4, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "debug_info", graphQLPeopleYouMayKnowFeedUnit.B_(), 5, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLPeopleYouMayKnowFeedUnit.k = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "feedback", graphQLPeopleYouMayKnowFeedUnit.B_(), 6, true);
            return true;
        } else if ("feedback_context".equals(str)) {
            GraphQLFeedbackContext a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedbackContext__JsonHelper.m7479a(FieldAccessQueryTracker.a(jsonParser, "feedback_context"));
            }
            graphQLPeopleYouMayKnowFeedUnit.l = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "feedback_context", graphQLPeopleYouMayKnowFeedUnit.B_(), 7, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLPeopleYouMayKnowFeedUnit.m = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "fetchTimeMs", graphQLPeopleYouMayKnowFeedUnit.B_(), 8, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "hideable_token", graphQLPeopleYouMayKnowFeedUnit.B_(), 9, false);
            return true;
        } else if ("items".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20686a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
            graphQLPeopleYouMayKnowFeedUnit.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "items", graphQLPeopleYouMayKnowFeedUnit.B_(), 10, true);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLPeopleYouMayKnowFeedUnit.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "message", graphQLPeopleYouMayKnowFeedUnit.B_(), 11, true);
            return true;
        } else if ("multiShareAttachmentWithImageFields".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "multiShareAttachmentWithImageFields"));
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
            graphQLPeopleYouMayKnowFeedUnit.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "multiShareAttachmentWithImageFields", graphQLPeopleYouMayKnowFeedUnit.B_(), 12, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLPeopleYouMayKnowFeedUnit.r = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "negative_feedback_actions", graphQLPeopleYouMayKnowFeedUnit.B_(), 13, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLPeopleYouMayKnowFeedUnit.s = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "privacy_scope", graphQLPeopleYouMayKnowFeedUnit.B_(), 14, true);
            return true;
        } else if ("pymkItems".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20686a(FieldAccessQueryTracker.a(jsonParser, "pymkItems"));
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
            graphQLPeopleYouMayKnowFeedUnit.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "pymkItems", graphQLPeopleYouMayKnowFeedUnit.B_(), 15, true);
            return true;
        } else if ("seen_state".equals(str)) {
            graphQLPeopleYouMayKnowFeedUnit.u = GraphQLStorySeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "seen_state", graphQLPeopleYouMayKnowFeedUnit.B_(), 16, false);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
            }
            graphQLPeopleYouMayKnowFeedUnit.v = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "shareable", graphQLPeopleYouMayKnowFeedUnit.B_(), 17, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.w = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "short_term_cache_key", graphQLPeopleYouMayKnowFeedUnit.B_(), 18, false);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLStoryHeader__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "story_header"));
            }
            graphQLPeopleYouMayKnowFeedUnit.x = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "story_header", graphQLPeopleYouMayKnowFeedUnit.B_(), 20, true);
            return true;
        } else if ("substories_grouping_reasons".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLSubstoriesGroupingReason fromString = GraphQLSubstoriesGroupingReason.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPeopleYouMayKnowFeedUnit.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "substories_grouping_reasons", graphQLPeopleYouMayKnowFeedUnit.B_(), 21, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPeopleYouMayKnowFeedUnit.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "title", graphQLPeopleYouMayKnowFeedUnit.B_(), 23, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.A = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "tracking", graphQLPeopleYouMayKnowFeedUnit.B_(), 24, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.B = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "local_last_negative_feedback_action_type", graphQLPeopleYouMayKnowFeedUnit.B_(), 25, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayKnowFeedUnit.C = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "local_story_visibility", graphQLPeopleYouMayKnowFeedUnit.B_(), 26, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLPeopleYouMayKnowFeedUnit.D = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayKnowFeedUnit, "local_story_visible_height", graphQLPeopleYouMayKnowFeedUnit.B_(), 27, false);
            return true;
        }
    }
}
