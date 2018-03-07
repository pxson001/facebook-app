package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nf_headline */
public class GraphQLPhotoTagsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoTagsEdge.class, new GraphQLPhotoTagsEdgeDeserializer());
    }

    public GraphQLPhotoTagsEdgeDeserializer() {
        a(GraphQLPhotoTagsEdge.class);
    }

    public Object m20760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotoTagsEdge__JsonHelper.m20762a(jsonParser);
    }
}
