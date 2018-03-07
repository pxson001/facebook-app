package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minZoomLevel */
public class GraphQLTrendingTopicDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrendingTopicData.class, new GraphQLTrendingTopicDataDeserializer());
    }

    public GraphQLTrendingTopicDataDeserializer() {
        a(GraphQLTrendingTopicData.class);
    }

    public Object m22299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTrendingTopicData__JsonHelper.m22301a(jsonParser);
    }
}
