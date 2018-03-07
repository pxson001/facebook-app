package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: TopReactionsConnection */
public final class GraphQLUserEducationExperiencesConnection__JsonHelper {
    public static GraphQLUserEducationExperiencesConnection m22389a(JsonParser jsonParser) {
        GraphQLUserEducationExperiencesConnection graphQLUserEducationExperiencesConnection = new GraphQLUserEducationExperiencesConnection();
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
                        GraphQLUserEducationExperiencesEdge a = GraphQLUserEducationExperiencesEdge__JsonHelper.m22398a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLUserEducationExperiencesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserEducationExperiencesConnection, "edges", graphQLUserEducationExperiencesConnection.a_, 0, true);
            } else if ("nodes".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLEducationExperience a2 = GraphQLEducationExperience__JsonHelper.m6983a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLUserEducationExperiencesConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserEducationExperiencesConnection, "nodes", graphQLUserEducationExperiencesConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLUserEducationExperiencesConnection;
    }

    public static void m22390a(JsonGenerator jsonGenerator, GraphQLUserEducationExperiencesConnection graphQLUserEducationExperiencesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLUserEducationExperiencesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLUserEducationExperiencesEdge graphQLUserEducationExperiencesEdge : graphQLUserEducationExperiencesConnection.a()) {
                if (graphQLUserEducationExperiencesEdge != null) {
                    GraphQLUserEducationExperiencesEdge__JsonHelper.m22399a(jsonGenerator, graphQLUserEducationExperiencesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLUserEducationExperiencesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEducationExperience graphQLEducationExperience : graphQLUserEducationExperiencesConnection.j()) {
                if (graphQLEducationExperience != null) {
                    GraphQLEducationExperience__JsonHelper.m6984a(jsonGenerator, graphQLEducationExperience, true);
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
