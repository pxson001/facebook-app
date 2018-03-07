package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Using content provider URI for %s */
public final class GraphQLSinglePublisherVideoChannelsConnection__JsonHelper {
    public static GraphQLSinglePublisherVideoChannelsConnection m21662a(JsonParser jsonParser) {
        GraphQLSinglePublisherVideoChannelsConnection graphQLSinglePublisherVideoChannelsConnection = new GraphQLSinglePublisherVideoChannelsConnection();
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
                        GraphQLSinglePublisherVideoChannelsEdge a = GraphQLSinglePublisherVideoChannelsEdge__JsonHelper.m21671a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSinglePublisherVideoChannelsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSinglePublisherVideoChannelsConnection, "edges", graphQLSinglePublisherVideoChannelsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSinglePublisherVideoChannelsConnection;
    }

    public static void m21663a(JsonGenerator jsonGenerator, GraphQLSinglePublisherVideoChannelsConnection graphQLSinglePublisherVideoChannelsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSinglePublisherVideoChannelsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLSinglePublisherVideoChannelsEdge graphQLSinglePublisherVideoChannelsEdge : graphQLSinglePublisherVideoChannelsConnection.a()) {
                if (graphQLSinglePublisherVideoChannelsEdge != null) {
                    GraphQLSinglePublisherVideoChannelsEdge__JsonHelper.m21672a(jsonGenerator, graphQLSinglePublisherVideoChannelsEdge, true);
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
