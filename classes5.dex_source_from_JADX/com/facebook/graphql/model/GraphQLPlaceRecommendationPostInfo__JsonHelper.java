package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WATER_FILTRATION_TREATMENT */
public final class GraphQLPlaceRecommendationPostInfo__JsonHelper {
    public static GraphQLPlaceRecommendationPostInfo m20893a(JsonParser jsonParser) {
        GraphQLPlaceRecommendationPostInfo graphQLPlaceRecommendationPostInfo = new GraphQLPlaceRecommendationPostInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("confidence".equals(i)) {
                double d;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLPlaceRecommendationPostInfo.d = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceRecommendationPostInfo, "confidence", graphQLPlaceRecommendationPostInfo.a_, 0, false);
                i2 = 1;
            } else if ("place_entities".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPage a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "place_entities"));
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
                graphQLPlaceRecommendationPostInfo.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceRecommendationPostInfo, "place_entities", graphQLPlaceRecommendationPostInfo.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLPlaceRecommendationPostInfo;
    }

    public static void m20894a(JsonGenerator jsonGenerator, GraphQLPlaceRecommendationPostInfo graphQLPlaceRecommendationPostInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("confidence", graphQLPlaceRecommendationPostInfo.a());
        jsonGenerator.a("place_entities");
        if (graphQLPlaceRecommendationPostInfo.j() != null) {
            jsonGenerator.d();
            for (GraphQLPage graphQLPage : graphQLPlaceRecommendationPostInfo.j()) {
                if (graphQLPage != null) {
                    GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPage, true);
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
