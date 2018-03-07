package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: last_error_details */
public class GraphQLAdAccountSerializer extends JsonSerializer<GraphQLAdAccount> {
    public final void m6426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdAccount__JsonHelper.m6428a(jsonGenerator, (GraphQLAdAccount) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAdAccount.class, new GraphQLAdAccountSerializer());
    }
}
