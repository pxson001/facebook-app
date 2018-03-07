package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ads */
public class GraphQLTimelineAppCollectionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionsConnection.class, new GraphQLTimelineAppCollectionsConnectionDeserializer());
    }

    public GraphQLTimelineAppCollectionsConnectionDeserializer() {
        a(GraphQLTimelineAppCollectionsConnection.class);
    }

    public Object m22171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineAppCollectionsConnection__JsonHelper.m22173a(jsonParser);
    }
}
