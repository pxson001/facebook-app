package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIDEO_CREATOR_SPACE */
public final class GraphQLResearchPollQuestionResponsesConnection__JsonHelper {
    public static GraphQLResearchPollQuestionResponsesConnection m21453a(JsonParser jsonParser) {
        GraphQLResearchPollQuestionResponsesConnection graphQLResearchPollQuestionResponsesConnection = new GraphQLResearchPollQuestionResponsesConnection();
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
                        GraphQLResearchPollMultipleChoiceResponse a = GraphQLResearchPollMultipleChoiceResponse__JsonHelper.m21434a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLResearchPollQuestionResponsesConnection.f12929d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollQuestionResponsesConnection, "nodes", graphQLResearchPollQuestionResponsesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLResearchPollQuestionResponsesConnection;
    }

    public static void m21454a(JsonGenerator jsonGenerator, GraphQLResearchPollQuestionResponsesConnection graphQLResearchPollQuestionResponsesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLResearchPollQuestionResponsesConnection.m21450a() != null) {
            jsonGenerator.d();
            for (GraphQLResearchPollMultipleChoiceResponse graphQLResearchPollMultipleChoiceResponse : graphQLResearchPollQuestionResponsesConnection.m21450a()) {
                if (graphQLResearchPollMultipleChoiceResponse != null) {
                    GraphQLResearchPollMultipleChoiceResponse__JsonHelper.m21435a(jsonGenerator, graphQLResearchPollMultipleChoiceResponse, true);
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
