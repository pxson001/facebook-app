package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: group_commerce_map */
public final class GraphQLGoodwillAnniversaryCampaign__JsonHelper {
    public static GraphQLGoodwillAnniversaryCampaign m7794a(JsonParser jsonParser) {
        GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign = new GraphQLGoodwillAnniversaryCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7796a(graphQLGoodwillAnniversaryCampaign, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGoodwillAnniversaryCampaign;
    }

    private static boolean m7796a(GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign, String str, JsonParser jsonParser) {
        String str2 = null;
        Collection arrayList;
        GraphQLStoryAttachment a;
        List copyOf;
        if ("featured_video_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "featured_video_attachments"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGoodwillAnniversaryCampaign.f3852d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "featured_video_attachments", graphQLGoodwillAnniversaryCampaign.a_, 0, true);
            return true;
        } else if ("feed_promotion_call_to_action".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_call_to_action"));
            }
            graphQLGoodwillAnniversaryCampaign.f3853e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "feed_promotion_call_to_action", graphQLGoodwillAnniversaryCampaign.B_(), 1, true);
            return true;
        } else if ("feed_promotion_favicon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_favicon"));
            }
            graphQLGoodwillAnniversaryCampaign.f3854f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "feed_promotion_favicon", graphQLGoodwillAnniversaryCampaign.B_(), 2, true);
            return true;
        } else if ("feed_promotion_icon_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_icon_image"));
            }
            graphQLGoodwillAnniversaryCampaign.f3855g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "feed_promotion_icon_image", graphQLGoodwillAnniversaryCampaign.B_(), 3, true);
            return true;
        } else if ("feed_promotion_privacy_notice".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_privacy_notice"));
            }
            graphQLGoodwillAnniversaryCampaign.f3856h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "feed_promotion_privacy_notice", graphQLGoodwillAnniversaryCampaign.B_(), 4, true);
            return true;
        } else if ("feed_promotion_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feed_promotion_title"));
            }
            graphQLGoodwillAnniversaryCampaign.f3857i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "feed_promotion_title", graphQLGoodwillAnniversaryCampaign.B_(), 5, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaign.f3858j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "id", graphQLGoodwillAnniversaryCampaign.B_(), 6, false);
            return true;
        } else if ("media_set".equals(str)) {
            GraphQLMediaSet a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLMediaSet__JsonHelper.m9076a(FieldAccessQueryTracker.a(jsonParser, "media_set"));
            }
            graphQLGoodwillAnniversaryCampaign.f3859k = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "media_set", graphQLGoodwillAnniversaryCampaign.B_(), 7, true);
            return true;
        } else if ("photo_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "photo_attachments"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGoodwillAnniversaryCampaign.f3860l = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "photo_attachments", graphQLGoodwillAnniversaryCampaign.B_(), 8, true);
            return true;
        } else if ("relationship_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "relationship_context"));
            }
            graphQLGoodwillAnniversaryCampaign.f3861m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "relationship_context", graphQLGoodwillAnniversaryCampaign.B_(), 9, true);
            return true;
        } else if ("share_preview_icon_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_icon_image"));
            }
            graphQLGoodwillAnniversaryCampaign.f3862n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "share_preview_icon_image", graphQLGoodwillAnniversaryCampaign.B_(), 10, true);
            return true;
        } else if ("share_preview_story_placeholder".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_story_placeholder"));
            }
            graphQLGoodwillAnniversaryCampaign.f3863o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "share_preview_story_placeholder", graphQLGoodwillAnniversaryCampaign.B_(), 11, true);
            return true;
        } else if ("share_preview_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "share_preview_title"));
            }
            graphQLGoodwillAnniversaryCampaign.f3864p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "share_preview_title", graphQLGoodwillAnniversaryCampaign.B_(), 12, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillAnniversaryCampaign.f3865q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillAnniversaryCampaign, "url", graphQLGoodwillAnniversaryCampaign.B_(), 13, false);
            return true;
        }
    }

    public static void m7795a(JsonGenerator jsonGenerator, GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("featured_video_attachments");
        if (graphQLGoodwillAnniversaryCampaign.m7773j() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillAnniversaryCampaign.m7773j()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillAnniversaryCampaign.m7774k() != null) {
            jsonGenerator.a("feed_promotion_call_to_action");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7774k(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7775l() != null) {
            jsonGenerator.a("feed_promotion_favicon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7775l(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7776m() != null) {
            jsonGenerator.a("feed_promotion_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7776m(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7777n() != null) {
            jsonGenerator.a("feed_promotion_privacy_notice");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7777n(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7778o() != null) {
            jsonGenerator.a("feed_promotion_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7778o(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7779p() != null) {
            jsonGenerator.a("id", graphQLGoodwillAnniversaryCampaign.m7779p());
        }
        if (graphQLGoodwillAnniversaryCampaign.m7780q() != null) {
            jsonGenerator.a("media_set");
            GraphQLMediaSet__JsonHelper.m9077a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7780q(), true);
        }
        jsonGenerator.a("photo_attachments");
        if (graphQLGoodwillAnniversaryCampaign.m7781r() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment2 : graphQLGoodwillAnniversaryCampaign.m7781r()) {
                if (graphQLStoryAttachment2 != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillAnniversaryCampaign.m7782s() != null) {
            jsonGenerator.a("relationship_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7782s(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7783t() != null) {
            jsonGenerator.a("share_preview_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7783t(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7784u() != null) {
            jsonGenerator.a("share_preview_story_placeholder");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7784u(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7785v() != null) {
            jsonGenerator.a("share_preview_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillAnniversaryCampaign.m7785v(), true);
        }
        if (graphQLGoodwillAnniversaryCampaign.m7786w() != null) {
            jsonGenerator.a("url", graphQLGoodwillAnniversaryCampaign.m7786w());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
