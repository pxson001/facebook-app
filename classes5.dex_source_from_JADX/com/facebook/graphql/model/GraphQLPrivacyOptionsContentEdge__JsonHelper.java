package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VideoChannelFeedEdge */
public final class GraphQLPrivacyOptionsContentEdge__JsonHelper {
    public static GraphQLPrivacyOptionsContentEdge m21017a(JsonParser jsonParser) {
        GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge = new GraphQLPrivacyOptionsContentEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21019a(graphQLPrivacyOptionsContentEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPrivacyOptionsContentEdge;
    }

    private static boolean m21019a(GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge, String str, JsonParser jsonParser) {
        if ("is_currently_selected".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLPrivacyOptionsContentEdge.d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyOptionsContentEdge, "is_currently_selected", graphQLPrivacyOptionsContentEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            graphQLPrivacyOptionsContentEdge.e = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLPrivacyOption__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyOptionsContentEdge, "node", graphQLPrivacyOptionsContentEdge.B_(), 1, true);
            return true;
        } else if (!"option_type".equals(str)) {
            return false;
        } else {
            graphQLPrivacyOptionsContentEdge.f = GraphQLPrivacyOptionInfoType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyOptionsContentEdge, "option_type", graphQLPrivacyOptionsContentEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m21018a(JsonGenerator jsonGenerator, GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_currently_selected", graphQLPrivacyOptionsContentEdge.a());
        if (graphQLPrivacyOptionsContentEdge.j() != null) {
            jsonGenerator.a("node");
            GraphQLPrivacyOption__JsonHelper.a(jsonGenerator, graphQLPrivacyOptionsContentEdge.j(), true);
        }
        if (graphQLPrivacyOptionsContentEdge.k() != null) {
            jsonGenerator.a("option_type", graphQLPrivacyOptionsContentEdge.k().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
