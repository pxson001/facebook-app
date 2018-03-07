package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Text may not be null */
public final class GraphQLVideoTimestampedCommentsConnection__JsonHelper {
    public static GraphQLVideoTimestampedCommentsConnection m22472a(JsonParser jsonParser) {
        GraphQLVideoTimestampedCommentsConnection graphQLVideoTimestampedCommentsConnection = new GraphQLVideoTimestampedCommentsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLVideoTimestampedCommentsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoTimestampedCommentsConnection, "count", graphQLVideoTimestampedCommentsConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLVideoTimestampedCommentsEdge a = GraphQLVideoTimestampedCommentsEdge__JsonHelper.m22481a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLVideoTimestampedCommentsConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoTimestampedCommentsConnection, "edges", graphQLVideoTimestampedCommentsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLVideoTimestampedCommentsConnection;
    }

    public static void m22473a(JsonGenerator jsonGenerator, GraphQLVideoTimestampedCommentsConnection graphQLVideoTimestampedCommentsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLVideoTimestampedCommentsConnection.a());
        jsonGenerator.a("edges");
        if (graphQLVideoTimestampedCommentsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLVideoTimestampedCommentsEdge graphQLVideoTimestampedCommentsEdge : graphQLVideoTimestampedCommentsConnection.j()) {
                if (graphQLVideoTimestampedCommentsEdge != null) {
                    GraphQLVideoTimestampedCommentsEdge__JsonHelper.m22482a(jsonGenerator, graphQLVideoTimestampedCommentsEdge, true);
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
