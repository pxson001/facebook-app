package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_expired */
public class GraphQLBylineFragmentSerializer extends JsonSerializer<GraphQLBylineFragment> {
    public final void m6710a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBylineFragment__JsonHelper.m6712a(jsonGenerator, (GraphQLBylineFragment) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLBylineFragment.class, new GraphQLBylineFragmentSerializer());
    }
}
