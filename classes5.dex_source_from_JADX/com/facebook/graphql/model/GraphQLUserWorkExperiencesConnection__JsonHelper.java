package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: TimelineSectionsConnection */
public final class GraphQLUserWorkExperiencesConnection__JsonHelper {
    public static GraphQLUserWorkExperiencesConnection m22405a(JsonParser jsonParser) {
        GraphQLUserWorkExperiencesConnection graphQLUserWorkExperiencesConnection = new GraphQLUserWorkExperiencesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            Collection arrayList;
            if ("edges".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUserWorkExperiencesEdge a = GraphQLUserWorkExperiencesEdge__JsonHelper.m22414a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLUserWorkExperiencesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserWorkExperiencesConnection, "edges", graphQLUserWorkExperiencesConnection.a_, 0, true);
            } else if ("nodes".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLWorkExperience a2 = GraphQLWorkExperience__JsonHelper.m22533a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLUserWorkExperiencesConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserWorkExperiencesConnection, "nodes", graphQLUserWorkExperiencesConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLUserWorkExperiencesConnection;
    }

    public static void m22406a(JsonGenerator jsonGenerator, GraphQLUserWorkExperiencesConnection graphQLUserWorkExperiencesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLUserWorkExperiencesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLUserWorkExperiencesEdge graphQLUserWorkExperiencesEdge : graphQLUserWorkExperiencesConnection.a()) {
                if (graphQLUserWorkExperiencesEdge != null) {
                    GraphQLUserWorkExperiencesEdge__JsonHelper.m22415a(jsonGenerator, graphQLUserWorkExperiencesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLUserWorkExperiencesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLWorkExperience graphQLWorkExperience : graphQLUserWorkExperiencesConnection.j()) {
                if (graphQLWorkExperience != null) {
                    GraphQLWorkExperience__JsonHelper.m22534a(jsonGenerator, graphQLWorkExperience, true);
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
