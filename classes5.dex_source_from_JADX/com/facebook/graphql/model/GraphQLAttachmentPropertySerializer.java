package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_seen */
public class GraphQLAttachmentPropertySerializer extends JsonSerializer<GraphQLAttachmentProperty> {
    public final void m6608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAttachmentProperty__JsonHelper.m6610a(jsonGenerator, (GraphQLAttachmentProperty) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAttachmentProperty.class, new GraphQLAttachmentPropertySerializer());
    }
}
