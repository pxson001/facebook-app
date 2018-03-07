package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: equal */
public final class GraphQLPYMLWithLargeImageFeedUnitsConnection__JsonHelper {
    public static GraphQLPYMLWithLargeImageFeedUnitsConnection m9452a(JsonParser jsonParser) {
        GraphQLPYMLWithLargeImageFeedUnitsConnection graphQLPYMLWithLargeImageFeedUnitsConnection = new GraphQLPYMLWithLargeImageFeedUnitsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPYMLWithLargeImageFeedUnitsEdge a = GraphQLPYMLWithLargeImageFeedUnitsEdge__JsonHelper.m9458a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLPYMLWithLargeImageFeedUnitsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitsConnection, "edges", graphQLPYMLWithLargeImageFeedUnitsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPYMLWithLargeImageFeedUnitsConnection;
    }

    public static void m9453a(JsonGenerator jsonGenerator, GraphQLPYMLWithLargeImageFeedUnitsConnection graphQLPYMLWithLargeImageFeedUnitsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPYMLWithLargeImageFeedUnitsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPYMLWithLargeImageFeedUnitsEdge graphQLPYMLWithLargeImageFeedUnitsEdge : graphQLPYMLWithLargeImageFeedUnitsConnection.a()) {
                if (graphQLPYMLWithLargeImageFeedUnitsEdge != null) {
                    GraphQLPYMLWithLargeImageFeedUnitsEdge__JsonHelper.m9459a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitsEdge, true);
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
