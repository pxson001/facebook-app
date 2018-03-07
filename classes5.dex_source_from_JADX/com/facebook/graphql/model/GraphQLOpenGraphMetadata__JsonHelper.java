package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: eventUptime= */
public final class GraphQLOpenGraphMetadata__JsonHelper {
    public static GraphQLOpenGraphMetadata m9402a(JsonParser jsonParser) {
        GraphQLOpenGraphMetadata graphQLOpenGraphMetadata = new GraphQLOpenGraphMetadata();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9404a(graphQLOpenGraphMetadata, i, jsonParser);
            jsonParser.f();
        }
        return graphQLOpenGraphMetadata;
    }

    private static boolean m9404a(GraphQLOpenGraphMetadata graphQLOpenGraphMetadata, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("ownerUserId".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOpenGraphMetadata.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphMetadata, "ownerUserId", graphQLOpenGraphMetadata.a_, 0, false);
            return true;
        } else if ("prices".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLCurrencyQuantity a = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "prices"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLOpenGraphMetadata.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphMetadata, "prices", graphQLOpenGraphMetadata.B_(), 1, true);
            return true;
        } else if (!"stringForTitle".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOpenGraphMetadata.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphMetadata, "stringForTitle", graphQLOpenGraphMetadata.B_(), 2, false);
            return true;
        }
    }

    public static void m9403a(JsonGenerator jsonGenerator, GraphQLOpenGraphMetadata graphQLOpenGraphMetadata, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLOpenGraphMetadata.a() != null) {
            jsonGenerator.a("ownerUserId", graphQLOpenGraphMetadata.a());
        }
        jsonGenerator.a("prices");
        if (graphQLOpenGraphMetadata.j() != null) {
            jsonGenerator.d();
            for (GraphQLCurrencyQuantity graphQLCurrencyQuantity : graphQLOpenGraphMetadata.j()) {
                if (graphQLCurrencyQuantity != null) {
                    GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLCurrencyQuantity, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOpenGraphMetadata.k() != null) {
            jsonGenerator.a("stringForTitle", graphQLOpenGraphMetadata.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
