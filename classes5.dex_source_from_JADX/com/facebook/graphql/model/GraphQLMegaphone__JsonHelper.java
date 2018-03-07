package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: facts */
public final class GraphQLMegaphone__JsonHelper {
    public static GraphQLMegaphone m9105a(JsonParser jsonParser) {
        GraphQLMegaphone graphQLMegaphone = new GraphQLMegaphone();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9107a(graphQLMegaphone, i, jsonParser);
            jsonParser.f();
        }
        return graphQLMegaphone;
    }

    private static boolean m9107a(GraphQLMegaphone graphQLMegaphone, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("action".equals(str)) {
            GraphQLMegaphoneAction a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLMegaphoneAction__JsonHelper.m9101a(FieldAccessQueryTracker.a(jsonParser, "action"));
            }
            graphQLMegaphone.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "action", graphQLMegaphone.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "cache_id", graphQLMegaphone.B_(), 1, false);
            return true;
        } else if ("close_label".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "close_label", graphQLMegaphone.B_(), 2, false);
            return true;
        } else if ("content".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "content"));
            }
            graphQLMegaphone.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "content", graphQLMegaphone.B_(), 3, true);
            return true;
        } else if ("image".equals(str)) {
            GraphQLImage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLMegaphone.h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "image", graphQLMegaphone.B_(), 4, true);
            return true;
        } else if ("image_action".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "image_action", graphQLMegaphone.B_(), 5, false);
            return true;
        } else if ("is_persistent".equals(str)) {
            graphQLMegaphone.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "is_persistent", graphQLMegaphone.B_(), 6, false);
            return true;
        } else if ("location".equals(str)) {
            graphQLMegaphone.k = GraphQLMegaphoneLocation.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "location", graphQLMegaphone.B_(), 7, false);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLMegaphone.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "social_context", graphQLMegaphone.B_(), 8, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "title", graphQLMegaphone.B_(), 9, false);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "tracking", graphQLMegaphone.B_(), 10, false);
            return true;
        } else if (!"ui_version".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMegaphone.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMegaphone, "ui_version", graphQLMegaphone.B_(), 11, false);
            return true;
        }
    }

    public static void m9106a(JsonGenerator jsonGenerator, GraphQLMegaphone graphQLMegaphone, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMegaphone.j() != null) {
            jsonGenerator.a("action");
            GraphQLMegaphoneAction__JsonHelper.m9102a(jsonGenerator, graphQLMegaphone.j(), true);
        }
        if (graphQLMegaphone.k() != null) {
            jsonGenerator.a("cache_id", graphQLMegaphone.k());
        }
        if (graphQLMegaphone.l() != null) {
            jsonGenerator.a("close_label", graphQLMegaphone.l());
        }
        if (graphQLMegaphone.m() != null) {
            jsonGenerator.a("content");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMegaphone.m(), true);
        }
        if (graphQLMegaphone.n() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMegaphone.n(), true);
        }
        if (graphQLMegaphone.o() != null) {
            jsonGenerator.a("image_action", graphQLMegaphone.o());
        }
        jsonGenerator.a("is_persistent", graphQLMegaphone.p());
        if (graphQLMegaphone.q() != null) {
            jsonGenerator.a("location", graphQLMegaphone.q().toString());
        }
        if (graphQLMegaphone.r() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMegaphone.r(), true);
        }
        if (graphQLMegaphone.s() != null) {
            jsonGenerator.a("title", graphQLMegaphone.s());
        }
        if (graphQLMegaphone.t() != null) {
            jsonGenerator.a("tracking", graphQLMegaphone.t());
        }
        if (graphQLMegaphone.u() != null) {
            jsonGenerator.a("ui_version", graphQLMegaphone.u());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
