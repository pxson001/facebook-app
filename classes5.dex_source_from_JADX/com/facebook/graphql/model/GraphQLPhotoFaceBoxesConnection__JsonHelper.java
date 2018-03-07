package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WILLS_ESTATE_LAWYER */
public final class GraphQLPhotoFaceBoxesConnection__JsonHelper {
    public static GraphQLPhotoFaceBoxesConnection m20730a(JsonParser jsonParser) {
        GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection = new GraphQLPhotoFaceBoxesConnection();
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
                        GraphQLFaceBox a = GraphQLFaceBox__JsonHelper.m7452a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPhotoFaceBoxesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoFaceBoxesConnection, "nodes", graphQLPhotoFaceBoxesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPhotoFaceBoxesConnection;
    }

    public static void m20731a(JsonGenerator jsonGenerator, GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPhotoFaceBoxesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLFaceBox graphQLFaceBox : graphQLPhotoFaceBoxesConnection.a()) {
                if (graphQLFaceBox != null) {
                    GraphQLFaceBox__JsonHelper.m7453a(jsonGenerator, graphQLFaceBox, true);
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
