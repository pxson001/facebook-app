package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WATCH_MOVIE */
public final class GraphQLPlaceReviewFeedUnitItem__JsonHelper {
    public static GraphQLPlaceReviewFeedUnitItem m20909a(JsonParser jsonParser) {
        GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem = new GraphQLPlaceReviewFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20911a(graphQLPlaceReviewFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlaceReviewFeedUnitItem;
    }

    private static boolean m20911a(GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPlaceReviewFeedUnitItem.f12661d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnitItem, "hideable_token", graphQLPlaceReviewFeedUnitItem.a_, 0, false);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLPlaceReviewFeedUnitItem.f12662e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnitItem, "profile", graphQLPlaceReviewFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("rating_context_string".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "rating_context_string"));
            }
            graphQLPlaceReviewFeedUnitItem.f12663f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnitItem, "rating_context_string", graphQLPlaceReviewFeedUnitItem.B_(), 2, true);
            return true;
        } else if ("representative_image".equals(str)) {
            GraphQLImage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "representative_image"));
            }
            graphQLPlaceReviewFeedUnitItem.f12664g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnitItem, "representative_image", graphQLPlaceReviewFeedUnitItem.B_(), 3, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPlaceReviewFeedUnitItem.f12665h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnitItem, "tracking", graphQLPlaceReviewFeedUnitItem.B_(), 4, false);
            return true;
        }
    }

    public static void m20910a(JsonGenerator jsonGenerator, GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlaceReviewFeedUnitItem.m20902j() != null) {
            jsonGenerator.a("hideable_token", graphQLPlaceReviewFeedUnitItem.m20902j());
        }
        if (graphQLPlaceReviewFeedUnitItem.m20904l() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPlaceReviewFeedUnitItem.m20904l(), true);
        }
        if (graphQLPlaceReviewFeedUnitItem.m20905m() != null) {
            jsonGenerator.a("rating_context_string");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPlaceReviewFeedUnitItem.m20905m(), true);
        }
        if (graphQLPlaceReviewFeedUnitItem.m20906n() != null) {
            jsonGenerator.a("representative_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPlaceReviewFeedUnitItem.m20906n(), true);
        }
        if (graphQLPlaceReviewFeedUnitItem.m20903k() != null) {
            jsonGenerator.a("tracking", graphQLPlaceReviewFeedUnitItem.m20903k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
