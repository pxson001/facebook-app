package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMobileStoreObjectDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: facecastCameraZoomLevel */
public class GraphQLMobileStoreObject$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMobileStoreObject.class, new GraphQLMobileStoreObject$Deserializer());
    }

    public Object m9134a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMobileStoreObjectDeserializer.m5378a(jsonParser, (short) 69);
        Object graphQLMobileStoreObject = new GraphQLMobileStoreObject();
        ((BaseModel) graphQLMobileStoreObject).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMobileStoreObject instanceof Postprocessable) {
            return ((Postprocessable) graphQLMobileStoreObject).a();
        }
        return graphQLMobileStoreObject;
    }
}
