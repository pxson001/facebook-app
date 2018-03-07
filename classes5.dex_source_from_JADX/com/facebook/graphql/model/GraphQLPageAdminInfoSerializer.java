package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entity_card_subtitle */
public class GraphQLPageAdminInfoSerializer extends JsonSerializer<GraphQLPageAdminInfo> {
    public final void m9466a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageAdminInfo__JsonHelper.m9468a(jsonGenerator, (GraphQLPageAdminInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageAdminInfo.class, new GraphQLPageAdminInfoSerializer());
    }
}
