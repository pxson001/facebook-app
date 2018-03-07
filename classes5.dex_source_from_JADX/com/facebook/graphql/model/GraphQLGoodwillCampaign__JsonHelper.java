package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: graphql_fields_tracking */
public final class GraphQLGoodwillCampaign__JsonHelper {
    public static GraphQLGoodwillCampaign m7851a(JsonParser jsonParser) {
        GraphQLGoodwillCampaign graphQLGoodwillCampaign = new GraphQLGoodwillCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7853a(graphQLGoodwillCampaign, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGoodwillCampaign;
    }

    private static boolean m7853a(GraphQLGoodwillCampaign graphQLGoodwillCampaign, String str, JsonParser jsonParser) {
        List list = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLGoodwillCampaign.f3880d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "__type__", graphQLGoodwillCampaign.a_, 0, false);
            return true;
        } else if ("campaign_owner".equals(str)) {
            GraphQLProfile a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "campaign_owner"));
            }
            graphQLGoodwillCampaign.f3881e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "campaign_owner", graphQLGoodwillCampaign.B_(), 1, true);
            return true;
        } else if ("data_points".equals(str)) {
            GraphQLGoodwillThrowbackDataPointsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7940a(FieldAccessQueryTracker.a(jsonParser, "data_points"));
            }
            graphQLGoodwillCampaign.f3882f = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "data_points", graphQLGoodwillCampaign.B_(), 2, true);
            return true;
        } else if ("featured_video_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "featured_video_attachments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillCampaign.f3883g = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "featured_video_attachments", graphQLGoodwillCampaign.B_(), 3, true);
            return true;
        } else if ("feed_promotion_call_to_action".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_call_to_action"));
            }
            graphQLGoodwillCampaign.f3884h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "feed_promotion_call_to_action", graphQLGoodwillCampaign.B_(), 4, true);
            return true;
        } else if ("feed_promotion_favicon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_favicon"));
            }
            graphQLGoodwillCampaign.f3885i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "feed_promotion_favicon", graphQLGoodwillCampaign.B_(), 5, true);
            return true;
        } else if ("feed_promotion_icon_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_icon_image"));
            }
            graphQLGoodwillCampaign.f3886j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "feed_promotion_icon_image", graphQLGoodwillCampaign.B_(), 6, true);
            return true;
        } else if ("feed_promotion_privacy_notice".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_privacy_notice"));
            }
            graphQLGoodwillCampaign.f3887k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "feed_promotion_privacy_notice", graphQLGoodwillCampaign.B_(), 7, true);
            return true;
        } else if ("feed_promotion_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_title"));
            }
            graphQLGoodwillCampaign.f3888l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "feed_promotion_title", graphQLGoodwillCampaign.B_(), 8, true);
            return true;
        } else if ("friend".equals(str)) {
            GraphQLUser a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "friend"));
            }
            graphQLGoodwillCampaign.f3889m = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "friend", graphQLGoodwillCampaign.B_(), 9, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillCampaign.f3890n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "id", graphQLGoodwillCampaign.B_(), 10, false);
            return true;
        } else if ("photo_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "photo_attachments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillCampaign.f3891o = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "photo_attachments", graphQLGoodwillCampaign.B_(), 11, true);
            return true;
        } else if ("posting_actors".equals(str)) {
            GraphQLGoodwillBirthdayCampaignPostingActorsConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = C0344xcce9d9af.m7816a(FieldAccessQueryTracker.a(jsonParser, "posting_actors"));
            }
            graphQLGoodwillCampaign.f3892p = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "posting_actors", graphQLGoodwillCampaign.B_(), 12, true);
            return true;
        } else if ("relationship_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "relationship_context"));
            }
            graphQLGoodwillCampaign.f3893q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "relationship_context", graphQLGoodwillCampaign.B_(), 13, true);
            return true;
        } else if ("share_message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_message"));
            }
            graphQLGoodwillCampaign.f3894r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "share_message", graphQLGoodwillCampaign.B_(), 14, true);
            return true;
        } else if ("share_preview_icon_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_icon_image"));
            }
            graphQLGoodwillCampaign.f3895s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "share_preview_icon_image", graphQLGoodwillCampaign.B_(), 15, true);
            return true;
        } else if ("share_preview_story_placeholder".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_story_placeholder"));
            }
            graphQLGoodwillCampaign.f3896t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "share_preview_story_placeholder", graphQLGoodwillCampaign.B_(), 16, true);
            return true;
        } else if ("share_preview_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_title"));
            }
            graphQLGoodwillCampaign.f3897u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "share_preview_title", graphQLGoodwillCampaign.B_(), 17, true);
            return true;
        } else if ("share_status".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillCampaign.f3898v = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "share_status", graphQLGoodwillCampaign.B_(), 18, false);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLGoodwillCampaign.f3899w = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "social_context", graphQLGoodwillCampaign.B_(), 19, true);
            return true;
        } else if ("throwback_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "throwback_subtitle"));
            }
            graphQLGoodwillCampaign.f3900x = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "throwback_subtitle", graphQLGoodwillCampaign.B_(), 20, true);
            return true;
        } else if ("throwback_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "throwback_title"));
            }
            graphQLGoodwillCampaign.f3901y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "throwback_title", graphQLGoodwillCampaign.B_(), 21, true);
            return true;
        } else if ("video_campaign".equals(str)) {
            GraphQLGoodwillVideoCampaign a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLGoodwillVideoCampaign__JsonHelper.m8135a(FieldAccessQueryTracker.a(jsonParser, "video_campaign"));
            }
            graphQLGoodwillCampaign.f3902z = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "video_campaign", graphQLGoodwillCampaign.B_(), 22, true);
            return true;
        } else if (!"image_overlays".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLImageOverlay a7 = GraphQLImageOverlay__JsonHelper.m8630a(FieldAccessQueryTracker.a(jsonParser, "image_overlays"));
                    if (a7 != null) {
                        r1.add(a7);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillCampaign.f3879A = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillCampaign, "image_overlays", graphQLGoodwillCampaign.B_(), 23, true);
            return true;
        }
    }

    public static void m7852a(JsonGenerator jsonGenerator, GraphQLGoodwillCampaign graphQLGoodwillCampaign, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillCampaign.m7832j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillCampaign.m7832j().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillCampaign.m7833k() != null) {
            jsonGenerator.a("campaign_owner");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGoodwillCampaign.m7833k(), true);
        }
        if (graphQLGoodwillCampaign.m7834l() != null) {
            jsonGenerator.a("data_points");
            GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7941a(jsonGenerator, graphQLGoodwillCampaign.m7834l(), true);
        }
        jsonGenerator.a("featured_video_attachments");
        if (graphQLGoodwillCampaign.m7835m() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillCampaign.m7835m()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillCampaign.m7836n() != null) {
            jsonGenerator.a("feed_promotion_call_to_action");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7836n(), true);
        }
        if (graphQLGoodwillCampaign.m7837o() != null) {
            jsonGenerator.a("feed_promotion_favicon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7837o(), true);
        }
        if (graphQLGoodwillCampaign.m7838p() != null) {
            jsonGenerator.a("feed_promotion_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7838p(), true);
        }
        if (graphQLGoodwillCampaign.m7839q() != null) {
            jsonGenerator.a("feed_promotion_privacy_notice");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7839q(), true);
        }
        if (graphQLGoodwillCampaign.m7840r() != null) {
            jsonGenerator.a("feed_promotion_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7840r(), true);
        }
        if (graphQLGoodwillCampaign.m7841s() != null) {
            jsonGenerator.a("friend");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7841s(), true);
        }
        if (graphQLGoodwillCampaign.m7842t() != null) {
            jsonGenerator.a("id", graphQLGoodwillCampaign.m7842t());
        }
        jsonGenerator.a("photo_attachments");
        if (graphQLGoodwillCampaign.m7843u() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLGoodwillCampaign.m7843u()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillCampaign.m7844v() != null) {
            jsonGenerator.a("posting_actors");
            C0344xcce9d9af.m7817a(jsonGenerator, graphQLGoodwillCampaign.m7844v(), true);
        }
        if (graphQLGoodwillCampaign.m7845w() != null) {
            jsonGenerator.a("relationship_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7845w(), true);
        }
        if (graphQLGoodwillCampaign.m7846x() != null) {
            jsonGenerator.a("share_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7846x(), true);
        }
        if (graphQLGoodwillCampaign.m7847y() != null) {
            jsonGenerator.a("share_preview_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7847y(), true);
        }
        if (graphQLGoodwillCampaign.m7848z() != null) {
            jsonGenerator.a("share_preview_story_placeholder");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7848z(), true);
        }
        if (graphQLGoodwillCampaign.m7822A() != null) {
            jsonGenerator.a("share_preview_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7822A(), true);
        }
        if (graphQLGoodwillCampaign.m7823B() != null) {
            jsonGenerator.a("share_status", graphQLGoodwillCampaign.m7823B());
        }
        if (graphQLGoodwillCampaign.m7824C() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7824C(), true);
        }
        if (graphQLGoodwillCampaign.m7825D() != null) {
            jsonGenerator.a("throwback_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7825D(), true);
        }
        if (graphQLGoodwillCampaign.m7826E() != null) {
            jsonGenerator.a("throwback_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillCampaign.m7826E(), true);
        }
        if (graphQLGoodwillCampaign.m7827F() != null) {
            jsonGenerator.a("video_campaign");
            GraphQLGoodwillVideoCampaign__JsonHelper.m8136a(jsonGenerator, graphQLGoodwillCampaign.m7827F(), true);
        }
        jsonGenerator.a("image_overlays");
        if (graphQLGoodwillCampaign.m7828G() != null) {
            jsonGenerator.d();
            for (GraphQLImageOverlay graphQLImageOverlay : graphQLGoodwillCampaign.m7828G()) {
                if (graphQLImageOverlay != null) {
                    GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, graphQLImageOverlay, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
