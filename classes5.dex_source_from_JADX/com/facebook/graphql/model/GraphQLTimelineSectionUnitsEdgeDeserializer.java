package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: missing_attachment_report.txt */
public class GraphQLTimelineSectionUnitsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionUnitsEdge.class, new GraphQLTimelineSectionUnitsEdgeDeserializer());
    }

    public GraphQLTimelineSectionUnitsEdgeDeserializer() {
        a(GraphQLTimelineSectionUnitsEdge.class);
    }

    public Object m22212a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineSectionUnitsEdge__JsonHelper.m22214a(jsonParser);
    }
}
