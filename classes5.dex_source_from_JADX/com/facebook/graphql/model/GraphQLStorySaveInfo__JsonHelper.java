package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unable to access notification extras */
public final class GraphQLStorySaveInfo__JsonHelper {
    public static GraphQLStorySaveInfo m21885a(JsonParser jsonParser) {
        GraphQLStorySaveInfo graphQLStorySaveInfo = new GraphQLStorySaveInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("story_save_nux_max_consume_duration".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStorySaveInfo.d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySaveInfo, "story_save_nux_max_consume_duration", graphQLStorySaveInfo.a_, 0, false);
            } else if ("story_save_nux_min_consume_duration".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLStorySaveInfo.e = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySaveInfo, "story_save_nux_min_consume_duration", graphQLStorySaveInfo.a_, 1, false);
            } else if ("story_save_nux_type".equals(i)) {
                graphQLStorySaveInfo.f = GraphQLStorySaveNuxType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySaveInfo, "story_save_nux_type", graphQLStorySaveInfo.a_, 2, false);
            } else if ("story_save_type".equals(i)) {
                graphQLStorySaveInfo.g = GraphQLStorySaveType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySaveInfo, "story_save_type", graphQLStorySaveInfo.a_, 3, false);
            } else if ("viewer_save_state".equals(i)) {
                graphQLStorySaveInfo.h = GraphQLSavedState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySaveInfo, "viewer_save_state", graphQLStorySaveInfo.a_, 4, false);
            }
            jsonParser.f();
        }
        return graphQLStorySaveInfo;
    }

    public static void m21886a(JsonGenerator jsonGenerator, GraphQLStorySaveInfo graphQLStorySaveInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("story_save_nux_max_consume_duration", graphQLStorySaveInfo.a());
        jsonGenerator.a("story_save_nux_min_consume_duration", graphQLStorySaveInfo.j());
        if (graphQLStorySaveInfo.k() != null) {
            jsonGenerator.a("story_save_nux_type", graphQLStorySaveInfo.k().toString());
        }
        if (graphQLStorySaveInfo.l() != null) {
            jsonGenerator.a("story_save_type", graphQLStorySaveInfo.l().toString());
        }
        if (graphQLStorySaveInfo.m() != null) {
            jsonGenerator.a("viewer_save_state", graphQLStorySaveInfo.m().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
