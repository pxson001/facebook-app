package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: filtered_claim_count */
public final class GraphQLInstagramPhotosFromFriendsFeedUnit$Serializer extends JsonSerializer<GraphQLInstagramPhotosFromFriendsFeedUnit> {
    public final void m8706a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) obj;
        GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer.m5256a(graphQLInstagramPhotosFromFriendsFeedUnit.w_(), graphQLInstagramPhotosFromFriendsFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, new GraphQLInstagramPhotosFromFriendsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, new GraphQLInstagramPhotosFromFriendsFeedUnit$Serializer());
    }
}
