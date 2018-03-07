package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: sms_anonymous_chathead_impression_count */
public final class GraphQLPrivacyOptionsComposerConnection__JsonHelper {
    public static GraphQLPrivacyOptionsComposerConnection m2240a(JsonParser jsonParser) {
        GraphQLPrivacyOptionsComposerConnection graphQLPrivacyOptionsComposerConnection = new GraphQLPrivacyOptionsComposerConnection();
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
                        GraphQLPrivacyOptionsComposerEdge a = GraphQLPrivacyOptionsComposerEdge__JsonHelper.m2245a(FieldAccessQueryTracker.m2235a(jsonParser, "edges"));
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
                graphQLPrivacyOptionsComposerConnection.f2133d = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerConnection, "edges", graphQLPrivacyOptionsComposerConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPrivacyOptionsComposerConnection;
    }

    public static void m2241a(JsonGenerator jsonGenerator, GraphQLPrivacyOptionsComposerConnection graphQLPrivacyOptionsComposerConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPrivacyOptionsComposerConnection.m2244a() != null) {
            jsonGenerator.d();
            for (GraphQLPrivacyOptionsComposerEdge graphQLPrivacyOptionsComposerEdge : graphQLPrivacyOptionsComposerConnection.m2244a()) {
                if (graphQLPrivacyOptionsComposerEdge != null) {
                    GraphQLPrivacyOptionsComposerEdge__JsonHelper.m2246a(jsonGenerator, graphQLPrivacyOptionsComposerEdge, true);
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
