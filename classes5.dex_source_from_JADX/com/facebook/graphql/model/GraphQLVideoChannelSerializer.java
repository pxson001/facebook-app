package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ThrottlingProducer */
public class GraphQLVideoChannelSerializer extends JsonSerializer<GraphQLVideoChannel> {
    public final void m22445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoChannel__JsonHelper.m22447a(jsonGenerator, (GraphQLVideoChannel) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoChannel.class, new GraphQLVideoChannelSerializer());
    }
}
