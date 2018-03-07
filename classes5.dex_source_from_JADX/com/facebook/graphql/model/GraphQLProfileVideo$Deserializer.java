package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLProfileVideoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VOD_FULLSCREEN */
public class GraphQLProfileVideo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfileVideo.class, new GraphQLProfileVideo$Deserializer());
    }

    public Object m21107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLProfileVideoDeserializer.m5723a(jsonParser, (short) 558);
        Object graphQLProfileVideo = new GraphQLProfileVideo();
        ((BaseModel) graphQLProfileVideo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLProfileVideo instanceof Postprocessable) {
            return ((Postprocessable) graphQLProfileVideo).a();
        }
        return graphQLProfileVideo;
    }
}
