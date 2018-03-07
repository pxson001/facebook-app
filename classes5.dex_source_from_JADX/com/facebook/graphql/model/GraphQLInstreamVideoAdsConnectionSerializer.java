package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_unlike */
public class GraphQLInstreamVideoAdsConnectionSerializer extends JsonSerializer<GraphQLInstreamVideoAdsConnection> {
    public final void m8738a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstreamVideoAdsConnection__JsonHelper.m8740a(jsonGenerator, (GraphQLInstreamVideoAdsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInstreamVideoAdsConnection.class, new GraphQLInstreamVideoAdsConnectionSerializer());
    }
}
