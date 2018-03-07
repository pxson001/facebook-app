package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: install_messenger_button */
public final class GraphQLEventCategoryData__JsonHelper {
    public static GraphQLEventCategoryData m7122a(JsonParser jsonParser) {
        GraphQLEventCategoryData graphQLEventCategoryData = new GraphQLEventCategoryData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("category_name".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLEventCategoryData.d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventCategoryData, "category_name", graphQLEventCategoryData.a_, 0, false);
            } else if ("label".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLEventCategoryData.e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventCategoryData, "label", graphQLEventCategoryData.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventCategoryData;
    }

    public static void m7123a(JsonGenerator jsonGenerator, GraphQLEventCategoryData graphQLEventCategoryData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventCategoryData.a() != null) {
            jsonGenerator.a("category_name", graphQLEventCategoryData.a());
        }
        if (graphQLEventCategoryData.j() != null) {
            jsonGenerator.a("label", graphQLEventCategoryData.j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
