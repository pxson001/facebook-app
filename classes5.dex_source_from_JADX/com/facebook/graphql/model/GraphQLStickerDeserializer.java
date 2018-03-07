package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: model_name */
public class GraphQLStickerDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSticker.class, new GraphQLStickerDeserializer());
    }

    public GraphQLStickerDeserializer() {
        a(GraphQLSticker.class);
    }

    public Object m21834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSticker__JsonHelper.m21836a(jsonParser);
    }
}
