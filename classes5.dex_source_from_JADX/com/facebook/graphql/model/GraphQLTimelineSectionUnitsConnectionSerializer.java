package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNIFIED_MESSAGE */
public class GraphQLTimelineSectionUnitsConnectionSerializer extends JsonSerializer<GraphQLTimelineSectionUnitsConnection> {
    public final void m22202a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineSectionUnitsConnection__JsonHelper.m22204a(jsonGenerator, (GraphQLTimelineSectionUnitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineSectionUnitsConnection.class, new GraphQLTimelineSectionUnitsConnectionSerializer());
    }
}
