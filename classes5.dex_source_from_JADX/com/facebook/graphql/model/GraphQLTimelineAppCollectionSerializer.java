package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKNOWN */
public class GraphQLTimelineAppCollectionSerializer extends JsonSerializer<GraphQLTimelineAppCollection> {
    public final void m22159a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, (GraphQLTimelineAppCollection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollection.class, new GraphQLTimelineAppCollectionSerializer());
    }
}
