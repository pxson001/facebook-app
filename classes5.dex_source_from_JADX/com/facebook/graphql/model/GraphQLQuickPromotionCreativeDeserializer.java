package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: need JSON String that contains type id (for subtype of  */
public class GraphQLQuickPromotionCreativeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionCreative.class, new GraphQLQuickPromotionCreativeDeserializer());
    }

    public GraphQLQuickPromotionCreativeDeserializer() {
        a(GraphQLQuickPromotionCreative.class);
    }

    public Object m21228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuickPromotionCreative__JsonHelper.m21230a(jsonParser);
    }
}
