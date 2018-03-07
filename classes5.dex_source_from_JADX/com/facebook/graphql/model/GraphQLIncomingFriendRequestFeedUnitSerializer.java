package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: five_very_good */
public class GraphQLIncomingFriendRequestFeedUnitSerializer extends JsonSerializer<GraphQLIncomingFriendRequestFeedUnit> {
    public final void m8673a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit = (GraphQLIncomingFriendRequestFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLIncomingFriendRequestFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLIncomingFriendRequestFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8648g() != null) {
            jsonGenerator.a("cache_id", graphQLIncomingFriendRequestFeedUnit.m8648g());
        }
        if (graphQLIncomingFriendRequestFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLIncomingFriendRequestFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLIncomingFriendRequestFeedUnit.T_());
        if (graphQLIncomingFriendRequestFeedUnit.m8651l() != null) {
            jsonGenerator.a("id", graphQLIncomingFriendRequestFeedUnit.m8651l());
        }
        jsonGenerator.a("requests");
        if (graphQLIncomingFriendRequestFeedUnit.m8653o() != null) {
            jsonGenerator.d();
            for (GraphQLIncomingFriendRequestFeedUnitItem graphQLIncomingFriendRequestFeedUnitItem : graphQLIncomingFriendRequestFeedUnit.m8653o()) {
                if (graphQLIncomingFriendRequestFeedUnitItem != null) {
                    GraphQLIncomingFriendRequestFeedUnitItem__JsonHelper.m8671a(jsonGenerator, graphQLIncomingFriendRequestFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8654p() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLIncomingFriendRequestFeedUnit.m8654p());
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8655q() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLIncomingFriendRequestFeedUnit.m8655q(), true);
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8656r() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLIncomingFriendRequestFeedUnit.m8656r(), true);
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8650k() != null) {
            jsonGenerator.a("tracking", graphQLIncomingFriendRequestFeedUnit.m8650k());
        }
        if (graphQLIncomingFriendRequestFeedUnit.m8657s() != null) {
            jsonGenerator.a("url", graphQLIncomingFriendRequestFeedUnit.m8657s());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnit.class, new GraphQLIncomingFriendRequestFeedUnitSerializer());
    }
}
