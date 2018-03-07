package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VISIT_YOUR_PAGE */
public final class GraphQLProfileVideo__JsonHelper {
    public static GraphQLProfileVideo m21111a(JsonParser jsonParser) {
        GraphQLProfileVideo graphQLProfileVideo = new GraphQLProfileVideo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21113a(graphQLProfileVideo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLProfileVideo;
    }

    private static boolean m21113a(GraphQLProfileVideo graphQLProfileVideo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("associated_video".equals(str)) {
            GraphQLVideo a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "associated_video"));
            }
            graphQLProfileVideo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileVideo, "associated_video", graphQLProfileVideo.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLProfileVideo.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileVideo, "id", graphQLProfileVideo.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLProfileVideo.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLProfileVideo, "url", graphQLProfileVideo.B_(), 2, false);
            return true;
        }
    }

    public static void m21112a(JsonGenerator jsonGenerator, GraphQLProfileVideo graphQLProfileVideo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLProfileVideo.j() != null) {
            jsonGenerator.a("associated_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLProfileVideo.j(), true);
        }
        if (graphQLProfileVideo.k() != null) {
            jsonGenerator.a("id", graphQLProfileVideo.k());
        }
        if (graphQLProfileVideo.l() != null) {
            jsonGenerator.a("url", graphQLProfileVideo.l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
