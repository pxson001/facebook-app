package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: email_address */
public final class GraphQLPageVisitsConnection__JsonHelper {
    public static GraphQLPageVisitsConnection m9551a(JsonParser jsonParser) {
        GraphQLPageVisitsConnection graphQLPageVisitsConnection = new GraphQLPageVisitsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("count".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPageVisitsConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageVisitsConnection, "count", graphQLPageVisitsConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLPageVisitsConnection;
    }

    public static void m9552a(JsonGenerator jsonGenerator, GraphQLPageVisitsConnection graphQLPageVisitsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLPageVisitsConnection.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
