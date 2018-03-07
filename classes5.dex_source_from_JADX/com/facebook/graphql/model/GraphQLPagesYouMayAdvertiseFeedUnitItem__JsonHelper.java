package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: elementType */
public final class GraphQLPagesYouMayAdvertiseFeedUnitItem__JsonHelper {
    public static GraphQLPagesYouMayAdvertiseFeedUnitItem m9570a(JsonParser jsonParser) {
        GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem = new GraphQLPagesYouMayAdvertiseFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9572a(graphQLPagesYouMayAdvertiseFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPagesYouMayAdvertiseFeedUnitItem;
    }

    private static boolean m9572a(GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("action_link".equals(str)) {
            GraphQLStoryActionLink a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_link"));
            }
            graphQLPagesYouMayAdvertiseFeedUnitItem.f4760d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnitItem, "action_link", graphQLPagesYouMayAdvertiseFeedUnitItem.a_, 0, true);
            return true;
        } else if ("feed_unit_preview".equals(str)) {
            FeedUnit a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "feed_unit_preview"));
            }
            graphQLPagesYouMayAdvertiseFeedUnitItem.f4761e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnitItem, "feed_unit_preview", graphQLPagesYouMayAdvertiseFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnitItem.f4762f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnitItem, "hideable_token", graphQLPagesYouMayAdvertiseFeedUnitItem.B_(), 2, false);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLProfile a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLPagesYouMayAdvertiseFeedUnitItem.f4763g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnitItem, "profile", graphQLPagesYouMayAdvertiseFeedUnitItem.B_(), 3, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnitItem.f4764h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnitItem, "tracking", graphQLPagesYouMayAdvertiseFeedUnitItem.B_(), 4, false);
            return true;
        }
    }

    public static void m9571a(JsonGenerator jsonGenerator, GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPagesYouMayAdvertiseFeedUnitItem.m9562a() != null) {
            jsonGenerator.a("action_link");
            GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnitItem.m9562a(), true);
        }
        if (graphQLPagesYouMayAdvertiseFeedUnitItem.m9564j() != null) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnitItem.m9564j());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnitItem.m9566l() != null) {
            jsonGenerator.a("hideable_token", graphQLPagesYouMayAdvertiseFeedUnitItem.m9566l());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnitItem.m9567m() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnitItem.m9567m(), true);
        }
        if (graphQLPagesYouMayAdvertiseFeedUnitItem.m9565k() != null) {
            jsonGenerator.a("tracking", graphQLPagesYouMayAdvertiseFeedUnitItem.m9565k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
