package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_CALL */
public final class GraphQLResharesOfContentConnection__JsonHelper {
    public static GraphQLResharesOfContentConnection m21504a(JsonParser jsonParser) {
        GraphQLResharesOfContentConnection graphQLResharesOfContentConnection = new GraphQLResharesOfContentConnection();
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
                graphQLResharesOfContentConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLResharesOfContentConnection, "count", graphQLResharesOfContentConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLResharesOfContentConnection;
    }

    public static void m21505a(JsonGenerator jsonGenerator, GraphQLResharesOfContentConnection graphQLResharesOfContentConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLResharesOfContentConnection.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
