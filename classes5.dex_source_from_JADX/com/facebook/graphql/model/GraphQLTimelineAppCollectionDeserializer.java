package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android_finch_edit */
public class GraphQLTimelineAppCollectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollection.class, new GraphQLTimelineAppCollectionDeserializer());
    }

    public GraphQLTimelineAppCollectionDeserializer() {
        a(GraphQLTimelineAppCollection.class);
    }

    public Object m22118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineAppCollection__JsonHelper.m22160a(jsonParser);
    }
}
