package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityIconDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSET_OR_UNRECOGNIZED_ENUM_VALUE */
public final class GraphQLTaggableActivityIcon$Serializer extends JsonSerializer<GraphQLTaggableActivityIcon> {
    public final void m22051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityIcon graphQLTaggableActivityIcon = (GraphQLTaggableActivityIcon) obj;
        GraphQLTaggableActivityIconDeserializer.m6040b(graphQLTaggableActivityIcon.w_(), graphQLTaggableActivityIcon.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityIcon.class, new GraphQLTaggableActivityIcon$Serializer());
        FbSerializerProvider.a(GraphQLTaggableActivityIcon.class, new GraphQLTaggableActivityIcon$Serializer());
    }
}
