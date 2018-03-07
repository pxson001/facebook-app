package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_purpose */
public class GraphQLFundraiserPageSerializer extends JsonSerializer<GraphQLFundraiserPage> {
    public final void m7681a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserPage__JsonHelper.m7683a(jsonGenerator, (GraphQLFundraiserPage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserPage.class, new GraphQLFundraiserPageSerializer());
    }
}
