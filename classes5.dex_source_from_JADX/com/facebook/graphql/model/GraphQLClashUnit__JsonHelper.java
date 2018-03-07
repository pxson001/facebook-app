package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_current */
public final class GraphQLClashUnit__JsonHelper {
    public static GraphQLClashUnit m6772a(JsonParser jsonParser) {
        GraphQLClashUnit graphQLClashUnit = new GraphQLClashUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLClashUnit.f3434d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLClashUnit, "id", graphQLClashUnit.a_, 0, false);
            } else if ("name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLClashUnit.f3435e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLClashUnit, "name", graphQLClashUnit.a_, 1, false);
            } else if ("priority".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLClashUnit.f3436f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLClashUnit, "priority", graphQLClashUnit.a_, 2, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLClashUnit.f3437g = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLClashUnit, "url", graphQLClashUnit.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLClashUnit;
    }

    public static void m6773a(JsonGenerator jsonGenerator, GraphQLClashUnit graphQLClashUnit, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLClashUnit.m6766j() != null) {
            jsonGenerator.a("id", graphQLClashUnit.m6766j());
        }
        if (graphQLClashUnit.m6767k() != null) {
            jsonGenerator.a("name", graphQLClashUnit.m6767k());
        }
        jsonGenerator.a("priority", graphQLClashUnit.m6768l());
        if (graphQLClashUnit.m6769m() != null) {
            jsonGenerator.a("url", graphQLClashUnit.m6769m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
