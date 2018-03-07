package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_add_members */
public class GraphQLTimelineAppSectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppSection.class, new GraphQLTimelineAppSectionDeserializer());
    }

    public GraphQLTimelineAppSectionDeserializer() {
        a(GraphQLTimelineAppSection.class);
    }

    public Object m22177a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineAppSection__JsonHelper.m22179a(jsonParser);
    }
}
