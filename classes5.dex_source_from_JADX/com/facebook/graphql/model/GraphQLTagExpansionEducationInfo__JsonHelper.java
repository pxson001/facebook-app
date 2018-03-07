package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNSUPPORTED_BROWSER */
public final class GraphQLTagExpansionEducationInfo__JsonHelper {
    public static GraphQLTagExpansionEducationInfo m22036a(JsonParser jsonParser) {
        GraphQLTagExpansionEducationInfo graphQLTagExpansionEducationInfo = new GraphQLTagExpansionEducationInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("education_content".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTagExpansionEducationInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTagExpansionEducationInfo, "education_content", graphQLTagExpansionEducationInfo.a_, 0, false);
            } else if ("eligible_for_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLTagExpansionEducationInfo.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTagExpansionEducationInfo, "eligible_for_education", graphQLTagExpansionEducationInfo.a_, 1, false);
            } else if ("show_active_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLTagExpansionEducationInfo.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTagExpansionEducationInfo, "show_active_education", graphQLTagExpansionEducationInfo.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLTagExpansionEducationInfo;
    }

    public static void m22037a(JsonGenerator jsonGenerator, GraphQLTagExpansionEducationInfo graphQLTagExpansionEducationInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTagExpansionEducationInfo.a() != null) {
            jsonGenerator.a("education_content", graphQLTagExpansionEducationInfo.a());
        }
        jsonGenerator.a("eligible_for_education", graphQLTagExpansionEducationInfo.j());
        jsonGenerator.a("show_active_education", graphQLTagExpansionEducationInfo.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
