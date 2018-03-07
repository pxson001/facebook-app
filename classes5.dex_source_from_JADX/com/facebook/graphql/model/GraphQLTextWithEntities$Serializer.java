package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTextWithEntitiesDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNLINK */
public final class GraphQLTextWithEntities$Serializer extends JsonSerializer<GraphQLTextWithEntities> {
    public final void m22107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) obj;
        GraphQLTextWithEntitiesDeserializer.m6060b(graphQLTextWithEntities.w_(), graphQLTextWithEntities.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTextWithEntities.class, new GraphQLTextWithEntities$Serializer());
        FbSerializerProvider.a(GraphQLTextWithEntities.class, new GraphQLTextWithEntities$Serializer());
    }
}
