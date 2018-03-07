package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNIT_TEST2 */
public class GraphQLTimelineAppSectionSerializer extends JsonSerializer<GraphQLTimelineAppSection> {
    public final void m22178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppSection__JsonHelper.m22180a(jsonGenerator, (GraphQLTimelineAppSection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppSection.class, new GraphQLTimelineAppSectionSerializer());
    }
}
