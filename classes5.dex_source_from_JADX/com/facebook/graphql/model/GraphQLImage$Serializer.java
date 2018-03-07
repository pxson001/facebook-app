package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLImageDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: follow_up_action_url */
public final class GraphQLImage$Serializer extends JsonSerializer<GraphQLImage> {
    public final void m8616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImage graphQLImage = (GraphQLImage) obj;
        GraphQLImageDeserializer.a(graphQLImage.w_(), graphQLImage.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLImage.class, new GraphQLImage$Serializer());
        FbSerializerProvider.a(GraphQLImage.class, new GraphQLImage$Serializer());
    }
}
