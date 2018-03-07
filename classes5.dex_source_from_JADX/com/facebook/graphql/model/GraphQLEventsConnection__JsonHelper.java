package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: imageLargeAspect */
public final class GraphQLEventsConnection__JsonHelper {
    public static GraphQLEventsConnection m7351a(JsonParser jsonParser) {
        GraphQLEventsConnection graphQLEventsConnection = new GraphQLEventsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
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
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLEventsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventsConnection, "nodes", graphQLEventsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLEventsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventsConnection, "page_info", graphQLEventsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventsConnection;
    }

    public static void m7352a(JsonGenerator jsonGenerator, GraphQLEventsConnection graphQLEventsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLEventsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLEvent graphQLEvent : graphQLEventsConnection.a()) {
                if (graphQLEvent != null) {
                    GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEvent, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
