package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: family_suggest */
public class GraphQLMediaSerializer extends JsonSerializer<GraphQLMedia> {
    public final void m9064a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMedia__JsonHelper.m9079a(jsonGenerator, (GraphQLMedia) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMedia.class, new GraphQLMediaSerializer());
    }
}
