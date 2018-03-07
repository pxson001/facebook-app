package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_promotion_title */
public class GraphQLLeadGenInfoFieldDataSerializer extends JsonSerializer<GraphQLLeadGenInfoFieldData> {
    public final void m8851a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenInfoFieldData__JsonHelper.m8853a(jsonGenerator, (GraphQLLeadGenInfoFieldData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenInfoFieldData.class, new GraphQLLeadGenInfoFieldDataSerializer());
    }
}
