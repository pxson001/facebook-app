package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: landing_page_cta */
public class GraphQLAdditionalSuggestedPostAdItemsConnectionSerializer extends JsonSerializer<GraphQLAdditionalSuggestedPostAdItemsConnection> {
    public final void m6452a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdditionalSuggestedPostAdItemsConnection__JsonHelper.m6454a(jsonGenerator, (GraphQLAdditionalSuggestedPostAdItemsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsConnection.class, new GraphQLAdditionalSuggestedPostAdItemsConnectionSerializer());
    }
}
