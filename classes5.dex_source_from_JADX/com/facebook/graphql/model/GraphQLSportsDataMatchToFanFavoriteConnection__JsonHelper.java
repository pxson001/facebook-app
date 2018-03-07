package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unknown field type out */
public final class GraphQLSportsDataMatchToFanFavoriteConnection__JsonHelper {
    public static GraphQLSportsDataMatchToFanFavoriteConnection m21806a(JsonParser jsonParser) {
        GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection = new GraphQLSportsDataMatchToFanFavoriteConnection();
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
                        GraphQLSportsDataMatchToFanFavoriteEdge a = GraphQLSportsDataMatchToFanFavoriteEdge__JsonHelper.m21815a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSportsDataMatchToFanFavoriteConnection.f13073d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchToFanFavoriteConnection, "edges", graphQLSportsDataMatchToFanFavoriteConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSportsDataMatchToFanFavoriteConnection;
    }

    public static void m21807a(JsonGenerator jsonGenerator, GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSportsDataMatchToFanFavoriteConnection.m21803a() != null) {
            jsonGenerator.d();
            for (GraphQLSportsDataMatchToFanFavoriteEdge graphQLSportsDataMatchToFanFavoriteEdge : graphQLSportsDataMatchToFanFavoriteConnection.m21803a()) {
                if (graphQLSportsDataMatchToFanFavoriteEdge != null) {
                    GraphQLSportsDataMatchToFanFavoriteEdge__JsonHelper.m21816a(jsonGenerator, graphQLSportsDataMatchToFanFavoriteEdge, true);
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
