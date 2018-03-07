package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: endpoint */
public final class GraphQLPageCallToAction__JsonHelper {
    public static GraphQLPageCallToAction m9484a(JsonParser jsonParser) {
        GraphQLPageCallToAction graphQLPageCallToAction = new GraphQLPageCallToAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("ads_cta_type".equals(i)) {
                graphQLPageCallToAction.d = GraphQLCallToActionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "ads_cta_type", graphQLPageCallToAction.a_, 0, false);
            } else if ("android_deep_link".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "android_deep_link", graphQLPageCallToAction.a_, 1, false);
            } else if ("android_package_name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "android_package_name", graphQLPageCallToAction.a_, 2, false);
            } else if ("application".equals(i)) {
                GraphQLApplication graphQLApplication;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLApplication = null;
                } else {
                    graphQLApplication = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
                }
                graphQLPageCallToAction.g = graphQLApplication;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "application", graphQLPageCallToAction.a_, 3, true);
            } else if ("cta_type".equals(i)) {
                graphQLPageCallToAction.h = GraphQLPageCallToActionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "cta_type", graphQLPageCallToAction.a_, 4, false);
            } else if ("desktop_uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "desktop_uri", graphQLPageCallToAction.a_, 5, false);
            } else if ("email_address".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "email_address", graphQLPageCallToAction.a_, 6, false);
            } else if ("fallback_uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "fallback_uri", graphQLPageCallToAction.a_, 7, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "id", graphQLPageCallToAction.a_, 8, false);
            } else if ("is_first_party".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLPageCallToAction.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "is_first_party", graphQLPageCallToAction.a_, 9, false);
            } else if ("label".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "label", graphQLPageCallToAction.a_, 10, false);
            } else if ("phone_number".equals(i)) {
                GraphQLPhoneNumber graphQLPhoneNumber;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPhoneNumber = null;
                } else {
                    graphQLPhoneNumber = GraphQLPhoneNumber__JsonHelper.m20713a(FieldAccessQueryTracker.a(jsonParser, "phone_number"));
                }
                graphQLPageCallToAction.o = graphQLPhoneNumber;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "phone_number", graphQLPageCallToAction.a_, 11, true);
            } else if ("status".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "status", graphQLPageCallToAction.a_, 12, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageCallToAction.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "url", graphQLPageCallToAction.a_, 13, false);
            } else if ("autofill_enabled_on_fallback".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLPageCallToAction.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageCallToAction, "autofill_enabled_on_fallback", graphQLPageCallToAction.a_, 14, false);
            }
            jsonParser.f();
        }
        return graphQLPageCallToAction;
    }

    public static void m9485a(JsonGenerator jsonGenerator, GraphQLPageCallToAction graphQLPageCallToAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageCallToAction.j() != null) {
            jsonGenerator.a("ads_cta_type", graphQLPageCallToAction.j().toString());
        }
        if (graphQLPageCallToAction.k() != null) {
            jsonGenerator.a("android_deep_link", graphQLPageCallToAction.k());
        }
        if (graphQLPageCallToAction.l() != null) {
            jsonGenerator.a("android_package_name", graphQLPageCallToAction.l());
        }
        if (graphQLPageCallToAction.m() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLPageCallToAction.m(), true);
        }
        if (graphQLPageCallToAction.n() != null) {
            jsonGenerator.a("cta_type", graphQLPageCallToAction.n().toString());
        }
        if (graphQLPageCallToAction.o() != null) {
            jsonGenerator.a("desktop_uri", graphQLPageCallToAction.o());
        }
        if (graphQLPageCallToAction.p() != null) {
            jsonGenerator.a("email_address", graphQLPageCallToAction.p());
        }
        if (graphQLPageCallToAction.q() != null) {
            jsonGenerator.a("fallback_uri", graphQLPageCallToAction.q());
        }
        if (graphQLPageCallToAction.r() != null) {
            jsonGenerator.a("id", graphQLPageCallToAction.r());
        }
        jsonGenerator.a("is_first_party", graphQLPageCallToAction.s());
        if (graphQLPageCallToAction.t() != null) {
            jsonGenerator.a("label", graphQLPageCallToAction.t());
        }
        if (graphQLPageCallToAction.u() != null) {
            jsonGenerator.a("phone_number");
            GraphQLPhoneNumber__JsonHelper.m20714a(jsonGenerator, graphQLPageCallToAction.u(), true);
        }
        if (graphQLPageCallToAction.v() != null) {
            jsonGenerator.a("status", graphQLPageCallToAction.v());
        }
        if (graphQLPageCallToAction.w() != null) {
            jsonGenerator.a("url", graphQLPageCallToAction.w());
        }
        jsonGenerator.a("autofill_enabled_on_fallback", graphQLPageCallToAction.x());
        if (z) {
            jsonGenerator.g();
        }
    }
}
