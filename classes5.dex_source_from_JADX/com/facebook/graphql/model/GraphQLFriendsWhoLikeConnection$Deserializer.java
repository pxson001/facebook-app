package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFriendsWhoLikeConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: has_ad_conversion_pixel_domain */
public class GraphQLFriendsWhoLikeConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoLikeConnection.class, new GraphQLFriendsWhoLikeConnection$Deserializer());
    }

    public Object m7637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFriendsWhoLikeConnectionDeserializer.m4960a(jsonParser, (short) 424);
        Object graphQLFriendsWhoLikeConnection = new GraphQLFriendsWhoLikeConnection();
        ((BaseModel) graphQLFriendsWhoLikeConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFriendsWhoLikeConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFriendsWhoLikeConnection).a();
        }
        return graphQLFriendsWhoLikeConnection;
    }
}
