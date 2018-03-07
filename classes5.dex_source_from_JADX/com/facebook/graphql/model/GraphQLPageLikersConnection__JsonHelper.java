package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: end_date */
public final class GraphQLPageLikersConnection__JsonHelper {
    public static GraphQLPageLikersConnection m9494a(JsonParser jsonParser) {
        GraphQLPageLikersConnection graphQLPageLikersConnection = new GraphQLPageLikersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPageLikersConnection.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageLikersConnection, "count", graphQLPageLikersConnection.a_, 0, false);
            } else if ("new_likers_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLPageLikersConnection.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageLikersConnection, "new_likers_count", graphQLPageLikersConnection.a_, 1, false);
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPageLikersConnection.f = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageLikersConnection, "nodes", graphQLPageLikersConnection.a_, 2, true);
            } else {
                int i3 = 0;
            }
            jsonParser.f();
        }
        return graphQLPageLikersConnection;
    }

    public static void m9495a(JsonGenerator jsonGenerator, GraphQLPageLikersConnection graphQLPageLikersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLPageLikersConnection.a());
        jsonGenerator.a("new_likers_count", graphQLPageLikersConnection.j());
        jsonGenerator.a("nodes");
        if (graphQLPageLikersConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLPageLikersConnection.k()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
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
