package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: sms_anonymous_promo_ignore_delay */
public class GraphQLViewerDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLViewer.class, new GraphQLViewerDeserializer());
    }

    public GraphQLViewerDeserializer() {
        a(GraphQLViewer.class);
    }

    public Object m2231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLViewer__JsonHelper.m2232a(jsonParser);
    }
}
