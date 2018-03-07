package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPlaceOpenStatusType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WEAK_CONSENT_ADMIN_MESSAGE */
public final class GraphQLPlaceOpenStatusFormat__JsonHelper {
    public static GraphQLPlaceOpenStatusFormat m20886a(JsonParser jsonParser) {
        GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat = new GraphQLPlaceOpenStatusFormat();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20888a(graphQLPlaceOpenStatusFormat, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlaceOpenStatusFormat;
    }

    private static boolean m20888a(GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat, String str, JsonParser jsonParser) {
        List list = null;
        if ("status_type".equals(str)) {
            graphQLPlaceOpenStatusFormat.d = GraphQLPlaceOpenStatusType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceOpenStatusFormat, "status_type", graphQLPlaceOpenStatusFormat.a_, 0, false);
            return true;
        } else if ("time_range".equals(str)) {
            GraphQLTimeRange a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimeRange__JsonHelper.m22114a(FieldAccessQueryTracker.a(jsonParser, "time_range"));
            }
            graphQLPlaceOpenStatusFormat.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceOpenStatusFormat, "time_range", graphQLPlaceOpenStatusFormat.B_(), 1, true);
            return true;
        } else if (!"time_values".equals(str)) {
            return false;
        } else {
            Collection arrayList;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Long valueOf = Long.valueOf(jsonParser.F());
                    if (valueOf != null) {
                        arrayList.add(valueOf);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLPlaceOpenStatusFormat.f = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceOpenStatusFormat, "time_values", graphQLPlaceOpenStatusFormat.B_(), 2, false);
            return true;
        }
    }

    public static void m20887a(JsonGenerator jsonGenerator, GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlaceOpenStatusFormat.a() != null) {
            jsonGenerator.a("status_type", graphQLPlaceOpenStatusFormat.a().toString());
        }
        if (graphQLPlaceOpenStatusFormat.j() != null) {
            jsonGenerator.a("time_range");
            GraphQLTimeRange__JsonHelper.m22115a(jsonGenerator, graphQLPlaceOpenStatusFormat.j(), true);
        }
        jsonGenerator.a("time_values");
        if (graphQLPlaceOpenStatusFormat.k() != null) {
            jsonGenerator.d();
            for (Long l : graphQLPlaceOpenStatusFormat.k()) {
                if (l != null) {
                    jsonGenerator.a(l.longValue());
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
