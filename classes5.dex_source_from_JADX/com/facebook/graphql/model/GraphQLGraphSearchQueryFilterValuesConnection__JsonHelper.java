package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: game_gysj */
public final class GraphQLGraphSearchQueryFilterValuesConnection__JsonHelper {
    public static GraphQLGraphSearchQueryFilterValuesConnection m8253a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryFilterValuesConnection graphQLGraphSearchQueryFilterValuesConnection = new GraphQLGraphSearchQueryFilterValuesConnection();
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
                        GraphQLGraphSearchQueryFilterValue a = GraphQLGraphSearchQueryFilterValue__JsonHelper.m8247a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGraphSearchQueryFilterValuesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterValuesConnection, "nodes", graphQLGraphSearchQueryFilterValuesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchQueryFilterValuesConnection;
    }

    public static void m8254a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryFilterValuesConnection graphQLGraphSearchQueryFilterValuesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGraphSearchQueryFilterValuesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchQueryFilterValue graphQLGraphSearchQueryFilterValue : graphQLGraphSearchQueryFilterValuesConnection.a()) {
                if (graphQLGraphSearchQueryFilterValue != null) {
                    GraphQLGraphSearchQueryFilterValue__JsonHelper.m8248a(jsonGenerator, graphQLGraphSearchQueryFilterValue, true);
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
