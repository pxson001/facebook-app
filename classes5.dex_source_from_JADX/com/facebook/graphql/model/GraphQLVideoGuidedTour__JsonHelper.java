package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: The socket may not be null */
public final class GraphQLVideoGuidedTour__JsonHelper {
    public static GraphQLVideoGuidedTour m22465a(JsonParser jsonParser) {
        GraphQLVideoGuidedTour graphQLVideoGuidedTour = new GraphQLVideoGuidedTour();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("keyframes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLVideoGuidedTourKeyframe a = GraphQLVideoGuidedTourKeyframe__JsonHelper.m22462a(FieldAccessQueryTracker.a(jsonParser, "keyframes"));
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
                graphQLVideoGuidedTour.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoGuidedTour, "keyframes", graphQLVideoGuidedTour.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLVideoGuidedTour;
    }

    public static void m22466a(JsonGenerator jsonGenerator, GraphQLVideoGuidedTour graphQLVideoGuidedTour, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("keyframes");
        if (graphQLVideoGuidedTour.a() != null) {
            jsonGenerator.d();
            for (GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe : graphQLVideoGuidedTour.a()) {
                if (graphQLVideoGuidedTourKeyframe != null) {
                    GraphQLVideoGuidedTourKeyframe__JsonHelper.m22463a(jsonGenerator, graphQLVideoGuidedTourKeyframe, true);
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
