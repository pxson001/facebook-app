package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: generateAcraReport */
public final class GraphQLGraphSearchQueryFilterGroup__JsonHelper {
    public static GraphQLGraphSearchQueryFilterGroup m8233a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryFilterGroup graphQLGraphSearchQueryFilterGroup = new GraphQLGraphSearchQueryFilterGroup();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("main_filter".equals(i)) {
                GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLGraphSearchQueryFilter = null;
                } else {
                    graphQLGraphSearchQueryFilter = GraphQLGraphSearchQueryFilter__JsonHelper.m8255a(FieldAccessQueryTracker.a(jsonParser, "main_filter"));
                }
                graphQLGraphSearchQueryFilterGroup.f4087d = graphQLGraphSearchQueryFilter;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterGroup, "main_filter", graphQLGraphSearchQueryFilterGroup.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchQueryFilterGroup;
    }

    public static void m8234a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryFilterGroup graphQLGraphSearchQueryFilterGroup, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchQueryFilterGroup.m8229a() != null) {
            jsonGenerator.a("main_filter");
            GraphQLGraphSearchQueryFilter__JsonHelper.m8256a(jsonGenerator, graphQLGraphSearchQueryFilterGroup.m8229a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
