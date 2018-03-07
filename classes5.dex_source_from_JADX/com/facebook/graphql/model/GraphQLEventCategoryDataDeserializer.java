package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_ssr */
public class GraphQLEventCategoryDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventCategoryData.class, new GraphQLEventCategoryDataDeserializer());
    }

    public GraphQLEventCategoryDataDeserializer() {
        a(GraphQLEventCategoryData.class);
    }

    public Object m7120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventCategoryData__JsonHelper.m7122a(jsonParser);
    }
}
