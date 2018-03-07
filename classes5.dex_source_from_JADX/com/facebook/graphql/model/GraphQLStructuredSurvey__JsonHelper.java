package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStructuredSurveyFlowType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UPSELL_FOOTER */
public final class GraphQLStructuredSurvey__JsonHelper {
    public static GraphQLStructuredSurvey m21998a(JsonParser jsonParser) {
        GraphQLStructuredSurvey graphQLStructuredSurvey = new GraphQLStructuredSurvey();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22000a(graphQLStructuredSurvey, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStructuredSurvey;
    }

    private static boolean m22000a(GraphQLStructuredSurvey graphQLStructuredSurvey, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLStructuredSurveyQuestionsConnection a;
        if ("firstQuestion".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21982a(FieldAccessQueryTracker.a(jsonParser, "firstQuestion"));
            }
            graphQLStructuredSurvey.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "firstQuestion", graphQLStructuredSurvey.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurvey.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "id", graphQLStructuredSurvey.B_(), 1, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurvey.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "name", graphQLStructuredSurvey.B_(), 2, false);
            return true;
        } else if ("structured_questions".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21982a(FieldAccessQueryTracker.a(jsonParser, "structured_questions"));
            }
            graphQLStructuredSurvey.g = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "structured_questions", graphQLStructuredSurvey.B_(), 3, true);
            return true;
        } else if ("survey_flow_type".equals(str)) {
            graphQLStructuredSurvey.h = GraphQLStructuredSurveyFlowType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "survey_flow_type", graphQLStructuredSurvey.B_(), 4, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurvey.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurvey, "url", graphQLStructuredSurvey.B_(), 5, false);
            return true;
        }
    }

    public static void m21999a(JsonGenerator jsonGenerator, GraphQLStructuredSurvey graphQLStructuredSurvey, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStructuredSurvey.j() != null) {
            jsonGenerator.a("firstQuestion");
            GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21983a(jsonGenerator, graphQLStructuredSurvey.j(), true);
        }
        if (graphQLStructuredSurvey.k() != null) {
            jsonGenerator.a("id", graphQLStructuredSurvey.k());
        }
        if (graphQLStructuredSurvey.l() != null) {
            jsonGenerator.a("name", graphQLStructuredSurvey.l());
        }
        if (graphQLStructuredSurvey.m() != null) {
            jsonGenerator.a("structured_questions");
            GraphQLStructuredSurveyQuestionsConnection__JsonHelper.m21983a(jsonGenerator, graphQLStructuredSurvey.m(), true);
        }
        if (graphQLStructuredSurvey.n() != null) {
            jsonGenerator.a("survey_flow_type", graphQLStructuredSurvey.n().toString());
        }
        if (graphQLStructuredSurvey.o() != null) {
            jsonGenerator.a("url", graphQLStructuredSurvey.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
