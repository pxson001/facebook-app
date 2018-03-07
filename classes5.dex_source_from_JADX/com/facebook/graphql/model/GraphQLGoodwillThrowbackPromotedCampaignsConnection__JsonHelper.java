package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: getStatistics */
public final class GraphQLGoodwillThrowbackPromotedCampaignsConnection__JsonHelper {
    public static GraphQLGoodwillThrowbackPromotedCampaignsConnection m8077a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackPromotedCampaignsConnection graphQLGoodwillThrowbackPromotedCampaignsConnection = new GraphQLGoodwillThrowbackPromotedCampaignsConnection();
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
                        GraphQLGoodwillCampaign a = GraphQLGoodwillCampaign__JsonHelper.m7851a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLGoodwillThrowbackPromotedCampaignsConnection.f4030d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotedCampaignsConnection, "nodes", graphQLGoodwillThrowbackPromotedCampaignsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackPromotedCampaignsConnection;
    }

    public static void m8078a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackPromotedCampaignsConnection graphQLGoodwillThrowbackPromotedCampaignsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGoodwillThrowbackPromotedCampaignsConnection.m8074a() != null) {
            jsonGenerator.d();
            for (GraphQLGoodwillCampaign graphQLGoodwillCampaign : graphQLGoodwillThrowbackPromotedCampaignsConnection.m8074a()) {
                if (graphQLGoodwillCampaign != null) {
                    GraphQLGoodwillCampaign__JsonHelper.m7852a(jsonGenerator, graphQLGoodwillCampaign, true);
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
