package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: error_calling_getSoSNDTimeout */
public final class GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper {
    public static GraphQLPYMLWithLargeImageFeedUnitItem m9444a(JsonParser jsonParser) {
        GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem = new GraphQLPYMLWithLargeImageFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9446a(graphQLPYMLWithLargeImageFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPYMLWithLargeImageFeedUnitItem;
    }

    private static boolean m9446a(GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLImage a;
        if ("creativeImageHigh".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creativeImageHigh"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creativeImageHigh", graphQLPYMLWithLargeImageFeedUnitItem.a_, 0, true);
            return true;
        } else if ("creativeImageLow".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creativeImageLow"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creativeImageLow", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("creativeImageMedium".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creativeImageMedium"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creativeImageMedium", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 2, true);
            return true;
        } else if ("creative_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creative_image"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.g = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creative_image", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("creative_image_mobile_feed_focus".equals(str)) {
            GraphQLVect2 a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLVect2__JsonHelper.m22421a(FieldAccessQueryTracker.a(jsonParser, "creative_image_mobile_feed_focus"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creative_image_mobile_feed_focus", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("creative_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPYMLWithLargeImageFeedUnitItem.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "creative_text", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 5, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPYMLWithLargeImageFeedUnitItem.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "hideable_token", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 6, false);
            return true;
        } else if ("like_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "like_sentence"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "like_sentence", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 7, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.l = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "negative_feedback_actions", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 8, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLPage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.m = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "profile", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 9, true);
            return true;
        } else if ("social_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "social_context", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 10, true);
            return true;
        } else if ("sponsored_data".equals(str)) {
            GraphQLSponsoredData a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
            }
            graphQLPYMLWithLargeImageFeedUnitItem.o = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "sponsored_data", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 11, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPYMLWithLargeImageFeedUnitItem.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitItem, "tracking", graphQLPYMLWithLargeImageFeedUnitItem.B_(), 12, false);
            return true;
        }
    }

    public static void m9445a(JsonGenerator jsonGenerator, GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.s() != null) {
            jsonGenerator.a("creativeImageHigh");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.s(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.t() != null) {
            jsonGenerator.a("creativeImageLow");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.t(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.u() != null) {
            jsonGenerator.a("creativeImageMedium");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.u(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.v() != null) {
            jsonGenerator.a("creative_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.v(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.x() != null) {
            jsonGenerator.a("creative_image_mobile_feed_focus");
            GraphQLVect2__JsonHelper.m22422a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.x(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.y() != null) {
            jsonGenerator.a("creative_text", graphQLPYMLWithLargeImageFeedUnitItem.y());
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.B() != null) {
            jsonGenerator.a("hideable_token", graphQLPYMLWithLargeImageFeedUnitItem.B());
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.w() != null) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.w(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.C() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.C(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.D() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.D(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.z() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.z(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.A() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem.A(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnitItem.k() != null) {
            jsonGenerator.a("tracking", graphQLPYMLWithLargeImageFeedUnitItem.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
