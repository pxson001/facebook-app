package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: intercept_decline_button_label */
public final class GraphQLEntityCardContextItemLink__JsonHelper {
    public static GraphQLEntityCardContextItemLink m7080a(JsonParser jsonParser) {
        GraphQLEntityCardContextItemLink graphQLEntityCardContextItemLink = new GraphQLEntityCardContextItemLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("deep_link_urls".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLEntityCardContextItemLink.f3545d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemLink, "deep_link_urls", graphQLEntityCardContextItemLink.a_, 0, false);
            } else if ("store_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntityCardContextItemLink.f3546e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemLink, "store_id", graphQLEntityCardContextItemLink.a_, 1, false);
            } else if ("title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLEntityCardContextItemLink.f3547f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItemLink, "title", graphQLEntityCardContextItemLink.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLEntityCardContextItemLink;
    }

    public static void m7081a(JsonGenerator jsonGenerator, GraphQLEntityCardContextItemLink graphQLEntityCardContextItemLink, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("deep_link_urls");
        if (graphQLEntityCardContextItemLink.m7075a() != null) {
            jsonGenerator.d();
            for (String str : graphQLEntityCardContextItemLink.m7075a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEntityCardContextItemLink.m7076j() != null) {
            jsonGenerator.a("store_id", graphQLEntityCardContextItemLink.m7076j());
        }
        if (graphQLEntityCardContextItemLink.m7077k() != null) {
            jsonGenerator.a("title", graphQLEntityCardContextItemLink.m7077k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
