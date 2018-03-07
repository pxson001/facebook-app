package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSUBSCRIBED */
public final class GraphQLTaggableActivity$Serializer extends JsonSerializer<GraphQLTaggableActivity> {
    public final void m22040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivity graphQLTaggableActivity = (GraphQLTaggableActivity) obj;
        GraphQLTaggableActivityDeserializer.m6035b(graphQLTaggableActivity.w_(), graphQLTaggableActivity.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivity.class, new GraphQLTaggableActivity$Serializer());
        FbSerializerProvider.a(GraphQLTaggableActivity.class, new GraphQLTaggableActivity$Serializer());
    }
}
