package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInstantArticleVersionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ffa */
public final class GraphQLInstantArticleVersion$Serializer extends JsonSerializer<GraphQLInstantArticleVersion> {
    public final void m8727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstantArticleVersion graphQLInstantArticleVersion = (GraphQLInstantArticleVersion) obj;
        GraphQLInstantArticleVersionDeserializer.m5267a(graphQLInstantArticleVersion.w_(), graphQLInstantArticleVersion.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInstantArticleVersion.class, new GraphQLInstantArticleVersion$Serializer());
        FbSerializerProvider.a(GraphQLInstantArticleVersion.class, new GraphQLInstantArticleVersion$Serializer());
    }
}
