package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friends_center_search */
public final class GraphQLGroupConfigurationsConnection__JsonHelper {
    public static GraphQLGroupConfigurationsConnection m8398a(JsonParser jsonParser) {
        GraphQLGroupConfigurationsConnection graphQLGroupConfigurationsConnection = new GraphQLGroupConfigurationsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLConfiguration a = GraphQLConfiguration__JsonHelper.m6859a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGroupConfigurationsConnection.f4191d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupConfigurationsConnection, "nodes", graphQLGroupConfigurationsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupConfigurationsConnection;
    }

    public static void m8399a(JsonGenerator jsonGenerator, GraphQLGroupConfigurationsConnection graphQLGroupConfigurationsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGroupConfigurationsConnection.m8395a() != null) {
            jsonGenerator.d();
            for (GraphQLConfiguration graphQLConfiguration : graphQLGroupConfigurationsConnection.m8395a()) {
                if (graphQLConfiguration != null) {
                    GraphQLConfiguration__JsonHelper.m6860a(jsonGenerator, graphQLConfiguration, true);
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
