package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: feed_omnistore_delta_mod_50 */
public final class GraphQLLeadGenLegalContent__JsonHelper {
    public static GraphQLLeadGenLegalContent m8881a(JsonParser jsonParser) {
        GraphQLLeadGenLegalContent graphQLLeadGenLegalContent = new GraphQLLeadGenLegalContent();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8883a(graphQLLeadGenLegalContent, i, jsonParser);
            jsonParser.f();
        }
        return graphQLLeadGenLegalContent;
    }

    private static boolean m8883a(GraphQLLeadGenLegalContent graphQLLeadGenLegalContent, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("advertiser_privacy_policy_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenLegalContent.f4379d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContent, "advertiser_privacy_policy_name", graphQLLeadGenLegalContent.a_, 0, false);
            return true;
        } else if ("checkboxes".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLLeadGenLegalContentCheckbox a = GraphQLLeadGenLegalContentCheckbox__JsonHelper.m8876a(FieldAccessQueryTracker.a(jsonParser, "checkboxes"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLLeadGenLegalContent.f4380e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContent, "checkboxes", graphQLLeadGenLegalContent.B_(), 1, true);
            return true;
        } else if ("disclaimer_body".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTextWithEntities a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "disclaimer_body"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLLeadGenLegalContent.f4381f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContent, "disclaimer_body", graphQLLeadGenLegalContent.B_(), 2, true);
            return true;
        } else if (!"disclaimer_title".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenLegalContent.f4382g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContent, "disclaimer_title", graphQLLeadGenLegalContent.B_(), 3, false);
            return true;
        }
    }

    public static void m8882a(JsonGenerator jsonGenerator, GraphQLLeadGenLegalContent graphQLLeadGenLegalContent, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenLegalContent.m8858a() != null) {
            jsonGenerator.a("advertiser_privacy_policy_name", graphQLLeadGenLegalContent.m8858a());
        }
        jsonGenerator.a("checkboxes");
        if (graphQLLeadGenLegalContent.m8859j() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox : graphQLLeadGenLegalContent.m8859j()) {
                if (graphQLLeadGenLegalContentCheckbox != null) {
                    GraphQLLeadGenLegalContentCheckbox__JsonHelper.m8877a(jsonGenerator, graphQLLeadGenLegalContentCheckbox, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("disclaimer_body");
        if (graphQLLeadGenLegalContent.m8860k() != null) {
            jsonGenerator.d();
            for (GraphQLTextWithEntities graphQLTextWithEntities : graphQLLeadGenLegalContent.m8860k()) {
                if (graphQLTextWithEntities != null) {
                    GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTextWithEntities, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenLegalContent.m8861l() != null) {
            jsonGenerator.a("disclaimer_title", graphQLLeadGenLegalContent.m8861l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
