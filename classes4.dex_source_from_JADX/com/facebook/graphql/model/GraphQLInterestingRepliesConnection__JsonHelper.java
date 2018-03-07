package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: scope */
public final class GraphQLInterestingRepliesConnection__JsonHelper {
    public static GraphQLInterestingRepliesConnection m3231a(JsonParser jsonParser) {
        GraphQLInterestingRepliesConnection graphQLInterestingRepliesConnection = new GraphQLInterestingRepliesConnection();
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
                graphQLInterestingRepliesConnection.d = i3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLInterestingRepliesConnection, "count", graphQLInterestingRepliesConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLComment a = GraphQLComment__JsonHelper.m3228a(FieldAccessQueryTracker.m2235a(jsonParser, "nodes"));
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
                graphQLInterestingRepliesConnection.e = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLInterestingRepliesConnection, "nodes", graphQLInterestingRepliesConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLInterestingRepliesConnection;
    }

    public static void m3232a(JsonGenerator jsonGenerator, GraphQLInterestingRepliesConnection graphQLInterestingRepliesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLInterestingRepliesConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLInterestingRepliesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLInterestingRepliesConnection.j()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.m3229a(jsonGenerator, graphQLComment, true);
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
