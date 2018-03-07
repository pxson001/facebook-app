package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: install_messenger_now_button */
public final class GraphQLError__JsonHelper {
    public static GraphQLError m7114a(JsonParser jsonParser) {
        GraphQLError graphQLError = new GraphQLError();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("code".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLError.f3552d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLError, "code", graphQLError.a_, 0, false);
            } else if ("description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLError.f3553e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLError, "description", graphQLError.a_, 1, false);
            } else if ("summary".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLError.f3554f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLError, "summary", graphQLError.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLError;
    }

    public static void m7115a(JsonGenerator jsonGenerator, GraphQLError graphQLError, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("code", graphQLError.m7106a());
        if (graphQLError.m7110j() != null) {
            jsonGenerator.a("description", graphQLError.m7110j());
        }
        if (graphQLError.m7111k() != null) {
            jsonGenerator.a("summary", graphQLError.m7111k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
