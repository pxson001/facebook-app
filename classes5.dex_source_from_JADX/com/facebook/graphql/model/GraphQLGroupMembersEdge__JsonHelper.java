package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friend_center_outgoing_req */
public final class GraphQLGroupMembersEdge__JsonHelper {
    public static GraphQLGroupMembersEdge m8469a(JsonParser jsonParser) {
        GraphQLGroupMembersEdge graphQLGroupMembersEdge = new GraphQLGroupMembersEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("is_group_admin".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLGroupMembersEdge.f4205d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersEdge, "is_group_admin", graphQLGroupMembersEdge.a_, 2, false);
                i2 = 1;
            } else if ("node".equals(i)) {
                GraphQLUser graphQLUser;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLUser = null;
                } else {
                    graphQLUser = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLGroupMembersEdge.f4206e = graphQLUser;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersEdge, "node", graphQLGroupMembersEdge.a_, 3, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLGroupMembersEdge;
    }

    public static void m8470a(JsonGenerator jsonGenerator, GraphQLGroupMembersEdge graphQLGroupMembersEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_group_admin", graphQLGroupMembersEdge.m8465a());
        if (graphQLGroupMembersEdge.m8466j() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLGroupMembersEdge.m8466j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
