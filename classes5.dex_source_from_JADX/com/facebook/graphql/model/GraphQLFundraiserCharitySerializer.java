package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: groups_mall_view */
public class GraphQLFundraiserCharitySerializer extends JsonSerializer<GraphQLFundraiserCharity> {
    public final void m7674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFundraiserCharity__JsonHelper.m7676a(jsonGenerator, (GraphQLFundraiserCharity) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFundraiserCharity.class, new GraphQLFundraiserCharitySerializer());
    }
}
