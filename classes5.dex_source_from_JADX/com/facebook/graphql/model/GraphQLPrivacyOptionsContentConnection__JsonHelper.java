package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VideoThumbnailProducer */
public final class GraphQLPrivacyOptionsContentConnection__JsonHelper {
    public static GraphQLPrivacyOptionsContentConnection m21009a(JsonParser jsonParser) {
        GraphQLPrivacyOptionsContentConnection graphQLPrivacyOptionsContentConnection = new GraphQLPrivacyOptionsContentConnection();
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
                        GraphQLPrivacyOptionsContentEdge a = GraphQLPrivacyOptionsContentEdge__JsonHelper.m21017a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPrivacyOptionsContentConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyOptionsContentConnection, "edges", graphQLPrivacyOptionsContentConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPrivacyOptionsContentConnection;
    }

    public static void m21010a(JsonGenerator jsonGenerator, GraphQLPrivacyOptionsContentConnection graphQLPrivacyOptionsContentConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPrivacyOptionsContentConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge : graphQLPrivacyOptionsContentConnection.a()) {
                if (graphQLPrivacyOptionsContentEdge != null) {
                    GraphQLPrivacyOptionsContentEdge__JsonHelper.m21018a(jsonGenerator, graphQLPrivacyOptionsContentEdge, true);
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
