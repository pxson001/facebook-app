package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PAGE_ADMIN_POST */
public final class GraphQLQuickPromotionPeopleYouMayKnowFeedUnit$Serializer extends JsonSerializer<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> {
    public final void m21252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) obj;
        GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer.m5762a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit.w_(), graphQLQuickPromotionPeopleYouMayKnowFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit$Serializer());
    }
}
