package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fact_clock */
public final class GraphQLMessengerContentSubscriptionOption__JsonHelper {
    public static GraphQLMessengerContentSubscriptionOption m9112a(JsonParser jsonParser) {
        GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption = new GraphQLMessengerContentSubscriptionOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9114a(graphQLMessengerContentSubscriptionOption, i, jsonParser);
            jsonParser.f();
        }
        return graphQLMessengerContentSubscriptionOption;
    }

    private static boolean m9114a(GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("content".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMessengerContentSubscriptionOption.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMessengerContentSubscriptionOption, "content", graphQLMessengerContentSubscriptionOption.a_, 0, false);
            return true;
        } else if ("page".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
            }
            graphQLMessengerContentSubscriptionOption.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLMessengerContentSubscriptionOption, "page", graphQLMessengerContentSubscriptionOption.B_(), 1, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMessengerContentSubscriptionOption.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMessengerContentSubscriptionOption, "title", graphQLMessengerContentSubscriptionOption.B_(), 2, false);
            return true;
        }
    }

    public static void m9113a(JsonGenerator jsonGenerator, GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMessengerContentSubscriptionOption.a() != null) {
            jsonGenerator.a("content", graphQLMessengerContentSubscriptionOption.a());
        }
        if (graphQLMessengerContentSubscriptionOption.j() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLMessengerContentSubscriptionOption.j(), true);
        }
        if (graphQLMessengerContentSubscriptionOption.k() != null) {
            jsonGenerator.a("title", graphQLMessengerContentSubscriptionOption.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
