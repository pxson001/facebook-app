package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_PAGE_EVENTS */
public final class GraphQLQuickPromotionFeedUnitItem__JsonHelper {
    public static GraphQLQuickPromotionFeedUnitItem m21247a(JsonParser jsonParser) {
        GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem = new GraphQLQuickPromotionFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21249a(graphQLQuickPromotionFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLQuickPromotionFeedUnitItem;
    }

    private static boolean m21249a(GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLQuickPromotionFeedUnitItem.f12860d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnitItem, "hideable_token", graphQLQuickPromotionFeedUnitItem.a_, 0, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLQuickPromotionFeedUnitItem.f12861e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnitItem, "negative_feedback_actions", graphQLQuickPromotionFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLProfile a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLQuickPromotionFeedUnitItem.f12862f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnitItem, "profile", graphQLQuickPromotionFeedUnitItem.B_(), 2, true);
            return true;
        } else if ("quick_promotion".equals(str)) {
            GraphQLQuickPromotion a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLQuickPromotion__JsonHelper.m21266a(FieldAccessQueryTracker.a(jsonParser, "quick_promotion"));
            }
            graphQLQuickPromotionFeedUnitItem.f12863g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnitItem, "quick_promotion", graphQLQuickPromotionFeedUnitItem.B_(), 3, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLQuickPromotionFeedUnitItem.f12864h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnitItem, "tracking", graphQLQuickPromotionFeedUnitItem.B_(), 4, false);
            return true;
        }
    }

    public static void m21248a(JsonGenerator jsonGenerator, GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionFeedUnitItem.m21240a() != null) {
            jsonGenerator.a("hideable_token", graphQLQuickPromotionFeedUnitItem.m21240a());
        }
        if (graphQLQuickPromotionFeedUnitItem.m21241j() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLQuickPromotionFeedUnitItem.m21241j(), true);
        }
        if (graphQLQuickPromotionFeedUnitItem.m21242k() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLQuickPromotionFeedUnitItem.m21242k(), true);
        }
        if (graphQLQuickPromotionFeedUnitItem.m21243l() != null) {
            jsonGenerator.a("quick_promotion");
            GraphQLQuickPromotion__JsonHelper.m21267a(jsonGenerator, graphQLQuickPromotionFeedUnitItem.m21243l(), true);
        }
        if (graphQLQuickPromotionFeedUnitItem.m21244m() != null) {
            jsonGenerator.a("tracking", graphQLQuickPromotionFeedUnitItem.m21244m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
