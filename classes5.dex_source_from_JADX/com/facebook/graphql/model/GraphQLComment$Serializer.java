package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCommentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_away_toggle_on */
public final class GraphQLComment$Serializer extends JsonSerializer<GraphQLComment> {
    public final void m6803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLComment graphQLComment = (GraphQLComment) obj;
        GraphQLCommentDeserializer.m4661b(graphQLComment.w_(), graphQLComment.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLComment.class, new GraphQLComment$Serializer());
        FbSerializerProvider.a(GraphQLComment.class, new GraphQLComment$Serializer());
    }
}
