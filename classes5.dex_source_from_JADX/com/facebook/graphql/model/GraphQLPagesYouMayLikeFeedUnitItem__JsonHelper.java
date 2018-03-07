package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WRITE_RENAME_FILE_OTHER */
public final class GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper {
    public static GraphQLPagesYouMayLikeFeedUnitItem m20579a(JsonParser jsonParser) {
        GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem = new GraphQLPagesYouMayLikeFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20581a(graphQLPagesYouMayLikeFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPagesYouMayLikeFeedUnitItem;
    }

    private static boolean m20581a(GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("content_set".equals(str)) {
            GraphQLPagesYouMayLikeFeedUnitItemContentConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPagesYouMayLikeFeedUnitItemContentConnection__JsonHelper.m20575a(FieldAccessQueryTracker.a(jsonParser, "content_set"));
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12399d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "content_set", graphQLPagesYouMayLikeFeedUnitItem.a_, 0, true);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12400e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "hideable_token", graphQLPagesYouMayLikeFeedUnitItem.B_(), 1, false);
            return true;
        } else if ("like_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "like_sentence"));
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12401f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "like_sentence", graphQLPagesYouMayLikeFeedUnitItem.B_(), 2, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLPage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12402g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "profile", graphQLPagesYouMayLikeFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12403h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "social_context", graphQLPagesYouMayLikeFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("sponsored_data".equals(str)) {
            GraphQLSponsoredData a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12404i = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "sponsored_data", graphQLPagesYouMayLikeFeedUnitItem.B_(), 5, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayLikeFeedUnitItem.f12405j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnitItem, "tracking", graphQLPagesYouMayLikeFeedUnitItem.B_(), 6, false);
            return true;
        }
    }

    public static void m20580a(JsonGenerator jsonGenerator, GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20563s() != null) {
            jsonGenerator.a("content_set");
            GraphQLPagesYouMayLikeFeedUnitItemContentConnection__JsonHelper.m20576a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem.m20563s(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20564t() != null) {
            jsonGenerator.a("hideable_token", graphQLPagesYouMayLikeFeedUnitItem.m20564t());
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20566w() != null) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem.m20566w(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20565u() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem.m20565u(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20567z() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem.m20567z(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20552A() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem.m20552A(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnitItem.m20556k() != null) {
            jsonGenerator.a("tracking", graphQLPagesYouMayLikeFeedUnitItem.m20556k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
