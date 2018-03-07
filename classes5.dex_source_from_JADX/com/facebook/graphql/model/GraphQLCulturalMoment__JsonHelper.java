package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_suggest_edits_bookmark */
public final class GraphQLCulturalMoment__JsonHelper {
    public static boolean m6918a(GraphQLCulturalMoment graphQLCulturalMoment, String str, JsonParser jsonParser) {
        GraphQLVideo graphQLVideo = null;
        GraphQLImage a;
        if ("cultural_moment_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "cultural_moment_image"));
            }
            graphQLCulturalMoment.f3501d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "cultural_moment_image", graphQLCulturalMoment.a_, 0, true);
            return true;
        } else if ("favicon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "favicon"));
            }
            graphQLCulturalMoment.f3502e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "favicon", graphQLCulturalMoment.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLCulturalMoment.f3503f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "id", graphQLCulturalMoment.B_(), 2, false);
            return true;
        } else if ("image_margin".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLCulturalMoment.f3504g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "image_margin", graphQLCulturalMoment.B_(), 3, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLCulturalMoment.f3505h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "url", graphQLCulturalMoment.B_(), 5, false);
            return true;
        } else if (!"cultural_moment_video".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLVideo = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "cultural_moment_video"));
            }
            graphQLCulturalMoment.f3506i = graphQLVideo;
            FieldAccessQueryTracker.a(jsonParser, graphQLCulturalMoment, "cultural_moment_video", graphQLCulturalMoment.B_(), 6, true);
            return true;
        }
    }
}
