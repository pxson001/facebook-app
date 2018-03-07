package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: feed_connections_pyml */
public final class GraphQLLeadGenPrivacyNode__JsonHelper {
    public static GraphQLLeadGenPrivacyNode m8902a(JsonParser jsonParser) {
        GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode = new GraphQLLeadGenPrivacyNode();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("privacy_text".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLLeadGenPrivacyNode.f4391d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenPrivacyNode, "privacy_text", graphQLLeadGenPrivacyNode.a_, 0, false);
            } else if ("privacy_type".equals(i)) {
                graphQLLeadGenPrivacyNode.f4392e = GraphQLLeadGenPrivacyType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenPrivacyNode, "privacy_type", graphQLLeadGenPrivacyNode.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLLeadGenPrivacyNode;
    }

    public static void m8903a(JsonGenerator jsonGenerator, GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenPrivacyNode.m8898a() != null) {
            jsonGenerator.a("privacy_text", graphQLLeadGenPrivacyNode.m8898a());
        }
        if (graphQLLeadGenPrivacyNode.m8899j() != null) {
            jsonGenerator.a("privacy_type", graphQLLeadGenPrivacyNode.m8899j().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
