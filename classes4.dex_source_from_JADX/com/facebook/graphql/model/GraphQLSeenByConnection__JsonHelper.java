package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: screen_height */
public final class GraphQLSeenByConnection__JsonHelper {
    public static GraphQLSeenByConnection m3223a(JsonParser jsonParser) {
        GraphQLSeenByConnection graphQLSeenByConnection = new GraphQLSeenByConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLSeenByConnection.d = i3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLSeenByConnection, "count", graphQLSeenByConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
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
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLSeenByConnection.e = copyOf;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLSeenByConnection, "nodes", graphQLSeenByConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.m11279a(FieldAccessQueryTracker.m2235a(jsonParser, "page_info"));
                }
                graphQLSeenByConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLSeenByConnection, "page_info", graphQLSeenByConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLSeenByConnection;
    }

    public static void m3224a(JsonGenerator jsonGenerator, GraphQLSeenByConnection graphQLSeenByConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLSeenByConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLSeenByConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLSeenByConnection.j()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.m3234a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSeenByConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.m11280a(jsonGenerator, graphQLSeenByConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
