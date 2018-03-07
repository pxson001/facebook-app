package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageNatural */
public class GraphQLEventWatchersConnectionSerializer extends JsonSerializer<GraphQLEventWatchersConnection> {
    public final void m7331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventWatchersConnection__JsonHelper.m7333a(jsonGenerator, (GraphQLEventWatchersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventWatchersConnection.class, new GraphQLEventWatchersConnectionSerializer());
    }
}
