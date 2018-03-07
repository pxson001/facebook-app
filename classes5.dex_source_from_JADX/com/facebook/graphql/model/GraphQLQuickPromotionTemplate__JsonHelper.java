package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIEW_IN_APP_STORE */
public final class GraphQLQuickPromotionTemplate__JsonHelper {
    public static GraphQLQuickPromotionTemplate m21264a(JsonParser jsonParser) {
        GraphQLQuickPromotionTemplate graphQLQuickPromotionTemplate = new GraphQLQuickPromotionTemplate();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("name".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLQuickPromotionTemplate.f12875d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionTemplate, "name", graphQLQuickPromotionTemplate.a_, 0, false);
                i2 = 1;
            } else if ("parameters".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLQPTemplateParameter a = GraphQLQPTemplateParameter__JsonHelper.m21138a(FieldAccessQueryTracker.a(jsonParser, "parameters"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLQuickPromotionTemplate.f12876e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionTemplate, "parameters", graphQLQuickPromotionTemplate.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLQuickPromotionTemplate;
    }

    public static void m21265a(JsonGenerator jsonGenerator, GraphQLQuickPromotionTemplate graphQLQuickPromotionTemplate, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionTemplate.m21260a() != null) {
            jsonGenerator.a("name", graphQLQuickPromotionTemplate.m21260a());
        }
        jsonGenerator.a("parameters");
        if (graphQLQuickPromotionTemplate.m21261j() != null) {
            jsonGenerator.d();
            for (GraphQLQPTemplateParameter graphQLQPTemplateParameter : graphQLQuickPromotionTemplate.m21261j()) {
                if (graphQLQPTemplateParameter != null) {
                    GraphQLQPTemplateParameter__JsonHelper.m21139a(jsonGenerator, graphQLQPTemplateParameter, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
