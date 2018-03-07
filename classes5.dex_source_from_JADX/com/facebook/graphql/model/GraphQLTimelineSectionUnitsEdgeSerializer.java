package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNFRIEND_TOOL */
public class GraphQLTimelineSectionUnitsEdgeSerializer extends JsonSerializer<GraphQLTimelineSectionUnitsEdge> {
    public final void m22213a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineSectionUnitsEdge__JsonHelper.m22215a(jsonGenerator, (GraphQLTimelineSectionUnitsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineSectionUnitsEdge.class, new GraphQLTimelineSectionUnitsEdgeSerializer());
    }
}
