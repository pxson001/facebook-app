package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messaging_enabled */
public class GraphQLVideoGuidedTourDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoGuidedTour.class, new GraphQLVideoGuidedTourDeserializer());
    }

    public GraphQLVideoGuidedTourDeserializer() {
        a(GraphQLVideoGuidedTour.class);
    }

    public Object m22451a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoGuidedTour__JsonHelper.m22465a(jsonParser);
    }
}
