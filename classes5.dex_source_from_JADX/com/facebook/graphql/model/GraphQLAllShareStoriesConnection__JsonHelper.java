package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: java serialization is not supported */
public final class GraphQLAllShareStoriesConnection__JsonHelper {
    public static GraphQLAllShareStoriesConnection m6534a(JsonParser jsonParser) {
        GraphQLAllShareStoriesConnection graphQLAllShareStoriesConnection = new GraphQLAllShareStoriesConnection();
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
                graphQLAllShareStoriesConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLAllShareStoriesConnection, "count", graphQLAllShareStoriesConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLAllShareStoriesConnection;
    }

    public static void m6535a(JsonGenerator jsonGenerator, GraphQLAllShareStoriesConnection graphQLAllShareStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLAllShareStoriesConnection.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
