package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendversaryStoryDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getWifiScanTime */
public final class GraphQLGoodwillThrowbackFriendversaryStory$Serializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendversaryStory> {
    public final void m8031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) obj;
        GraphQLGoodwillThrowbackFriendversaryStoryDeserializer.m5046a(graphQLGoodwillThrowbackFriendversaryStory.w_(), graphQLGoodwillThrowbackFriendversaryStory.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryStory.class, new GraphQLGoodwillThrowbackFriendversaryStory$Serializer());
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryStory.class, new GraphQLGoodwillThrowbackFriendversaryStory$Serializer());
    }
}
