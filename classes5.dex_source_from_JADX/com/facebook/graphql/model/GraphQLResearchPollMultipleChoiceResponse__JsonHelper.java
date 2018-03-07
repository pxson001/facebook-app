package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_HOME */
public final class GraphQLResearchPollMultipleChoiceResponse__JsonHelper {
    public static GraphQLResearchPollMultipleChoiceResponse m21434a(JsonParser jsonParser) {
        GraphQLResearchPollMultipleChoiceResponse graphQLResearchPollMultipleChoiceResponse = new GraphQLResearchPollMultipleChoiceResponse();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("answer".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceResponse.f12923d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceResponse, "answer", graphQLResearchPollMultipleChoiceResponse.a_, 0, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceResponse.f12924e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceResponse, "id", graphQLResearchPollMultipleChoiceResponse.a_, 1, false);
            } else if ("next_question".equals(i)) {
                GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLResearchPollMultipleChoiceQuestion = null;
                } else {
                    graphQLResearchPollMultipleChoiceQuestion = GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21420a(FieldAccessQueryTracker.a(jsonParser, "next_question"));
                }
                graphQLResearchPollMultipleChoiceResponse.f12925f = graphQLResearchPollMultipleChoiceQuestion;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceResponse, "next_question", graphQLResearchPollMultipleChoiceResponse.a_, 2, true);
            } else if ("response_responders".equals(i)) {
                GraphQLResearchPollResponseRespondersConnection graphQLResearchPollResponseRespondersConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLResearchPollResponseRespondersConnection = null;
                } else {
                    graphQLResearchPollResponseRespondersConnection = GraphQLResearchPollResponseRespondersConnection__JsonHelper.m21463a(FieldAccessQueryTracker.a(jsonParser, "response_responders"));
                }
                graphQLResearchPollMultipleChoiceResponse.f12926g = graphQLResearchPollResponseRespondersConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceResponse, "response_responders", graphQLResearchPollMultipleChoiceResponse.a_, 3, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLResearchPollMultipleChoiceResponse.f12927h = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollMultipleChoiceResponse, "url", graphQLResearchPollMultipleChoiceResponse.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLResearchPollMultipleChoiceResponse;
    }

    public static void m21435a(JsonGenerator jsonGenerator, GraphQLResearchPollMultipleChoiceResponse graphQLResearchPollMultipleChoiceResponse, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLResearchPollMultipleChoiceResponse.m21427j() != null) {
            jsonGenerator.a("answer", graphQLResearchPollMultipleChoiceResponse.m21427j());
        }
        if (graphQLResearchPollMultipleChoiceResponse.m21428k() != null) {
            jsonGenerator.a("id", graphQLResearchPollMultipleChoiceResponse.m21428k());
        }
        if (graphQLResearchPollMultipleChoiceResponse.m21429l() != null) {
            jsonGenerator.a("next_question");
            GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21421a(jsonGenerator, graphQLResearchPollMultipleChoiceResponse.m21429l(), true);
        }
        if (graphQLResearchPollMultipleChoiceResponse.m21430m() != null) {
            jsonGenerator.a("response_responders");
            GraphQLResearchPollResponseRespondersConnection__JsonHelper.m21464a(jsonGenerator, graphQLResearchPollMultipleChoiceResponse.m21430m(), true);
        }
        if (graphQLResearchPollMultipleChoiceResponse.m21431n() != null) {
            jsonGenerator.a("url", graphQLResearchPollMultipleChoiceResponse.m21431n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
