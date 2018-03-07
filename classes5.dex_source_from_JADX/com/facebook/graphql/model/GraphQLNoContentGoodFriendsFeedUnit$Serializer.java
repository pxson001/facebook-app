package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNoContentGoodFriendsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_ticket_order_id */
public final class GraphQLNoContentGoodFriendsFeedUnit$Serializer extends JsonSerializer<GraphQLNoContentGoodFriendsFeedUnit> {
    public final void m9279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNoContentGoodFriendsFeedUnit graphQLNoContentGoodFriendsFeedUnit = (GraphQLNoContentGoodFriendsFeedUnit) obj;
        GraphQLNoContentGoodFriendsFeedUnitDeserializer.m5435a(graphQLNoContentGoodFriendsFeedUnit.w_(), graphQLNoContentGoodFriendsFeedUnit.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLNoContentGoodFriendsFeedUnit.class, new GraphQLNoContentGoodFriendsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLNoContentGoodFriendsFeedUnit.class, new GraphQLNoContentGoodFriendsFeedUnit$Serializer());
    }
}
