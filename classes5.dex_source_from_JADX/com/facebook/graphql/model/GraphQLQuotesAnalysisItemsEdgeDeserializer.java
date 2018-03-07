package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_store_url */
public class GraphQLQuotesAnalysisItemsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItemsEdge.class, new GraphQLQuotesAnalysisItemsEdgeDeserializer());
    }

    public GraphQLQuotesAnalysisItemsEdgeDeserializer() {
        a(GraphQLQuotesAnalysisItemsEdge.class);
    }

    public Object m21297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuotesAnalysisItemsEdge__JsonHelper.m21299a(jsonParser);
    }
}
