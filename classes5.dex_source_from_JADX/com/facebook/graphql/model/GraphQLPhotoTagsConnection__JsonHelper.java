package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WIKIVOYAGE */
public final class GraphQLPhotoTagsConnection__JsonHelper {
    public static GraphQLPhotoTagsConnection m20751a(JsonParser jsonParser) {
        GraphQLPhotoTagsConnection graphQLPhotoTagsConnection = new GraphQLPhotoTagsConnection();
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
                        GraphQLPhotoTagsEdge a = GraphQLPhotoTagsEdge__JsonHelper.m20762a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPhotoTagsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTagsConnection, "edges", graphQLPhotoTagsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPhotoTagsConnection;
    }

    public static void m20752a(JsonGenerator jsonGenerator, GraphQLPhotoTagsConnection graphQLPhotoTagsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPhotoTagsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPhotoTagsEdge graphQLPhotoTagsEdge : graphQLPhotoTagsConnection.a()) {
                if (graphQLPhotoTagsEdge != null) {
                    GraphQLPhotoTagsEdge__JsonHelper.m20763a(jsonGenerator, graphQLPhotoTagsEdge, true);
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
