package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ensureImeVisible */
public final class GraphQLPageBrowserCategoryInfo__JsonHelper {
    public static GraphQLPageBrowserCategoryInfo m9478a(JsonParser jsonParser) {
        GraphQLPageBrowserCategoryInfo graphQLPageBrowserCategoryInfo = new GraphQLPageBrowserCategoryInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("category".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLPageBrowserCategoryInfo.f4742d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageBrowserCategoryInfo, "category", graphQLPageBrowserCategoryInfo.a_, 0, false);
            } else if ("name".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLPageBrowserCategoryInfo.f4743e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageBrowserCategoryInfo, "name", graphQLPageBrowserCategoryInfo.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPageBrowserCategoryInfo;
    }

    public static void m9479a(JsonGenerator jsonGenerator, GraphQLPageBrowserCategoryInfo graphQLPageBrowserCategoryInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageBrowserCategoryInfo.m9474a() != null) {
            jsonGenerator.a("category", graphQLPageBrowserCategoryInfo.m9474a());
        }
        if (graphQLPageBrowserCategoryInfo.m9475j() != null) {
            jsonGenerator.a("name", graphQLPageBrowserCategoryInfo.m9475j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
