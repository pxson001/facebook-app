package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: UDPPrimingServiceHandler */
public final class GraphQLTopicCustomizationStory__JsonHelper {
    public static boolean m22263a(GraphQLTopicCustomizationStory graphQLTopicCustomizationStory, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLExploreFeed graphQLExploreFeed = null;
        if ("__type__".equals(str)) {
            graphQLTopicCustomizationStory.d = GraphQLObjectType.a(jsonParser);
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
            graphQLTopicCustomizationStory.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "action_links", graphQLTopicCustomizationStory.a_, 0, true);
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
            graphQLTopicCustomizationStory.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "actors", graphQLTopicCustomizationStory.B_(), 1, true);
            return true;
        } else if ("app_icon".equals(str)) {
            GraphQLImage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "app_icon"));
            }
            graphQLTopicCustomizationStory.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "app_icon", graphQLTopicCustomizationStory.B_(), 2, true);
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
            graphQLTopicCustomizationStory.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "attachments", graphQLTopicCustomizationStory.B_(), 3, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "cache_id", graphQLTopicCustomizationStory.B_(), 4, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLTopicCustomizationStory.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "creation_time", graphQLTopicCustomizationStory.B_(), 5, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "debug_info", graphQLTopicCustomizationStory.B_(), 6, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLTopicCustomizationStory.l = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "feedback", graphQLTopicCustomizationStory.B_(), 7, true);
            return true;
        } else if ("feedback_context".equals(str)) {
            GraphQLFeedbackContext a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLFeedbackContext__JsonHelper.m7479a(FieldAccessQueryTracker.a(jsonParser, "feedback_context"));
            }
            graphQLTopicCustomizationStory.m = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "feedback_context", graphQLTopicCustomizationStory.B_(), 8, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLTopicCustomizationStory.n = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "fetchTimeMs", graphQLTopicCustomizationStory.B_(), 9, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "hideable_token", graphQLTopicCustomizationStory.B_(), 10, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "id", graphQLTopicCustomizationStory.B_(), 11, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLTopicCustomizationStory.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "message", graphQLTopicCustomizationStory.B_(), 12, true);
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
            graphQLTopicCustomizationStory.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "multiShareAttachmentWithImageFields", graphQLTopicCustomizationStory.B_(), 13, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLTopicCustomizationStory.s = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "negative_feedback_actions", graphQLTopicCustomizationStory.B_(), 14, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLTopicCustomizationStory.t = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "privacy_scope", graphQLTopicCustomizationStory.B_(), 15, true);
            return true;
        } else if ("seen_state".equals(str)) {
            graphQLTopicCustomizationStory.u = GraphQLStorySeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "seen_state", graphQLTopicCustomizationStory.B_(), 16, false);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "shareable"));
            }
            graphQLTopicCustomizationStory.v = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "shareable", graphQLTopicCustomizationStory.B_(), 17, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "short_term_cache_key", graphQLTopicCustomizationStory.B_(), 19, false);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLStoryHeader__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "story_header"));
            }
            graphQLTopicCustomizationStory.x = a9;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "story_header", graphQLTopicCustomizationStory.B_(), 21, true);
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
            graphQLTopicCustomizationStory.y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "substories_grouping_reasons", graphQLTopicCustomizationStory.B_(), 22, false);
            return true;
        } else if ("subtopic_options".equals(str)) {
            GraphQLTrueTopicFeedOptionsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLTrueTopicFeedOptionsConnection__JsonHelper.m22328a(FieldAccessQueryTracker.a(jsonParser, "subtopic_options"));
            }
            graphQLTopicCustomizationStory.z = a10;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "subtopic_options", graphQLTopicCustomizationStory.B_(), 24, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLTopicCustomizationStory.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "title", graphQLTopicCustomizationStory.B_(), 25, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLTopicCustomizationStory.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "titleForSummary", graphQLTopicCustomizationStory.B_(), 26, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.C = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "tracking", graphQLTopicCustomizationStory.B_(), 27, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLTopicCustomizationStory.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "url", graphQLTopicCustomizationStory.B_(), 28, false);
            return true;
        } else if (!"topic_section".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLExploreFeed = GraphQLExploreFeed__JsonHelper.m7404a(FieldAccessQueryTracker.a(jsonParser, "topic_section"));
            }
            graphQLTopicCustomizationStory.E = graphQLExploreFeed;
            FieldAccessQueryTracker.a(jsonParser, graphQLTopicCustomizationStory, "topic_section", graphQLTopicCustomizationStory.B_(), 29, true);
            return true;
        }
    }
}
