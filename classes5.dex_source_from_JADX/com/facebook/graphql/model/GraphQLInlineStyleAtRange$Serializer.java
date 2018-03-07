package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInlineStyleAtRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: finch_more */
public final class GraphQLInlineStyleAtRange$Serializer extends JsonSerializer<GraphQLInlineStyleAtRange> {
    public final void m8700a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineStyleAtRange graphQLInlineStyleAtRange = (GraphQLInlineStyleAtRange) obj;
        GraphQLInlineStyleAtRangeDeserializer.m5252a(graphQLInlineStyleAtRange.w_(), graphQLInlineStyleAtRange.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineStyleAtRange.class, new GraphQLInlineStyleAtRange$Serializer());
        FbSerializerProvider.a(GraphQLInlineStyleAtRange.class, new GraphQLInlineStyleAtRange$Serializer());
    }
}
