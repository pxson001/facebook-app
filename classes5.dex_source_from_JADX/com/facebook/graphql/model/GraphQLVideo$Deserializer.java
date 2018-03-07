package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TimelineAppCollectionItem */
public class GraphQLVideo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideo.class, new GraphQLVideo$Deserializer());
    }

    public Object m22423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoDeserializer.m6185a(jsonParser, (short) 85);
        Object graphQLVideo = new GraphQLVideo();
        ((BaseModel) graphQLVideo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideo instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideo).a();
        }
        return graphQLVideo;
    }
}
