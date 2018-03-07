package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLStructuredSurveyCustomQuestionType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: US */
public final class GraphQLStructuredSurveyConfiguredQuestion__JsonHelper {
    public static boolean m21956a(GraphQLStructuredSurveyConfiguredQuestion graphQLStructuredSurveyConfiguredQuestion, String str, JsonParser jsonParser) {
        List list = null;
        if ("allow_write_in_response".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLStructuredSurveyConfiguredQuestion.f13207d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "allow_write_in_response", graphQLStructuredSurveyConfiguredQuestion.a_, 0, false);
            return true;
        } else if ("body".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "body"));
            }
            graphQLStructuredSurveyConfiguredQuestion.f13208e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "body", graphQLStructuredSurveyConfiguredQuestion.B_(), 1, true);
            return true;
        } else if ("custom_question_type".equals(str)) {
            graphQLStructuredSurveyConfiguredQuestion.f13209f = GraphQLStructuredSurveyCustomQuestionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "custom_question_type", graphQLStructuredSurveyConfiguredQuestion.B_(), 2, false);
            return true;
        } else if ("is_required".equals(str)) {
            graphQLStructuredSurveyConfiguredQuestion.f13210g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "is_required", graphQLStructuredSurveyConfiguredQuestion.B_(), 3, false);
            return true;
        } else if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLStructuredSurveyConfiguredQuestion.f13211h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "message", graphQLStructuredSurveyConfiguredQuestion.B_(), 4, true);
            return true;
        } else if ("question_class".equals(str)) {
            graphQLStructuredSurveyConfiguredQuestion.f13212i = GraphQLStructuredSurveyQuestionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "question_class", graphQLStructuredSurveyConfiguredQuestion.B_(), 5, false);
            return true;
        } else if ("question_id".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLStructuredSurveyConfiguredQuestion.f13213j = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "question_id", graphQLStructuredSurveyConfiguredQuestion.B_(), 6, false);
            return true;
        } else if ("response_options".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStructuredSurveyResponseOption a = GraphQLStructuredSurveyResponseOption__JsonHelper.m21994a(FieldAccessQueryTracker.a(jsonParser, "response_options"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLStructuredSurveyConfiguredQuestion.f13214k = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "response_options", graphQLStructuredSurveyConfiguredQuestion.B_(), 7, true);
            return true;
        } else if (!"subquestion_labels".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTextWithEntities a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subquestion_labels"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLStructuredSurveyConfiguredQuestion.f13215l = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyConfiguredQuestion, "subquestion_labels", graphQLStructuredSurveyConfiguredQuestion.B_(), 8, true);
            return true;
        }
    }
}
