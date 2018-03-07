package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFindFriendsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: help_center_url */
public final class GraphQLFindFriendsFeedUnit$Serializer extends JsonSerializer<GraphQLFindFriendsFeedUnit> {
    public final void m7510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindFriendsFeedUnit graphQLFindFriendsFeedUnit = (GraphQLFindFriendsFeedUnit) obj;
        GraphQLFindFriendsFeedUnitDeserializer.m4912a(graphQLFindFriendsFeedUnit.w_(), graphQLFindFriendsFeedUnit.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLFindFriendsFeedUnit.class, new GraphQLFindFriendsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLFindFriendsFeedUnit.class, new GraphQLFindFriendsFeedUnit$Serializer());
    }
}
