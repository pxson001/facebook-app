package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: enable_attachments_for_reply_previews */
public final class GraphQLPageStarRatersConnection__JsonHelper {
    public static GraphQLPageStarRatersConnection m9521a(JsonParser jsonParser) {
        GraphQLPageStarRatersConnection graphQLPageStarRatersConnection = new GraphQLPageStarRatersConnection();
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
                graphQLPageStarRatersConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageStarRatersConnection, "count", graphQLPageStarRatersConnection.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLPageStarRatersConnection;
    }

    public static void m9522a(JsonGenerator jsonGenerator, GraphQLPageStarRatersConnection graphQLPageStarRatersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLPageStarRatersConnection.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
