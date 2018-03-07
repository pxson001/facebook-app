package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: http.authscheme-registry */
public final class GraphQLFaceBoxTagSuggestionsEdge__JsonHelper {
    public static GraphQLFaceBoxTagSuggestionsEdge m7450a(JsonParser jsonParser) {
        GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge = new GraphQLFaceBoxTagSuggestionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLProfile graphQLProfile = null;
            int i2;
            if ("cursor".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLFaceBoxTagSuggestionsEdge.f3754d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLFaceBoxTagSuggestionsEdge, "cursor", graphQLFaceBoxTagSuggestionsEdge.a_, 0, false);
                i2 = 1;
            } else if ("node".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLProfile = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLFaceBoxTagSuggestionsEdge.f3755e = graphQLProfile;
                FieldAccessQueryTracker.a(jsonParser, graphQLFaceBoxTagSuggestionsEdge, "node", graphQLFaceBoxTagSuggestionsEdge.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLFaceBoxTagSuggestionsEdge;
    }

    public static void m7451a(JsonGenerator jsonGenerator, GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFaceBoxTagSuggestionsEdge.m7446a() != null) {
            jsonGenerator.a("cursor", graphQLFaceBoxTagSuggestionsEdge.m7446a());
        }
        if (graphQLFaceBoxTagSuggestionsEdge.m7447j() != null) {
            jsonGenerator.a("node");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLFaceBoxTagSuggestionsEdge.m7447j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
