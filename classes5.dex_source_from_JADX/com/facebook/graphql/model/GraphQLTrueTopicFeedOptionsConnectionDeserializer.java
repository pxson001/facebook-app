package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mime */
public class GraphQLTrueTopicFeedOptionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOptionsConnection.class, new GraphQLTrueTopicFeedOptionsConnectionDeserializer());
    }

    public GraphQLTrueTopicFeedOptionsConnectionDeserializer() {
        a(GraphQLTrueTopicFeedOptionsConnection.class);
    }

    public Object m22326a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTrueTopicFeedOptionsConnection__JsonHelper.m22328a(jsonParser);
    }
}
