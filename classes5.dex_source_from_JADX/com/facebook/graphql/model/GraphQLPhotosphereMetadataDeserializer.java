package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nf_fr */
public class GraphQLPhotosphereMetadataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotosphereMetadata.class, new GraphQLPhotosphereMetadataDeserializer());
    }

    public GraphQLPhotosphereMetadataDeserializer() {
        a(GraphQLPhotosphereMetadata.class);
    }

    public Object m20782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotosphereMetadata__JsonHelper.m20784a(jsonParser);
    }
}
