package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: enable_page_info_for_reply_connection */
public final class GraphQLPagePostPromotionInfo__JsonHelper {
    public static GraphQLPagePostPromotionInfo m9513a(JsonParser jsonParser) {
        GraphQLPagePostPromotionInfo graphQLPagePostPromotionInfo = new GraphQLPagePostPromotionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9515a(graphQLPagePostPromotionInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPagePostPromotionInfo;
    }

    private static boolean m9515a(GraphQLPagePostPromotionInfo graphQLPagePostPromotionInfo, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("ad_account".equals(str)) {
            GraphQLAdAccount a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAdAccount__JsonHelper.m6427a(FieldAccessQueryTracker.a(jsonParser, "ad_account"));
            }
            graphQLPagePostPromotionInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "ad_account", graphQLPagePostPromotionInfo.a_, 0, true);
            return true;
        } else if ("audience_option".equals(str)) {
            graphQLPagePostPromotionInfo.e = GraphQLBoostedPostAudienceOption.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "audience_option", graphQLPagePostPromotionInfo.B_(), 1, false);
            return true;
        } else if ("budget".equals(str)) {
            GraphQLCurrencyQuantity a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "budget"));
            }
            graphQLPagePostPromotionInfo.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "budget", graphQLPagePostPromotionInfo.B_(), 2, true);
            return true;
        } else if ("feed_unit_preview".equals(str)) {
            FeedUnit a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "feed_unit_preview"));
            }
            graphQLPagePostPromotionInfo.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "feed_unit_preview", graphQLPagePostPromotionInfo.B_(), 3, true);
            return true;
        } else if ("has_ad_conversion_pixel_domain".equals(str)) {
            graphQLPagePostPromotionInfo.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "has_ad_conversion_pixel_domain", graphQLPagePostPromotionInfo.B_(), 4, false);
            return true;
        } else if ("ineligible_reason".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPagePostPromotionInfo.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "ineligible_reason", graphQLPagePostPromotionInfo.B_(), 5, false);
            return true;
        } else if ("paid_reach".equals(str)) {
            graphQLPagePostPromotionInfo.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "paid_reach", graphQLPagePostPromotionInfo.B_(), 6, false);
            return true;
        } else if ("promotion_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPagePostPromotionInfo.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "promotion_id", graphQLPagePostPromotionInfo.B_(), 7, false);
            return true;
        } else if ("rejection_reason".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "rejection_reason"));
            }
            graphQLPagePostPromotionInfo.l = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "rejection_reason", graphQLPagePostPromotionInfo.B_(), 8, true);
            return true;
        } else if ("spent".equals(str)) {
            graphQLPagePostPromotionInfo.m = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "spent", graphQLPagePostPromotionInfo.B_(), 9, false);
            return true;
        } else if ("status".equals(str)) {
            graphQLPagePostPromotionInfo.n = GraphQLBoostedPostStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "status", graphQLPagePostPromotionInfo.B_(), 10, false);
            return true;
        } else if (!"stop_time".equals(str)) {
            return false;
        } else {
            graphQLPagePostPromotionInfo.o = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagePostPromotionInfo, "stop_time", graphQLPagePostPromotionInfo.B_(), 11, false);
            return true;
        }
    }

    public static void m9514a(JsonGenerator jsonGenerator, GraphQLPagePostPromotionInfo graphQLPagePostPromotionInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPagePostPromotionInfo.a() != null) {
            jsonGenerator.a("ad_account");
            GraphQLAdAccount__JsonHelper.m6428a(jsonGenerator, graphQLPagePostPromotionInfo.a(), true);
        }
        if (graphQLPagePostPromotionInfo.j() != null) {
            jsonGenerator.a("audience_option", graphQLPagePostPromotionInfo.j().toString());
        }
        if (graphQLPagePostPromotionInfo.k() != null) {
            jsonGenerator.a("budget");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLPagePostPromotionInfo.k(), true);
        }
        if (graphQLPagePostPromotionInfo.l() != null) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLPagePostPromotionInfo.l());
        }
        jsonGenerator.a("has_ad_conversion_pixel_domain", graphQLPagePostPromotionInfo.m());
        if (graphQLPagePostPromotionInfo.n() != null) {
            jsonGenerator.a("ineligible_reason", graphQLPagePostPromotionInfo.n());
        }
        jsonGenerator.a("paid_reach", graphQLPagePostPromotionInfo.o());
        if (graphQLPagePostPromotionInfo.p() != null) {
            jsonGenerator.a("promotion_id", graphQLPagePostPromotionInfo.p());
        }
        if (graphQLPagePostPromotionInfo.q() != null) {
            jsonGenerator.a("rejection_reason");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagePostPromotionInfo.q(), true);
        }
        jsonGenerator.a("spent", graphQLPagePostPromotionInfo.r());
        if (graphQLPagePostPromotionInfo.s() != null) {
            jsonGenerator.a("status", graphQLPagePostPromotionInfo.s().toString());
        }
        jsonGenerator.a("stop_time", graphQLPagePostPromotionInfo.t());
        if (z) {
            jsonGenerator.g();
        }
    }
}
