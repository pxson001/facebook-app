package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLProfileBadgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOIP */
public final class GraphQLProfileBadge$Serializer extends JsonSerializer<GraphQLProfileBadge> {
    public final void m21099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfileBadge graphQLProfileBadge = (GraphQLProfileBadge) obj;
        GraphQLProfileBadgeDeserializer.m5716a(graphQLProfileBadge.w_(), graphQLProfileBadge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLProfileBadge.class, new GraphQLProfileBadge$Serializer());
        FbSerializerProvider.a(GraphQLProfileBadge.class, new GraphQLProfileBadge$Serializer());
    }
}
