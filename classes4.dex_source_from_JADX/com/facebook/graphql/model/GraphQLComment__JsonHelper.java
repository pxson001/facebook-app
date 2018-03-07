package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: screen_brightness */
public final class GraphQLComment__JsonHelper {
    public static GraphQLComment m3228a(JsonParser jsonParser) {
        GraphQLComment graphQLComment = new GraphQLComment();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3230a(graphQLComment, i, jsonParser);
            jsonParser.f();
        }
        return graphQLComment;
    }

    private static boolean m3230a(GraphQLComment graphQLComment, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("approximate_position".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLComment.d = i;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "approximate_position", graphQLComment.a_, 0, false);
            return true;
        } else if ("attached_story".equals(str)) {
            GraphQLStory a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStory__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "attached_story"));
            }
            graphQLComment.e = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "attached_story", graphQLComment.B_(), 1, true);
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
            graphQLComment.f = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "attachments", graphQLComment.B_(), 2, true);
            return true;
        } else if ("author".equals(str)) {
            GraphQLActor a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLActor__JsonHelper.m3233a(FieldAccessQueryTracker.m2235a(jsonParser, "author"));
            }
            graphQLComment.g = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "author", graphQLComment.B_(), 3, true);
            return true;
        } else if ("body".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "body"));
            }
            graphQLComment.h = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "body", graphQLComment.B_(), 4, true);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLComment.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "can_viewer_delete", graphQLComment.B_(), 5, false);
            return true;
        } else if ("can_viewer_edit".equals(str)) {
            graphQLComment.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "can_viewer_edit", graphQLComment.B_(), 6, false);
            return true;
        } else if ("comment_parent".equals(str)) {
            GraphQLComment a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = m3228a(FieldAccessQueryTracker.m2235a(jsonParser, "comment_parent"));
            }
            graphQLComment.k = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "comment_parent", graphQLComment.B_(), 7, true);
            return true;
        } else if ("created_time".equals(str)) {
            graphQLComment.l = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "created_time", graphQLComment.B_(), 8, false);
            return true;
        } else if ("edit_history".equals(str)) {
            GraphQLEditHistoryConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLEditHistoryConnection__JsonHelper.m3249a(FieldAccessQueryTracker.m2235a(jsonParser, "edit_history"));
            }
            graphQLComment.m = a4;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "edit_history", graphQLComment.B_(), 9, true);
            return true;
        } else if ("feedback".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFeedback__JsonHelper.m3218a(FieldAccessQueryTracker.m2235a(jsonParser, "feedback"));
            }
            graphQLComment.n = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "feedback", graphQLComment.B_(), 10, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLComment.o = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "id", graphQLComment.B_(), 11, false);
            return true;
        } else if ("interesting_replies".equals(str)) {
            GraphQLInterestingRepliesConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLInterestingRepliesConnection__JsonHelper.m3231a(FieldAccessQueryTracker.m2235a(jsonParser, "interesting_replies"));
            }
            graphQLComment.p = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "interesting_replies", graphQLComment.B_(), 12, true);
            return true;
        } else if ("is_featured".equals(str)) {
            graphQLComment.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "is_featured", graphQLComment.B_(), 13, false);
            return true;
        } else if ("is_marked_as_spam".equals(str)) {
            graphQLComment.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "is_marked_as_spam", graphQLComment.B_(), 14, false);
            return true;
        } else if ("is_pinned".equals(str)) {
            graphQLComment.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "is_pinned", graphQLComment.B_(), 15, false);
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
            graphQLComment.t = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "multiShareAttachmentWithImageFields", graphQLComment.B_(), 16, true);
            return true;
        } else if ("permalink_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "permalink_title"));
            }
            graphQLComment.u = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "permalink_title", graphQLComment.B_(), 17, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLPrivacyScope__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "privacy_scope"));
            }
            graphQLComment.v = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "privacy_scope", graphQLComment.B_(), 18, true);
            return true;
        } else if ("private_reply_context".equals(str)) {
            GraphQLPrivateReplyContext a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPrivateReplyContext__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "private_reply_context"));
            }
            graphQLComment.w = a7;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "private_reply_context", graphQLComment.B_(), 19, true);
            return true;
        } else if ("request_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLComment.x = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "request_id", graphQLComment.B_(), 20, false);
            return true;
        } else if ("sort_key".equals(str)) {
            graphQLComment.y = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "sort_key", graphQLComment.B_(), 21, false);
            return true;
        } else if ("translatability_for_viewer".equals(str)) {
            GraphQLPostTranslatability a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLPostTranslatability__JsonHelper.m3251a(FieldAccessQueryTracker.m2235a(jsonParser, "translatability_for_viewer"));
            }
            graphQLComment.z = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "translatability_for_viewer", graphQLComment.B_(), 22, true);
            return true;
        } else if ("translated_body_for_viewer".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "translated_body_for_viewer"));
            }
            graphQLComment.A = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "translated_body_for_viewer", graphQLComment.B_(), 23, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLComment.B = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "url", graphQLComment.B_(), 24, false);
            return true;
        } else if ("timestamp_in_video".equals(str)) {
            graphQLComment.C = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "timestamp_in_video", graphQLComment.B_(), 25, false);
            return true;
        } else if ("written_while_video_was_live".equals(str)) {
            graphQLComment.D = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "written_while_video_was_live", graphQLComment.B_(), 26, false);
            return true;
        } else if ("parent_feedback".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLFeedback__JsonHelper.m3218a(FieldAccessQueryTracker.m2235a(jsonParser, "parent_feedback"));
            }
            graphQLComment.E = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "parent_feedback", graphQLComment.B_(), 27, true);
            return true;
        } else if (!"body_markdown_html".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.m3246a(FieldAccessQueryTracker.m2235a(jsonParser, "body_markdown_html"));
            }
            graphQLComment.F = graphQLTextWithEntities;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComment, "body_markdown_html", graphQLComment.B_(), 28, true);
            return true;
        }
    }

    public static void m3229a(JsonGenerator jsonGenerator, GraphQLComment graphQLComment, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("approximate_position", graphQLComment.o());
        if (graphQLComment.p() != null) {
            jsonGenerator.a("attached_story");
            GraphQLStory__JsonHelper.a(jsonGenerator, graphQLComment.p(), true);
        }
        jsonGenerator.a("attachments");
        if (graphQLComment.q() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLComment.q()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLComment.r() != null) {
            jsonGenerator.a("author");
            GraphQLActor__JsonHelper.m3234a(jsonGenerator, graphQLComment.r(), true);
        }
        if (graphQLComment.s() != null) {
            jsonGenerator.a("body");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLComment.s(), true);
        }
        jsonGenerator.a("can_viewer_delete", graphQLComment.t());
        jsonGenerator.a("can_viewer_edit", graphQLComment.u());
        if (graphQLComment.v() != null) {
            jsonGenerator.a("comment_parent");
            m3229a(jsonGenerator, graphQLComment.v(), true);
        }
        jsonGenerator.a("created_time", graphQLComment.w());
        if (graphQLComment.x() != null) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnection__JsonHelper.m3250a(jsonGenerator, graphQLComment.x(), true);
        }
        if (graphQLComment.l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.m3219a(jsonGenerator, graphQLComment.l(), true);
        }
        if (graphQLComment.y() != null) {
            jsonGenerator.a("id", graphQLComment.y());
        }
        if (graphQLComment.z() != null) {
            jsonGenerator.a("interesting_replies");
            GraphQLInterestingRepliesConnection__JsonHelper.m3232a(jsonGenerator, graphQLComment.z(), true);
        }
        jsonGenerator.a("is_featured", graphQLComment.A());
        jsonGenerator.a("is_marked_as_spam", graphQLComment.B());
        jsonGenerator.a("is_pinned", graphQLComment.C());
        jsonGenerator.a("multiShareAttachmentWithImageFields");
        if (graphQLComment.D() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLComment.D()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLComment.E() != null) {
            jsonGenerator.a("permalink_title");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLComment.E(), true);
        }
        if (graphQLComment.F() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.a(jsonGenerator, graphQLComment.F(), true);
        }
        if (graphQLComment.G() != null) {
            jsonGenerator.a("private_reply_context");
            GraphQLPrivateReplyContext__JsonHelper.a(jsonGenerator, graphQLComment.G(), true);
        }
        if (graphQLComment.H() != null) {
            jsonGenerator.a("request_id", graphQLComment.H());
        }
        jsonGenerator.a("sort_key", graphQLComment.I());
        if (graphQLComment.J() != null) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatability__JsonHelper.m3252a(jsonGenerator, graphQLComment.J(), true);
        }
        if (graphQLComment.K() != null) {
            jsonGenerator.a("translated_body_for_viewer");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLComment.K(), true);
        }
        if (graphQLComment.L() != null) {
            jsonGenerator.a("url", graphQLComment.L());
        }
        jsonGenerator.a("timestamp_in_video", graphQLComment.M());
        jsonGenerator.a("written_while_video_was_live", graphQLComment.N());
        if (graphQLComment.O() != null) {
            jsonGenerator.a("parent_feedback");
            GraphQLFeedback__JsonHelper.m3219a(jsonGenerator, graphQLComment.O(), true);
        }
        if (graphQLComment.P() != null) {
            jsonGenerator.a("body_markdown_html");
            GraphQLTextWithEntities__JsonHelper.m3247a(jsonGenerator, graphQLComment.P(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
