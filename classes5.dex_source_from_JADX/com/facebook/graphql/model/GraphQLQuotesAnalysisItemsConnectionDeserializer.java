package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_template_bundles */
public class GraphQLQuotesAnalysisItemsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItemsConnection.class, new GraphQLQuotesAnalysisItemsConnectionDeserializer());
    }

    public GraphQLQuotesAnalysisItemsConnectionDeserializer() {
        a(GraphQLQuotesAnalysisItemsConnection.class);
    }

    public Object m21288a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuotesAnalysisItemsConnection__JsonHelper.m21290a(jsonParser);
    }
}
