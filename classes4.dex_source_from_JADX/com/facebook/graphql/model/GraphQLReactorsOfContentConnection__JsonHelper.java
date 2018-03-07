package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: sampling_interval_us */
public final class GraphQLReactorsOfContentConnection__JsonHelper {
    public static GraphQLReactorsOfContentConnection m3254a(JsonParser jsonParser) {
        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection = new GraphQLReactorsOfContentConnection();
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
                graphQLReactorsOfContentConnection.d = i3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLReactorsOfContentConnection, "count", graphQLReactorsOfContentConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLReactorsOfContentEdge a = GraphQLReactorsOfContentEdge__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "edges"));
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
                graphQLReactorsOfContentConnection.e = copyOf;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLReactorsOfContentConnection, "edges", graphQLReactorsOfContentConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.m11279a(FieldAccessQueryTracker.m2235a(jsonParser, "page_info"));
                }
                graphQLReactorsOfContentConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLReactorsOfContentConnection, "page_info", graphQLReactorsOfContentConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLReactorsOfContentConnection;
    }

    public static void m3255a(JsonGenerator jsonGenerator, GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLReactorsOfContentConnection.a());
        jsonGenerator.a("edges");
        if (graphQLReactorsOfContentConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge : graphQLReactorsOfContentConnection.j()) {
                if (graphQLReactorsOfContentEdge != null) {
                    GraphQLReactorsOfContentEdge__JsonHelper.a(jsonGenerator, graphQLReactorsOfContentEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLReactorsOfContentConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.m11280a(jsonGenerator, graphQLReactorsOfContentConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
