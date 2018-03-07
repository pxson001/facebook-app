package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friend_requestee_ids */
public final class GraphQLGroupMallAdsEducationInfo__JsonHelper {
    public static GraphQLGroupMallAdsEducationInfo m8436a(JsonParser jsonParser) {
        GraphQLGroupMallAdsEducationInfo graphQLGroupMallAdsEducationInfo = new GraphQLGroupMallAdsEducationInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("education_content".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGroupMallAdsEducationInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallAdsEducationInfo, "education_content", graphQLGroupMallAdsEducationInfo.a_, 0, false);
            } else if ("eligible_for_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLGroupMallAdsEducationInfo.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallAdsEducationInfo, "eligible_for_education", graphQLGroupMallAdsEducationInfo.a_, 1, false);
            } else if ("show_active_education".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLGroupMallAdsEducationInfo.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMallAdsEducationInfo, "show_active_education", graphQLGroupMallAdsEducationInfo.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLGroupMallAdsEducationInfo;
    }

    public static void m8437a(JsonGenerator jsonGenerator, GraphQLGroupMallAdsEducationInfo graphQLGroupMallAdsEducationInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupMallAdsEducationInfo.a() != null) {
            jsonGenerator.a("education_content", graphQLGroupMallAdsEducationInfo.a());
        }
        jsonGenerator.a("eligible_for_education", graphQLGroupMallAdsEducationInfo.j());
        jsonGenerator.a("show_active_education", graphQLGroupMallAdsEducationInfo.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
