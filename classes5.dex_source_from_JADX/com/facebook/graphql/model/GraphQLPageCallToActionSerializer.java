package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: engaged_user_count */
public class GraphQLPageCallToActionSerializer extends JsonSerializer<GraphQLPageCallToAction> {
    public final void m9483a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageCallToAction__JsonHelper.m9485a(jsonGenerator, (GraphQLPageCallToAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageCallToAction.class, new GraphQLPageCallToActionSerializer());
    }
}
