package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: group_browse */
public final class C0344xcce9d9af {
    public static GraphQLGoodwillBirthdayCampaignPostingActorsConnection m7816a(JsonParser jsonParser) {
        GraphQLGoodwillBirthdayCampaignPostingActorsConnection graphQLGoodwillBirthdayCampaignPostingActorsConnection = new GraphQLGoodwillBirthdayCampaignPostingActorsConnection();
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
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGoodwillBirthdayCampaignPostingActorsConnection.f3878d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaignPostingActorsConnection, "nodes", graphQLGoodwillBirthdayCampaignPostingActorsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillBirthdayCampaignPostingActorsConnection;
    }

    public static void m7817a(JsonGenerator jsonGenerator, GraphQLGoodwillBirthdayCampaignPostingActorsConnection graphQLGoodwillBirthdayCampaignPostingActorsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGoodwillBirthdayCampaignPostingActorsConnection.m7813a() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGoodwillBirthdayCampaignPostingActorsConnection.m7813a()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
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
