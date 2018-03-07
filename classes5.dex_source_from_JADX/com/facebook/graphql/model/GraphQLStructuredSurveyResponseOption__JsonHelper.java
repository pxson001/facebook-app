package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UPSELL_WITHOUT_DATA_CONTROL */
public final class GraphQLStructuredSurveyResponseOption__JsonHelper {
    public static GraphQLStructuredSurveyResponseOption m21994a(JsonParser jsonParser) {
        GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption = new GraphQLStructuredSurveyResponseOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21996a(graphQLStructuredSurveyResponseOption, i, jsonParser);
            jsonParser.f();
        }
        return graphQLStructuredSurveyResponseOption;
    }

    private static boolean m21996a(GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("option_numeric_value".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLStructuredSurveyResponseOption.f13224d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyResponseOption, "option_numeric_value", graphQLStructuredSurveyResponseOption.a_, 0, false);
            return true;
        } else if ("option_text".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "option_text"));
            }
            graphQLStructuredSurveyResponseOption.f13225e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyResponseOption, "option_text", graphQLStructuredSurveyResponseOption.B_(), 1, true);
            return true;
        } else if (!"option_value".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStructuredSurveyResponseOption.f13226f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStructuredSurveyResponseOption, "option_value", graphQLStructuredSurveyResponseOption.B_(), 2, false);
            return true;
        }
    }

    public static void m21995a(JsonGenerator jsonGenerator, GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("option_numeric_value", graphQLStructuredSurveyResponseOption.m21986a());
        if (graphQLStructuredSurveyResponseOption.m21990j() != null) {
            jsonGenerator.a("option_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStructuredSurveyResponseOption.m21990j(), true);
        }
        if (graphQLStructuredSurveyResponseOption.m21991k() != null) {
            jsonGenerator.a("option_value", graphQLStructuredSurveyResponseOption.m21991k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
