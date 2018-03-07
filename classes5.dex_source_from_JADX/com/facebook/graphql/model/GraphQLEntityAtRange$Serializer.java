package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEntityAtRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intern_match_manager_suggest_match */
public final class GraphQLEntityAtRange$Serializer extends JsonSerializer<GraphQLEntityAtRange> {
    public final void m7041a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) obj;
        GraphQLEntityAtRangeDeserializer.m4749b(graphQLEntityAtRange.w_(), graphQLEntityAtRange.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityAtRange.class, new GraphQLEntityAtRange$Serializer());
        FbSerializerProvider.a(GraphQLEntityAtRange.class, new GraphQLEntityAtRange$Serializer());
    }
}
