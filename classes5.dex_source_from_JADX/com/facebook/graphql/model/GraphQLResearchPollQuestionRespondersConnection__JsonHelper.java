package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_GAME */
public final class GraphQLResearchPollQuestionRespondersConnection__JsonHelper {
    public static GraphQLResearchPollQuestionRespondersConnection m21444a(JsonParser jsonParser) {
        GraphQLResearchPollQuestionRespondersConnection graphQLResearchPollQuestionRespondersConnection = new GraphQLResearchPollQuestionRespondersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLResearchPollQuestionRespondersConnection.f12928d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollQuestionRespondersConnection, "count", graphQLResearchPollQuestionRespondersConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLResearchPollQuestionRespondersConnection;
    }

    public static void m21445a(JsonGenerator jsonGenerator, GraphQLResearchPollQuestionRespondersConnection graphQLResearchPollQuestionRespondersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLResearchPollQuestionRespondersConnection.m21438a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
