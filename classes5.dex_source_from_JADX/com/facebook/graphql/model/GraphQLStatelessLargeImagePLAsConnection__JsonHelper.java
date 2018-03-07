package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unexpected long[] element size */
public final class GraphQLStatelessLargeImagePLAsConnection__JsonHelper {
    public static GraphQLStatelessLargeImagePLAsConnection m21821a(JsonParser jsonParser) {
        GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection = new GraphQLStatelessLargeImagePLAsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLStatelessLargeImagePLAsEdge a = GraphQLStatelessLargeImagePLAsEdge__JsonHelper.m21830a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLStatelessLargeImagePLAsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLStatelessLargeImagePLAsConnection, "edges", graphQLStatelessLargeImagePLAsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLStatelessLargeImagePLAsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLStatelessLargeImagePLAsConnection, "page_info", graphQLStatelessLargeImagePLAsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLStatelessLargeImagePLAsConnection;
    }

    public static void m21822a(JsonGenerator jsonGenerator, GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLStatelessLargeImagePLAsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLStatelessLargeImagePLAsEdge graphQLStatelessLargeImagePLAsEdge : graphQLStatelessLargeImagePLAsConnection.a()) {
                if (graphQLStatelessLargeImagePLAsEdge != null) {
                    GraphQLStatelessLargeImagePLAsEdge__JsonHelper.m21831a(jsonGenerator, graphQLStatelessLargeImagePLAsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStatelessLargeImagePLAsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLStatelessLargeImagePLAsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
