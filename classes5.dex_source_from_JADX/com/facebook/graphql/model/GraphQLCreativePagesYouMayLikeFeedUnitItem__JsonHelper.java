package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is-adts */
public final class GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper {
    public static GraphQLCreativePagesYouMayLikeFeedUnitItem m6900a(JsonParser jsonParser) {
        GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem = new GraphQLCreativePagesYouMayLikeFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6902a(graphQLCreativePagesYouMayLikeFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLCreativePagesYouMayLikeFeedUnitItem;
    }

    private static boolean m6902a(GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("creative_image".equals(str)) {
            GraphQLImage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creative_image"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "creative_image", graphQLCreativePagesYouMayLikeFeedUnitItem.a_, 0, true);
            return true;
        } else if ("creative_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "creative_text", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 1, false);
            return true;
        } else if ("creative_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "creative_title", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 2, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "hideable_token", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 3, false);
            return true;
        } else if ("like_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "like_sentence"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "like_sentence", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "negative_feedback_actions", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 5, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLPage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.j = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "profile", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 6, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "social_context", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 7, true);
            return true;
        } else if ("sponsored_data".equals(str)) {
            GraphQLSponsoredData a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.l = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "sponsored_data", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 8, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnitItem.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnitItem, "tracking", graphQLCreativePagesYouMayLikeFeedUnitItem.B_(), 9, false);
            return true;
        }
    }

    public static void m6901a(JsonGenerator jsonGenerator, GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.s() != null) {
            jsonGenerator.a("creative_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.s(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.t() != null) {
            jsonGenerator.a("creative_text", graphQLCreativePagesYouMayLikeFeedUnitItem.t());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.u() != null) {
            jsonGenerator.a("creative_title", graphQLCreativePagesYouMayLikeFeedUnitItem.u());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.v() != null) {
            jsonGenerator.a("hideable_token", graphQLCreativePagesYouMayLikeFeedUnitItem.v());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.w() != null) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.w(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.x() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.x(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.y() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.y(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.z() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.z(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.A() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem.A(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.k() != null) {
            jsonGenerator.a("tracking", graphQLCreativePagesYouMayLikeFeedUnitItem.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
