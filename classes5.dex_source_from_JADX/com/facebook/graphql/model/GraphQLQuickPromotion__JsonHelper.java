package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIEW_HIDDEN_UNITS_SETTINGS */
public final class GraphQLQuickPromotion__JsonHelper {
    public static GraphQLQuickPromotion m21266a(JsonParser jsonParser) {
        GraphQLQuickPromotion graphQLQuickPromotion = new GraphQLQuickPromotion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21268a(graphQLQuickPromotion, i, jsonParser);
            jsonParser.f();
        }
        return graphQLQuickPromotion;
    }

    private static boolean m21268a(GraphQLQuickPromotion graphQLQuickPromotion, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("creatives".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLQuickPromotionCreative a = GraphQLQuickPromotionCreative__JsonHelper.m21230a(FieldAccessQueryTracker.a(jsonParser, "creatives"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLQuickPromotion.f12843d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotion, "creatives", graphQLQuickPromotion.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLQuickPromotion.f12844e = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotion, "id", graphQLQuickPromotion.B_(), 1, false);
            return true;
        } else if ("template".equals(str)) {
            GraphQLQuickPromotionTemplate a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLQuickPromotionTemplate__JsonHelper.m21264a(FieldAccessQueryTracker.a(jsonParser, "template"));
            }
            graphQLQuickPromotion.f12845f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotion, "template", graphQLQuickPromotion.B_(), 2, true);
            return true;
        } else if (!"unit_title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "unit_title"));
            }
            graphQLQuickPromotion.f12846g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotion, "unit_title", graphQLQuickPromotion.B_(), 3, true);
            return true;
        }
    }

    public static void m21267a(JsonGenerator jsonGenerator, GraphQLQuickPromotion graphQLQuickPromotion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("creatives");
        if (graphQLQuickPromotion.m21198j() != null) {
            jsonGenerator.d();
            for (GraphQLQuickPromotionCreative graphQLQuickPromotionCreative : graphQLQuickPromotion.m21198j()) {
                if (graphQLQuickPromotionCreative != null) {
                    GraphQLQuickPromotionCreative__JsonHelper.m21231a(jsonGenerator, graphQLQuickPromotionCreative, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLQuickPromotion.m21199k() != null) {
            jsonGenerator.a("id", graphQLQuickPromotion.m21199k());
        }
        if (graphQLQuickPromotion.m21200l() != null) {
            jsonGenerator.a("template");
            GraphQLQuickPromotionTemplate__JsonHelper.m21265a(jsonGenerator, graphQLQuickPromotion.m21200l(), true);
        }
        if (graphQLQuickPromotion.m21201m() != null) {
            jsonGenerator.a("unit_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotion.m21201m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
