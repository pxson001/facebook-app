package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: sa_href */
public final class GraphQLImportantReactorsConnection__JsonHelper {
    public static GraphQLImportantReactorsConnection m3265a(JsonParser jsonParser) {
        GraphQLImportantReactorsConnection graphQLImportantReactorsConnection = new GraphQLImportantReactorsConnection();
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
                        GraphQLActor a = GraphQLActor__JsonHelper.m3233a(FieldAccessQueryTracker.m2235a(jsonParser, "nodes"));
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
                graphQLImportantReactorsConnection.d = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLImportantReactorsConnection, "nodes", graphQLImportantReactorsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLImportantReactorsConnection;
    }

    public static void m3266a(JsonGenerator jsonGenerator, GraphQLImportantReactorsConnection graphQLImportantReactorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLImportantReactorsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLImportantReactorsConnection.a()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.m3234a(jsonGenerator, graphQLActor, true);
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
