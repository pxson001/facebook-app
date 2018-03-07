package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: isFacecastReady */
public final class GraphQLContactPoint__JsonHelper {
    public static GraphQLContactPoint m6874a(JsonParser jsonParser) {
        GraphQLContactPoint graphQLContactPoint = new GraphQLContactPoint();
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
                graphQLContactPoint.f3498d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLContactPoint, "__type__", graphQLContactPoint.a_, 0, false);
            } else if ("__typename".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLContactPoint.f3499e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLContactPoint, "__typename", graphQLContactPoint.a_, 1, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLContactPoint.f3500f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLContactPoint, "id", graphQLContactPoint.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLContactPoint;
    }

    public static void m6875a(JsonGenerator jsonGenerator, GraphQLContactPoint graphQLContactPoint, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLContactPoint.m6869j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLContactPoint.m6869j().e());
            jsonGenerator.g();
        }
        if (graphQLContactPoint.m6870k() != null) {
            jsonGenerator.a("__typename", graphQLContactPoint.m6870k());
        }
        if (graphQLContactPoint.m6871l() != null) {
            jsonGenerator.a("id", graphQLContactPoint.m6871l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
