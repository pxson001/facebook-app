package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: intern_all_styles */
public final class GraphQLEntityAtRange__JsonHelper {
    public static GraphQLEntityAtRange m7044a(JsonParser jsonParser) {
        GraphQLEntityAtRange graphQLEntityAtRange = new GraphQLEntityAtRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7046a(graphQLEntityAtRange, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEntityAtRange;
    }

    private static boolean m7046a(GraphQLEntityAtRange graphQLEntityAtRange, String str, JsonParser jsonParser) {
        if ("entity".equals(str)) {
            GraphQLEntity graphQLEntity;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLEntity = null;
            } else {
                graphQLEntity = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "entity"));
            }
            graphQLEntityAtRange.d = graphQLEntity;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityAtRange, "entity", graphQLEntityAtRange.a_, 0, true);
            return true;
        } else if ("length".equals(str)) {
            graphQLEntityAtRange.e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityAtRange, "length", graphQLEntityAtRange.B_(), 1, false);
            return true;
        } else if (!"offset".equals(str)) {
            return false;
        } else {
            graphQLEntityAtRange.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityAtRange, "offset", graphQLEntityAtRange.B_(), 2, false);
            return true;
        }
    }

    public static void m7045a(JsonGenerator jsonGenerator, GraphQLEntityAtRange graphQLEntityAtRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEntityAtRange.j() != null) {
            jsonGenerator.a("entity");
            GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLEntityAtRange.j(), true);
        }
        jsonGenerator.a("length", graphQLEntityAtRange.b());
        jsonGenerator.a("offset", graphQLEntityAtRange.c());
        if (z) {
            jsonGenerator.g();
        }
    }
}
