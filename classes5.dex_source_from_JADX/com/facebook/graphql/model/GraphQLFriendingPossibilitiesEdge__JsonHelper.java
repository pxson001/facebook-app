package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: has_reply_permission */
public final class GraphQLFriendingPossibilitiesEdge__JsonHelper {
    public static GraphQLFriendingPossibilitiesEdge m7601a(JsonParser jsonParser) {
        GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge = new GraphQLFriendingPossibilitiesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7603a(graphQLFriendingPossibilitiesEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendingPossibilitiesEdge;
    }

    private static boolean m7603a(GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("is_seen".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLFriendingPossibilitiesEdge.f3790d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesEdge, "is_seen", graphQLFriendingPossibilitiesEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            GraphQLUser a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLFriendingPossibilitiesEdge.f3791e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesEdge, "node", graphQLFriendingPossibilitiesEdge.B_(), 1, true);
            return true;
        } else if ("suggesters".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLUser a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggesters"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLFriendingPossibilitiesEdge.f3792f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesEdge, "suggesters", graphQLFriendingPossibilitiesEdge.B_(), 2, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFriendingPossibilitiesEdge.f3793g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesEdge, "tracking", graphQLFriendingPossibilitiesEdge.B_(), 3, false);
            return true;
        }
    }

    public static void m7602a(JsonGenerator jsonGenerator, GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_seen", graphQLFriendingPossibilitiesEdge.m7595a());
        if (graphQLFriendingPossibilitiesEdge.m7596j() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLFriendingPossibilitiesEdge.m7596j(), true);
        }
        jsonGenerator.a("suggesters");
        if (graphQLFriendingPossibilitiesEdge.m7597k() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLFriendingPossibilitiesEdge.m7597k()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendingPossibilitiesEdge.m7598l() != null) {
            jsonGenerator.a("tracking", graphQLFriendingPossibilitiesEdge.m7598l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
