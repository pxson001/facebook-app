package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WORK_GROUP_CREATION_DIALOG */
public final class GraphQLPeopleYouMayInviteFeedUnitContactsConnection__JsonHelper {
    public static GraphQLPeopleYouMayInviteFeedUnitContactsConnection m20652a(JsonParser jsonParser) {
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection = new GraphQLPeopleYouMayInviteFeedUnitContactsConnection();
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
                        GraphQLPeopleYouMayInviteFeedUnitContactsEdge a = GraphQLPeopleYouMayInviteFeedUnitContactsEdge__JsonHelper.m20668a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPeopleYouMayInviteFeedUnitContactsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsConnection, "edges", graphQLPeopleYouMayInviteFeedUnitContactsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLPeopleYouMayInviteFeedUnitContactsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouMayInviteFeedUnitContactsConnection, "page_info", graphQLPeopleYouMayInviteFeedUnitContactsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPeopleYouMayInviteFeedUnitContactsConnection;
    }

    public static void m20653a(JsonGenerator jsonGenerator, GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPeopleYouMayInviteFeedUnitContactsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge : graphQLPeopleYouMayInviteFeedUnitContactsConnection.a()) {
                if (graphQLPeopleYouMayInviteFeedUnitContactsEdge != null) {
                    GraphQLPeopleYouMayInviteFeedUnitContactsEdge__JsonHelper.m20669a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnitContactsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPeopleYouMayInviteFeedUnitContactsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLPeopleYouMayInviteFeedUnitContactsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
