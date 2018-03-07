package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: isAnonymous= */
public final class GraphQLCoupon__JsonHelper {
    public static GraphQLCoupon m6891a(JsonParser jsonParser) {
        GraphQLCoupon graphQLCoupon = new GraphQLCoupon();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("claim_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLCoupon.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "claim_count", graphQLCoupon.a_, 0, false);
            } else if ("coupon_claim_location".equals(i)) {
                graphQLCoupon.e = GraphQLCouponClaimLocation.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "coupon_claim_location", graphQLCoupon.a_, 1, false);
            } else if ("creation_story".equals(i)) {
                GraphQLStory graphQLStory;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLStory = null;
                } else {
                    graphQLStory = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "creation_story"));
                }
                graphQLCoupon.f = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "creation_story", graphQLCoupon.a_, 2, true);
            } else if ("expiration_date".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLCoupon.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "expiration_date", graphQLCoupon.a_, 3, false);
            } else if ("filtered_claim_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLCoupon.h = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "filtered_claim_count", graphQLCoupon.a_, 4, false);
            } else if ("has_viewer_claimed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLCoupon.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "has_viewer_claimed", graphQLCoupon.a_, 5, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "id", graphQLCoupon.a_, 6, false);
            } else if ("is_active".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLCoupon.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "is_active", graphQLCoupon.a_, 7, false);
            } else if ("is_expired".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLCoupon.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "is_expired", graphQLCoupon.a_, 8, false);
            } else if ("is_stopped".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLCoupon.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "is_stopped", graphQLCoupon.a_, 9, false);
            } else if ("message".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                }
                graphQLCoupon.n = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "message", graphQLCoupon.a_, 10, true);
            } else if ("mobile_post_claim_message".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "mobile_post_claim_message", graphQLCoupon.a_, 11, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "name", graphQLCoupon.a_, 12, false);
            } else if ("owning_page".equals(i)) {
                GraphQLPage graphQLPage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPage = null;
                } else {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "owning_page"));
                }
                graphQLCoupon.q = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "owning_page", graphQLCoupon.a_, 13, true);
            } else if ("photo".equals(i)) {
                GraphQLPhoto graphQLPhoto;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhoto = null;
                } else {
                    graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "photo"));
                }
                graphQLCoupon.r = graphQLPhoto;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "photo", graphQLCoupon.a_, 14, true);
            } else if ("redemption_code".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "redemption_code", graphQLCoupon.a_, 15, false);
            } else if ("redemption_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.t = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "redemption_url", graphQLCoupon.a_, 16, false);
            } else if ("reminder_time".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.F();
                }
                graphQLCoupon.u = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "reminder_time", graphQLCoupon.a_, 17, false);
            } else if ("terms".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.v = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "terms", graphQLCoupon.a_, 18, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLCoupon.w = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCoupon, "url", graphQLCoupon.a_, 19, false);
            }
            jsonParser.f();
        }
        return graphQLCoupon;
    }

    public static void m6892a(JsonGenerator jsonGenerator, GraphQLCoupon graphQLCoupon, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("claim_count", graphQLCoupon.j());
        if (graphQLCoupon.k() != null) {
            jsonGenerator.a("coupon_claim_location", graphQLCoupon.k().toString());
        }
        if (graphQLCoupon.l() != null) {
            jsonGenerator.a("creation_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLCoupon.l(), true);
        }
        jsonGenerator.a("expiration_date", graphQLCoupon.m());
        jsonGenerator.a("filtered_claim_count", graphQLCoupon.n());
        jsonGenerator.a("has_viewer_claimed", graphQLCoupon.o());
        if (graphQLCoupon.p() != null) {
            jsonGenerator.a("id", graphQLCoupon.p());
        }
        jsonGenerator.a("is_active", graphQLCoupon.q());
        jsonGenerator.a("is_expired", graphQLCoupon.r());
        jsonGenerator.a("is_stopped", graphQLCoupon.s());
        if (graphQLCoupon.t() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCoupon.t(), true);
        }
        if (graphQLCoupon.u() != null) {
            jsonGenerator.a("mobile_post_claim_message", graphQLCoupon.u());
        }
        if (graphQLCoupon.v() != null) {
            jsonGenerator.a("name", graphQLCoupon.v());
        }
        if (graphQLCoupon.w() != null) {
            jsonGenerator.a("owning_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLCoupon.w(), true);
        }
        if (graphQLCoupon.x() != null) {
            jsonGenerator.a("photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLCoupon.x(), true);
        }
        if (graphQLCoupon.y() != null) {
            jsonGenerator.a("redemption_code", graphQLCoupon.y());
        }
        if (graphQLCoupon.z() != null) {
            jsonGenerator.a("redemption_url", graphQLCoupon.z());
        }
        jsonGenerator.a("reminder_time", graphQLCoupon.A());
        if (graphQLCoupon.B() != null) {
            jsonGenerator.a("terms", graphQLCoupon.B());
        }
        if (graphQLCoupon.C() != null) {
            jsonGenerator.a("url", graphQLCoupon.C());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
