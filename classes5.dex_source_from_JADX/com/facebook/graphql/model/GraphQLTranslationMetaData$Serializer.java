package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTranslationMetaDataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TrueTopicFeedOptionsEdge */
public final class GraphQLTranslationMetaData$Serializer extends JsonSerializer<GraphQLTranslationMetaData> {
    public final void m22281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTranslationMetaData graphQLTranslationMetaData = (GraphQLTranslationMetaData) obj;
        GraphQLTranslationMetaDataDeserializer.m6123a(graphQLTranslationMetaData.w_(), graphQLTranslationMetaData.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLTranslationMetaData.class, new GraphQLTranslationMetaData$Serializer());
        FbSerializerProvider.a(GraphQLTranslationMetaData.class, new GraphQLTranslationMetaData$Serializer());
    }
}
