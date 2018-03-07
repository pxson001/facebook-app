package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fromAuthoritativeData */
public final class GraphQLGreetingCardSlidePhotosConnection__JsonHelper {
    public static GraphQLGreetingCardSlidePhotosConnection m8347a(JsonParser jsonParser) {
        GraphQLGreetingCardSlidePhotosConnection graphQLGreetingCardSlidePhotosConnection = new GraphQLGreetingCardSlidePhotosConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPhoto a = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGreetingCardSlidePhotosConnection.f4136d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlidePhotosConnection, "nodes", graphQLGreetingCardSlidePhotosConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGreetingCardSlidePhotosConnection;
    }

    public static void m8348a(JsonGenerator jsonGenerator, GraphQLGreetingCardSlidePhotosConnection graphQLGreetingCardSlidePhotosConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGreetingCardSlidePhotosConnection.m8344a() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLGreetingCardSlidePhotosConnection.m8344a()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
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
