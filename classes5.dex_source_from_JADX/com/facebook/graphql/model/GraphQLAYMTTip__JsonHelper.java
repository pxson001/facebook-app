package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: launch_point_home_pyml */
public final class GraphQLAYMTTip__JsonHelper {
    public static GraphQLAYMTTip m6387a(JsonParser jsonParser) {
        GraphQLAYMTTip graphQLAYMTTip = new GraphQLAYMTTip();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("action_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3261d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "action_text", graphQLAYMTTip.a_, 0, false);
            } else if ("action_uri".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3262e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "action_uri", graphQLAYMTTip.a_, 1, false);
            } else if ("body_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3263f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "body_text", graphQLAYMTTip.a_, 2, false);
            } else if ("image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                }
                graphQLAYMTTip.f3264g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "image", graphQLAYMTTip.a_, 3, true);
            } else if ("native_action_name".equals(i)) {
                graphQLAYMTTip.f3265h = GraphQLAYMTNativeAction.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "native_action_name", graphQLAYMTTip.a_, 4, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3266i = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "id", graphQLAYMTTip.a_, 5, false);
            } else if ("title_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3267j = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "title_text", graphQLAYMTTip.a_, 6, false);
            } else if ("image_uri".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3268k = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "image_uri", graphQLAYMTTip.a_, 7, false);
            } else if ("is_dismissible".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLAYMTTip.f3269l = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "is_dismissible", graphQLAYMTTip.a_, 8, false);
            } else if ("secondary_action_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3270m = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "secondary_action_text", graphQLAYMTTip.a_, 9, false);
            } else if ("secondary_action_uri".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAYMTTip.f3271n = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLAYMTTip, "secondary_action_uri", graphQLAYMTTip.a_, 10, false);
            }
            jsonParser.f();
        }
        return graphQLAYMTTip;
    }

    public static void m6388a(JsonGenerator jsonGenerator, GraphQLAYMTTip graphQLAYMTTip, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAYMTTip.m6374j() != null) {
            jsonGenerator.a("action_text", graphQLAYMTTip.m6374j());
        }
        if (graphQLAYMTTip.m6375k() != null) {
            jsonGenerator.a("action_uri", graphQLAYMTTip.m6375k());
        }
        if (graphQLAYMTTip.m6376l() != null) {
            jsonGenerator.a("body_text", graphQLAYMTTip.m6376l());
        }
        if (graphQLAYMTTip.m6377m() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLAYMTTip.m6377m(), true);
        }
        if (graphQLAYMTTip.m6378n() != null) {
            jsonGenerator.a("native_action_name", graphQLAYMTTip.m6378n().toString());
        }
        if (graphQLAYMTTip.m6379o() != null) {
            jsonGenerator.a("id", graphQLAYMTTip.m6379o());
        }
        if (graphQLAYMTTip.m6380p() != null) {
            jsonGenerator.a("title_text", graphQLAYMTTip.m6380p());
        }
        if (graphQLAYMTTip.m6381q() != null) {
            jsonGenerator.a("image_uri", graphQLAYMTTip.m6381q());
        }
        jsonGenerator.a("is_dismissible", graphQLAYMTTip.m6382r());
        if (graphQLAYMTTip.m6383s() != null) {
            jsonGenerator.a("secondary_action_text", graphQLAYMTTip.m6383s());
        }
        if (graphQLAYMTTip.m6384t() != null) {
            jsonGenerator.a("secondary_action_uri", graphQLAYMTTip.m6384t());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
