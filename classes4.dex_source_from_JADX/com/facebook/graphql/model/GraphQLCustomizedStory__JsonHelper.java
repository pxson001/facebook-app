package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: preview_asset */
public final class GraphQLCustomizedStory__JsonHelper {
    public static GraphQLCustomizedStory m4778a(JsonParser jsonParser) {
        GraphQLCustomizedStory graphQLCustomizedStory = new GraphQLCustomizedStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m4780a(graphQLCustomizedStory, i, jsonParser);
            jsonParser.f();
        }
        return graphQLCustomizedStory;
    }

    private static boolean m4780a(GraphQLCustomizedStory graphQLCustomizedStory, String str, JsonParser jsonParser) {
        long j = 0;
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLCustomizedStory.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "action_links"));
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
            graphQLCustomizedStory.e = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "action_links", graphQLCustomizedStory.a_, 0, true);
            return true;
        } else if ("actors".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a2 = GraphQLActor__JsonHelper.m3233a(FieldAccessQueryTracker.m2235a(jsonParser, "actors"));
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
            graphQLCustomizedStory.f = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "actors", graphQLCustomizedStory.B_(), 1, true);
            return true;
        } else if ("app_icon".equals(str)) {
            GraphQLImage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "app_icon"));
            }
            graphQLCustomizedStory.g = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "app_icon", graphQLCustomizedStory.B_(), 2, true);
            return true;
        } else if ("attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "attachments"));
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
            graphQLCustomizedStory.h = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "attachments", graphQLCustomizedStory.B_(), 3, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.i = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "cache_id", graphQLCustomizedStory.B_(), 4, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLCustomizedStory.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "creation_time", graphQLCustomizedStory.B_(), 5, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.k = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "debug_info", graphQLCustomizedStory.B_(), 6, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedback__JsonHelper.m3218a(FieldAccessQueryTracker.m2235a(jsonParser, "feedback"));
            }
            graphQLCustomizedStory.l = a4;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "feedback", graphQLCustomizedStory.B_(), 7, true);
            return true;
        } else if ("feedback_context".equals(str)) {
            GraphQLFeedbackContext a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLFeedbackContext__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "feedback_context"));
            }
            graphQLCustomizedStory.m = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "feedback_context", graphQLCustomizedStory.B_(), 8, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLCustomizedStory.n = j;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "fetchTimeMs", graphQLCustomizedStory.B_(), 9, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.o = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "hideable_token", graphQLCustomizedStory.B_(), 10, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.p = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "id", graphQLCustomizedStory.B_(), 11, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "message"));
            }
            graphQLCustomizedStory.q = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "message", graphQLCustomizedStory.B_(), 12, true);
            return true;
        } else if ("multiShareAttachmentWithImageFields".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "multiShareAttachmentWithImageFields"));
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
            graphQLCustomizedStory.r = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "multiShareAttachmentWithImageFields", graphQLCustomizedStory.B_(), 13, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "negative_feedback_actions"));
            }
            graphQLCustomizedStory.s = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "negative_feedback_actions", graphQLCustomizedStory.B_(), 14, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPrivacyScope__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "privacy_scope"));
            }
            graphQLCustomizedStory.t = a7;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "privacy_scope", graphQLCustomizedStory.B_(), 15, true);
            return true;
        } else if ("seen_state".equals(str)) {
            graphQLCustomizedStory.u = GraphQLStorySeenState.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "seen_state", graphQLCustomizedStory.B_(), 16, false);
            return true;
        } else if ("shareable".equals(str)) {
            GraphQLEntity a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLEntity__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "shareable"));
            }
            graphQLCustomizedStory.v = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "shareable", graphQLCustomizedStory.B_(), 17, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.w = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "short_term_cache_key", graphQLCustomizedStory.B_(), 19, false);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "social_context"));
            }
            graphQLCustomizedStory.x = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "social_context", graphQLCustomizedStory.B_(), 20, true);
            return true;
        } else if ("story_header".equals(str)) {
            GraphQLStoryHeader a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLStoryHeader__JsonHelper.m4781a(FieldAccessQueryTracker.m2235a(jsonParser, "story_header"));
            }
            graphQLCustomizedStory.y = a9;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "story_header", graphQLCustomizedStory.B_(), 22, true);
            return true;
        } else if ("story_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "story_title"));
            }
            graphQLCustomizedStory.z = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "story_title", graphQLCustomizedStory.B_(), 23, true);
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
            graphQLCustomizedStory.A = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "substories_grouping_reasons", graphQLCustomizedStory.B_(), 24, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "subtitle"));
            }
            graphQLCustomizedStory.B = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "subtitle", graphQLCustomizedStory.B_(), 25, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "title"));
            }
            graphQLCustomizedStory.C = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "title", graphQLCustomizedStory.B_(), 26, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "titleForSummary"));
            }
            graphQLCustomizedStory.D = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "titleForSummary", graphQLCustomizedStory.B_(), 27, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.E = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "tracking", graphQLCustomizedStory.B_(), 28, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.F = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "url", graphQLCustomizedStory.B_(), 29, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.G = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "local_last_negative_feedback_action_type", graphQLCustomizedStory.B_(), 30, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCustomizedStory.H = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "local_story_visibility", graphQLCustomizedStory.B_(), 31, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLCustomizedStory.I = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLCustomizedStory, "local_story_visible_height", graphQLCustomizedStory.B_(), 32, false);
            return true;
        }
    }

    public static void m4779a(JsonGenerator jsonGenerator, GraphQLCustomizedStory graphQLCustomizedStory, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLCustomizedStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLCustomizedStory.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLCustomizedStory.l() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLCustomizedStory.l()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("actors");
        if (graphQLCustomizedStory.m() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLCustomizedStory.m()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.m3234a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCustomizedStory.n() != null) {
            jsonGenerator.a("app_icon");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLCustomizedStory.n(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLCustomizedStory.u() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLCustomizedStory.u()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCustomizedStory.g() != null) {
            jsonGenerator.a("cache_id", graphQLCustomizedStory.g());
        }
        jsonGenerator.a("creation_time", graphQLCustomizedStory.v());
        if (graphQLCustomizedStory.S_() != null) {
            jsonGenerator.a("debug_info", graphQLCustomizedStory.S_());
        }
        if (graphQLCustomizedStory.w() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.m3219a(jsonGenerator, graphQLCustomizedStory.w(), true);
        }
        if (graphQLCustomizedStory.x() != null) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContext__JsonHelper.a(jsonGenerator, graphQLCustomizedStory.x(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLCustomizedStory.T_());
        if (graphQLCustomizedStory.y() != null) {
            jsonGenerator.a("hideable_token", graphQLCustomizedStory.y());
        }
        if (graphQLCustomizedStory.z() != null) {
            jsonGenerator.a("id", graphQLCustomizedStory.z());
        }
        if (graphQLCustomizedStory.A() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.A(), true);
        }
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLCustomizedStory.B() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLCustomizedStory.B()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCustomizedStory.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.a(jsonGenerator, graphQLCustomizedStory.C(), true);
        }
        if (graphQLCustomizedStory.D() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.a(jsonGenerator, graphQLCustomizedStory.D(), true);
        }
        if (graphQLCustomizedStory.E() != null) {
            jsonGenerator.a("seen_state", graphQLCustomizedStory.E().toString());
        }
        if (graphQLCustomizedStory.F() != null) {
            jsonGenerator.a("shareable");
            GraphQLEntity__JsonHelper.a(jsonGenerator, graphQLCustomizedStory.F(), true);
        }
        if (graphQLCustomizedStory.G() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLCustomizedStory.G());
        }
        if (graphQLCustomizedStory.H() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.H(), true);
        }
        if (graphQLCustomizedStory.I() != null) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeader__JsonHelper.m4782a(jsonGenerator, graphQLCustomizedStory.I(), true);
        }
        if (graphQLCustomizedStory.J() != null) {
            jsonGenerator.a("story_title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.J(), true);
        }
        jsonGenerator.a("substories_grouping_reasons");
        if (graphQLCustomizedStory.K() != null) {
            jsonGenerator.d();
            for (GraphQLSubstoriesGroupingReason graphQLSubstoriesGroupingReason : graphQLCustomizedStory.K()) {
                if (graphQLSubstoriesGroupingReason != null) {
                    jsonGenerator.b(graphQLSubstoriesGroupingReason.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCustomizedStory.L() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.L(), true);
        }
        if (graphQLCustomizedStory.M() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.M(), true);
        }
        if (graphQLCustomizedStory.N() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLCustomizedStory.N(), true);
        }
        if (graphQLCustomizedStory.k() != null) {
            jsonGenerator.a("tracking", graphQLCustomizedStory.k());
        }
        if (graphQLCustomizedStory.O() != null) {
            jsonGenerator.a("url", graphQLCustomizedStory.O());
        }
        if (graphQLCustomizedStory.P() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLCustomizedStory.P());
        }
        if (graphQLCustomizedStory.Q() != null) {
            jsonGenerator.a("local_story_visibility", graphQLCustomizedStory.Q());
        }
        jsonGenerator.a("local_story_visible_height", graphQLCustomizedStory.R());
        if (z) {
            jsonGenerator.g();
        }
    }
}
