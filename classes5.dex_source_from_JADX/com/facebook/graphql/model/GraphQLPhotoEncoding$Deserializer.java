package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhotoEncodingDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WINERY_VINEYARD */
public class GraphQLPhotoEncoding$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoEncoding.class, new GraphQLPhotoEncoding$Deserializer());
    }

    public Object m20719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhotoEncodingDeserializer.m5607a(jsonParser, (short) 80);
        Object graphQLPhotoEncoding = new GraphQLPhotoEncoding();
        ((BaseModel) graphQLPhotoEncoding).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhotoEncoding instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhotoEncoding).a();
        }
        return graphQLPhotoEncoding;
    }
}
