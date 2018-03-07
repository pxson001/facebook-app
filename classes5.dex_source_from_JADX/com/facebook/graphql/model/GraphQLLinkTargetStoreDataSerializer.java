package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fc_requests */
public class GraphQLLinkTargetStoreDataSerializer extends JsonSerializer<GraphQLLinkTargetStoreData> {
    public final void m8946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLinkTargetStoreData__JsonHelper.m8948a(jsonGenerator, (GraphQLLinkTargetStoreData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLinkTargetStoreData.class, new GraphQLLinkTargetStoreDataSerializer());
    }
}
