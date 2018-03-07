package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PAGE_MENU */
public class GraphQLQuickPromotionFeedUnitItemSerializer extends JsonSerializer<GraphQLQuickPromotionFeedUnitItem> {
    public final void m21246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21248a(jsonGenerator, (GraphQLQuickPromotionFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionFeedUnitItem.class, new GraphQLQuickPromotionFeedUnitItemSerializer());
    }
}
