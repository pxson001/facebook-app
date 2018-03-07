package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: extra_no_composer */
public class GraphQLNamePartSerializer extends JsonSerializer<GraphQLNamePart> {
    public final void m9154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNamePart__JsonHelper.a(jsonGenerator, (GraphQLNamePart) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNamePart.class, new GraphQLNamePartSerializer());
    }
}
