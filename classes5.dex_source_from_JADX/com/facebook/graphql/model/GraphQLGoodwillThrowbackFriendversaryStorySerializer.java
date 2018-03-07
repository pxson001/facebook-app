package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getWifiRunningTime */
public class GraphQLGoodwillThrowbackFriendversaryStorySerializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendversaryStory> {
    public final void m8033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackFriendversaryStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackFriendversaryStory.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGoodwillThrowbackFriendversaryStory.k() != null) {
            jsonGenerator.a("accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryStory.k(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillThrowbackFriendversaryStory.T_());
        if (graphQLGoodwillThrowbackFriendversaryStory.l() != null) {
            jsonGenerator.a("friend_list");
            GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8002a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryStory.l(), true);
        }
        if (graphQLGoodwillThrowbackFriendversaryStory.m() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryStory.m(), true);
        }
        if (graphQLGoodwillThrowbackFriendversaryStory.n() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillThrowbackFriendversaryStory.n());
        }
        if (graphQLGoodwillThrowbackFriendversaryStory.o() != null) {
            jsonGenerator.a("section_header");
            GraphQLGoodwillThrowbackSection__JsonHelper.m8117a(jsonGenerator, graphQLGoodwillThrowbackFriendversaryStory.o(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryStory.class, new GraphQLGoodwillThrowbackFriendversaryStorySerializer());
    }
}
