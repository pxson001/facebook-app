package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: feed_settings */
public final class GraphQLLeadGenErrorNode__JsonHelper {
    public static GraphQLLeadGenErrorNode m8833a(JsonParser jsonParser) {
        GraphQLLeadGenErrorNode graphQLLeadGenErrorNode = new GraphQLLeadGenErrorNode();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("error_text".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLLeadGenErrorNode.d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenErrorNode, "error_text", graphQLLeadGenErrorNode.a_, 0, false);
            } else if ("input_type".equals(i)) {
                graphQLLeadGenErrorNode.e = GraphQLLeadGenInfoFieldInputType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenErrorNode, "input_type", graphQLLeadGenErrorNode.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLLeadGenErrorNode;
    }

    public static void m8834a(JsonGenerator jsonGenerator, GraphQLLeadGenErrorNode graphQLLeadGenErrorNode, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenErrorNode.a() != null) {
            jsonGenerator.a("error_text", graphQLLeadGenErrorNode.a());
        }
        if (graphQLLeadGenErrorNode.j() != null) {
            jsonGenerator.a("input_type", graphQLLeadGenErrorNode.j().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
