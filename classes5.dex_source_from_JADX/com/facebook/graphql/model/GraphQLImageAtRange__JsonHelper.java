package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fof_invite_join_dialogue */
public final class GraphQLImageAtRange__JsonHelper {
    public static GraphQLImageAtRange m8622a(JsonParser jsonParser) {
        GraphQLImageAtRange graphQLImageAtRange = new GraphQLImageAtRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8624a(graphQLImageAtRange, i, jsonParser);
            jsonParser.f();
        }
        return graphQLImageAtRange;
    }

    private static boolean m8624a(GraphQLImageAtRange graphQLImageAtRange, String str, JsonParser jsonParser) {
        if ("entity_with_image".equals(str)) {
            GraphQLEntityWithImage graphQLEntityWithImage;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLEntityWithImage = null;
            } else {
                graphQLEntityWithImage = GraphQLEntityWithImage__JsonHelper.m7100a(FieldAccessQueryTracker.a(jsonParser, "entity_with_image"));
            }
            graphQLImageAtRange.d = graphQLEntityWithImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLImageAtRange, "entity_with_image", graphQLImageAtRange.a_, 0, true);
            return true;
        } else if ("length".equals(str)) {
            graphQLImageAtRange.e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLImageAtRange, "length", graphQLImageAtRange.B_(), 1, false);
            return true;
        } else if (!"offset".equals(str)) {
            return false;
        } else {
            graphQLImageAtRange.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLImageAtRange, "offset", graphQLImageAtRange.B_(), 2, false);
            return true;
        }
    }

    public static void m8623a(JsonGenerator jsonGenerator, GraphQLImageAtRange graphQLImageAtRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLImageAtRange.j() != null) {
            jsonGenerator.a("entity_with_image");
            GraphQLEntityWithImage__JsonHelper.m7101a(jsonGenerator, graphQLImageAtRange.j(), true);
        }
        jsonGenerator.a("length", graphQLImageAtRange.b());
        jsonGenerator.a("offset", graphQLImageAtRange.c());
        if (z) {
            jsonGenerator.g();
        }
    }
}
