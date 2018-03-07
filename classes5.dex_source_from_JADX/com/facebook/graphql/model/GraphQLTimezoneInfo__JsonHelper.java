package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNCONNECTED_LIVE_VIDEO */
public final class GraphQLTimezoneInfo__JsonHelper {
    public static GraphQLTimezoneInfo m22238a(JsonParser jsonParser) {
        GraphQLTimezoneInfo graphQLTimezoneInfo = new GraphQLTimezoneInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("timezone".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLTimezoneInfo.f13352d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimezoneInfo, "timezone", graphQLTimezoneInfo.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLTimezoneInfo;
    }

    public static void m22239a(JsonGenerator jsonGenerator, GraphQLTimezoneInfo graphQLTimezoneInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimezoneInfo.m22235a() != null) {
            jsonGenerator.a("timezone", graphQLTimezoneInfo.m22235a());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
