package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friends_who_used_contact_importer_count */
public final class GraphQLGreetingCardSlidesConnection__JsonHelper {
    public static GraphQLGreetingCardSlidesConnection m8357a(JsonParser jsonParser) {
        GraphQLGreetingCardSlidesConnection graphQLGreetingCardSlidesConnection = new GraphQLGreetingCardSlidesConnection();
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
                        GraphQLGreetingCardSlide a = GraphQLGreetingCardSlide__JsonHelper.m8350a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGreetingCardSlidesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlidesConnection, "nodes", graphQLGreetingCardSlidesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGreetingCardSlidesConnection;
    }

    public static void m8358a(JsonGenerator jsonGenerator, GraphQLGreetingCardSlidesConnection graphQLGreetingCardSlidesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGreetingCardSlidesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLGreetingCardSlide graphQLGreetingCardSlide : graphQLGreetingCardSlidesConnection.a()) {
                if (graphQLGreetingCardSlide != null) {
                    GraphQLGreetingCardSlide__JsonHelper.m8351a(jsonGenerator, graphQLGreetingCardSlide, true);
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
