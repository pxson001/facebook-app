package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_CHANNEL_CIRCLE */
public final class GraphQLReshareEducationInfo__JsonHelper {
    public static GraphQLReshareEducationInfo m21496a(JsonParser jsonParser) {
        GraphQLReshareEducationInfo graphQLReshareEducationInfo = new GraphQLReshareEducationInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("education_content".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLReshareEducationInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLReshareEducationInfo, "education_content", graphQLReshareEducationInfo.a_, 0, false);
            } else if ("eligible_for_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLReshareEducationInfo.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLReshareEducationInfo, "eligible_for_education", graphQLReshareEducationInfo.a_, 1, false);
            } else if ("show_active_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLReshareEducationInfo.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLReshareEducationInfo, "show_active_education", graphQLReshareEducationInfo.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLReshareEducationInfo;
    }

    public static void m21497a(JsonGenerator jsonGenerator, GraphQLReshareEducationInfo graphQLReshareEducationInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLReshareEducationInfo.a() != null) {
            jsonGenerator.a("education_content", graphQLReshareEducationInfo.a());
        }
        jsonGenerator.a("eligible_for_education", graphQLReshareEducationInfo.j());
        jsonGenerator.a("show_active_education", graphQLReshareEducationInfo.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
