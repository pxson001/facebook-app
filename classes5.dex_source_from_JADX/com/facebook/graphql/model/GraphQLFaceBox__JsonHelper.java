package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: http.auth.credentials-provider */
public final class GraphQLFaceBox__JsonHelper {
    public static GraphQLFaceBox m7452a(JsonParser jsonParser) {
        GraphQLFaceBox graphQLFaceBox = new GraphQLFaceBox();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7454a(graphQLFaceBox, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFaceBox;
    }

    private static boolean m7454a(GraphQLFaceBox graphQLFaceBox, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLVect2 a;
        if ("facebox_center".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "facebox_center"));
            }
            graphQLFaceBox.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFaceBox, "facebox_center", graphQLFaceBox.a_, 0, true);
            return true;
        } else if ("facebox_size".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "facebox_size"));
            }
            graphQLFaceBox.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFaceBox, "facebox_size", graphQLFaceBox.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFaceBox.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFaceBox, "id", graphQLFaceBox.B_(), 2, false);
            return true;
        } else if ("tag_suggestions".equals(str)) {
            GraphQLFaceBoxTagSuggestionsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFaceBoxTagSuggestionsConnection__JsonHelper.m7440a(FieldAccessQueryTracker.a(jsonParser, "tag_suggestions"));
            }
            graphQLFaceBox.g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFaceBox, "tag_suggestions", graphQLFaceBox.B_(), 3, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFaceBox.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFaceBox, "url", graphQLFaceBox.B_(), 4, false);
            return true;
        }
    }

    public static void m7453a(JsonGenerator jsonGenerator, GraphQLFaceBox graphQLFaceBox, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFaceBox.j() != null) {
            jsonGenerator.a("facebox_center");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLFaceBox.j(), true);
        }
        if (graphQLFaceBox.k() != null) {
            jsonGenerator.a("facebox_size");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLFaceBox.k(), true);
        }
        if (graphQLFaceBox.l() != null) {
            jsonGenerator.a("id", graphQLFaceBox.l());
        }
        if (graphQLFaceBox.m() != null) {
            jsonGenerator.a("tag_suggestions");
            GraphQLFaceBoxTagSuggestionsConnection__JsonHelper.m7441a(jsonGenerator, graphQLFaceBox.m(), true);
        }
        if (graphQLFaceBox.n() != null) {
            jsonGenerator.a("url", graphQLFaceBox.n());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
