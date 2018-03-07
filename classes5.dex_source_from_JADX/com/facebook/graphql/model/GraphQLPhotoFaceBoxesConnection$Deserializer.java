package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPhotoFaceBoxesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WINDOWS_10_STORE */
public class GraphQLPhotoFaceBoxesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoFaceBoxesConnection.class, new GraphQLPhotoFaceBoxesConnection$Deserializer());
    }

    public Object m20726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPhotoFaceBoxesConnectionDeserializer.m5612a(jsonParser, (short) 276);
        Object graphQLPhotoFaceBoxesConnection = new GraphQLPhotoFaceBoxesConnection();
        ((BaseModel) graphQLPhotoFaceBoxesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPhotoFaceBoxesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPhotoFaceBoxesConnection).a();
        }
        return graphQLPhotoFaceBoxesConnection;
    }
}
