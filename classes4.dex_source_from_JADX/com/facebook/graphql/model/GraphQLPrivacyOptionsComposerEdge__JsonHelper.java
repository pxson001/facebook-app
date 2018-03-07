package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: smsInviteContacts */
public final class GraphQLPrivacyOptionsComposerEdge__JsonHelper {
    public static GraphQLPrivacyOptionsComposerEdge m2245a(JsonParser jsonParser) {
        GraphQLPrivacyOptionsComposerEdge graphQLPrivacyOptionsComposerEdge = new GraphQLPrivacyOptionsComposerEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            boolean z;
            if ("is_currently_selected".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPrivacyOptionsComposerEdge.f2134d = z;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerEdge, "is_currently_selected", graphQLPrivacyOptionsComposerEdge.a_, 0, false);
            } else if ("is_most_recent".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPrivacyOptionsComposerEdge.f2135e = z;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerEdge, "is_most_recent", graphQLPrivacyOptionsComposerEdge.a_, 1, false);
            } else if ("is_primary".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPrivacyOptionsComposerEdge.f2136f = z;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerEdge, "is_primary", graphQLPrivacyOptionsComposerEdge.a_, 2, false);
            } else if ("node".equals(i)) {
                GraphQLPrivacyOption graphQLPrivacyOption;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPrivacyOption = null;
                } else {
                    graphQLPrivacyOption = GraphQLPrivacyOption__JsonHelper.m2255a(FieldAccessQueryTracker.m2235a(jsonParser, "node"));
                }
                graphQLPrivacyOptionsComposerEdge.f2137g = graphQLPrivacyOption;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerEdge, "node", graphQLPrivacyOptionsComposerEdge.a_, 3, true);
            } else if ("option_type".equals(i)) {
                graphQLPrivacyOptionsComposerEdge.f2138h = GraphQLPrivacyOptionInfoType.fromString(jsonParser.o());
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOptionsComposerEdge, "option_type", graphQLPrivacyOptionsComposerEdge.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLPrivacyOptionsComposerEdge;
    }

    public static void m2246a(JsonGenerator jsonGenerator, GraphQLPrivacyOptionsComposerEdge graphQLPrivacyOptionsComposerEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_currently_selected", graphQLPrivacyOptionsComposerEdge.m2250a());
        jsonGenerator.a("is_most_recent", graphQLPrivacyOptionsComposerEdge.m2251j());
        jsonGenerator.a("is_primary", graphQLPrivacyOptionsComposerEdge.m2252k());
        if (graphQLPrivacyOptionsComposerEdge.m2253l() != null) {
            jsonGenerator.a("node");
            GraphQLPrivacyOption__JsonHelper.m2256a(jsonGenerator, graphQLPrivacyOptionsComposerEdge.m2253l(), true);
        }
        if (graphQLPrivacyOptionsComposerEdge.m2254m() != null) {
            jsonGenerator.a("option_type", graphQLPrivacyOptionsComposerEdge.m2254m().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
