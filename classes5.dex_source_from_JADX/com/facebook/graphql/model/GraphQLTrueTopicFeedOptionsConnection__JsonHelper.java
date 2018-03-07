package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Total wifi usage  */
public final class GraphQLTrueTopicFeedOptionsConnection__JsonHelper {
    public static GraphQLTrueTopicFeedOptionsConnection m22328a(JsonParser jsonParser) {
        GraphQLTrueTopicFeedOptionsConnection graphQLTrueTopicFeedOptionsConnection = new GraphQLTrueTopicFeedOptionsConnection();
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
                        GraphQLTrueTopicFeedOptionsEdge a = GraphQLTrueTopicFeedOptionsEdge__JsonHelper.m22337a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLTrueTopicFeedOptionsConnection.f13372d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOptionsConnection, "edges", graphQLTrueTopicFeedOptionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTrueTopicFeedOptionsConnection;
    }

    public static void m22329a(JsonGenerator jsonGenerator, GraphQLTrueTopicFeedOptionsConnection graphQLTrueTopicFeedOptionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLTrueTopicFeedOptionsConnection.m22325a() != null) {
            jsonGenerator.d();
            for (GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge : graphQLTrueTopicFeedOptionsConnection.m22325a()) {
                if (graphQLTrueTopicFeedOptionsEdge != null) {
                    GraphQLTrueTopicFeedOptionsEdge__JsonHelper.m22338a(jsonGenerator, graphQLTrueTopicFeedOptionsEdge, true);
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
