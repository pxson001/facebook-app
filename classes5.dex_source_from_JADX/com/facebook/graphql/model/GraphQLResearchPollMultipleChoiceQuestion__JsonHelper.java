package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLResearchPollQuestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_HOME_GUIDE */
public final class GraphQLResearchPollMultipleChoiceQuestion__JsonHelper {
    public static GraphQLResearchPollMultipleChoiceQuestion m21420a(JsonParser jsonParser) {
        GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = new GraphQLResearchPollMultipleChoiceQuestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("hide_responses".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLResearchPollMultipleChoiceQuestion.f12915d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "hide_responses", graphQLResearchPollMultipleChoiceQuestion.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceQuestion.f12916e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "id", graphQLResearchPollMultipleChoiceQuestion.a_, 1, false);
            } else if ("next_question".equals(i)) {
                GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLResearchPollMultipleChoiceQuestion2 = null;
                } else {
                    graphQLResearchPollMultipleChoiceQuestion2 = m21420a(FieldAccessQueryTracker.a(jsonParser, "next_question"));
                }
                graphQLResearchPollMultipleChoiceQuestion.f12917f = graphQLResearchPollMultipleChoiceQuestion2;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "next_question", graphQLResearchPollMultipleChoiceQuestion.a_, 2, true);
            } else if ("question_responders".equals(i)) {
                GraphQLResearchPollQuestionRespondersConnection graphQLResearchPollQuestionRespondersConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLResearchPollQuestionRespondersConnection = null;
                } else {
                    graphQLResearchPollQuestionRespondersConnection = GraphQLResearchPollQuestionRespondersConnection__JsonHelper.m21444a(FieldAccessQueryTracker.a(jsonParser, "question_responders"));
                }
                graphQLResearchPollMultipleChoiceQuestion.f12918g = graphQLResearchPollQuestionRespondersConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "question_responders", graphQLResearchPollMultipleChoiceQuestion.a_, 3, true);
            } else if ("question_type".equals(i)) {
                graphQLResearchPollMultipleChoiceQuestion.f12919h = GraphQLResearchPollQuestionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "question_type", graphQLResearchPollMultipleChoiceQuestion.a_, 4, false);
            } else if ("research_poll_question".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceQuestion.f12920i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "research_poll_question", graphQLResearchPollMultipleChoiceQuestion.a_, 5, false);
            } else if ("responses".equals(i)) {
                GraphQLResearchPollQuestionResponsesConnection graphQLResearchPollQuestionResponsesConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLResearchPollQuestionResponsesConnection = null;
                } else {
                    graphQLResearchPollQuestionResponsesConnection = GraphQLResearchPollQuestionResponsesConnection__JsonHelper.m21453a(FieldAccessQueryTracker.a(jsonParser, "responses"));
                }
                graphQLResearchPollMultipleChoiceQuestion.f12921j = graphQLResearchPollQuestionResponsesConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "responses", graphQLResearchPollMultipleChoiceQuestion.a_, 6, true);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceQuestion.f12922k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceQuestion, "url", graphQLResearchPollMultipleChoiceQuestion.a_, 7, false);
            }
            jsonParser.f();
        }
        return graphQLResearchPollMultipleChoiceQuestion;
    }

    public static void m21421a(JsonGenerator jsonGenerator, GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("hide_responses", graphQLResearchPollMultipleChoiceQuestion.m21410j());
        if (graphQLResearchPollMultipleChoiceQuestion.m21411k() != null) {
            jsonGenerator.a("id", graphQLResearchPollMultipleChoiceQuestion.m21411k());
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21412l() != null) {
            jsonGenerator.a("next_question");
            m21421a(jsonGenerator, graphQLResearchPollMultipleChoiceQuestion.m21412l(), true);
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21413m() != null) {
            jsonGenerator.a("question_responders");
            GraphQLResearchPollQuestionRespondersConnection__JsonHelper.m21445a(jsonGenerator, graphQLResearchPollMultipleChoiceQuestion.m21413m(), true);
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21414n() != null) {
            jsonGenerator.a("question_type", graphQLResearchPollMultipleChoiceQuestion.m21414n().toString());
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21415o() != null) {
            jsonGenerator.a("research_poll_question", graphQLResearchPollMultipleChoiceQuestion.m21415o());
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21416p() != null) {
            jsonGenerator.a("responses");
            GraphQLResearchPollQuestionResponsesConnection__JsonHelper.m21454a(jsonGenerator, graphQLResearchPollMultipleChoiceQuestion.m21416p(), true);
        }
        if (graphQLResearchPollMultipleChoiceQuestion.m21417q() != null) {
            jsonGenerator.a("url", graphQLResearchPollMultipleChoiceQuestion.m21417q());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
