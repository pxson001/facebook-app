package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStorySetDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UTF-8 */
public final class GraphQLStorySet$Serializer extends JsonSerializer<GraphQLStorySet> {
    public final void m21891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySet graphQLStorySet = (GraphQLStorySet) obj;
        GraphQLStorySetDeserializer.m5981a(graphQLStorySet.w_(), graphQLStorySet.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySet.class, new GraphQLStorySet$Serializer());
        FbSerializerProvider.a(GraphQLStorySet.class, new GraphQLStorySet$Serializer());
    }
}
