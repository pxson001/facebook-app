package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_ask_friends_enabled */
public final class GraphQLCommentPlaceInfoToPlaceListItemsConnection$Serializer extends JsonSerializer<GraphQLCommentPlaceInfoToPlaceListItemsConnection> {
    public final void m6807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCommentPlaceInfoToPlaceListItemsConnection graphQLCommentPlaceInfoToPlaceListItemsConnection = (GraphQLCommentPlaceInfoToPlaceListItemsConnection) obj;
        GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4664a(graphQLCommentPlaceInfoToPlaceListItemsConnection.w_(), graphQLCommentPlaceInfoToPlaceListItemsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class, new GraphQLCommentPlaceInfoToPlaceListItemsConnection$Serializer());
        FbSerializerProvider.a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class, new GraphQLCommentPlaceInfoToPlaceListItemsConnection$Serializer());
    }
}
