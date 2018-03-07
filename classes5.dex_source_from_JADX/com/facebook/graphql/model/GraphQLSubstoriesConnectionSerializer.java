package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPSELL */
public class GraphQLSubstoriesConnectionSerializer extends JsonSerializer<GraphQLSubstoriesConnection> {
    public final void m22006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSubstoriesConnection__JsonHelper.m22008a(jsonGenerator, (GraphQLSubstoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSubstoriesConnection.class, new GraphQLSubstoriesConnectionSerializer());
    }
}
