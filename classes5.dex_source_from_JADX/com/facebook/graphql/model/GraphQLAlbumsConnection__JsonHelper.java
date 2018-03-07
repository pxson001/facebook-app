package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: jewel */
public final class GraphQLAlbumsConnection__JsonHelper {
    public static GraphQLAlbumsConnection m6518a(JsonParser jsonParser) {
        GraphQLAlbumsConnection graphQLAlbumsConnection = new GraphQLAlbumsConnection();
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
                        GraphQLAlbum a = GraphQLAlbum__JsonHelper.m6510a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLAlbumsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLAlbumsConnection, "nodes", graphQLAlbumsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLAlbumsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLAlbumsConnection, "page_info", graphQLAlbumsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLAlbumsConnection;
    }

    public static void m6519a(JsonGenerator jsonGenerator, GraphQLAlbumsConnection graphQLAlbumsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLAlbumsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLAlbum graphQLAlbum : graphQLAlbumsConnection.a()) {
                if (graphQLAlbum != null) {
                    GraphQLAlbum__JsonHelper.m6511a(jsonGenerator, graphQLAlbum, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAlbumsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLAlbumsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
