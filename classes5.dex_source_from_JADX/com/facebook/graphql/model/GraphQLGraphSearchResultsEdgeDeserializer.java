package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_comments_card */
public class GraphQLGraphSearchResultsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultsEdge.class, new GraphQLGraphSearchResultsEdgeDeserializer());
    }

    public GraphQLGraphSearchResultsEdgeDeserializer() {
        a(GraphQLGraphSearchResultsEdge.class);
    }

    public Object m8307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchResultsEdge__JsonHelper.m8309a(jsonParser);
    }
}
