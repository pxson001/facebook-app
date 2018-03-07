package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: number_of_keystrokes */
public class GraphQLPagePostPromotionInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagePostPromotionInfo.class, new GraphQLPagePostPromotionInfoDeserializer());
    }

    public GraphQLPagePostPromotionInfoDeserializer() {
        a(GraphQLPagePostPromotionInfo.class);
    }

    public Object m9511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPagePostPromotionInfo__JsonHelper.m9513a(jsonParser);
    }
}
