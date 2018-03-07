package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: message_cta_label */
public class GraphQLViewerVisitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLViewerVisitsConnection.class, new GraphQLViewerVisitsConnectionDeserializer());
    }

    public GraphQLViewerVisitsConnectionDeserializer() {
        a(GraphQLViewerVisitsConnection.class);
    }

    public Object m22490a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLViewerVisitsConnection__JsonHelper.m22492a(jsonParser);
    }
}
