package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: peopleYouMayInviteTitle */
public class GraphQLEmotionalAnalysisItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItem.class, new GraphQLEmotionalAnalysisItemDeserializer());
    }

    public GraphQLEmotionalAnalysisItemDeserializer() {
        a(GraphQLEmotionalAnalysisItem.class);
    }

    public Object m7012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEmotionalAnalysisItem__JsonHelper.m7014a(jsonParser);
    }
}
