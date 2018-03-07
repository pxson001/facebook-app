package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: genie_message */
public final class GraphQLGraphSearchQueryFilterCustomValue__JsonHelper {
    public static GraphQLGraphSearchQueryFilterCustomValue m8223a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryFilterCustomValue graphQLGraphSearchQueryFilterCustomValue = new GraphQLGraphSearchQueryFilterCustomValue();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLGraphSearchQueryFilterCustomValue.f4084d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterCustomValue, "__type__", graphQLGraphSearchQueryFilterCustomValue.a_, 0, false);
            } else if ("lower_bound".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLGraphSearchQueryFilterCustomValue.f4085e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterCustomValue, "lower_bound", graphQLGraphSearchQueryFilterCustomValue.a_, 1, false);
            } else if ("support_free_text".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLGraphSearchQueryFilterCustomValue.f4086f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterCustomValue, "support_free_text", graphQLGraphSearchQueryFilterCustomValue.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLGraphSearchQueryFilterCustomValue;
    }

    public static void m8224a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryFilterCustomValue graphQLGraphSearchQueryFilterCustomValue, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchQueryFilterCustomValue.m8216a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGraphSearchQueryFilterCustomValue.m8216a().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("lower_bound", graphQLGraphSearchQueryFilterCustomValue.m8219j());
        jsonGenerator.a("support_free_text", graphQLGraphSearchQueryFilterCustomValue.m8220k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
