package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WEATHER_CONDITION_NARROW */
public final class GraphQLPlaceListItemsFromPlaceListConnection__JsonHelper {
    public static GraphQLPlaceListItemsFromPlaceListConnection m20880a(JsonParser jsonParser) {
        GraphQLPlaceListItemsFromPlaceListConnection graphQLPlaceListItemsFromPlaceListConnection = new GraphQLPlaceListItemsFromPlaceListConnection();
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
                        GraphQLPlaceListItem a = GraphQLPlaceListItem__JsonHelper.m20872a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPlaceListItemsFromPlaceListConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItemsFromPlaceListConnection, "nodes", graphQLPlaceListItemsFromPlaceListConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPlaceListItemsFromPlaceListConnection;
    }

    public static void m20881a(JsonGenerator jsonGenerator, GraphQLPlaceListItemsFromPlaceListConnection graphQLPlaceListItemsFromPlaceListConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPlaceListItemsFromPlaceListConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPlaceListItem graphQLPlaceListItem : graphQLPlaceListItemsFromPlaceListConnection.a()) {
                if (graphQLPlaceListItem != null) {
                    GraphQLPlaceListItem__JsonHelper.m20873a(jsonGenerator, graphQLPlaceListItem, true);
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
