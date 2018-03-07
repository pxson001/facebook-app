package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT_SQUARE */
public final class GraphQLResearchPollSurveyQuestionHistoryConnection__JsonHelper {
    public static GraphQLResearchPollSurveyQuestionHistoryConnection m21486a(JsonParser jsonParser) {
        GraphQLResearchPollSurveyQuestionHistoryConnection graphQLResearchPollSurveyQuestionHistoryConnection = new GraphQLResearchPollSurveyQuestionHistoryConnection();
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
                        GraphQLResearchPollMultipleChoiceQuestion a = GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21420a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLResearchPollSurveyQuestionHistoryConnection.f12938d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurveyQuestionHistoryConnection, "nodes", graphQLResearchPollSurveyQuestionHistoryConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLResearchPollSurveyQuestionHistoryConnection;
    }

    public static void m21487a(JsonGenerator jsonGenerator, GraphQLResearchPollSurveyQuestionHistoryConnection graphQLResearchPollSurveyQuestionHistoryConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLResearchPollSurveyQuestionHistoryConnection.m21483a() != null) {
            jsonGenerator.d();
            for (GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion : graphQLResearchPollSurveyQuestionHistoryConnection.m21483a()) {
                if (graphQLResearchPollMultipleChoiceQuestion != null) {
                    GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21421a(jsonGenerator, graphQLResearchPollMultipleChoiceQuestion, true);
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
