package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: field_key */
public class GraphQLInstagramPhotosFromFriendsFeedUnitSerializer extends JsonSerializer<GraphQLInstagramPhotosFromFriendsFeedUnit> {
    public final void m8721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = (GraphQLInstagramPhotosFromFriendsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLInstagramPhotosFromFriendsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLInstagramPhotosFromFriendsFeedUnit.g());
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLInstagramPhotosFromFriendsFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLInstagramPhotosFromFriendsFeedUnit.T_());
        jsonGenerator.a("igPffItems");
        if (graphQLInstagramPhotosFromFriendsFeedUnit.o() != null) {
            jsonGenerator.d();
            for (GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem : graphQLInstagramPhotosFromFriendsFeedUnit.o()) {
                if (graphQLInstagramPhotosFromFriendsFeedUnitItem != null) {
                    GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8719a(jsonGenerator, graphQLInstagramPhotosFromFriendsFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("items");
        if (graphQLInstagramPhotosFromFriendsFeedUnit.p() != null) {
            jsonGenerator.d();
            for (GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem2 : graphQLInstagramPhotosFromFriendsFeedUnit.p()) {
                if (graphQLInstagramPhotosFromFriendsFeedUnitItem2 != null) {
                    GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8719a(jsonGenerator, graphQLInstagramPhotosFromFriendsFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLInstagramPhotosFromFriendsFeedUnit.q());
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLInstagramPhotosFromFriendsFeedUnit.r(), true);
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLInstagramPhotosFromFriendsFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, new GraphQLInstagramPhotosFromFriendsFeedUnitSerializer());
    }
}
