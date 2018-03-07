package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: escape_hatch */
public final class GraphQLOverlayCallToActionInfo__JsonHelper {
    public static GraphQLOverlayCallToActionInfo m9427a(JsonParser jsonParser) {
        GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo = new GraphQLOverlayCallToActionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9429a(graphQLOverlayCallToActionInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLOverlayCallToActionInfo;
    }

    private static boolean m9429a(GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLOverlayCallToActionInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayCallToActionInfo, "__type__", graphQLOverlayCallToActionInfo.a_, 0, false);
            return true;
        } else if ("creation_suggestion".equals(str)) {
            GraphQLGroupCreationSuggestion a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGroupCreationSuggestion__JsonHelper.m8429a(FieldAccessQueryTracker.a(jsonParser, "creation_suggestion"));
            }
            graphQLOverlayCallToActionInfo.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayCallToActionInfo, "creation_suggestion", graphQLOverlayCallToActionInfo.B_(), 1, true);
            return true;
        } else if (!"group_id".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOverlayCallToActionInfo.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayCallToActionInfo, "group_id", graphQLOverlayCallToActionInfo.B_(), 3, false);
            return true;
        }
    }

    public static void m9428a(JsonGenerator jsonGenerator, GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLOverlayCallToActionInfo.a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLOverlayCallToActionInfo.a().e());
            jsonGenerator.g();
        }
        if (graphQLOverlayCallToActionInfo.j() != null) {
            jsonGenerator.a("creation_suggestion");
            GraphQLGroupCreationSuggestion__JsonHelper.m8430a(jsonGenerator, graphQLOverlayCallToActionInfo.j(), true);
        }
        if (graphQLOverlayCallToActionInfo.k() != null) {
            jsonGenerator.a("group_id", graphQLOverlayCallToActionInfo.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
