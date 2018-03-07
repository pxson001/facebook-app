package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFriendsLocationsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_comprehensive_title */
public final class GraphQLFriendsLocationsFeedUnit$Serializer extends JsonSerializer<GraphQLFriendsLocationsFeedUnit> {
    public final void m7634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) obj;
        GraphQLFriendsLocationsFeedUnitDeserializer.m4958a(graphQLFriendsLocationsFeedUnit.w_(), graphQLFriendsLocationsFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsLocationsFeedUnit.class, new GraphQLFriendsLocationsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLFriendsLocationsFeedUnit.class, new GraphQLFriendsLocationsFeedUnit$Serializer());
    }
}
