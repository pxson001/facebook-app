package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unpaired surrogate at index  */
public class GraphQLSponsoredDataSerializer extends JsonSerializer<GraphQLSponsoredData> {
    public final void m21755a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, (GraphQLSponsoredData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSponsoredData.class, new GraphQLSponsoredDataSerializer());
    }
}
