package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT_PRUNE_LIVE_SEAL */
public final class GraphQLResearchPollSurvey__JsonHelper {
    public static GraphQLResearchPollSurvey m21489a(JsonParser jsonParser) {
        GraphQLResearchPollSurvey graphQLResearchPollSurvey = new GraphQLResearchPollSurvey();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21491a(graphQLResearchPollSurvey, i, jsonParser);
            jsonParser.f();
        }
        return graphQLResearchPollSurvey;
    }

    private static boolean m21491a(GraphQLResearchPollSurvey graphQLResearchPollSurvey, String str, JsonParser jsonParser) {
        GraphQLResearchPollSurveyQuestionHistoryConnection graphQLResearchPollSurveyQuestionHistoryConnection = null;
        if ("actor".equals(str)) {
            GraphQLActor a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "actor"));
            }
            graphQLResearchPollSurvey.f12931d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "actor", graphQLResearchPollSurvey.a_, 0, true);
            return true;
        } else if ("first_question".equals(str)) {
            GraphQLResearchPollMultipleChoiceQuestion a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21420a(FieldAccessQueryTracker.a(jsonParser, "first_question"));
            }
            graphQLResearchPollSurvey.f12932e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "first_question", graphQLResearchPollSurvey.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLResearchPollSurvey.f12933f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "id", graphQLResearchPollSurvey.B_(), 2, false);
            return true;
        } else if ("questions".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLResearchPollMultipleChoiceQuestion a3 = GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21420a(FieldAccessQueryTracker.a(jsonParser, "questions"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLResearchPollSurvey.f12934g = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "questions", graphQLResearchPollSurvey.B_(), 3, true);
            return true;
        } else if ("research_poll_complete_time".equals(str)) {
            graphQLResearchPollSurvey.f12935h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "research_poll_complete_time", graphQLResearchPollSurvey.B_(), 4, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLResearchPollSurvey.f12936i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "url", graphQLResearchPollSurvey.B_(), 5, false);
            return true;
        } else if (!"user_question_history".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLResearchPollSurveyQuestionHistoryConnection = GraphQLResearchPollSurveyQuestionHistoryConnection__JsonHelper.m21486a(FieldAccessQueryTracker.a(jsonParser, "user_question_history"));
            }
            graphQLResearchPollSurvey.f12937j = graphQLResearchPollSurveyQuestionHistoryConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLResearchPollSurvey, "user_question_history", graphQLResearchPollSurvey.B_(), 6, true);
            return true;
        }
    }

    public static void m21490a(JsonGenerator jsonGenerator, GraphQLResearchPollSurvey graphQLResearchPollSurvey, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLResearchPollSurvey.m21471j() != null) {
            jsonGenerator.a("actor");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLResearchPollSurvey.m21471j(), true);
        }
        if (graphQLResearchPollSurvey.m21472k() != null) {
            jsonGenerator.a("first_question");
            GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21421a(jsonGenerator, graphQLResearchPollSurvey.m21472k(), true);
        }
        if (graphQLResearchPollSurvey.m21473l() != null) {
            jsonGenerator.a("id", graphQLResearchPollSurvey.m21473l());
        }
        jsonGenerator.a("questions");
        if (graphQLResearchPollSurvey.m21474m() != null) {
            jsonGenerator.d();
            for (GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion : graphQLResearchPollSurvey.m21474m()) {
                if (graphQLResearchPollMultipleChoiceQuestion != null) {
                    GraphQLResearchPollMultipleChoiceQuestion__JsonHelper.m21421a(jsonGenerator, graphQLResearchPollMultipleChoiceQuestion, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("research_poll_complete_time", graphQLResearchPollSurvey.m21475n());
        if (graphQLResearchPollSurvey.m21476o() != null) {
            jsonGenerator.a("url", graphQLResearchPollSurvey.m21476o());
        }
        if (graphQLResearchPollSurvey.m21477p() != null) {
            jsonGenerator.a("user_question_history");
            GraphQLResearchPollSurveyQuestionHistoryConnection__JsonHelper.m21487a(jsonGenerator, graphQLResearchPollSurvey.m21477p(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
