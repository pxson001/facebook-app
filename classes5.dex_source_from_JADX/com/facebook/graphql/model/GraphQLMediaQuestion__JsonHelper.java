package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fan_context_story */
public final class GraphQLMediaQuestion__JsonHelper {
    public static GraphQLMediaQuestion m9061a(JsonParser jsonParser) {
        GraphQLMediaQuestion graphQLMediaQuestion = new GraphQLMediaQuestion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9063a(graphQLMediaQuestion, i, jsonParser);
            jsonParser.f();
        }
        return graphQLMediaQuestion;
    }

    private static boolean m9063a(GraphQLMediaQuestion graphQLMediaQuestion, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMediaQuestion.f4475d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "id", graphQLMediaQuestion.a_, 0, false);
            return true;
        } else if ("media_question_option_order".equals(str)) {
            GraphQLMediaQuestionOptionsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLMediaQuestionOptionsConnection__JsonHelper.m9049a(FieldAccessQueryTracker.a(jsonParser, "media_question_option_order"));
            }
            graphQLMediaQuestion.f4476e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "media_question_option_order", graphQLMediaQuestion.B_(), 1, true);
            return true;
        } else if ("media_question_photos".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhoto a2 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "media_question_photos"));
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
            graphQLMediaQuestion.f4477f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "media_question_photos", graphQLMediaQuestion.B_(), 2, true);
            return true;
        } else if ("media_question_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMediaQuestion.f4478g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "media_question_type", graphQLMediaQuestion.B_(), 3, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMediaQuestion.f4479h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "url", graphQLMediaQuestion.B_(), 4, false);
            return true;
        } else if (!"viewer_has_voted".equals(str)) {
            return false;
        } else {
            graphQLMediaQuestion.f4480i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestion, "viewer_has_voted", graphQLMediaQuestion.B_(), 5, false);
            return true;
        }
    }

    public static void m9062a(JsonGenerator jsonGenerator, GraphQLMediaQuestion graphQLMediaQuestion, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMediaQuestion.m9021j() != null) {
            jsonGenerator.a("id", graphQLMediaQuestion.m9021j());
        }
        if (graphQLMediaQuestion.m9022k() != null) {
            jsonGenerator.a("media_question_option_order");
            GraphQLMediaQuestionOptionsConnection__JsonHelper.m9050a(jsonGenerator, graphQLMediaQuestion.m9022k(), true);
        }
        jsonGenerator.a("media_question_photos");
        if (graphQLMediaQuestion.m9023l() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLMediaQuestion.m9023l()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMediaQuestion.m9024m() != null) {
            jsonGenerator.a("media_question_type", graphQLMediaQuestion.m9024m());
        }
        if (graphQLMediaQuestion.m9025n() != null) {
            jsonGenerator.a("url", graphQLMediaQuestion.m9025n());
        }
        jsonGenerator.a("viewer_has_voted", graphQLMediaQuestion.m9026o());
        if (z) {
            jsonGenerator.g();
        }
    }
}
