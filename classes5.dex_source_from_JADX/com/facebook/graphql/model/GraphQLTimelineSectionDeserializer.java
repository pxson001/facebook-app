package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mkv */
public class GraphQLTimelineSectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineSection.class, new GraphQLTimelineSectionDeserializer());
    }

    public GraphQLTimelineSectionDeserializer() {
        a(GraphQLTimelineSection.class);
    }

    public Object m22193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineSection__JsonHelper.m22217a(jsonParser);
    }
}
