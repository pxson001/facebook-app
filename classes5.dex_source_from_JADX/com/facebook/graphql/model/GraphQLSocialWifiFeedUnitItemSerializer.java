package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UserCancel */
public class GraphQLSocialWifiFeedUnitItemSerializer extends JsonSerializer<GraphQLSocialWifiFeedUnitItem> {
    public final void m21683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSocialWifiFeedUnitItem__JsonHelper.m21685a(jsonGenerator, (GraphQLSocialWifiFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSocialWifiFeedUnitItem.class, new GraphQLSocialWifiFeedUnitItemSerializer());
    }
}
