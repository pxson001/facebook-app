package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNITTEST */
public class GraphQLTimelineSectionSerializer extends JsonSerializer<GraphQLTimelineSection> {
    public final void m22194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineSection__JsonHelper.m22218a(jsonGenerator, (GraphQLTimelineSection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineSection.class, new GraphQLTimelineSectionSerializer());
    }
}
