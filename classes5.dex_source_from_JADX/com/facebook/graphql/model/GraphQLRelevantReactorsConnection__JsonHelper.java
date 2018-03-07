package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIDEO_HOME_STICKY_HEADER */
public final class GraphQLRelevantReactorsConnection__JsonHelper {
    public static GraphQLRelevantReactorsConnection m21388a(JsonParser jsonParser) {
        GraphQLRelevantReactorsConnection graphQLRelevantReactorsConnection = new GraphQLRelevantReactorsConnection();
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
                graphQLRelevantReactorsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLRelevantReactorsConnection, "count", graphQLRelevantReactorsConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLRelevantReactorsEdge a = GraphQLRelevantReactorsEdge__JsonHelper.m21397a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLRelevantReactorsConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLRelevantReactorsConnection, "edges", graphQLRelevantReactorsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLRelevantReactorsConnection;
    }

    public static void m21389a(JsonGenerator jsonGenerator, GraphQLRelevantReactorsConnection graphQLRelevantReactorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLRelevantReactorsConnection.a());
        jsonGenerator.a("edges");
        if (graphQLRelevantReactorsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLRelevantReactorsEdge graphQLRelevantReactorsEdge : graphQLRelevantReactorsConnection.j()) {
                if (graphQLRelevantReactorsEdge != null) {
                    GraphQLRelevantReactorsEdge__JsonHelper.m21398a(jsonGenerator, graphQLRelevantReactorsEdge, true);
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
