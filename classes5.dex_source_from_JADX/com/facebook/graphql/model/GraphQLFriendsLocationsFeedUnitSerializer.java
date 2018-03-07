package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_commercial */
public class GraphQLFriendsLocationsFeedUnitSerializer extends JsonSerializer<GraphQLFriendsLocationsFeedUnit> {
    public final void m7636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFriendsLocationsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLFriendsLocationsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLFriendsLocationsFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLFriendsLocationsFeedUnit.g());
        }
        jsonGenerator.a("creation_time", graphQLFriendsLocationsFeedUnit.l());
        if (graphQLFriendsLocationsFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLFriendsLocationsFeedUnit.S_());
        }
        if (graphQLFriendsLocationsFeedUnit.o() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendsLocationsFeedUnit.o(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLFriendsLocationsFeedUnit.T_());
        if (graphQLFriendsLocationsFeedUnit.p() != null) {
            jsonGenerator.a("footer");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendsLocationsFeedUnit.p(), true);
        }
        jsonGenerator.a("friendsLocationsItems");
        if (graphQLFriendsLocationsFeedUnit.q() != null) {
            jsonGenerator.d();
            for (GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem : graphQLFriendsLocationsFeedUnit.q()) {
                if (graphQLFriendLocationFeedUnitItem != null) {
                    GraphQLFriendLocationFeedUnitItem__JsonHelper.m7581a(jsonGenerator, graphQLFriendLocationFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("items");
        if (graphQLFriendsLocationsFeedUnit.r() != null) {
            jsonGenerator.d();
            for (GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem2 : graphQLFriendsLocationsFeedUnit.r()) {
                if (graphQLFriendLocationFeedUnitItem2 != null) {
                    GraphQLFriendLocationFeedUnitItem__JsonHelper.m7581a(jsonGenerator, graphQLFriendLocationFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendsLocationsFeedUnit.s() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLFriendsLocationsFeedUnit.s());
        }
        if (graphQLFriendsLocationsFeedUnit.t() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendsLocationsFeedUnit.t(), true);
        }
        if (graphQLFriendsLocationsFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLFriendsLocationsFeedUnit.k());
        }
        if (graphQLFriendsLocationsFeedUnit.u() != null) {
            jsonGenerator.a("feed_type", graphQLFriendsLocationsFeedUnit.u().toString());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsLocationsFeedUnit.class, new GraphQLFriendsLocationsFeedUnitSerializer());
    }
}
