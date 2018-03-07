package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: http.cookiespec-registry */
public final class GraphQLFaceBoxTagSuggestionsConnection__JsonHelper {
    public static GraphQLFaceBoxTagSuggestionsConnection m7440a(JsonParser jsonParser) {
        GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection = new GraphQLFaceBoxTagSuggestionsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLFaceBoxTagSuggestionsEdge a = GraphQLFaceBoxTagSuggestionsEdge__JsonHelper.m7450a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLFaceBoxTagSuggestionsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLFaceBoxTagSuggestionsConnection, "edges", graphQLFaceBoxTagSuggestionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFaceBoxTagSuggestionsConnection;
    }

    public static void m7441a(JsonGenerator jsonGenerator, GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLFaceBoxTagSuggestionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge : graphQLFaceBoxTagSuggestionsConnection.a()) {
                if (graphQLFaceBoxTagSuggestionsEdge != null) {
                    GraphQLFaceBoxTagSuggestionsEdge__JsonHelper.m7451a(jsonGenerator, graphQLFaceBoxTagSuggestionsEdge, true);
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
