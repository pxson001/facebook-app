package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: face_boxes */
public final class GraphQLMutualFriendsConnection__JsonHelper {
    public static GraphQLMutualFriendsConnection m9146a(JsonParser jsonParser) {
        GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = new GraphQLMutualFriendsConnection();
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
                graphQLMutualFriendsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMutualFriendsConnection, "count", graphQLMutualFriendsConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
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
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLMutualFriendsConnection.e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLMutualFriendsConnection, "nodes", graphQLMutualFriendsConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLMutualFriendsConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLMutualFriendsConnection, "page_info", graphQLMutualFriendsConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLMutualFriendsConnection;
    }

    public static void m9147a(JsonGenerator jsonGenerator, GraphQLMutualFriendsConnection graphQLMutualFriendsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLMutualFriendsConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLMutualFriendsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLMutualFriendsConnection.j()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMutualFriendsConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLMutualFriendsConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
