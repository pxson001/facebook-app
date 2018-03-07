package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unsupported encoding */
public final class GraphQLSouvenirMediaElementMediaConnection__JsonHelper {
    public static GraphQLSouvenirMediaElementMediaConnection m21736a(JsonParser jsonParser) {
        GraphQLSouvenirMediaElementMediaConnection graphQLSouvenirMediaElementMediaConnection = new GraphQLSouvenirMediaElementMediaConnection();
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
                        GraphQLSouvenirMediaElementMediaEdge a = GraphQLSouvenirMediaElementMediaEdge__JsonHelper.m21745a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSouvenirMediaElementMediaConnection.f13040d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElementMediaConnection, "edges", graphQLSouvenirMediaElementMediaConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSouvenirMediaElementMediaConnection;
    }

    public static void m21737a(JsonGenerator jsonGenerator, GraphQLSouvenirMediaElementMediaConnection graphQLSouvenirMediaElementMediaConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSouvenirMediaElementMediaConnection.m21733a() != null) {
            jsonGenerator.d();
            for (GraphQLSouvenirMediaElementMediaEdge graphQLSouvenirMediaElementMediaEdge : graphQLSouvenirMediaElementMediaConnection.m21733a()) {
                if (graphQLSouvenirMediaElementMediaEdge != null) {
                    GraphQLSouvenirMediaElementMediaEdge__JsonHelper.m21746a(jsonGenerator, graphQLSouvenirMediaElementMediaEdge, true);
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
