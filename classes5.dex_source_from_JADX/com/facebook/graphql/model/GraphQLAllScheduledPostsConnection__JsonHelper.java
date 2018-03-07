package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: java.util.ArrayList */
public final class GraphQLAllScheduledPostsConnection__JsonHelper {
    public static GraphQLAllScheduledPostsConnection m6528a(JsonParser jsonParser) {
        GraphQLAllScheduledPostsConnection graphQLAllScheduledPostsConnection = new GraphQLAllScheduledPostsConnection();
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
                graphQLAllScheduledPostsConnection.f3345d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLAllScheduledPostsConnection, "count", graphQLAllScheduledPostsConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLAllScheduledPostsConnection;
    }

    public static void m6529a(JsonGenerator jsonGenerator, GraphQLAllScheduledPostsConnection graphQLAllScheduledPostsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLAllScheduledPostsConnection.m6522a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
