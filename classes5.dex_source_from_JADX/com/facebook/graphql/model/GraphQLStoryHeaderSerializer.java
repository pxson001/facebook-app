package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to create thumbnails. */
public class GraphQLStoryHeaderSerializer extends JsonSerializer<GraphQLStoryHeader> {
    public final void m21874a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryHeader__JsonHelper.a(jsonGenerator, (GraphQLStoryHeader) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryHeader.class, new GraphQLStoryHeaderSerializer());
    }
}
