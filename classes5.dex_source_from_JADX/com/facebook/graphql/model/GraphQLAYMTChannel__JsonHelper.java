package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: layout_width */
public final class GraphQLAYMTChannel__JsonHelper {
    public static GraphQLAYMTChannel m6353a(JsonParser jsonParser) {
        GraphQLAYMTChannel graphQLAYMTChannel = new GraphQLAYMTChannel();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6355a(graphQLAYMTChannel, i, jsonParser);
            jsonParser.f();
        }
        return graphQLAYMTChannel;
    }

    private static boolean m6355a(GraphQLAYMTChannel graphQLAYMTChannel, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAYMTChannel.f3255d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTChannel, "id", graphQLAYMTChannel.a_, 0, false);
            return true;
        } else if ("tips".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLAYMTTip a = GraphQLAYMTTip__JsonHelper.m6387a(FieldAccessQueryTracker.a(jsonParser, "tips"));
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
            graphQLAYMTChannel.f3256e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTChannel, "tips", graphQLAYMTChannel.B_(), 1, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAYMTChannel.f3257f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTChannel, "url", graphQLAYMTChannel.B_(), 2, false);
            return true;
        }
    }

    public static void m6354a(JsonGenerator jsonGenerator, GraphQLAYMTChannel graphQLAYMTChannel, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAYMTChannel.m6348j() != null) {
            jsonGenerator.a("id", graphQLAYMTChannel.m6348j());
        }
        jsonGenerator.a("tips");
        if (graphQLAYMTChannel.m6349k() != null) {
            jsonGenerator.d();
            for (GraphQLAYMTTip graphQLAYMTTip : graphQLAYMTChannel.m6349k()) {
                if (graphQLAYMTTip != null) {
                    GraphQLAYMTTip__JsonHelper.m6388a(jsonGenerator, graphQLAYMTTip, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAYMTChannel.m6350l() != null) {
            jsonGenerator.a("url", graphQLAYMTChannel.m6350l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
