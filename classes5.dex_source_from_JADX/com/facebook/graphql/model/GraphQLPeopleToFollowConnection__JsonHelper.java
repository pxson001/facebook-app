package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WORK_MULTI_COMPANY */
public final class GraphQLPeopleToFollowConnection__JsonHelper {
    public static GraphQLPeopleToFollowConnection m20640a(JsonParser jsonParser) {
        GraphQLPeopleToFollowConnection graphQLPeopleToFollowConnection = new GraphQLPeopleToFollowConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPeopleYouShouldFollowFeedUnitItem a = GraphQLPeopleYouShouldFollowFeedUnitItem__JsonHelper.m20705a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPeopleToFollowConnection.f12438d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleToFollowConnection, "nodes", graphQLPeopleToFollowConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPeopleToFollowConnection;
    }

    public static void m20641a(JsonGenerator jsonGenerator, GraphQLPeopleToFollowConnection graphQLPeopleToFollowConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPeopleToFollowConnection.m20637a() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem : graphQLPeopleToFollowConnection.m20637a()) {
                if (graphQLPeopleYouShouldFollowFeedUnitItem != null) {
                    GraphQLPeopleYouShouldFollowFeedUnitItem__JsonHelper.m20706a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnitItem, true);
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
