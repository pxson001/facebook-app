package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: hc_ufi */
public final class GraphQLFollowUpFeedUnitsConnection__JsonHelper {
    public static GraphQLFollowUpFeedUnitsConnection m7532a(JsonParser jsonParser) {
        GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection = new GraphQLFollowUpFeedUnitsConnection();
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
                        GraphQLFollowUpFeedUnitsEdge a = GraphQLFollowUpFeedUnitsEdge__JsonHelper.m7542a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLFollowUpFeedUnitsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLFollowUpFeedUnitsConnection, "edges", graphQLFollowUpFeedUnitsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFollowUpFeedUnitsConnection;
    }

    public static void m7533a(JsonGenerator jsonGenerator, GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLFollowUpFeedUnitsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge : graphQLFollowUpFeedUnitsConnection.a()) {
                if (graphQLFollowUpFeedUnitsEdge != null) {
                    GraphQLFollowUpFeedUnitsEdge__JsonHelper.m7543a(jsonGenerator, graphQLFollowUpFeedUnitsEdge, true);
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
