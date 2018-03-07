package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: enabling */
public final class GraphQLPageMenuInfo__JsonHelper {
    public static GraphQLPageMenuInfo m9500a(JsonParser jsonParser) {
        GraphQLPageMenuInfo graphQLPageMenuInfo = new GraphQLPageMenuInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            boolean z;
            if ("can_edit_menu".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPageMenuInfo.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageMenuInfo, "can_edit_menu", graphQLPageMenuInfo.a_, 0, false);
            } else if ("has_link_menus".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPageMenuInfo.e = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageMenuInfo, "has_link_menus", graphQLPageMenuInfo.a_, 1, false);
            } else if ("has_photo_menus".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPageMenuInfo.f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageMenuInfo, "has_photo_menus", graphQLPageMenuInfo.a_, 2, false);
            } else if ("has_structured_menu".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPageMenuInfo.g = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageMenuInfo, "has_structured_menu", graphQLPageMenuInfo.a_, 3, false);
            } else if ("url".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPageMenuInfo.h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageMenuInfo, "url", graphQLPageMenuInfo.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLPageMenuInfo;
    }

    public static void m9501a(JsonGenerator jsonGenerator, GraphQLPageMenuInfo graphQLPageMenuInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_edit_menu", graphQLPageMenuInfo.a());
        jsonGenerator.a("has_link_menus", graphQLPageMenuInfo.j());
        jsonGenerator.a("has_photo_menus", graphQLPageMenuInfo.k());
        jsonGenerator.a("has_structured_menu", graphQLPageMenuInfo.l());
        if (graphQLPageMenuInfo.m() != null) {
            jsonGenerator.a("url", graphQLPageMenuInfo.m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
