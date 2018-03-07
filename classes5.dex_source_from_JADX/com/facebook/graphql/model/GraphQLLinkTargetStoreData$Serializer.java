package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLinkTargetStoreDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fc_search */
public final class GraphQLLinkTargetStoreData$Serializer extends JsonSerializer<GraphQLLinkTargetStoreData> {
    public final void m8944a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLinkTargetStoreData graphQLLinkTargetStoreData = (GraphQLLinkTargetStoreData) obj;
        GraphQLLinkTargetStoreDataDeserializer.m5326a(graphQLLinkTargetStoreData.w_(), graphQLLinkTargetStoreData.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLLinkTargetStoreData.class, new GraphQLLinkTargetStoreData$Serializer());
        FbSerializerProvider.a(GraphQLLinkTargetStoreData.class, new GraphQLLinkTargetStoreData$Serializer());
    }
}
