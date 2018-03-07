package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: journal */
public final class GraphQLAggregatedEntitiesAtRange__JsonHelper {
    public static GraphQLAggregatedEntitiesAtRange m6502a(JsonParser jsonParser) {
        GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange = new GraphQLAggregatedEntitiesAtRange();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLAggregatedEntitiesAtRange.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLAggregatedEntitiesAtRange, "count", graphQLAggregatedEntitiesAtRange.a_, 0, false);
            } else if ("length".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLAggregatedEntitiesAtRange.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLAggregatedEntitiesAtRange, "length", graphQLAggregatedEntitiesAtRange.a_, 1, false);
            } else if ("offset".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLAggregatedEntitiesAtRange.f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLAggregatedEntitiesAtRange, "offset", graphQLAggregatedEntitiesAtRange.a_, 2, false);
            } else if ("sample_entities".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLEntity a = GraphQLEntity__JsonHelper.m7102a(FieldAccessQueryTracker.a(jsonParser, "sample_entities"));
                        if (a != null) {
                            collection.add(a);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLAggregatedEntitiesAtRange.g = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLAggregatedEntitiesAtRange, "sample_entities", graphQLAggregatedEntitiesAtRange.a_, 3, true);
            }
            jsonParser.f();
        }
        return graphQLAggregatedEntitiesAtRange;
    }

    public static void m6503a(JsonGenerator jsonGenerator, GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLAggregatedEntitiesAtRange.a());
        jsonGenerator.a("length", graphQLAggregatedEntitiesAtRange.b());
        jsonGenerator.a("offset", graphQLAggregatedEntitiesAtRange.c());
        jsonGenerator.a("sample_entities");
        if (graphQLAggregatedEntitiesAtRange.j() != null) {
            jsonGenerator.d();
            for (GraphQLEntity graphQLEntity : graphQLAggregatedEntitiesAtRange.j()) {
                if (graphQLEntity != null) {
                    GraphQLEntity__JsonHelper.m7103a(jsonGenerator, graphQLEntity, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
