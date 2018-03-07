package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_NEARBY_FRIENDS_NUX */
public class GraphQLQuickPromotionSerializer extends JsonSerializer<GraphQLQuickPromotion> {
    public final void m21255a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuickPromotion__JsonHelper.m21267a(jsonGenerator, (GraphQLQuickPromotion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuickPromotion.class, new GraphQLQuickPromotionSerializer());
    }
}
