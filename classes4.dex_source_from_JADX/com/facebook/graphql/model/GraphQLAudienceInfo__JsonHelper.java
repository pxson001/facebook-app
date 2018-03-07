package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: refetch_count */
public final class GraphQLAudienceInfo__JsonHelper {
    public static GraphQLAudienceInfo m3913a(JsonParser jsonParser) {
        GraphQLAudienceInfo graphQLAudienceInfo = new GraphQLAudienceInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3915a(graphQLAudienceInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLAudienceInfo;
    }

    private static boolean m3915a(GraphQLAudienceInfo graphQLAudienceInfo, String str, JsonParser jsonParser) {
        if ("composer_privacy_guardrail_info".equals(str)) {
            GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLComposerPrivacyGuardrailInfo = null;
            } else {
                graphQLComposerPrivacyGuardrailInfo = GraphQLComposerPrivacyGuardrailInfo__JsonHelper.m3916a(FieldAccessQueryTracker.m2235a(jsonParser, "composer_privacy_guardrail_info"));
            }
            graphQLAudienceInfo.f2207d = graphQLComposerPrivacyGuardrailInfo;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLAudienceInfo, "composer_privacy_guardrail_info", graphQLAudienceInfo.a_, 0, true);
            return true;
        } else if ("eligible_for_audience_alignment_education".equals(str)) {
            graphQLAudienceInfo.f2208e = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLAudienceInfo, "eligible_for_audience_alignment_education", graphQLAudienceInfo.B_(), 1, false);
            return true;
        } else if ("eligible_for_audience_alignment_only_me_education".equals(str)) {
            graphQLAudienceInfo.f2209f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLAudienceInfo, "eligible_for_audience_alignment_only_me_education", graphQLAudienceInfo.B_(), 2, false);
            return true;
        } else if ("eligible_for_newcomer_audience_selector".equals(str)) {
            graphQLAudienceInfo.f2210g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLAudienceInfo, "eligible_for_newcomer_audience_selector", graphQLAudienceInfo.B_(), 3, false);
            return true;
        } else if (!"has_default_privacy".equals(str)) {
            return false;
        } else {
            graphQLAudienceInfo.f2211h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLAudienceInfo, "has_default_privacy", graphQLAudienceInfo.B_(), 4, false);
            return true;
        }
    }

    public static void m3914a(JsonGenerator jsonGenerator, GraphQLAudienceInfo graphQLAudienceInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAudienceInfo.m2391a() != null) {
            jsonGenerator.a("composer_privacy_guardrail_info");
            GraphQLComposerPrivacyGuardrailInfo__JsonHelper.m3917a(jsonGenerator, graphQLAudienceInfo.m2391a(), true);
        }
        jsonGenerator.a("eligible_for_audience_alignment_education", graphQLAudienceInfo.m2394j());
        jsonGenerator.a("eligible_for_audience_alignment_only_me_education", graphQLAudienceInfo.m2395k());
        jsonGenerator.a("eligible_for_newcomer_audience_selector", graphQLAudienceInfo.m2396l());
        jsonGenerator.a("has_default_privacy", graphQLAudienceInfo.m2397m());
        if (z) {
            jsonGenerator.g();
        }
    }
}
