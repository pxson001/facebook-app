package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimelineSectionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNDO_BUTTON */
public final class GraphQLTimelineSectionsConnection$Serializer extends JsonSerializer<GraphQLTimelineSectionsConnection> {
    public final void m22220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection = (GraphQLTimelineSectionsConnection) obj;
        GraphQLTimelineSectionsConnectionDeserializer.m6094a(graphQLTimelineSectionsConnection.w_(), graphQLTimelineSectionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineSectionsConnection.class, new GraphQLTimelineSectionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLTimelineSectionsConnection.class, new GraphQLTimelineSectionsConnection$Serializer());
    }
}
