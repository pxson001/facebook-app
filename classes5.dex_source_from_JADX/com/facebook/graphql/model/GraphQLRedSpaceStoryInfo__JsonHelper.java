package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_OVERLAY */
public final class GraphQLRedSpaceStoryInfo__JsonHelper {
    public static GraphQLRedSpaceStoryInfo m21375a(JsonParser jsonParser) {
        GraphQLRedSpaceStoryInfo graphQLRedSpaceStoryInfo = new GraphQLRedSpaceStoryInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("visibility_state".equals(i)) {
                graphQLRedSpaceStoryInfo.d = GraphQLRedSpaceVisibilityState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceStoryInfo, "visibility_state", graphQLRedSpaceStoryInfo.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLRedSpaceStoryInfo;
    }

    public static void m21376a(JsonGenerator jsonGenerator, GraphQLRedSpaceStoryInfo graphQLRedSpaceStoryInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLRedSpaceStoryInfo.a() != null) {
            jsonGenerator.a("visibility_state", graphQLRedSpaceStoryInfo.a().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
