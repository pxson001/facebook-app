package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: guided_cleanup */
public final class GraphQLFullIndexEducationInfo__JsonHelper {
    public static GraphQLFullIndexEducationInfo m7662a(JsonParser jsonParser) {
        GraphQLFullIndexEducationInfo graphQLFullIndexEducationInfo = new GraphQLFullIndexEducationInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("education_content".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFullIndexEducationInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLFullIndexEducationInfo, "education_content", graphQLFullIndexEducationInfo.a_, 0, false);
            } else if ("eligible_for_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLFullIndexEducationInfo.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFullIndexEducationInfo, "eligible_for_education", graphQLFullIndexEducationInfo.a_, 1, false);
            } else if ("help_center_url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFullIndexEducationInfo.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLFullIndexEducationInfo, "help_center_url", graphQLFullIndexEducationInfo.a_, 2, false);
            } else if ("show_active_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLFullIndexEducationInfo.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFullIndexEducationInfo, "show_active_education", graphQLFullIndexEducationInfo.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLFullIndexEducationInfo;
    }

    public static void m7663a(JsonGenerator jsonGenerator, GraphQLFullIndexEducationInfo graphQLFullIndexEducationInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFullIndexEducationInfo.a() != null) {
            jsonGenerator.a("education_content", graphQLFullIndexEducationInfo.a());
        }
        jsonGenerator.a("eligible_for_education", graphQLFullIndexEducationInfo.j());
        if (graphQLFullIndexEducationInfo.k() != null) {
            jsonGenerator.a("help_center_url", graphQLFullIndexEducationInfo.k());
        }
        jsonGenerator.a("show_active_education", graphQLFullIndexEducationInfo.l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
