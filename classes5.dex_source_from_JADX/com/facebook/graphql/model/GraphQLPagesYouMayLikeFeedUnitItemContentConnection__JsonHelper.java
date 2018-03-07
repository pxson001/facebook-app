package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND */
public final class GraphQLPagesYouMayLikeFeedUnitItemContentConnection__JsonHelper {
    public static GraphQLPagesYouMayLikeFeedUnitItemContentConnection m20575a(JsonParser jsonParser) {
        GraphQLPagesYouMayLikeFeedUnitItemContentConnection graphQLPagesYouMayLikeFeedUnitItemContentConnection = new GraphQLPagesYouMayLikeFeedUnitItemContentConnection();
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
                        GraphQLNode a = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPagesYouMayLikeFeedUnitItemContentConnection.f12407d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItemContentConnection, "nodes", graphQLPagesYouMayLikeFeedUnitItemContentConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPagesYouMayLikeFeedUnitItemContentConnection;
    }

    public static void m20576a(JsonGenerator jsonGenerator, GraphQLPagesYouMayLikeFeedUnitItemContentConnection graphQLPagesYouMayLikeFeedUnitItemContentConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPagesYouMayLikeFeedUnitItemContentConnection.m20572a() != null) {
            jsonGenerator.d();
            for (GraphQLNode graphQLNode : graphQLPagesYouMayLikeFeedUnitItemContentConnection.m20572a()) {
                if (graphQLNode != null) {
                    GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLNode, true);
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
