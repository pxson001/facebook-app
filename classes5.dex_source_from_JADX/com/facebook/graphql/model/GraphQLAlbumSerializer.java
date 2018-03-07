package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: job_connect_search */
public class GraphQLAlbumSerializer extends JsonSerializer<GraphQLAlbum> {
    public final void m6509a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAlbum__JsonHelper.m6511a(jsonGenerator, (GraphQLAlbum) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAlbum.class, new GraphQLAlbumSerializer());
    }
}
