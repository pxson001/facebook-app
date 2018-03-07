package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStickerDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unexpected HTTP code  */
public class GraphQLSticker$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSticker.class, new GraphQLSticker$Deserializer());
    }

    public Object m21832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStickerDeserializer.m5946a(jsonParser, (short) 65);
        Object graphQLSticker = new GraphQLSticker();
        ((BaseModel) graphQLSticker).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSticker instanceof Postprocessable) {
            return ((Postprocessable) graphQLSticker).a();
        }
        return graphQLSticker;
    }
}
