package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: latest_version */
public final class GraphQLActivityTemplateToken__JsonHelper {
    public static GraphQLActivityTemplateToken m6394a(JsonParser jsonParser) {
        GraphQLActivityTemplateToken graphQLActivityTemplateToken = new GraphQLActivityTemplateToken();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("token_position".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLActivityTemplateToken.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLActivityTemplateToken, "token_position", graphQLActivityTemplateToken.a_, 0, false);
            } else if ("token_type".equals(i)) {
                graphQLActivityTemplateToken.e = GraphQLActivityTemplateTokenType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLActivityTemplateToken, "token_type", graphQLActivityTemplateToken.a_, 1, false);
            } else {
                int i3 = 0;
            }
            jsonParser.f();
        }
        return graphQLActivityTemplateToken;
    }

    public static void m6395a(JsonGenerator jsonGenerator, GraphQLActivityTemplateToken graphQLActivityTemplateToken, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("token_position", graphQLActivityTemplateToken.a());
        if (graphQLActivityTemplateToken.j() != null) {
            jsonGenerator.a("token_type", graphQLActivityTemplateToken.j().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
