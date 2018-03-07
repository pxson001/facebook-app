package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TargetingDescriptionSentence */
public final class GraphQLViewerVisitsConnection__JsonHelper {
    public static GraphQLViewerVisitsConnection m22492a(JsonParser jsonParser) {
        GraphQLViewerVisitsConnection graphQLViewerVisitsConnection = new GraphQLViewerVisitsConnection();
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
                graphQLViewerVisitsConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLViewerVisitsConnection, "count", graphQLViewerVisitsConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLViewerVisitsConnection;
    }

    public static void m22493a(JsonGenerator jsonGenerator, GraphQLViewerVisitsConnection graphQLViewerVisitsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLViewerVisitsConnection.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
