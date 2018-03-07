package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VINTAGE_STORE */
public final class GraphQLQPTemplateParameter__JsonHelper {
    public static GraphQLQPTemplateParameter m21138a(JsonParser jsonParser) {
        GraphQLQPTemplateParameter graphQLQPTemplateParameter = new GraphQLQPTemplateParameter();
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
                graphQLQPTemplateParameter.f12820d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLQPTemplateParameter, "__type__", graphQLQPTemplateParameter.a_, 0, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLQPTemplateParameter.f12821e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQPTemplateParameter, "name", graphQLQPTemplateParameter.a_, 1, false);
            } else if ("required".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLQPTemplateParameter.f12822f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLQPTemplateParameter, "required", graphQLQPTemplateParameter.a_, 2, false);
            } else if ("string_value".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLQPTemplateParameter.f12823g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLQPTemplateParameter, "string_value", graphQLQPTemplateParameter.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLQPTemplateParameter;
    }

    public static void m21139a(JsonGenerator jsonGenerator, GraphQLQPTemplateParameter graphQLQPTemplateParameter, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQPTemplateParameter.m21130a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLQPTemplateParameter.m21130a().e());
            jsonGenerator.g();
        }
        if (graphQLQPTemplateParameter.m21133j() != null) {
            jsonGenerator.a("name", graphQLQPTemplateParameter.m21133j());
        }
        jsonGenerator.a("required", graphQLQPTemplateParameter.m21134k());
        if (graphQLQPTemplateParameter.m21135l() != null) {
            jsonGenerator.a("string_value", graphQLQPTemplateParameter.m21135l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
