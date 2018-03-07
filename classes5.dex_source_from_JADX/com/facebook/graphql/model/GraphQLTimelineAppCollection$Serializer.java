package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKNOWN_REPORT_PLACE */
public final class GraphQLTimelineAppCollection$Serializer extends JsonSerializer<GraphQLTimelineAppCollection> {
    public final void m22117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) obj;
        GraphQLTimelineAppCollectionDeserializer.m6070b(graphQLTimelineAppCollection.w_(), graphQLTimelineAppCollection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollection.class, new GraphQLTimelineAppCollection$Serializer());
        FbSerializerProvider.a(GraphQLTimelineAppCollection.class, new GraphQLTimelineAppCollection$Serializer());
    }
}
