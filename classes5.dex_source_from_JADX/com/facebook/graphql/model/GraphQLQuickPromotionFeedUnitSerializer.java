package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PAGE_CHILD_LOCATIONS */
public class GraphQLQuickPromotionFeedUnitSerializer extends JsonSerializer<GraphQLQuickPromotionFeedUnit> {
    public final void m21250a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLQuickPromotionFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLQuickPromotionFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLQuickPromotionFeedUnit.g());
        }
        if (graphQLQuickPromotionFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLQuickPromotionFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLQuickPromotionFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLQuickPromotionFeedUnit.k() != null) {
            jsonGenerator.d();
            for (GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem : graphQLQuickPromotionFeedUnit.k()) {
                if (graphQLQuickPromotionFeedUnitItem != null) {
                    GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21248a(jsonGenerator, graphQLQuickPromotionFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("quick_promotion_items");
        if (graphQLQuickPromotionFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem2 : graphQLQuickPromotionFeedUnit.l()) {
                if (graphQLQuickPromotionFeedUnitItem2 != null) {
                    GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21248a(jsonGenerator, graphQLQuickPromotionFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLQuickPromotionFeedUnit.m() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLQuickPromotionFeedUnit.m());
        }
        if (graphQLQuickPromotionFeedUnit.n() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionFeedUnit.n(), true);
        }
        if (graphQLQuickPromotionFeedUnit.u() != null) {
            jsonGenerator.a("tracking", graphQLQuickPromotionFeedUnit.u());
        }
        if (graphQLQuickPromotionFeedUnit.v() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLQuickPromotionFeedUnit.v());
        }
        if (graphQLQuickPromotionFeedUnit.w() != null) {
            jsonGenerator.a("local_story_visibility", graphQLQuickPromotionFeedUnit.w());
        }
        jsonGenerator.a("local_story_visible_height", graphQLQuickPromotionFeedUnit.x());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionFeedUnit.class, new GraphQLQuickPromotionFeedUnitSerializer());
    }
}
