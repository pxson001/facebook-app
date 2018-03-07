package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WITHIN_A_DAY */
public class GraphQLPhoneNumberSerializer extends JsonSerializer<GraphQLPhoneNumber> {
    public final void m20712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhoneNumber__JsonHelper.m20714a(jsonGenerator, (GraphQLPhoneNumber) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhoneNumber.class, new GraphQLPhoneNumberSerializer());
    }
}
