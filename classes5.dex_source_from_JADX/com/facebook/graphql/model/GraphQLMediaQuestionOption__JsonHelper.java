package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fb4a_group_profile_more */
public final class GraphQLMediaQuestionOption__JsonHelper {
    public static GraphQLMediaQuestionOption m9043a(JsonParser jsonParser) {
        GraphQLMediaQuestionOption graphQLMediaQuestionOption = new GraphQLMediaQuestionOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMediaQuestionOption.f4481d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOption, "id", graphQLMediaQuestionOption.a_, 0, false);
            } else if ("option_text".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMediaQuestionOption.f4482e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOption, "option_text", graphQLMediaQuestionOption.a_, 1, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMediaQuestionOption.f4483f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOption, "url", graphQLMediaQuestionOption.a_, 2, false);
            } else if ("viewer_has_chosen".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLMediaQuestionOption.f4484g = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOption, "viewer_has_chosen", graphQLMediaQuestionOption.a_, 3, false);
            } else if ("vote_count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLMediaQuestionOption.f4485h = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaQuestionOption, "vote_count", graphQLMediaQuestionOption.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLMediaQuestionOption;
    }

    public static void m9044a(JsonGenerator jsonGenerator, GraphQLMediaQuestionOption graphQLMediaQuestionOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMediaQuestionOption.m9036j() != null) {
            jsonGenerator.a("id", graphQLMediaQuestionOption.m9036j());
        }
        if (graphQLMediaQuestionOption.m9037k() != null) {
            jsonGenerator.a("option_text", graphQLMediaQuestionOption.m9037k());
        }
        if (graphQLMediaQuestionOption.m9038l() != null) {
            jsonGenerator.a("url", graphQLMediaQuestionOption.m9038l());
        }
        jsonGenerator.a("viewer_has_chosen", graphQLMediaQuestionOption.m9039m());
        jsonGenerator.a("vote_count", graphQLMediaQuestionOption.m9040n());
        if (z) {
            jsonGenerator.g();
        }
    }
}
