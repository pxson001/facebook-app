package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: full_width_accent_image */
public final class GraphQLGraphSearchResultsConnection__JsonHelper {
    public static GraphQLGraphSearchResultsConnection m8297a(JsonParser jsonParser) {
        GraphQLGraphSearchResultsConnection graphQLGraphSearchResultsConnection = new GraphQLGraphSearchResultsConnection();
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
                graphQLGraphSearchResultsConnection.f4110d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsConnection, "count", graphQLGraphSearchResultsConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r4 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLGraphSearchResultsEdge a = GraphQLGraphSearchResultsEdge__JsonHelper.m8309a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            r4.add(a);
                        }
                    }
                } else {
                    r4 = null;
                }
                if (r4 != null) {
                    r3 = ImmutableList.copyOf(r4);
                }
                graphQLGraphSearchResultsConnection.f4111e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsConnection, "edges", graphQLGraphSearchResultsConnection.a_, 1, true);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r4 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLNode a2 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
                        if (a2 != null) {
                            r4.add(a2);
                        }
                    }
                } else {
                    r4 = null;
                }
                if (r4 != null) {
                    r3 = ImmutableList.copyOf(r4);
                }
                graphQLGraphSearchResultsConnection.f4112f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsConnection, "nodes", graphQLGraphSearchResultsConnection.a_, 2, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLGraphSearchResultsConnection.f4113g = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultsConnection, "page_info", graphQLGraphSearchResultsConnection.a_, 3, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchResultsConnection;
    }

    public static void m8298a(JsonGenerator jsonGenerator, GraphQLGraphSearchResultsConnection graphQLGraphSearchResultsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLGraphSearchResultsConnection.m8288a());
        jsonGenerator.a("edges");
        if (graphQLGraphSearchResultsConnection.m8292j() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge : graphQLGraphSearchResultsConnection.m8292j()) {
                if (graphQLGraphSearchResultsEdge != null) {
                    GraphQLGraphSearchResultsEdge__JsonHelper.m8310a(jsonGenerator, graphQLGraphSearchResultsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLGraphSearchResultsConnection.m8293k() != null) {
            jsonGenerator.d();
            for (GraphQLNode graphQLNode : graphQLGraphSearchResultsConnection.m8293k()) {
                if (graphQLNode != null) {
                    GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLNode, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchResultsConnection.m8294l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGraphSearchResultsConnection.m8294l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
