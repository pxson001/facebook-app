package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: feed_omnistore_vpv_db_sync */
public final class GraphQLLeadGenLegalContentCheckbox__JsonHelper {
    public static GraphQLLeadGenLegalContentCheckbox m8876a(JsonParser jsonParser) {
        GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox = new GraphQLLeadGenLegalContentCheckbox();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8878a(graphQLLeadGenLegalContentCheckbox, i, jsonParser);
            jsonParser.f();
        }
        return graphQLLeadGenLegalContentCheckbox;
    }

    private static boolean m8878a(GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("checkbox_body".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "checkbox_body"));
            }
            graphQLLeadGenLegalContentCheckbox.f4383d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "checkbox_body", graphQLLeadGenLegalContentCheckbox.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenLegalContentCheckbox.f4384e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "id", graphQLLeadGenLegalContentCheckbox.B_(), 1, false);
            return true;
        } else if ("is_checked_by_default".equals(str)) {
            graphQLLeadGenLegalContentCheckbox.f4385f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "is_checked_by_default", graphQLLeadGenLegalContentCheckbox.B_(), 2, false);
            return true;
        } else if ("is_required".equals(str)) {
            graphQLLeadGenLegalContentCheckbox.f4386g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "is_required", graphQLLeadGenLegalContentCheckbox.B_(), 3, false);
            return true;
        } else if ("token_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenLegalContentCheckbox.f4387h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "token_key", graphQLLeadGenLegalContentCheckbox.B_(), 4, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenLegalContentCheckbox.f4388i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenLegalContentCheckbox, "url", graphQLLeadGenLegalContentCheckbox.B_(), 5, false);
            return true;
        }
    }

    public static void m8877a(JsonGenerator jsonGenerator, GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenLegalContentCheckbox.m8868j() != null) {
            jsonGenerator.a("checkbox_body");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLLeadGenLegalContentCheckbox.m8868j(), true);
        }
        if (graphQLLeadGenLegalContentCheckbox.m8869k() != null) {
            jsonGenerator.a("id", graphQLLeadGenLegalContentCheckbox.m8869k());
        }
        jsonGenerator.a("is_checked_by_default", graphQLLeadGenLegalContentCheckbox.m8870l());
        jsonGenerator.a("is_required", graphQLLeadGenLegalContentCheckbox.m8871m());
        if (graphQLLeadGenLegalContentCheckbox.m8872n() != null) {
            jsonGenerator.a("token_key", graphQLLeadGenLegalContentCheckbox.m8872n());
        }
        if (graphQLLeadGenLegalContentCheckbox.m8873o() != null) {
            jsonGenerator.a("url", graphQLLeadGenLegalContentCheckbox.m8873o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
