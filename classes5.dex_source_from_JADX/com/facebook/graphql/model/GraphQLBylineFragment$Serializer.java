package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLBylineFragmentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_explicit_location */
public final class GraphQLBylineFragment$Serializer extends JsonSerializer<GraphQLBylineFragment> {
    public final void m6708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBylineFragment graphQLBylineFragment = (GraphQLBylineFragment) obj;
        GraphQLBylineFragmentDeserializer.m4636b(graphQLBylineFragment.w_(), graphQLBylineFragment.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLBylineFragment.class, new GraphQLBylineFragment$Serializer());
        FbSerializerProvider.a(GraphQLBylineFragment.class, new GraphQLBylineFragment$Serializer());
    }
}
