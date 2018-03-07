package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: events_calendar_can_viewer_subscribe */
public final class GraphQLNewsFeedConnection__JsonHelper {
    public static GraphQLNewsFeedConnection m9255a(JsonParser jsonParser) {
        GraphQLNewsFeedConnection graphQLNewsFeedConnection = new GraphQLNewsFeedConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9257a(graphQLNewsFeedConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLNewsFeedConnection;
    }

    private static boolean m9257a(GraphQLNewsFeedConnection graphQLNewsFeedConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("debug_info".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLNewsFeedConnection.d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedConnection, "debug_info", graphQLNewsFeedConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLNewsFeedEdge a = GraphQLNewsFeedEdge__JsonHelper.m9262a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLNewsFeedConnection.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedConnection, "edges", graphQLNewsFeedConnection.B_(), 1, true);
            return true;
        } else if ("no_feed_polling".equals(str)) {
            graphQLNewsFeedConnection.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedConnection, "no_feed_polling", graphQLNewsFeedConnection.B_(), 2, false);
            return true;
        } else if (!"page_info".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLNewsFeedConnection.g = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLNewsFeedConnection, "page_info", graphQLNewsFeedConnection.B_(), 3, true);
            return true;
        }
    }

    public static void m9256a(JsonGenerator jsonGenerator, GraphQLNewsFeedConnection graphQLNewsFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNewsFeedConnection.a() != null) {
            jsonGenerator.a("debug_info", graphQLNewsFeedConnection.a());
        }
        jsonGenerator.a("edges");
        if (graphQLNewsFeedConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLNewsFeedEdge graphQLNewsFeedEdge : graphQLNewsFeedConnection.j()) {
                if (graphQLNewsFeedEdge != null) {
                    GraphQLNewsFeedEdge__JsonHelper.m9263a(jsonGenerator, graphQLNewsFeedEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("no_feed_polling", graphQLNewsFeedConnection.k());
        if (graphQLNewsFeedConnection.l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLNewsFeedConnection.l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
