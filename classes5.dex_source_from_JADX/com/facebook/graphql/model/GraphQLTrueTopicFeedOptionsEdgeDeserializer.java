package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mge_suggest_edits_button */
public class GraphQLTrueTopicFeedOptionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOptionsEdge.class, new GraphQLTrueTopicFeedOptionsEdgeDeserializer());
    }

    public GraphQLTrueTopicFeedOptionsEdgeDeserializer() {
        a(GraphQLTrueTopicFeedOptionsEdge.class);
    }

    public Object m22335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTrueTopicFeedOptionsEdge__JsonHelper.m22337a(jsonParser);
    }
}
