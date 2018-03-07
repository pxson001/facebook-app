package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInlineActivityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fire_review_after_snap */
public final class GraphQLInlineActivity$Serializer extends JsonSerializer<GraphQLInlineActivity> {
    public final void m8693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineActivity graphQLInlineActivity = (GraphQLInlineActivity) obj;
        GraphQLInlineActivityDeserializer.m5249b(graphQLInlineActivity.w_(), graphQLInlineActivity.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineActivity.class, new GraphQLInlineActivity$Serializer());
        FbSerializerProvider.a(GraphQLInlineActivity.class, new GraphQLInlineActivity$Serializer());
    }
}
