package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: failed_client_id */
public class GraphQLMegaphoneActionSerializer extends JsonSerializer<GraphQLMegaphoneAction> {
    public final void m9100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMegaphoneAction__JsonHelper.m9102a(jsonGenerator, (GraphQLMegaphoneAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMegaphoneAction.class, new GraphQLMegaphoneActionSerializer());
    }
}
