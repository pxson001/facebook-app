package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: need_friendable_contacts */
public class GraphQLQuickPromotionActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionAction.class, new GraphQLQuickPromotionActionDeserializer());
    }

    public GraphQLQuickPromotionActionDeserializer() {
        a(GraphQLQuickPromotionAction.class);
    }

    public Object m21208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuickPromotionAction__JsonHelper.m21210a(jsonParser);
    }
}
