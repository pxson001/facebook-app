package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: feed_story_visibility */
public final class GraphQLLeadGenDeepLinkUserStatus__JsonHelper {
    public static GraphQLLeadGenDeepLinkUserStatus m8827a(JsonParser jsonParser) {
        GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus = new GraphQLLeadGenDeepLinkUserStatus();
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
                graphQLLeadGenDeepLinkUserStatus.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenDeepLinkUserStatus, "has_shared_info", graphQLLeadGenDeepLinkUserStatus.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenDeepLinkUserStatus.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenDeepLinkUserStatus, "id", graphQLLeadGenDeepLinkUserStatus.a_, 1, false);
            } else if ("signed_request".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenDeepLinkUserStatus.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenDeepLinkUserStatus, "signed_request", graphQLLeadGenDeepLinkUserStatus.a_, 2, false);
            } else if ("split_flow_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenDeepLinkUserStatus.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenDeepLinkUserStatus, "split_flow_url", graphQLLeadGenDeepLinkUserStatus.a_, 3, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenDeepLinkUserStatus.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenDeepLinkUserStatus, "url", graphQLLeadGenDeepLinkUserStatus.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLLeadGenDeepLinkUserStatus;
    }

    public static void m8828a(JsonGenerator jsonGenerator, GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("has_shared_info", graphQLLeadGenDeepLinkUserStatus.j());
        if (graphQLLeadGenDeepLinkUserStatus.k() != null) {
            jsonGenerator.a("id", graphQLLeadGenDeepLinkUserStatus.k());
        }
        if (graphQLLeadGenDeepLinkUserStatus.l() != null) {
            jsonGenerator.a("signed_request", graphQLLeadGenDeepLinkUserStatus.l());
        }
        if (graphQLLeadGenDeepLinkUserStatus.m() != null) {
            jsonGenerator.a("split_flow_url", graphQLLeadGenDeepLinkUserStatus.m());
        }
        if (graphQLLeadGenDeepLinkUserStatus.n() != null) {
            jsonGenerator.a("url", graphQLLeadGenDeepLinkUserStatus.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
