package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: URL %s follows too many redirects */
public final class GraphQLStructuredSurveyQuestion__JsonHelper {
    public static GraphQLStructuredSurveyQuestion m21972a(JsonParser jsonParser) {
        GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion = new GraphQLStructuredSurveyQuestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21974a(graphQLStructuredSurveyQuestion, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStructuredSurveyQuestion;
    }

    private static boolean m21974a(GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLTextWithEntities a;
        if ("body".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "body"));
            }
            graphQLStructuredSurveyQuestion.f13216d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "body", graphQLStructuredSurveyQuestion.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurveyQuestion.f13217e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "id", graphQLStructuredSurveyQuestion.B_(), 1, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLStructuredSurveyQuestion.f13218f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "message", graphQLStructuredSurveyQuestion.B_(), 2, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurveyQuestion.f13219g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "name", graphQLStructuredSurveyQuestion.B_(), 3, false);
            return true;
        } else if ("question_class".equals(str)) {
            graphQLStructuredSurveyQuestion.f13220h = GraphQLStructuredSurveyQuestionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "question_class", graphQLStructuredSurveyQuestion.B_(), 4, false);
            return true;
        } else if ("response_options".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStructuredSurveyResponseOption a2 = GraphQLStructuredSurveyResponseOption__JsonHelper.m21994a(FieldAccessQueryTracker.a(jsonParser, "response_options"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLStructuredSurveyQuestion.f13221i = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "response_options", graphQLStructuredSurveyQuestion.B_(), 5, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurveyQuestion.f13222j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyQuestion, "url", graphQLStructuredSurveyQuestion.B_(), 6, false);
            return true;
        }
    }

    public static void m21973a(JsonGenerator jsonGenerator, GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStructuredSurveyQuestion.m21963j() != null) {
            jsonGenerator.a("body");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStructuredSurveyQuestion.m21963j(), true);
        }
        if (graphQLStructuredSurveyQuestion.m21964k() != null) {
            jsonGenerator.a("id", graphQLStructuredSurveyQuestion.m21964k());
        }
        if (graphQLStructuredSurveyQuestion.m21965l() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStructuredSurveyQuestion.m21965l(), true);
        }
        if (graphQLStructuredSurveyQuestion.m21966m() != null) {
            jsonGenerator.a("name", graphQLStructuredSurveyQuestion.m21966m());
        }
        if (graphQLStructuredSurveyQuestion.m21967n() != null) {
            jsonGenerator.a("question_class", graphQLStructuredSurveyQuestion.m21967n().toString());
        }
        jsonGenerator.a("response_options");
        if (graphQLStructuredSurveyQuestion.m21968o() != null) {
            jsonGenerator.d();
            for (GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption : graphQLStructuredSurveyQuestion.m21968o()) {
                if (graphQLStructuredSurveyResponseOption != null) {
                    GraphQLStructuredSurveyResponseOption__JsonHelper.m21995a(jsonGenerator, graphQLStructuredSurveyResponseOption, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStructuredSurveyQuestion.m21969p() != null) {
            jsonGenerator.a("url", graphQLStructuredSurveyQuestion.m21969p());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
