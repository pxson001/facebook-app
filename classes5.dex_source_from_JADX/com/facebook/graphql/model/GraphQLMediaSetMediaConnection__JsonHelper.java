package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fallback_url */
public final class GraphQLMediaSetMediaConnection__JsonHelper {
    public static GraphQLMediaSetMediaConnection m9073a(JsonParser jsonParser) {
        GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection = new GraphQLMediaSetMediaConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLMediaSetMediaConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSetMediaConnection, "count", graphQLMediaSetMediaConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLMedia a = GraphQLMedia__JsonHelper.m9078a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLMediaSetMediaConnection.e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSetMediaConnection, "nodes", graphQLMediaSetMediaConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLMediaSetMediaConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSetMediaConnection, "page_info", graphQLMediaSetMediaConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLMediaSetMediaConnection;
    }

    public static void m9074a(JsonGenerator jsonGenerator, GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLMediaSetMediaConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLMediaSetMediaConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLMedia graphQLMedia : graphQLMediaSetMediaConnection.j()) {
                if (graphQLMedia != null) {
                    GraphQLMedia__JsonHelper.m9079a(jsonGenerator, graphQLMedia, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMediaSetMediaConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLMediaSetMediaConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
