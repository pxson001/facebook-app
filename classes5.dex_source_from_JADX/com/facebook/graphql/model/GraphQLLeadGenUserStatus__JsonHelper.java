package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: feed_attachment */
public final class GraphQLLeadGenUserStatus__JsonHelper {
    public static GraphQLLeadGenUserStatus m8908a(JsonParser jsonParser) {
        GraphQLLeadGenUserStatus graphQLLeadGenUserStatus = new GraphQLLeadGenUserStatus();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("has_shared_info".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLLeadGenUserStatus.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenUserStatus, "has_shared_info", graphQLLeadGenUserStatus.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenUserStatus.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenUserStatus, "id", graphQLLeadGenUserStatus.a_, 1, false);
            } else if ("signed_request".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenUserStatus.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenUserStatus, "signed_request", graphQLLeadGenUserStatus.a_, 2, false);
            } else if ("split_flow_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenUserStatus.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenUserStatus, "split_flow_url", graphQLLeadGenUserStatus.a_, 3, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenUserStatus.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenUserStatus, "url", graphQLLeadGenUserStatus.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLLeadGenUserStatus;
    }

    public static void m8909a(JsonGenerator jsonGenerator, GraphQLLeadGenUserStatus graphQLLeadGenUserStatus, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("has_shared_info", graphQLLeadGenUserStatus.j());
        if (graphQLLeadGenUserStatus.k() != null) {
            jsonGenerator.a("id", graphQLLeadGenUserStatus.k());
        }
        if (graphQLLeadGenUserStatus.l() != null) {
            jsonGenerator.a("signed_request", graphQLLeadGenUserStatus.l());
        }
        if (graphQLLeadGenUserStatus.m() != null) {
            jsonGenerator.a("split_flow_url", graphQLLeadGenUserStatus.m());
        }
        if (graphQLLeadGenUserStatus.n() != null) {
            jsonGenerator.a("url", graphQLLeadGenUserStatus.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
