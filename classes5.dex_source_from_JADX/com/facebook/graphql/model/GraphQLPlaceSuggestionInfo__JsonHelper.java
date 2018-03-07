package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WATCHABLE_EXPERIMENT */
public final class GraphQLPlaceSuggestionInfo__JsonHelper {
    public static GraphQLPlaceSuggestionInfo m20918a(JsonParser jsonParser) {
        GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo = new GraphQLPlaceSuggestionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20920a(graphQLPlaceSuggestionInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlaceSuggestionInfo;
    }

    private static boolean m20920a(GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("place".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "place"));
            }
            graphQLPlaceSuggestionInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceSuggestionInfo, "place", graphQLPlaceSuggestionInfo.a_, 0, true);
            return true;
        } else if ("session_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPlaceSuggestionInfo.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceSuggestionInfo, "session_id", graphQLPlaceSuggestionInfo.B_(), 1, false);
            return true;
        } else if (!"suggestion_type".equals(str)) {
            return false;
        } else {
            graphQLPlaceSuggestionInfo.f = GraphQLPlaceSuggestionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceSuggestionInfo, "suggestion_type", graphQLPlaceSuggestionInfo.B_(), 2, false);
            return true;
        }
    }

    public static void m20919a(JsonGenerator jsonGenerator, GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlaceSuggestionInfo.a() != null) {
            jsonGenerator.a("place");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPlaceSuggestionInfo.a(), true);
        }
        if (graphQLPlaceSuggestionInfo.j() != null) {
            jsonGenerator.a("session_id", graphQLPlaceSuggestionInfo.j());
        }
        if (graphQLPlaceSuggestionInfo.k() != null) {
            jsonGenerator.a("suggestion_type", graphQLPlaceSuggestionInfo.k().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
