package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: error_message_brief */
public final class GraphQLOwnedEventsConnection__JsonHelper {
    public static GraphQLOwnedEventsConnection m9435a(JsonParser jsonParser) {
        GraphQLOwnedEventsConnection graphQLOwnedEventsConnection = new GraphQLOwnedEventsConnection();
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
                graphQLOwnedEventsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLOwnedEventsConnection, "nodes", graphQLOwnedEventsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLOwnedEventsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLOwnedEventsConnection, "page_info", graphQLOwnedEventsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLOwnedEventsConnection;
    }

    public static void m9436a(JsonGenerator jsonGenerator, GraphQLOwnedEventsConnection graphQLOwnedEventsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLOwnedEventsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLEvent graphQLEvent : graphQLOwnedEventsConnection.a()) {
                if (graphQLEvent != null) {
                    GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEvent, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOwnedEventsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLOwnedEventsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
