package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAttributionEntryDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_save_primary_action */
public final class GraphQLAttributionEntry$Serializer extends JsonSerializer<GraphQLAttributionEntry> {
    public final void m6613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAttributionEntry graphQLAttributionEntry = (GraphQLAttributionEntry) obj;
        GraphQLAttributionEntryDeserializer.m4596b(graphQLAttributionEntry.w_(), graphQLAttributionEntry.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAttributionEntry.class, new GraphQLAttributionEntry$Serializer());
        FbSerializerProvider.a(GraphQLAttributionEntry.class, new GraphQLAttributionEntry$Serializer());
    }
}
