package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isCompulsory */
public class GraphQLContactSerializer extends JsonSerializer<GraphQLContact> {
    public final void m6883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLContact__JsonHelper.m6885a(jsonGenerator, (GraphQLContact) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLContact.class, new GraphQLContactSerializer());
    }
}
