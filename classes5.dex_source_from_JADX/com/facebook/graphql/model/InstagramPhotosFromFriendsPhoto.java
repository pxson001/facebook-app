package com.facebook.graphql.model;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TWITTER_IMPORTER */
public class InstagramPhotosFromFriendsPhoto {
    public final GraphQLPhoto f13473a;
    private final String f13474b;
    private final String f13475c;

    public InstagramPhotosFromFriendsPhoto(GraphQLPhoto graphQLPhoto, String str, String str2) {
        this.f13473a = graphQLPhoto;
        this.f13474b = str;
        this.f13475c = str2;
    }

    public final ArrayNode m22552a() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        if (this.f13474b != null) {
            arrayNode.h(this.f13474b);
        }
        if (this.f13475c != null) {
            arrayNode.h(this.f13475c);
        }
        return arrayNode;
    }
}
