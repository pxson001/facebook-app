package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStreamingImageDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: USER_DISABLED */
public class GraphQLStreamingImage$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStreamingImage.class, new GraphQLStreamingImage$Deserializer());
    }

    public Object m21925a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStreamingImageDeserializer.m5992a(jsonParser, (short) 392);
        Object graphQLStreamingImage = new GraphQLStreamingImage();
        ((BaseModel) graphQLStreamingImage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStreamingImage instanceof Postprocessable) {
            return ((Postprocessable) graphQLStreamingImage).a();
        }
        return graphQLStreamingImage;
    }
}
