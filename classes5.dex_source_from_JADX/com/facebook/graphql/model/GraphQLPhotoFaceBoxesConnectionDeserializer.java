package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no ReviewActivity intent could be created */
public class GraphQLPhotoFaceBoxesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoFaceBoxesConnection.class, new GraphQLPhotoFaceBoxesConnectionDeserializer());
    }

    public GraphQLPhotoFaceBoxesConnectionDeserializer() {
        a(GraphQLPhotoFaceBoxesConnection.class);
    }

    public Object m20728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotoFaceBoxesConnection__JsonHelper.m20730a(jsonParser);
    }
}
