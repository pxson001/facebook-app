package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_omnistore_invalidation */
public class GraphQLLeadGenLegalContentSerializer extends JsonSerializer<GraphQLLeadGenLegalContent> {
    public final void m8880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenLegalContent__JsonHelper.m8882a(jsonGenerator, (GraphQLLeadGenLegalContent) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenLegalContent.class, new GraphQLLeadGenLegalContentSerializer());
    }
}
