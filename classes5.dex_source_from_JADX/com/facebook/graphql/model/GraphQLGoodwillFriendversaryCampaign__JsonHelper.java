package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: graph_search_feedback */
public final class GraphQLGoodwillFriendversaryCampaign__JsonHelper {
    public static GraphQLGoodwillFriendversaryCampaign m7881a(JsonParser jsonParser) {
        GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = new GraphQLGoodwillFriendversaryCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7883a(graphQLGoodwillFriendversaryCampaign, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGoodwillFriendversaryCampaign;
    }

    private static boolean m7883a(GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign, String str, JsonParser jsonParser) {
        GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillFriendversaryCampaign.f3903d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("data_points".equals(str)) {
            GraphQLGoodwillThrowbackDataPointsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7940a(FieldAccessQueryTracker.a(jsonParser, "data_points"));
            }
            graphQLGoodwillFriendversaryCampaign.f3904e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "data_points", graphQLGoodwillFriendversaryCampaign.a_, 0, true);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGoodwillFriendversaryCampaign.f3905f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "fetchTimeMs", graphQLGoodwillFriendversaryCampaign.B_(), 1, false);
            return true;
        } else if ("friend".equals(str)) {
            GraphQLUser a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "friend"));
            }
            graphQLGoodwillFriendversaryCampaign.f3906g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "friend", graphQLGoodwillFriendversaryCampaign.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillFriendversaryCampaign.f3907h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "id", graphQLGoodwillFriendversaryCampaign.B_(), 3, false);
            return true;
        } else if ("media_set".equals(str)) {
            GraphQLMediaSet a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLMediaSet__JsonHelper.m9076a(FieldAccessQueryTracker.a(jsonParser, "media_set"));
            }
            graphQLGoodwillFriendversaryCampaign.f3908i = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "media_set", graphQLGoodwillFriendversaryCampaign.B_(), 4, true);
            return true;
        } else if ("photo_attachments".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryAttachment a4 = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "photo_attachments"));
                    if (a4 != null) {
                        arrayList.add(a4);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGoodwillFriendversaryCampaign.f3909j = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "photo_attachments", graphQLGoodwillFriendversaryCampaign.B_(), 5, true);
            return true;
        } else if ("share_message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_message"));
            }
            graphQLGoodwillFriendversaryCampaign.f3910k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "share_message", graphQLGoodwillFriendversaryCampaign.B_(), 6, true);
            return true;
        } else if ("share_preview_story_placeholder".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_story_placeholder"));
            }
            graphQLGoodwillFriendversaryCampaign.f3911l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "share_preview_story_placeholder", graphQLGoodwillFriendversaryCampaign.B_(), 7, true);
            return true;
        } else if ("share_preview_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_title"));
            }
            graphQLGoodwillFriendversaryCampaign.f3912m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "share_preview_title", graphQLGoodwillFriendversaryCampaign.B_(), 8, true);
            return true;
        } else if ("share_status".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillFriendversaryCampaign.f3913n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "share_status", graphQLGoodwillFriendversaryCampaign.B_(), 9, false);
            return true;
        } else if ("throwback_accent_image".equals(str)) {
            GraphQLImage a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "throwback_accent_image"));
            }
            graphQLGoodwillFriendversaryCampaign.f3914o = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "throwback_accent_image", graphQLGoodwillFriendversaryCampaign.B_(), 10, true);
            return true;
        } else if ("throwback_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "throwback_subtitle"));
            }
            graphQLGoodwillFriendversaryCampaign.f3915p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "throwback_subtitle", graphQLGoodwillFriendversaryCampaign.B_(), 11, true);
            return true;
        } else if ("throwback_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "throwback_title"));
            }
            graphQLGoodwillFriendversaryCampaign.f3916q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "throwback_title", graphQLGoodwillFriendversaryCampaign.B_(), 12, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillFriendversaryCampaign.f3917r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "url", graphQLGoodwillFriendversaryCampaign.B_(), 13, false);
            return true;
        } else if (!"video_campaign".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLGoodwillVideoCampaign = GraphQLGoodwillVideoCampaign__JsonHelper.m8135a(FieldAccessQueryTracker.a(jsonParser, "video_campaign"));
            }
            graphQLGoodwillFriendversaryCampaign.f3918s = graphQLGoodwillVideoCampaign;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillFriendversaryCampaign, "video_campaign", graphQLGoodwillFriendversaryCampaign.B_(), 14, true);
            return true;
        }
    }

    public static void m7882a(JsonGenerator jsonGenerator, GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillFriendversaryCampaign.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillFriendversaryCampaign.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillFriendversaryCampaign.m7865k() != null) {
            jsonGenerator.a("data_points");
            GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7941a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7865k(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillFriendversaryCampaign.T_());
        if (graphQLGoodwillFriendversaryCampaign.m7866l() != null) {
            jsonGenerator.a("friend");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7866l(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7867m() != null) {
            jsonGenerator.a("id", graphQLGoodwillFriendversaryCampaign.m7867m());
        }
        if (graphQLGoodwillFriendversaryCampaign.m7868n() != null) {
            jsonGenerator.a("media_set");
            GraphQLMediaSet__JsonHelper.m9077a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7868n(), true);
        }
        jsonGenerator.a("photo_attachments");
        if (graphQLGoodwillFriendversaryCampaign.m7869o() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillFriendversaryCampaign.m7869o()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillFriendversaryCampaign.m7870p() != null) {
            jsonGenerator.a("share_message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7870p(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7871q() != null) {
            jsonGenerator.a("share_preview_story_placeholder");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7871q(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7872r() != null) {
            jsonGenerator.a("share_preview_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7872r(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7873s() != null) {
            jsonGenerator.a("share_status", graphQLGoodwillFriendversaryCampaign.m7873s());
        }
        if (graphQLGoodwillFriendversaryCampaign.m7874t() != null) {
            jsonGenerator.a("throwback_accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7874t(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7875u() != null) {
            jsonGenerator.a("throwback_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7875u(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7876v() != null) {
            jsonGenerator.a("throwback_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7876v(), true);
        }
        if (graphQLGoodwillFriendversaryCampaign.m7877w() != null) {
            jsonGenerator.a("url", graphQLGoodwillFriendversaryCampaign.m7877w());
        }
        if (graphQLGoodwillFriendversaryCampaign.m7878x() != null) {
            jsonGenerator.a("video_campaign");
            GraphQLGoodwillVideoCampaign__JsonHelper.m8136a(jsonGenerator, graphQLGoodwillFriendversaryCampaign.m7878x(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
