package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: need JSON Object to contain As.WRAPPER_OBJECT type information for class  */
public class GraphQLQuickPromotionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotion.class, new GraphQLQuickPromotionDeserializer());
    }

    public GraphQLQuickPromotionDeserializer() {
        a(GraphQLQuickPromotion.class);
    }

    public Object m21232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuickPromotion__JsonHelper.m21266a(jsonParser);
    }
}
