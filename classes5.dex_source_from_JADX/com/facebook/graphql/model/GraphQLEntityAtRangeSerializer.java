package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intern_match_manager */
public class GraphQLEntityAtRangeSerializer extends JsonSerializer<GraphQLEntityAtRange> {
    public final void m7043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityAtRange__JsonHelper.m7045a(jsonGenerator, (GraphQLEntityAtRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityAtRange.class, new GraphQLEntityAtRangeSerializer());
    }
}
