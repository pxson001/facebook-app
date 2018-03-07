package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: feed_friendable_header */
public final class GraphQLLeadGenPage__JsonHelper {
    public static GraphQLLeadGenPage m8892a(JsonParser jsonParser) {
        GraphQLLeadGenPage graphQLLeadGenPage = new GraphQLLeadGenPage();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            Collection arrayList;
            if ("info_fields".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLLeadGenInfoFieldData a = GraphQLLeadGenInfoFieldData__JsonHelper.m8852a(FieldAccessQueryTracker.a(jsonParser, "info_fields"));
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
                graphQLLeadGenPage.f4389d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenPage, "info_fields", graphQLLeadGenPage.a_, 0, true);
            } else if ("privacy_data".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLLeadGenPrivacyNode a2 = GraphQLLeadGenPrivacyNode__JsonHelper.m8902a(FieldAccessQueryTracker.a(jsonParser, "privacy_data"));
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLLeadGenPage.f4390e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenPage, "privacy_data", graphQLLeadGenPage.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLLeadGenPage;
    }

    public static void m8893a(JsonGenerator jsonGenerator, GraphQLLeadGenPage graphQLLeadGenPage, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("info_fields");
        if (graphQLLeadGenPage.m8888a() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData : graphQLLeadGenPage.m8888a()) {
                if (graphQLLeadGenInfoFieldData != null) {
                    GraphQLLeadGenInfoFieldData__JsonHelper.m8853a(jsonGenerator, graphQLLeadGenInfoFieldData, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("privacy_data");
        if (graphQLLeadGenPage.m8889j() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode : graphQLLeadGenPage.m8889j()) {
                if (graphQLLeadGenPrivacyNode != null) {
                    GraphQLLeadGenPrivacyNode__JsonHelper.m8903a(jsonGenerator, graphQLLeadGenPrivacyNode, true);
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
