package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimelineAppSectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNIVERSAL_FEEDBACK */
public final class GraphQLTimelineAppSection$Serializer extends JsonSerializer<GraphQLTimelineAppSection> {
    public final void m22176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppSection graphQLTimelineAppSection = (GraphQLTimelineAppSection) obj;
        GraphQLTimelineAppSectionDeserializer.m6082a(graphQLTimelineAppSection.w_(), graphQLTimelineAppSection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppSection.class, new GraphQLTimelineAppSection$Serializer());
        FbSerializerProvider.a(GraphQLTimelineAppSection.class, new GraphQLTimelineAppSection$Serializer());
    }
}
