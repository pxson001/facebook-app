package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: imageHighRes */
public final class GraphQLEventsOccurringHereConnection__JsonHelper {
    public static GraphQLEventsOccurringHereConnection m7357a(JsonParser jsonParser) {
        GraphQLEventsOccurringHereConnection graphQLEventsOccurringHereConnection = new GraphQLEventsOccurringHereConnection();
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
                        GraphQLEvent a = GraphQLEvent__JsonHelper.m7344a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLEventsOccurringHereConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventsOccurringHereConnection, "nodes", graphQLEventsOccurringHereConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventsOccurringHereConnection;
    }

    public static void m7358a(JsonGenerator jsonGenerator, GraphQLEventsOccurringHereConnection graphQLEventsOccurringHereConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLEventsOccurringHereConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLEvent graphQLEvent : graphQLEventsOccurringHereConnection.a()) {
                if (graphQLEvent != null) {
                    GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEvent, true);
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
