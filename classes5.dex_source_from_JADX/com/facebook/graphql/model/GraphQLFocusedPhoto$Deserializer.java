package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFocusedPhotoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hd_playable_url */
public class GraphQLFocusedPhoto$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFocusedPhoto.class, new GraphQLFocusedPhoto$Deserializer());
    }

    public Object m7522a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFocusedPhotoDeserializer.m4920a(jsonParser, (short) 167);
        Object graphQLFocusedPhoto = new GraphQLFocusedPhoto();
        ((BaseModel) graphQLFocusedPhoto).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFocusedPhoto instanceof Postprocessable) {
            return ((Postprocessable) graphQLFocusedPhoto).a();
        }
        return graphQLFocusedPhoto;
    }
}
