package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PHOTOS_OF_PAGE_ALBUM */
public class GraphQLQuickPromotionActionSerializer extends JsonSerializer<GraphQLQuickPromotionAction> {
    public final void m21209a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotionAction__JsonHelper.m21211a(jsonGenerator, (GraphQLQuickPromotionAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotionAction.class, new GraphQLQuickPromotionActionSerializer());
    }
}
