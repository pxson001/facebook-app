package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: group_members_viewer_friend_count */
public final class GraphQLFundraiserPersonToCharityDonorsConnection__JsonHelper {
    public static GraphQLFundraiserPersonToCharityDonorsConnection m7729a(JsonParser jsonParser) {
        GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection = new GraphQLFundraiserPersonToCharityDonorsConnection();
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
                graphQLFundraiserPersonToCharityDonorsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharityDonorsConnection, "nodes", graphQLFundraiserPersonToCharityDonorsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLFundraiserPersonToCharityDonorsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserPersonToCharityDonorsConnection, "page_info", graphQLFundraiserPersonToCharityDonorsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFundraiserPersonToCharityDonorsConnection;
    }

    public static void m7730a(JsonGenerator jsonGenerator, GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLFundraiserPersonToCharityDonorsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLFundraiserPersonToCharityDonorsConnection.a()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFundraiserPersonToCharityDonorsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLFundraiserPersonToCharityDonorsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
