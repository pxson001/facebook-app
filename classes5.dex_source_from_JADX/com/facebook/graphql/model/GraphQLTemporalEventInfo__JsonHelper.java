package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNORDERED */
public final class GraphQLTemporalEventInfo__JsonHelper {
    public static GraphQLTemporalEventInfo m22103a(JsonParser jsonParser) {
        GraphQLTemporalEventInfo graphQLTemporalEventInfo = new GraphQLTemporalEventInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22105a(graphQLTemporalEventInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTemporalEventInfo;
    }

    private static boolean m22105a(GraphQLTemporalEventInfo graphQLTemporalEventInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("start_time".equals(str)) {
            long j;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                j = 0;
            } else {
                j = jsonParser.F();
            }
            graphQLTemporalEventInfo.d = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLTemporalEventInfo, "start_time", graphQLTemporalEventInfo.a_, 0, false);
            return true;
        } else if ("theme".equals(str)) {
            GraphQLEventThemePhoto a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEventThemePhoto__JsonHelper.m7280a(FieldAccessQueryTracker.a(jsonParser, "theme"));
            }
            graphQLTemporalEventInfo.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTemporalEventInfo, "theme", graphQLTemporalEventInfo.B_(), 1, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTemporalEventInfo.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTemporalEventInfo, "title", graphQLTemporalEventInfo.B_(), 2, false);
            return true;
        }
    }

    public static void m22104a(JsonGenerator jsonGenerator, GraphQLTemporalEventInfo graphQLTemporalEventInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("start_time", graphQLTemporalEventInfo.a());
        if (graphQLTemporalEventInfo.j() != null) {
            jsonGenerator.a("theme");
            GraphQLEventThemePhoto__JsonHelper.m7281a(jsonGenerator, graphQLTemporalEventInfo.j(), true);
        }
        if (graphQLTemporalEventInfo.k() != null) {
            jsonGenerator.a("title", graphQLTemporalEventInfo.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
