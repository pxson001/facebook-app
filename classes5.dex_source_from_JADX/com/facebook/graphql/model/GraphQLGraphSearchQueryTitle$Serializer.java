package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryTitleDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: game_about */
public final class GraphQLGraphSearchQueryTitle$Serializer extends JsonSerializer<GraphQLGraphSearchQueryTitle> {
    public final void m8260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle = (GraphQLGraphSearchQueryTitle) obj;
        GraphQLGraphSearchQueryTitleDeserializer.m5105a(graphQLGraphSearchQueryTitle.w_(), graphQLGraphSearchQueryTitle.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryTitle.class, new GraphQLGraphSearchQueryTitle$Serializer());
        FbSerializerProvider.a(GraphQLGraphSearchQueryTitle.class, new GraphQLGraphSearchQueryTitle$Serializer());
    }
}
