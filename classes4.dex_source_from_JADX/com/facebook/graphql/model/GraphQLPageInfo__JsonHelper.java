package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: has_viewer_commented_recently */
public final class GraphQLPageInfo__JsonHelper {
    public static GraphQLPageInfo m11279a(JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = new GraphQLPageInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("delta_cursor".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageInfo.d = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPageInfo, "delta_cursor", graphQLPageInfo.a_, 0, false);
            } else if ("end_cursor".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageInfo.e = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPageInfo, "end_cursor", graphQLPageInfo.a_, 1, false);
            } else if ("has_next_page".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLPageInfo.f = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPageInfo, "has_next_page", graphQLPageInfo.a_, 2, false);
            } else if ("has_previous_page".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLPageInfo.g = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPageInfo, "has_previous_page", graphQLPageInfo.a_, 3, false);
            } else if ("start_cursor".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageInfo.h = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPageInfo, "start_cursor", graphQLPageInfo.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLPageInfo;
    }

    public static void m11280a(JsonGenerator jsonGenerator, GraphQLPageInfo graphQLPageInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageInfo.j() != null) {
            jsonGenerator.a("delta_cursor", graphQLPageInfo.j());
        }
        if (graphQLPageInfo.a() != null) {
            jsonGenerator.a("end_cursor", graphQLPageInfo.a());
        }
        jsonGenerator.a("has_next_page", graphQLPageInfo.b());
        jsonGenerator.a("has_previous_page", graphQLPageInfo.c());
        if (graphQLPageInfo.v_() != null) {
            jsonGenerator.a("start_cursor", graphQLPageInfo.v_());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
