package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: jackson-core */
public class GraphQLAppAdStoriesSideFeedConnectionSerializer extends JsonSerializer<GraphQLAppAdStoriesSideFeedConnection> {
    public final void m6548a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppAdStoriesSideFeedConnection__JsonHelper.m6550a(jsonGenerator, (GraphQLAppAdStoriesSideFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedConnection.class, new GraphQLAppAdStoriesSideFeedConnectionSerializer());
    }
}
