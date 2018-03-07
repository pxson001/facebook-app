package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_PAGE_SERVICE */
public final class GraphQLQuickPromotionCreative__JsonHelper {
    public static GraphQLQuickPromotionCreative m21230a(JsonParser jsonParser) {
        GraphQLQuickPromotionCreative graphQLQuickPromotionCreative = new GraphQLQuickPromotionCreative();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("attachment".equals(i)) {
                GraphQLStoryAttachment a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "attachment"));
                }
                graphQLQuickPromotionCreative.f12849d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "attachment", graphQLQuickPromotionCreative.a_, 0, true);
            } else if ("branding_image".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "branding_image"));
                }
                graphQLQuickPromotionCreative.f12850e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "branding_image", graphQLQuickPromotionCreative.a_, 1, true);
            } else if ("content".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "content"));
                }
                graphQLQuickPromotionCreative.f12851f = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "content", graphQLQuickPromotionCreative.a_, 2, true);
            } else if ("dismiss_action".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLQuickPromotionAction__JsonHelper.m21210a(FieldAccessQueryTracker.a(jsonParser, "dismiss_action"));
                }
                graphQLQuickPromotionCreative.f12852g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "dismiss_action", graphQLQuickPromotionCreative.a_, 3, true);
            } else if ("footer".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "footer"));
                }
                graphQLQuickPromotionCreative.f12853h = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "footer", graphQLQuickPromotionCreative.a_, 4, true);
            } else if ("image".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLQuickPromotionCreative.f12854i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "image", graphQLQuickPromotionCreative.a_, 5, true);
            } else if ("largeImage".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "largeImage"));
                }
                graphQLQuickPromotionCreative.f12855j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "largeImage", graphQLQuickPromotionCreative.a_, 6, true);
            } else if ("primary_action".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLQuickPromotionAction__JsonHelper.m21210a(FieldAccessQueryTracker.a(jsonParser, "primary_action"));
                }
                graphQLQuickPromotionCreative.f12856k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "primary_action", graphQLQuickPromotionCreative.a_, 7, true);
            } else if ("secondary_action".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLQuickPromotionAction__JsonHelper.m21210a(FieldAccessQueryTracker.a(jsonParser, "secondary_action"));
                }
                graphQLQuickPromotionCreative.f12857l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "secondary_action", graphQLQuickPromotionCreative.a_, 8, true);
            } else if ("social_context".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
                }
                graphQLQuickPromotionCreative.f12858m = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "social_context", graphQLQuickPromotionCreative.a_, 9, true);
            } else if ("title".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                }
                graphQLQuickPromotionCreative.f12859n = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionCreative, "title", graphQLQuickPromotionCreative.a_, 11, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLQuickPromotionCreative;
    }

    public static void m21231a(JsonGenerator jsonGenerator, GraphQLQuickPromotionCreative graphQLQuickPromotionCreative, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionCreative.m21216a() != null) {
            jsonGenerator.a("attachment");
            GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLQuickPromotionCreative.m21216a(), true);
        }
        if (graphQLQuickPromotionCreative.m21218j() != null) {
            jsonGenerator.a("branding_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21218j(), true);
        }
        if (graphQLQuickPromotionCreative.m21219k() != null) {
            jsonGenerator.a("content");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21219k(), true);
        }
        if (graphQLQuickPromotionCreative.m21220l() != null) {
            jsonGenerator.a("dismiss_action");
            GraphQLQuickPromotionAction__JsonHelper.m21211a(jsonGenerator, graphQLQuickPromotionCreative.m21220l(), true);
        }
        if (graphQLQuickPromotionCreative.m21221m() != null) {
            jsonGenerator.a("footer");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21221m(), true);
        }
        if (graphQLQuickPromotionCreative.m21222n() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21222n(), true);
        }
        if (graphQLQuickPromotionCreative.m21223o() != null) {
            jsonGenerator.a("largeImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21223o(), true);
        }
        if (graphQLQuickPromotionCreative.m21224p() != null) {
            jsonGenerator.a("primary_action");
            GraphQLQuickPromotionAction__JsonHelper.m21211a(jsonGenerator, graphQLQuickPromotionCreative.m21224p(), true);
        }
        if (graphQLQuickPromotionCreative.m21225q() != null) {
            jsonGenerator.a("secondary_action");
            GraphQLQuickPromotionAction__JsonHelper.m21211a(jsonGenerator, graphQLQuickPromotionCreative.m21225q(), true);
        }
        if (graphQLQuickPromotionCreative.m21226r() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21226r(), true);
        }
        if (graphQLQuickPromotionCreative.m21227s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionCreative.m21227s(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
