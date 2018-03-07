package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Viewer */
public final class GraphQLPostedPhotosConnection__JsonHelper {
    public static GraphQLPostedPhotosConnection m20974a(JsonParser jsonParser) {
        GraphQLPostedPhotosConnection graphQLPostedPhotosConnection = new GraphQLPostedPhotosConnection();
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
                        GraphQLPhoto a = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPostedPhotosConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLPostedPhotosConnection, "nodes", graphQLPostedPhotosConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLPostedPhotosConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPostedPhotosConnection, "page_info", graphQLPostedPhotosConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPostedPhotosConnection;
    }

    public static void m20975a(JsonGenerator jsonGenerator, GraphQLPostedPhotosConnection graphQLPostedPhotosConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPostedPhotosConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLPostedPhotosConnection.a()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPostedPhotosConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLPostedPhotosConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
