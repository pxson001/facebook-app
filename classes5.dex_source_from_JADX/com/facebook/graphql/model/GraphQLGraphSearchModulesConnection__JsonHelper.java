package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getBluetoothPingCount */
public final class GraphQLGraphSearchModulesConnection__JsonHelper {
    public static GraphQLGraphSearchModulesConnection m8171a(JsonParser jsonParser) {
        GraphQLGraphSearchModulesConnection graphQLGraphSearchModulesConnection = new GraphQLGraphSearchModulesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8173a(graphQLGraphSearchModulesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGraphSearchModulesConnection;
    }

    private static boolean m8173a(GraphQLGraphSearchModulesConnection graphQLGraphSearchModulesConnection, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("corrected_query".equals(str)) {
            GraphQLGraphSearchQuery a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGraphSearchQuery__JsonHelper.m8265a(FieldAccessQueryTracker.a(jsonParser, "corrected_query"));
            }
            graphQLGraphSearchModulesConnection.f4050d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "corrected_query", graphQLGraphSearchModulesConnection.a_, 0, true);
            return true;
        } else if ("count".equals(str)) {
            graphQLGraphSearchModulesConnection.f4051e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "count", graphQLGraphSearchModulesConnection.B_(), 1, false);
            return true;
        } else if ("disable_auto_load".equals(str)) {
            graphQLGraphSearchModulesConnection.f4052f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "disable_auto_load", graphQLGraphSearchModulesConnection.B_(), 2, false);
            return true;
        } else if ("page_info".equals(str)) {
            GraphQLPageInfo a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLGraphSearchModulesConnection.f4053g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "page_info", graphQLGraphSearchModulesConnection.B_(), 3, true);
            return true;
        } else if ("session_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchModulesConnection.f4054h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "session_id", graphQLGraphSearchModulesConnection.B_(), 4, false);
            return true;
        } else if ("speller_confidence".equals(str)) {
            graphQLGraphSearchModulesConnection.f4055i = GraphQLGraphSearchSpellerConfidence.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "speller_confidence", graphQLGraphSearchModulesConnection.B_(), 5, false);
            return true;
        } else if (!"vertical_to_log".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchModulesConnection.f4056j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchModulesConnection, "vertical_to_log", graphQLGraphSearchModulesConnection.B_(), 6, false);
            return true;
        }
    }

    public static void m8172a(JsonGenerator jsonGenerator, GraphQLGraphSearchModulesConnection graphQLGraphSearchModulesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchModulesConnection.m8160a() != null) {
            jsonGenerator.a("corrected_query");
            GraphQLGraphSearchQuery__JsonHelper.m8266a(jsonGenerator, graphQLGraphSearchModulesConnection.m8160a(), true);
        }
        jsonGenerator.a("count", graphQLGraphSearchModulesConnection.m8163j());
        jsonGenerator.a("disable_auto_load", graphQLGraphSearchModulesConnection.m8164k());
        if (graphQLGraphSearchModulesConnection.m8165l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGraphSearchModulesConnection.m8165l(), true);
        }
        if (graphQLGraphSearchModulesConnection.m8166m() != null) {
            jsonGenerator.a("session_id", graphQLGraphSearchModulesConnection.m8166m());
        }
        if (graphQLGraphSearchModulesConnection.m8167n() != null) {
            jsonGenerator.a("speller_confidence", graphQLGraphSearchModulesConnection.m8167n().toString());
        }
        if (graphQLGraphSearchModulesConnection.m8168o() != null) {
            jsonGenerator.a("vertical_to_log", graphQLGraphSearchModulesConnection.m8168o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
