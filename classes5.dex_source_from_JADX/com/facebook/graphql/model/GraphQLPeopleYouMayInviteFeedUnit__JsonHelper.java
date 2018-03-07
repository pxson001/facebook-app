package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: WORK_ACCOUNT_MIGRATION */
public final class GraphQLPeopleYouMayInviteFeedUnit__JsonHelper {
    public static boolean m20672a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit, String str, JsonParser jsonParser) {
        long j = 0;
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLPeopleYouMayInviteFeedUnit.d = GraphQLObjectType.a(jsonParser);
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
            graphQLPeopleYouMayInviteFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "action_links", graphQLPeopleYouMayInviteFeedUnit.a_, 0, true);
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
            graphQLPeopleYouMayInviteFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "actors", graphQLPeopleYouMayInviteFeedUnit.B_(), 1, true);
            return true;
        } else if ("all_contacts".equals(str)) {
            GraphQLPeopleYouMayInviteFeedUnitContactsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPeopleYouMayInviteFeedUnitContactsConnection__JsonHelper.m20652a(FieldAccessQueryTracker.a(jsonParser, "all_contacts"));
            }
            graphQLPeopleYouMayInviteFeedUnit.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "all_contacts", graphQLPeopleYouMayInviteFeedUnit.B_(), 2, true);
            return true;
        } else if ("app_icon".equals(str)) {
            GraphQLImage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "app_icon"));
            }
            graphQLPeopleYouMayInviteFeedUnit.h = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "app_icon", graphQLPeopleYouMayInviteFeedUnit.B_(), 3, true);
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
            graphQLPeopleYouMayInviteFeedUnit.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "attachments", graphQLPeopleYouMayInviteFeedUnit.B_(), 4, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "cache_id", graphQLPeopleYouMayInviteFeedUnit.B_(), 5, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLPeopleYouMayInviteFeedUnit.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "creation_time", graphQLPeopleYouMayInviteFeedUnit.B_(), 6, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "debug_info", graphQLPeopleYouMayInviteFeedUnit.B_(), 7, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLPeopleYouMayInviteFeedUnit.m = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "feedback", graphQLPeopleYouMayInviteFeedUnit.B_(), 8, true);
            return true;
        } else if ("feedback_context".equals(str)) {
            GraphQLFeedbackContext a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLFeedbackContext__JsonHelper.m7479a(FieldAccessQueryTracker.a(jsonParser, "feedback_context"));
            }
            graphQLPeopleYouMayInviteFeedUnit.n = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "feedback_context", graphQLPeopleYouMayInviteFeedUnit.B_(), 9, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLPeopleYouMayInviteFeedUnit.o = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "fetchTimeMs", graphQLPeopleYouMayInviteFeedUnit.B_(), 10, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "hideable_token", graphQLPeopleYouMayInviteFeedUnit.B_(), 11, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "id", graphQLPeopleYouMayInviteFeedUnit.B_(), 12, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLPeopleYouMayInviteFeedUnit.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "message", graphQLPeopleYouMayInviteFeedUnit.B_(), 13, true);
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
            graphQLPeopleYouMayInviteFeedUnit.s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "multiShareAttachmentWithImageFields", graphQLPeopleYouMayInviteFeedUnit.B_(), 14, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLPeopleYouMayInviteFeedUnit.t = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "negative_feedback_actions", graphQLPeopleYouMayInviteFeedUnit.B_(), 15, true);
            return true;
        } else if ("peopleYouMayInviteTitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "peopleYouMayInviteTitle"));
            }
            graphQLPeopleYouMayInviteFeedUnit.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "peopleYouMayInviteTitle", graphQLPeopleYouMayInviteFeedUnit.B_(), 16, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLPeopleYouMayInviteFeedUnit.v = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "privacy_scope", graphQLPeopleYouMayInviteFeedUnit.B_(), 17, true);
            return true;
        } else if ("seen_state".equals(str)) {
            graphQLPeopleYouMayInviteFeedUnit.w = GraphQLStorySeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "seen_state", graphQLPeopleYouMayInviteFeedUnit.B_(), 18, false);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
            }
            graphQLPeopleYouMayInviteFeedUnit.x = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "shareable", graphQLPeopleYouMayInviteFeedUnit.B_(), 19, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.y = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "short_term_cache_key", graphQLPeopleYouMayInviteFeedUnit.B_(), 21, false);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLStoryHeader__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "story_header"));
            }
            graphQLPeopleYouMayInviteFeedUnit.z = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "story_header", graphQLPeopleYouMayInviteFeedUnit.B_(), 23, true);
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
            graphQLPeopleYouMayInviteFeedUnit.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "substories_grouping_reasons", graphQLPeopleYouMayInviteFeedUnit.B_(), 24, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPeopleYouMayInviteFeedUnit.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "title", graphQLPeopleYouMayInviteFeedUnit.B_(), 26, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLPeopleYouMayInviteFeedUnit.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "titleForSummary", graphQLPeopleYouMayInviteFeedUnit.B_(), 27, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.D = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "tracking", graphQLPeopleYouMayInviteFeedUnit.B_(), 28, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.E = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "url", graphQLPeopleYouMayInviteFeedUnit.B_(), 29, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.F = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "local_last_negative_feedback_action_type", graphQLPeopleYouMayInviteFeedUnit.B_(), 30, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPeopleYouMayInviteFeedUnit.G = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "local_story_visibility", graphQLPeopleYouMayInviteFeedUnit.B_(), 31, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLPeopleYouMayInviteFeedUnit.H = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnit, "local_story_visible_height", graphQLPeopleYouMayInviteFeedUnit.B_(), 32, false);
            return true;
        }
    }
}
