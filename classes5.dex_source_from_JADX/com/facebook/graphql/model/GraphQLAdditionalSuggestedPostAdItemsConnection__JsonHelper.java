package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: label_type */
public final class GraphQLAdditionalSuggestedPostAdItemsConnection__JsonHelper {
    public static GraphQLAdditionalSuggestedPostAdItemsConnection m6453a(JsonParser jsonParser) {
        GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = new GraphQLAdditionalSuggestedPostAdItemsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLAdditionalSuggestedPostAdItemsEdge a = GraphQLAdditionalSuggestedPostAdItemsEdge__JsonHelper.m6462a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLAdditionalSuggestedPostAdItemsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdditionalSuggestedPostAdItemsConnection, "edges", graphQLAdditionalSuggestedPostAdItemsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLAdditionalSuggestedPostAdItemsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdditionalSuggestedPostAdItemsConnection, "page_info", graphQLAdditionalSuggestedPostAdItemsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLAdditionalSuggestedPostAdItemsConnection;
    }

    public static void m6454a(JsonGenerator jsonGenerator, GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLAdditionalSuggestedPostAdItemsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLAdditionalSuggestedPostAdItemsEdge graphQLAdditionalSuggestedPostAdItemsEdge : graphQLAdditionalSuggestedPostAdItemsConnection.a()) {
                if (graphQLAdditionalSuggestedPostAdItemsEdge != null) {
                    GraphQLAdditionalSuggestedPostAdItemsEdge__JsonHelper.m6463a(jsonGenerator, graphQLAdditionalSuggestedPostAdItemsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAdditionalSuggestedPostAdItemsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLAdditionalSuggestedPostAdItemsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
