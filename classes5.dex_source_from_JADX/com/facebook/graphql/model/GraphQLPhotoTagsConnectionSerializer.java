package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WILDE_GROUPS_TAB */
public class GraphQLPhotoTagsConnectionSerializer extends JsonSerializer<GraphQLPhotoTagsConnection> {
    public final void m20750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoTagsConnection__JsonHelper.m20752a(jsonGenerator, (GraphQLPhotoTagsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoTagsConnection.class, new GraphQLPhotoTagsConnectionSerializer());
    }
}
