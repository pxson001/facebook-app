package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: hdBitrate */
public final class GraphQLFocusedPhoto__JsonHelper {
    public static GraphQLFocusedPhoto m7526a(JsonParser jsonParser) {
        GraphQLFocusedPhoto graphQLFocusedPhoto = new GraphQLFocusedPhoto();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPhoto graphQLPhoto = null;
            if ("focus".equals(i)) {
                GraphQLVect2 a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "focus"));
                }
                graphQLFocusedPhoto.d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLFocusedPhoto, "focus", graphQLFocusedPhoto.a_, 0, true);
            } else if ("photo".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "photo"));
                }
                graphQLFocusedPhoto.e = graphQLPhoto;
                FieldAccessQueryTracker.a(jsonParser, graphQLFocusedPhoto, "photo", graphQLFocusedPhoto.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFocusedPhoto;
    }

    public static void m7527a(JsonGenerator jsonGenerator, GraphQLFocusedPhoto graphQLFocusedPhoto, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFocusedPhoto.a() != null) {
            jsonGenerator.a("focus");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLFocusedPhoto.a(), true);
        }
        if (graphQLFocusedPhoto.j() != null) {
            jsonGenerator.a("photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLFocusedPhoto.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
