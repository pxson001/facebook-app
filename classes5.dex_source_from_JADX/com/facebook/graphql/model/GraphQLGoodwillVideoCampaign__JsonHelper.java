package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGoodwillVideoCampaignTypeEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: getHandle */
public final class GraphQLGoodwillVideoCampaign__JsonHelper {
    public static GraphQLGoodwillVideoCampaign m8135a(JsonParser jsonParser) {
        GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = new GraphQLGoodwillVideoCampaign();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGoodwillVideoCampaign.f4038d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "id", graphQLGoodwillVideoCampaign.a_, 0, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGoodwillVideoCampaign.f4039e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "url", graphQLGoodwillVideoCampaign.a_, 1, false);
            } else if ("video_attachments".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLStoryAttachment a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "video_attachments"));
                        if (a != null) {
                            r3.add(a);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLGoodwillVideoCampaign.f4040f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "video_attachments", graphQLGoodwillVideoCampaign.a_, 2, true);
            } else if ("campaign_type".equals(i)) {
                graphQLGoodwillVideoCampaign.f4041g = GraphQLGoodwillVideoCampaignTypeEnum.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "campaign_type", graphQLGoodwillVideoCampaign.a_, 3, false);
            } else if ("direct_share_preview_image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "direct_share_preview_image"));
                }
                graphQLGoodwillVideoCampaign.f4042h = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "direct_share_preview_image", graphQLGoodwillVideoCampaign.a_, 5, true);
            } else if ("target_users".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "target_users"));
                        if (a2 != null) {
                            r3.add(a2);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLGoodwillVideoCampaign.f4043i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "target_users", graphQLGoodwillVideoCampaign.a_, 6, true);
            } else if ("video_share_default_message".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGoodwillVideoCampaign.f4044j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "video_share_default_message", graphQLGoodwillVideoCampaign.a_, 7, false);
            } else if ("video_share_prompt_message".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGoodwillVideoCampaign.f4045k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "video_share_prompt_message", graphQLGoodwillVideoCampaign.a_, 8, false);
            } else if ("video_share_preview_title".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGoodwillVideoCampaign.f4046l = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillVideoCampaign, "video_share_preview_title", graphQLGoodwillVideoCampaign.a_, 9, false);
            }
            jsonParser.f();
        }
        return graphQLGoodwillVideoCampaign;
    }

    public static void m8136a(JsonGenerator jsonGenerator, GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillVideoCampaign.m8124j() != null) {
            jsonGenerator.a("id", graphQLGoodwillVideoCampaign.m8124j());
        }
        if (graphQLGoodwillVideoCampaign.m8125k() != null) {
            jsonGenerator.a("url", graphQLGoodwillVideoCampaign.m8125k());
        }
        jsonGenerator.a("video_attachments");
        if (graphQLGoodwillVideoCampaign.m8126l() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillVideoCampaign.m8126l()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillVideoCampaign.m8127m() != null) {
            jsonGenerator.a("campaign_type", graphQLGoodwillVideoCampaign.m8127m().toString());
        }
        if (graphQLGoodwillVideoCampaign.m8128n() != null) {
            jsonGenerator.a("direct_share_preview_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillVideoCampaign.m8128n(), true);
        }
        jsonGenerator.a("target_users");
        if (graphQLGoodwillVideoCampaign.m8129o() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGoodwillVideoCampaign.m8129o()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillVideoCampaign.m8130p() != null) {
            jsonGenerator.a("video_share_default_message", graphQLGoodwillVideoCampaign.m8130p());
        }
        if (graphQLGoodwillVideoCampaign.m8131q() != null) {
            jsonGenerator.a("video_share_prompt_message", graphQLGoodwillVideoCampaign.m8131q());
        }
        if (graphQLGoodwillVideoCampaign.m8132r() != null) {
            jsonGenerator.a("video_share_preview_title", graphQLGoodwillVideoCampaign.m8132r());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
