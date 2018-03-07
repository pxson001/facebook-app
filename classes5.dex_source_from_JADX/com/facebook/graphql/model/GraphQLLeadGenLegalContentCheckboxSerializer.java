package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_promotion_call_to_action */
public class GraphQLLeadGenLegalContentCheckboxSerializer extends JsonSerializer<GraphQLLeadGenLegalContentCheckbox> {
    public final void m8875a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenLegalContentCheckbox__JsonHelper.m8877a(jsonGenerator, (GraphQLLeadGenLegalContentCheckbox) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenLegalContentCheckbox.class, new GraphQLLeadGenLegalContentCheckboxSerializer());
    }
}
