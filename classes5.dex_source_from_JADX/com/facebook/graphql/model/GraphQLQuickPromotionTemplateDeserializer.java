package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nearby_friends */
public class GraphQLQuickPromotionTemplateDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionTemplate.class, new GraphQLQuickPromotionTemplateDeserializer());
    }

    public GraphQLQuickPromotionTemplateDeserializer() {
        a(GraphQLQuickPromotionTemplate.class);
    }

    public Object m21262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuickPromotionTemplate__JsonHelper.m21264a(jsonParser);
    }
}
