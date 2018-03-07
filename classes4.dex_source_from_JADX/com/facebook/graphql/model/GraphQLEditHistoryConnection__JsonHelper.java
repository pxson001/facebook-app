package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: save_privately */
public final class GraphQLEditHistoryConnection__JsonHelper {
    public static GraphQLEditHistoryConnection m3249a(JsonParser jsonParser) {
        GraphQLEditHistoryConnection graphQLEditHistoryConnection = new GraphQLEditHistoryConnection();
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
                graphQLEditHistoryConnection.d = i3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLEditHistoryConnection, "count", graphQLEditHistoryConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLEditAction a = GraphQLEditAction__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "nodes"));
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
                graphQLEditHistoryConnection.e = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLEditHistoryConnection, "nodes", graphQLEditHistoryConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLEditHistoryConnection;
    }

    public static void m3250a(JsonGenerator jsonGenerator, GraphQLEditHistoryConnection graphQLEditHistoryConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEditHistoryConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLEditHistoryConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEditAction graphQLEditAction : graphQLEditHistoryConnection.j()) {
                if (graphQLEditAction != null) {
                    GraphQLEditAction__JsonHelper.a(jsonGenerator, graphQLEditAction, true);
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
