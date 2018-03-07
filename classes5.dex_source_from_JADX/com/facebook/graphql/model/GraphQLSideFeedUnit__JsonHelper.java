package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VANITY */
public final class GraphQLSideFeedUnit__JsonHelper {
    public static GraphQLSideFeedUnit m21656a(JsonParser jsonParser) {
        GraphQLSideFeedUnit graphQLSideFeedUnit = new GraphQLSideFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection = null;
            int i2;
            if ("__type__".equals(i)) {
                GraphQLObjectType a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLObjectType.a(jsonParser);
                }
                graphQLSideFeedUnit.f13021d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLSideFeedUnit, "__type__", graphQLSideFeedUnit.a_, 0, false);
                i2 = 1;
            } else if ("app_stories".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLAppAdStoriesSideFeedConnection = GraphQLAppAdStoriesSideFeedConnection__JsonHelper.m6549a(FieldAccessQueryTracker.a(jsonParser, "app_stories"));
                }
                graphQLSideFeedUnit.f13022e = graphQLAppAdStoriesSideFeedConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLSideFeedUnit, "app_stories", graphQLSideFeedUnit.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLSideFeedUnit;
    }

    public static void m21657a(JsonGenerator jsonGenerator, GraphQLSideFeedUnit graphQLSideFeedUnit, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSideFeedUnit.m21651a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSideFeedUnit.m21651a().e());
            jsonGenerator.g();
        }
        if (graphQLSideFeedUnit.m21653j() != null) {
            jsonGenerator.a("app_stories");
            GraphQLAppAdStoriesSideFeedConnection__JsonHelper.m6550a(jsonGenerator, graphQLSideFeedUnit.m21653j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
