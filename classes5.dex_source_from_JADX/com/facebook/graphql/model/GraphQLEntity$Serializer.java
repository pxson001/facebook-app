package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEntityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intern_match_manager_suggest_phone */
public final class GraphQLEntity$Serializer extends JsonSerializer<GraphQLEntity> {
    public final void m7038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntity graphQLEntity = (GraphQLEntity) obj;
        GraphQLEntityDeserializer.m4766b(graphQLEntity.w_(), graphQLEntity.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEntity.class, new GraphQLEntity$Serializer());
        FbSerializerProvider.a(GraphQLEntity.class, new GraphQLEntity$Serializer());
    }
}
