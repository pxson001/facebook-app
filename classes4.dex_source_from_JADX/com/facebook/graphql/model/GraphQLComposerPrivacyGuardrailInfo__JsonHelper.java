package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: refetch_cancel_requested */
public final class GraphQLComposerPrivacyGuardrailInfo__JsonHelper {
    public static GraphQLComposerPrivacyGuardrailInfo m3916a(JsonParser jsonParser) {
        GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo = new GraphQLComposerPrivacyGuardrailInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3918a(graphQLComposerPrivacyGuardrailInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLComposerPrivacyGuardrailInfo;
    }

    private static boolean m3918a(GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo, String str, JsonParser jsonParser) {
        GraphQLPrivacyOption graphQLPrivacyOption = null;
        if ("current_privacy_option".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPrivacyOption = GraphQLPrivacyOption__JsonHelper.m2255a(FieldAccessQueryTracker.m2235a(jsonParser, "current_privacy_option"));
            }
            graphQLComposerPrivacyGuardrailInfo.f3533d = graphQLPrivacyOption;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComposerPrivacyGuardrailInfo, "current_privacy_option", graphQLComposerPrivacyGuardrailInfo.a_, 0, true);
            return true;
        } else if ("eligible_for_guardrail".equals(str)) {
            graphQLComposerPrivacyGuardrailInfo.f3534e = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComposerPrivacyGuardrailInfo, "eligible_for_guardrail", graphQLComposerPrivacyGuardrailInfo.B_(), 1, false);
            return true;
        } else if ("suggested_option_timestamp".equals(str)) {
            graphQLComposerPrivacyGuardrailInfo.f3535f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComposerPrivacyGuardrailInfo, "suggested_option_timestamp", graphQLComposerPrivacyGuardrailInfo.B_(), 2, false);
            return true;
        } else if (!"suggested_privacy_option".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPrivacyOption = GraphQLPrivacyOption__JsonHelper.m2255a(FieldAccessQueryTracker.m2235a(jsonParser, "suggested_privacy_option"));
            }
            graphQLComposerPrivacyGuardrailInfo.f3536g = graphQLPrivacyOption;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLComposerPrivacyGuardrailInfo, "suggested_privacy_option", graphQLComposerPrivacyGuardrailInfo.B_(), 3, true);
            return true;
        }
    }

    public static void m3917a(JsonGenerator jsonGenerator, GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLComposerPrivacyGuardrailInfo.m3920a() != null) {
            jsonGenerator.a("current_privacy_option");
            GraphQLPrivacyOption__JsonHelper.m2256a(jsonGenerator, graphQLComposerPrivacyGuardrailInfo.m3920a(), true);
        }
        jsonGenerator.a("eligible_for_guardrail", graphQLComposerPrivacyGuardrailInfo.m3923j());
        jsonGenerator.a("suggested_option_timestamp", graphQLComposerPrivacyGuardrailInfo.m3924k());
        if (graphQLComposerPrivacyGuardrailInfo.m3925l() != null) {
            jsonGenerator.a("suggested_privacy_option");
            GraphQLPrivacyOption__JsonHelper.m2256a(jsonGenerator, graphQLComposerPrivacyGuardrailInfo.m3925l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
