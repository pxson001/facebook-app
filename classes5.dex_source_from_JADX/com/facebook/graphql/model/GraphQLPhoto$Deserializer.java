package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhotoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WINE_BAR */
public class GraphQLPhoto$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhoto.class, new GraphQLPhoto$Deserializer());
    }

    public Object m20716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhotoDeserializer.m5602a(jsonParser, (short) 81);
        Object graphQLPhoto = new GraphQLPhoto();
        ((BaseModel) graphQLPhoto).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhoto instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhoto).a();
        }
        return graphQLPhoto;
    }
}
