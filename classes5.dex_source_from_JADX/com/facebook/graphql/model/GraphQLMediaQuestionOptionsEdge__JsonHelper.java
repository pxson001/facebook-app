package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: favicon */
public final class GraphQLMediaQuestionOptionsEdge__JsonHelper {
    public static GraphQLMediaQuestionOptionsEdge m9058a(JsonParser jsonParser) {
        GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge = new GraphQLMediaQuestionOptionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLMediaQuestionOption graphQLMediaQuestionOption;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLMediaQuestionOption = null;
                } else {
                    graphQLMediaQuestionOption = GraphQLMediaQuestionOption__JsonHelper.m9043a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLMediaQuestionOptionsEdge.f4486d = graphQLMediaQuestionOption;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOptionsEdge, "node", graphQLMediaQuestionOptionsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLMediaQuestionOptionsEdge;
    }

    public static void m9059a(JsonGenerator jsonGenerator, GraphQLMediaQuestionOptionsEdge graphQLMediaQuestionOptionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMediaQuestionOptionsEdge.m9054a() != null) {
            jsonGenerator.a("node");
            GraphQLMediaQuestionOption__JsonHelper.m9044a(jsonGenerator, graphQLMediaQuestionOptionsEdge.m9054a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
