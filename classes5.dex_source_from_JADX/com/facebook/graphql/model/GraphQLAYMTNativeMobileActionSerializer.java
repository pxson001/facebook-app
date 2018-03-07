package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: layout_height */
public class GraphQLAYMTNativeMobileActionSerializer extends JsonSerializer<GraphQLAYMTNativeMobileAction> {
    public final void m6364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAYMTNativeMobileAction__JsonHelper.m6366a(jsonGenerator, (GraphQLAYMTNativeMobileAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAYMTNativeMobileAction.class, new GraphQLAYMTNativeMobileActionSerializer());
    }
}
