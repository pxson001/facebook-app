package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_template_view */
public class GraphQLQuotesAnalysisItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItem.class, new GraphQLQuotesAnalysisItemDeserializer());
    }

    public GraphQLQuotesAnalysisItemDeserializer() {
        a(GraphQLQuotesAnalysisItem.class);
    }

    public Object m21279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuotesAnalysisItem__JsonHelper.m21281a(jsonParser);
    }
}
