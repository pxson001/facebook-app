package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Unknown message  */
public final class GraphQLSportsDataMatchToFactsConnection__JsonHelper {
    public static GraphQLSportsDataMatchToFactsConnection m21797a(JsonParser jsonParser) {
        GraphQLSportsDataMatchToFactsConnection graphQLSportsDataMatchToFactsConnection = new GraphQLSportsDataMatchToFactsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLSportsDataMatchDataFact a = GraphQLSportsDataMatchDataFact__JsonHelper.m21782a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLSportsDataMatchToFactsConnection.f13071d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchToFactsConnection, "nodes", graphQLSportsDataMatchToFactsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLSportsDataMatchToFactsConnection.f13072e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchToFactsConnection, "page_info", graphQLSportsDataMatchToFactsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSportsDataMatchToFactsConnection;
    }

    public static void m21798a(JsonGenerator jsonGenerator, GraphQLSportsDataMatchToFactsConnection graphQLSportsDataMatchToFactsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLSportsDataMatchToFactsConnection.m21793a() != null) {
            jsonGenerator.d();
            for (GraphQLSportsDataMatchDataFact graphQLSportsDataMatchDataFact : graphQLSportsDataMatchToFactsConnection.m21793a()) {
                if (graphQLSportsDataMatchDataFact != null) {
                    GraphQLSportsDataMatchDataFact__JsonHelper.m21783a(jsonGenerator, graphQLSportsDataMatchDataFact, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSportsDataMatchToFactsConnection.m21794j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLSportsDataMatchToFactsConnection.m21794j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
