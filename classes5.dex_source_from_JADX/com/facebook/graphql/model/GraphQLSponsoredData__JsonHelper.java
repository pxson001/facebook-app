package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unnecessary ViewGroup */
public final class GraphQLSponsoredData__JsonHelper {
    public static GraphQLSponsoredData m21756a(JsonParser jsonParser) {
        GraphQLSponsoredData graphQLSponsoredData = new GraphQLSponsoredData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("client_token".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSponsoredData.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "client_token", graphQLSponsoredData.a_, 0, false);
            } else if ("impression_logging_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSponsoredData.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "impression_logging_url", graphQLSponsoredData.a_, 1, false);
            } else if ("is_demo_ad".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "is_demo_ad", graphQLSponsoredData.a_, 2, false);
            } else if ("is_eligible_for_invalidation".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "is_eligible_for_invalidation", graphQLSponsoredData.a_, 3, false);
            } else if ("is_non_connected_page_post".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "is_non_connected_page_post", graphQLSponsoredData.a_, 4, false);
            } else if ("min_sponsored_gap".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLSponsoredData.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "min_sponsored_gap", graphQLSponsoredData.a_, 5, false);
            } else if ("should_log_full_view".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "should_log_full_view", graphQLSponsoredData.a_, 6, false);
            } else if ("show_ad_preferences".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "show_ad_preferences", graphQLSponsoredData.a_, 7, false);
            } else if ("show_sponsored_label".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "show_sponsored_label", graphQLSponsoredData.a_, 8, false);
            } else if ("third_party_click_tracking_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSponsoredData.m = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "third_party_click_tracking_url", graphQLSponsoredData.a_, 9, false);
            } else if ("third_party_impression_logging_needed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "third_party_impression_logging_needed", graphQLSponsoredData.a_, 10, false);
            } else if ("user".equals(i)) {
                GraphQLUser graphQLUser;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLUser = null;
                } else {
                    graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "user"));
                }
                graphQLSponsoredData.o = graphQLUser;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "user", graphQLSponsoredData.a_, 11, true);
            } else if ("uses_remarketing".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "uses_remarketing", graphQLSponsoredData.a_, 12, false);
            } else if ("viewability_duration".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLSponsoredData.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "viewability_duration", graphQLSponsoredData.a_, 13, false);
            } else if ("viewability_percentage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLSponsoredData.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "viewability_percentage", graphQLSponsoredData.a_, 14, false);
            } else if ("is_group_mall_ad".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSponsoredData.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSponsoredData, "is_group_mall_ad", graphQLSponsoredData.a_, 15, false);
            }
            jsonParser.f();
        }
        return graphQLSponsoredData;
    }

    public static void m21757a(JsonGenerator jsonGenerator, GraphQLSponsoredData graphQLSponsoredData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSponsoredData.l() != null) {
            jsonGenerator.a("client_token", graphQLSponsoredData.l());
        }
        if (graphQLSponsoredData.a() != null) {
            jsonGenerator.a("impression_logging_url", graphQLSponsoredData.a());
        }
        jsonGenerator.a("is_demo_ad", graphQLSponsoredData.b());
        jsonGenerator.a("is_eligible_for_invalidation", graphQLSponsoredData.c());
        jsonGenerator.a("is_non_connected_page_post", graphQLSponsoredData.m());
        jsonGenerator.a("min_sponsored_gap", graphQLSponsoredData.d());
        jsonGenerator.a("should_log_full_view", graphQLSponsoredData.K_());
        jsonGenerator.a("show_ad_preferences", graphQLSponsoredData.g());
        jsonGenerator.a("show_sponsored_label", graphQLSponsoredData.n());
        if (graphQLSponsoredData.o() != null) {
            jsonGenerator.a("third_party_click_tracking_url", graphQLSponsoredData.o());
        }
        jsonGenerator.a("third_party_impression_logging_needed", graphQLSponsoredData.L_());
        if (graphQLSponsoredData.p() != null) {
            jsonGenerator.a("user");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLSponsoredData.p(), true);
        }
        jsonGenerator.a("uses_remarketing", graphQLSponsoredData.M_());
        jsonGenerator.a("viewability_duration", graphQLSponsoredData.j());
        jsonGenerator.a("viewability_percentage", graphQLSponsoredData.k());
        jsonGenerator.a("is_group_mall_ad", graphQLSponsoredData.q());
        if (z) {
            jsonGenerator.g();
        }
    }
}
