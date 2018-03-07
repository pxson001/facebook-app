package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoChainingFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimeRange */
public final class GraphQLVideoChainingFeedUnit$Serializer extends JsonSerializer<GraphQLVideoChainingFeedUnit> {
    public final void m22432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoChainingFeedUnit graphQLVideoChainingFeedUnit = (GraphQLVideoChainingFeedUnit) obj;
        GraphQLVideoChainingFeedUnitDeserializer.m6175a(graphQLVideoChainingFeedUnit.w_(), graphQLVideoChainingFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoChainingFeedUnit.class, new GraphQLVideoChainingFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLVideoChainingFeedUnit.class, new GraphQLVideoChainingFeedUnit$Serializer());
    }
}
