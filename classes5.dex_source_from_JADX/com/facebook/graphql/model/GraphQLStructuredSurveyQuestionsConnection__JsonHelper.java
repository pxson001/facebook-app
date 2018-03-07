package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: URI */
public final class GraphQLStructuredSurveyQuestionsConnection__JsonHelper {
    public static GraphQLStructuredSurveyQuestionsConnection m21982a(JsonParser jsonParser) {
        GraphQLStructuredSurveyQuestionsConnection graphQLStructuredSurveyQuestionsConnection = new GraphQLStructuredSurveyQuestionsConnection();
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
                        GraphQLStructuredSurveyQuestion a = GraphQLStructuredSurveyQuestion__JsonHelper.m21972a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLStructuredSurveyQuestionsConnection.f13223d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestionsConnection, "nodes", graphQLStructuredSurveyQuestionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLStructuredSurveyQuestionsConnection;
    }

    public static void m21983a(JsonGenerator jsonGenerator, GraphQLStructuredSurveyQuestionsConnection graphQLStructuredSurveyQuestionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLStructuredSurveyQuestionsConnection.m21979a() != null) {
            jsonGenerator.d();
            for (GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion : graphQLStructuredSurveyQuestionsConnection.m21979a()) {
                if (graphQLStructuredSurveyQuestion != null) {
                    GraphQLStructuredSurveyQuestion__JsonHelper.m21973a(jsonGenerator, graphQLStructuredSurveyQuestion, true);
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
