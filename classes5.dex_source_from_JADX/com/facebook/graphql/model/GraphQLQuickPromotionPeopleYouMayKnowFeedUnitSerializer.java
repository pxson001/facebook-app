package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_ON_THIS_DAY_GOODWILL */
public class GraphQLQuickPromotionPeopleYouMayKnowFeedUnitSerializer extends JsonSerializer<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> {
    public final void m21254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.g());
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem : graphQLQuickPromotionPeopleYouMayKnowFeedUnit.l()) {
                if (graphQLPeopleYouMayKnowFeedUnitItem != null) {
                    GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20687a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("pymkItems");
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.o() != null) {
            jsonGenerator.d();
            for (GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem2 : graphQLQuickPromotionPeopleYouMayKnowFeedUnit.o()) {
                if (graphQLPeopleYouMayKnowFeedUnitItem2 != null) {
                    GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20687a(jsonGenerator, graphQLPeopleYouMayKnowFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.p() != null) {
            jsonGenerator.a("pymkTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionPeopleYouMayKnowFeedUnit.p(), true);
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.q());
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionPeopleYouMayKnowFeedUnit.r(), true);
        }
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, new GraphQLQuickPromotionPeopleYouMayKnowFeedUnitSerializer());
    }
}
