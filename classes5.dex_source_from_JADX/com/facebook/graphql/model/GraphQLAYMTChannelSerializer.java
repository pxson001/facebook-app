package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: layout_x */
public class GraphQLAYMTChannelSerializer extends JsonSerializer<GraphQLAYMTChannel> {
    public final void m6352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAYMTChannel__JsonHelper.m6354a(jsonGenerator, (GraphQLAYMTChannel) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAYMTChannel.class, new GraphQLAYMTChannelSerializer());
    }
}
