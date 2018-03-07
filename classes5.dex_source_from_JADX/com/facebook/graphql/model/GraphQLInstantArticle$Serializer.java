package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInstantArticleDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fieldAssignmentFormatter */
public final class GraphQLInstantArticle$Serializer extends JsonSerializer<GraphQLInstantArticle> {
    public final void m8723a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstantArticle graphQLInstantArticle = (GraphQLInstantArticle) obj;
        GraphQLInstantArticleDeserializer.m5264a(graphQLInstantArticle.w_(), graphQLInstantArticle.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInstantArticle.class, new GraphQLInstantArticle$Serializer());
        FbSerializerProvider.a(GraphQLInstantArticle.class, new GraphQLInstantArticle$Serializer());
    }
}
