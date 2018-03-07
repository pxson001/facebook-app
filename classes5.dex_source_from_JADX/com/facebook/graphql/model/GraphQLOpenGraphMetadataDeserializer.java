package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offending_view_group */
public class GraphQLOpenGraphMetadataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphMetadata.class, new GraphQLOpenGraphMetadataDeserializer());
    }

    public GraphQLOpenGraphMetadataDeserializer() {
        a(GraphQLOpenGraphMetadata.class);
    }

    public Object m9400a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLOpenGraphMetadata__JsonHelper.m9402a(jsonParser);
    }
}
