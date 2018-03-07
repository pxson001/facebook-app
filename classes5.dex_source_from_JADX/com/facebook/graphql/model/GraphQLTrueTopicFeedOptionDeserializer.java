package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minZoom */
public class GraphQLTrueTopicFeedOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOption.class, new GraphQLTrueTopicFeedOptionDeserializer());
    }

    public GraphQLTrueTopicFeedOptionDeserializer() {
        a(GraphQLTrueTopicFeedOption.class);
    }

    public Object m22317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTrueTopicFeedOption__JsonHelper.m22319a(jsonParser);
    }
}
