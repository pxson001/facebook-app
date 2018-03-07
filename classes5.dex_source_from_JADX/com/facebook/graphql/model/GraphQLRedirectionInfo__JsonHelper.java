package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLRedirectionReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_MODULE */
public final class GraphQLRedirectionInfo__JsonHelper {
    public static GraphQLRedirectionInfo m21381a(JsonParser jsonParser) {
        GraphQLRedirectionInfo graphQLRedirectionInfo = new GraphQLRedirectionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21383a(graphQLRedirectionInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLRedirectionInfo;
    }

    private static boolean m21383a(GraphQLRedirectionInfo graphQLRedirectionInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("node".equals(str)) {
            GraphQLNode a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLRedirectionInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLRedirectionInfo, "node", graphQLRedirectionInfo.a_, 0, true);
            return true;
        } else if ("reason".equals(str)) {
            graphQLRedirectionInfo.e = GraphQLRedirectionReason.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLRedirectionInfo, "reason", graphQLRedirectionInfo.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLRedirectionInfo.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLRedirectionInfo, "url", graphQLRedirectionInfo.B_(), 2, false);
            return true;
        }
    }

    public static void m21382a(JsonGenerator jsonGenerator, GraphQLRedirectionInfo graphQLRedirectionInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLRedirectionInfo.a() != null) {
            jsonGenerator.a("node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLRedirectionInfo.a(), true);
        }
        if (graphQLRedirectionInfo.j() != null) {
            jsonGenerator.a("reason", graphQLRedirectionInfo.j().toString());
        }
        if (graphQLRedirectionInfo.k() != null) {
            jsonGenerator.a("url", graphQLRedirectionInfo.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
