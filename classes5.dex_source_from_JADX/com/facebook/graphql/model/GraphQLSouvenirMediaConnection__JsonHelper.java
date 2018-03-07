package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UploadServiceLogic */
public final class GraphQLSouvenirMediaConnection__JsonHelper {
    public static GraphQLSouvenirMediaConnection m21706a(JsonParser jsonParser) {
        GraphQLSouvenirMediaConnection graphQLSouvenirMediaConnection = new GraphQLSouvenirMediaConnection();
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
                        GraphQLSouvenirMediaEdge a = GraphQLSouvenirMediaEdge__JsonHelper.m21715a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSouvenirMediaConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaConnection, "edges", graphQLSouvenirMediaConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSouvenirMediaConnection;
    }

    public static void m21707a(JsonGenerator jsonGenerator, GraphQLSouvenirMediaConnection graphQLSouvenirMediaConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSouvenirMediaConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLSouvenirMediaEdge graphQLSouvenirMediaEdge : graphQLSouvenirMediaConnection.a()) {
                if (graphQLSouvenirMediaEdge != null) {
                    GraphQLSouvenirMediaEdge__JsonHelper.m21716a(jsonGenerator, graphQLSouvenirMediaEdge, true);
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
