package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: feedback_target */
public final class GraphQLInteractorsConnection__JsonHelper {
    public static GraphQLInteractorsConnection m8745a(JsonParser jsonParser) {
        GraphQLInteractorsConnection graphQLInteractorsConnection = new GraphQLInteractorsConnection();
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
                graphQLInteractorsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLInteractorsConnection, "count", graphQLInteractorsConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLActor a = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLInteractorsConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLInteractorsConnection, "nodes", graphQLInteractorsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLInteractorsConnection;
    }

    public static void m8746a(JsonGenerator jsonGenerator, GraphQLInteractorsConnection graphQLInteractorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLInteractorsConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLInteractorsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLInteractorsConnection.j()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
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
