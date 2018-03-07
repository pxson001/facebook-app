package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_edit_dialog */
public class GraphQLAppAdStoriesSideFeedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppAdStoriesSideFeedEdge.class, new GraphQLAppAdStoriesSideFeedEdgeDeserializer());
    }

    public GraphQLAppAdStoriesSideFeedEdgeDeserializer() {
        a(GraphQLAppAdStoriesSideFeedEdge.class);
    }

    public Object m6556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAppAdStoriesSideFeedEdge__JsonHelper.m6558a(jsonParser);
    }
}
