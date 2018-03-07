package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendversaryStoryDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: getWifiScanTime */
public class GraphQLGoodwillThrowbackFriendversaryStory$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendversaryStory.class, new GraphQLGoodwillThrowbackFriendversaryStory$Deserializer());
    }

    public Object m8030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGoodwillThrowbackFriendversaryStoryDeserializer.m5045a(jsonParser, (short) 398);
        Object graphQLGoodwillThrowbackFriendversaryStory = new GraphQLGoodwillThrowbackFriendversaryStory();
        ((BaseModel) graphQLGoodwillThrowbackFriendversaryStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGoodwillThrowbackFriendversaryStory instanceof Postprocessable) {
            return ((Postprocessable) graphQLGoodwillThrowbackFriendversaryStory).a();
        }
        return graphQLGoodwillThrowbackFriendversaryStory;
    }
}
