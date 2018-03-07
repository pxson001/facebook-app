package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: scroll */
public final class GraphQLFeedback__JsonHelper {
    public static GraphQLFeedback m3218a(JsonParser jsonParser) {
        GraphQLFeedback graphQLFeedback = new GraphQLFeedback();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3220a(graphQLFeedback, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFeedback;
    }

    private static boolean m3220a(GraphQLFeedback graphQLFeedback, String str, JsonParser jsonParser) {
        GraphQLUser graphQLUser = null;
        if ("can_see_voice_switcher".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLFeedback.d = z;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_see_voice_switcher", graphQLFeedback.a_, 1, false);
            return true;
        } else if ("can_viewer_comment".equals(str)) {
            graphQLFeedback.e = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_comment", graphQLFeedback.B_(), 2, false);
            return true;
        } else if ("can_viewer_comment_with_photo".equals(str)) {
            graphQLFeedback.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_comment_with_photo", graphQLFeedback.B_(), 3, false);
            return true;
        } else if ("can_viewer_comment_with_sticker".equals(str)) {
            graphQLFeedback.g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_comment_with_sticker", graphQLFeedback.B_(), 4, false);
            return true;
        } else if ("can_viewer_comment_with_video".equals(str)) {
            graphQLFeedback.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_comment_with_video", graphQLFeedback.B_(), 5, false);
            return true;
        } else if ("can_viewer_like".equals(str)) {
            graphQLFeedback.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_like", graphQLFeedback.B_(), 6, false);
            return true;
        } else if ("can_viewer_react".equals(str)) {
            graphQLFeedback.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_react", graphQLFeedback.B_(), 7, false);
            return true;
        } else if ("can_viewer_subscribe".equals(str)) {
            graphQLFeedback.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "can_viewer_subscribe", graphQLFeedback.B_(), 8, false);
            return true;
        } else if ("comments".equals(str)) {
            GraphQLCommentsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLCommentsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "comments"));
            }
            graphQLFeedback.l = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "comments", graphQLFeedback.B_(), 9, true);
            return true;
        } else if ("comments_disabled_notice".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "comments_disabled_notice"));
            }
            graphQLFeedback.m = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "comments_disabled_notice", graphQLFeedback.B_(), 10, true);
            return true;
        } else if ("comments_mirroring_domain".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.n = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "comments_mirroring_domain", graphQLFeedback.B_(), 11, false);
            return true;
        } else if ("default_comment_ordering".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.o = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "default_comment_ordering", graphQLFeedback.B_(), 12, false);
            return true;
        } else if ("display_reactions".equals(str)) {
            graphQLFeedback.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "display_reactions", graphQLFeedback.B_(), 13, false);
            return true;
        } else if ("does_viewer_like".equals(str)) {
            graphQLFeedback.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "does_viewer_like", graphQLFeedback.B_(), 14, false);
            return true;
        } else if ("dont_append_here".equals(str)) {
            graphQLFeedback.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "dont_append_here", graphQLFeedback.B_(), 15, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLFeedback.s = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "fetchTimeMs", graphQLFeedback.B_(), 16, false);
            return true;
        } else if ("has_viewer_commented_recently".equals(str)) {
            graphQLFeedback.t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "has_viewer_commented_recently", graphQLFeedback.B_(), 17, false);
            return true;
        } else if ("have_comments_been_disabled".equals(str)) {
            graphQLFeedback.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "have_comments_been_disabled", graphQLFeedback.B_(), 18, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.v = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "id", graphQLFeedback.B_(), 19, false);
            return true;
        } else if ("interactors_friend".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInteractorsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "interactors_friend"));
            }
            graphQLFeedback.w = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "interactors_friend", graphQLFeedback.B_(), 20, true);
            return true;
        } else if ("interactors_not_friend".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLInteractorsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "interactors_not_friend"));
            }
            graphQLFeedback.x = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "interactors_not_friend", graphQLFeedback.B_(), 21, true);
            return true;
        } else if ("is_viewer_subscribed".equals(str)) {
            graphQLFeedback.y = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "is_viewer_subscribed", graphQLFeedback.B_(), 22, false);
            return true;
        } else if ("legacy_api_post_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.z = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "legacy_api_post_id", graphQLFeedback.B_(), 23, false);
            return true;
        } else if ("like_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "like_sentence"));
            }
            graphQLFeedback.A = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "like_sentence", graphQLFeedback.B_(), 24, true);
            return true;
        } else if ("likers".equals(str)) {
            GraphQLLikersOfContentConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLLikersOfContentConnection__JsonHelper.m3221a(FieldAccessQueryTracker.m2235a(jsonParser, "likers"));
            }
            graphQLFeedback.B = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "likers", graphQLFeedback.B_(), 25, true);
            return true;
        } else if ("mostRecentTopLevelComments".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTopLevelCommentsConnection__JsonHelper.m3225a(FieldAccessQueryTracker.m2235a(jsonParser, "mostRecentTopLevelComments"));
            }
            graphQLFeedback.C = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "mostRecentTopLevelComments", graphQLFeedback.B_(), 26, true);
            return true;
        } else if ("reactors".equals(str)) {
            GraphQLReactorsOfContentConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLReactorsOfContentConnection__JsonHelper.m3254a(FieldAccessQueryTracker.m2235a(jsonParser, "reactors"));
            }
            graphQLFeedback.D = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "reactors", graphQLFeedback.B_(), 27, true);
            return true;
        } else if ("real_time_activity_info".equals(str)) {
            GraphQLFeedbackRealTimeActivityInfo a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLFeedbackRealTimeActivityInfo__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "real_time_activity_info"));
            }
            graphQLFeedback.E = a4;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "real_time_activity_info", graphQLFeedback.B_(), 28, true);
            return true;
        } else if ("remixable_photo_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.F = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "remixable_photo_uri", graphQLFeedback.B_(), 30, false);
            return true;
        } else if ("reshares".equals(str)) {
            GraphQLResharesOfContentConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLResharesOfContentConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "reshares"));
            }
            graphQLFeedback.G = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "reshares", graphQLFeedback.B_(), 31, true);
            return true;
        } else if ("seen_by".equals(str)) {
            GraphQLSeenByConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLSeenByConnection__JsonHelper.m3223a(FieldAccessQueryTracker.m2235a(jsonParser, "seen_by"));
            }
            graphQLFeedback.H = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "seen_by", graphQLFeedback.B_(), 32, true);
            return true;
        } else if ("should_use_likers_sentence".equals(str)) {
            graphQLFeedback.I = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "should_use_likers_sentence", graphQLFeedback.B_(), 33, false);
            return true;
        } else if ("supported_reactions".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFeedbackReaction a7 = GraphQLFeedbackReaction__JsonHelper.m3263a(FieldAccessQueryTracker.m2235a(jsonParser, "supported_reactions"));
                    if (a7 != null) {
                        arrayList.add(a7);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLFeedback.J = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "supported_reactions", graphQLFeedback.B_(), 34, true);
            return true;
        } else if ("top_level_comments".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTopLevelCommentsConnection__JsonHelper.m3225a(FieldAccessQueryTracker.m2235a(jsonParser, "top_level_comments"));
            }
            graphQLFeedback.K = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "top_level_comments", graphQLFeedback.B_(), 35, true);
            return true;
        } else if ("top_reactions".equals(str)) {
            GraphQLTopReactionsConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLTopReactionsConnection__JsonHelper.m3256a(FieldAccessQueryTracker.m2235a(jsonParser, "top_reactions"));
            }
            graphQLFeedback.L = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "top_reactions", graphQLFeedback.B_(), 36, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.M = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "url", graphQLFeedback.B_(), 37, false);
            return true;
        } else if ("viewer_acts_as_page".equals(str)) {
            GraphQLPage a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_acts_as_page"));
            }
            graphQLFeedback.N = a9;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_acts_as_page", graphQLFeedback.B_(), 38, true);
            return true;
        } else if ("viewer_does_not_like_reaction_sentence_as_string".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.O = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_does_not_like_reaction_sentence_as_string", graphQLFeedback.B_(), 39, false);
            return true;
        } else if ("viewer_does_not_like_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_does_not_like_sentence"));
            }
            graphQLFeedback.P = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_does_not_like_sentence", graphQLFeedback.B_(), 40, true);
            return true;
        } else if ("viewer_feedback_reaction".equals(str)) {
            GraphQLFeedbackReaction a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLFeedbackReaction__JsonHelper.m3263a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_feedback_reaction"));
            }
            graphQLFeedback.Q = a10;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_feedback_reaction", graphQLFeedback.B_(), 41, true);
            return true;
        } else if ("viewer_feedback_reaction_key".equals(str)) {
            graphQLFeedback.R = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_feedback_reaction_key", graphQLFeedback.B_(), 42, false);
            return true;
        } else if ("viewer_likes_reaction_sentence_as_string".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFeedback.S = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_likes_reaction_sentence_as_string", graphQLFeedback.B_(), 43, false);
            return true;
        } else if ("viewer_likes_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_likes_sentence"));
            }
            graphQLFeedback.T = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_likes_sentence", graphQLFeedback.B_(), 44, true);
            return true;
        } else if ("video_timestamped_comments".equals(str)) {
            GraphQLVideoTimestampedCommentsConnection a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLVideoTimestampedCommentsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "video_timestamped_comments"));
            }
            graphQLFeedback.U = a11;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "video_timestamped_comments", graphQLFeedback.B_(), 45, true);
            return true;
        } else if ("important_reactors".equals(str)) {
            GraphQLImportantReactorsConnection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLImportantReactorsConnection__JsonHelper.m3265a(FieldAccessQueryTracker.m2235a(jsonParser, "important_reactors"));
            }
            graphQLFeedback.V = a12;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "important_reactors", graphQLFeedback.B_(), 46, true);
            return true;
        } else if (!"viewer_acts_as_person".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLUser = GraphQLUser__JsonHelper.m3267a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_acts_as_person"));
            }
            graphQLFeedback.W = graphQLUser;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedback, "viewer_acts_as_person", graphQLFeedback.B_(), 47, true);
            return true;
        }
    }

    public static void m3219a(JsonGenerator jsonGenerator, GraphQLFeedback graphQLFeedback, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_see_voice_switcher", graphQLFeedback.b());
        jsonGenerator.a("can_viewer_comment", graphQLFeedback.c());
        jsonGenerator.a("can_viewer_comment_with_photo", graphQLFeedback.d());
        jsonGenerator.a("can_viewer_comment_with_sticker", graphQLFeedback.m());
        jsonGenerator.a("can_viewer_comment_with_video", graphQLFeedback.x_());
        jsonGenerator.a("can_viewer_like", graphQLFeedback.g());
        jsonGenerator.a("can_viewer_react", graphQLFeedback.n());
        jsonGenerator.a("can_viewer_subscribe", graphQLFeedback.o());
        if (graphQLFeedback.p() != null) {
            jsonGenerator.a("comments");
            GraphQLCommentsConnection__JsonHelper.a(jsonGenerator, graphQLFeedback.p(), true);
        }
        if (graphQLFeedback.q() != null) {
            jsonGenerator.a("comments_disabled_notice");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLFeedback.q(), true);
        }
        if (graphQLFeedback.r() != null) {
            jsonGenerator.a("comments_mirroring_domain", graphQLFeedback.r());
        }
        if (graphQLFeedback.s() != null) {
            jsonGenerator.a("default_comment_ordering", graphQLFeedback.s());
        }
        jsonGenerator.a("display_reactions", graphQLFeedback.t());
        jsonGenerator.a("does_viewer_like", graphQLFeedback.y_());
        jsonGenerator.a("dont_append_here", graphQLFeedback.u());
        jsonGenerator.a("fetchTimeMs", graphQLFeedback.v());
        jsonGenerator.a("has_viewer_commented_recently", graphQLFeedback.w());
        jsonGenerator.a("have_comments_been_disabled", graphQLFeedback.x());
        if (graphQLFeedback.z_() != null) {
            jsonGenerator.a("id", graphQLFeedback.z_());
        }
        if (graphQLFeedback.y() != null) {
            jsonGenerator.a("interactors_friend");
            GraphQLInteractorsConnection__JsonHelper.a(jsonGenerator, graphQLFeedback.y(), true);
        }
        if (graphQLFeedback.z() != null) {
            jsonGenerator.a("interactors_not_friend");
            GraphQLInteractorsConnection__JsonHelper.a(jsonGenerator, graphQLFeedback.z(), true);
        }
        jsonGenerator.a("is_viewer_subscribed", graphQLFeedback.A());
        if (graphQLFeedback.j() != null) {
            jsonGenerator.a("legacy_api_post_id", graphQLFeedback.j());
        }
        if (graphQLFeedback.B() != null) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLFeedback.B(), true);
        }
        if (graphQLFeedback.C() != null) {
            jsonGenerator.a("likers");
            GraphQLLikersOfContentConnection__JsonHelper.m3222a(jsonGenerator, graphQLFeedback.C(), true);
        }
        if (graphQLFeedback.D() != null) {
            jsonGenerator.a("mostRecentTopLevelComments");
            GraphQLTopLevelCommentsConnection__JsonHelper.m3226a(jsonGenerator, graphQLFeedback.D(), true);
        }
        if (graphQLFeedback.E() != null) {
            jsonGenerator.a("reactors");
            GraphQLReactorsOfContentConnection__JsonHelper.m3255a(jsonGenerator, graphQLFeedback.E(), true);
        }
        if (graphQLFeedback.F() != null) {
            jsonGenerator.a("real_time_activity_info");
            GraphQLFeedbackRealTimeActivityInfo__JsonHelper.a(jsonGenerator, graphQLFeedback.F(), true);
        }
        if (graphQLFeedback.G() != null) {
            jsonGenerator.a("remixable_photo_uri", graphQLFeedback.G());
        }
        if (graphQLFeedback.H() != null) {
            jsonGenerator.a("reshares");
            GraphQLResharesOfContentConnection__JsonHelper.a(jsonGenerator, graphQLFeedback.H(), true);
        }
        if (graphQLFeedback.I() != null) {
            jsonGenerator.a("seen_by");
            GraphQLSeenByConnection__JsonHelper.m3224a(jsonGenerator, graphQLFeedback.I(), true);
        }
        jsonGenerator.a("should_use_likers_sentence", graphQLFeedback.J());
        jsonGenerator.a("supported_reactions");
        if (graphQLFeedback.K() != null) {
            jsonGenerator.d();
            for (GraphQLFeedbackReaction graphQLFeedbackReaction : graphQLFeedback.K()) {
                if (graphQLFeedbackReaction != null) {
                    GraphQLFeedbackReaction__JsonHelper.m3264a(jsonGenerator, graphQLFeedbackReaction, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFeedback.L() != null) {
            jsonGenerator.a("top_level_comments");
            GraphQLTopLevelCommentsConnection__JsonHelper.m3226a(jsonGenerator, graphQLFeedback.L(), true);
        }
        if (graphQLFeedback.M() != null) {
            jsonGenerator.a("top_reactions");
            GraphQLTopReactionsConnection__JsonHelper.m3257a(jsonGenerator, graphQLFeedback.M(), true);
        }
        if (graphQLFeedback.N() != null) {
            jsonGenerator.a("url", graphQLFeedback.N());
        }
        if (graphQLFeedback.O() != null) {
            jsonGenerator.a("viewer_acts_as_page");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLFeedback.O(), true);
        }
        if (graphQLFeedback.P() != null) {
            jsonGenerator.a("viewer_does_not_like_reaction_sentence_as_string", graphQLFeedback.P());
        }
        if (graphQLFeedback.Q() != null) {
            jsonGenerator.a("viewer_does_not_like_sentence");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLFeedback.Q(), true);
        }
        if (graphQLFeedback.R() != null) {
            jsonGenerator.a("viewer_feedback_reaction");
            GraphQLFeedbackReaction__JsonHelper.m3264a(jsonGenerator, graphQLFeedback.R(), true);
        }
        jsonGenerator.a("viewer_feedback_reaction_key", graphQLFeedback.S());
        if (graphQLFeedback.T() != null) {
            jsonGenerator.a("viewer_likes_reaction_sentence_as_string", graphQLFeedback.T());
        }
        if (graphQLFeedback.U() != null) {
            jsonGenerator.a("viewer_likes_sentence");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLFeedback.U(), true);
        }
        if (graphQLFeedback.V() != null) {
            jsonGenerator.a("video_timestamped_comments");
            GraphQLVideoTimestampedCommentsConnection__JsonHelper.a(jsonGenerator, graphQLFeedback.V(), true);
        }
        if (graphQLFeedback.W() != null) {
            jsonGenerator.a("important_reactors");
            GraphQLImportantReactorsConnection__JsonHelper.m3266a(jsonGenerator, graphQLFeedback.W(), true);
        }
        if (graphQLFeedback.X() != null) {
            jsonGenerator.a("viewer_acts_as_person");
            GraphQLUser__JsonHelper.m3268a(jsonGenerator, graphQLFeedback.X(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
