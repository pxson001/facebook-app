package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: field_type */
public final class GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper {
    public static GraphQLInstagramPhotosFromFriendsFeedUnitItem m8718a(JsonParser jsonParser) {
        GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem = new GraphQLInstagramPhotosFromFriendsFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8720a(graphQLInstagramPhotosFromFriendsFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLInstagramPhotosFromFriendsFeedUnitItem;
    }

    private static boolean m8720a(GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("photos".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPhoto a = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "photos"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLInstagramPhotosFromFriendsFeedUnitItem.f4312d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnitItem, "photos", graphQLInstagramPhotosFromFriendsFeedUnitItem.a_, 0, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLProfile a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLInstagramPhotosFromFriendsFeedUnitItem.f4313e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnitItem, "profile", graphQLInstagramPhotosFromFriendsFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLInstagramPhotosFromFriendsFeedUnitItem.f4314f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnitItem, "tracking", graphQLInstagramPhotosFromFriendsFeedUnitItem.B_(), 2, false);
            return true;
        } else if (!"num_friends_on_instagram".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLInstagramPhotosFromFriendsFeedUnitItem.f4315g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnitItem, "num_friends_on_instagram", graphQLInstagramPhotosFromFriendsFeedUnitItem.B_(), 3, false);
            return true;
        }
    }

    public static void m8719a(JsonGenerator jsonGenerator, GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("photos");
        if (graphQLInstagramPhotosFromFriendsFeedUnitItem.m8712a() != null) {
            jsonGenerator.d();
            for (GraphQLPhoto graphQLPhoto : graphQLInstagramPhotosFromFriendsFeedUnitItem.m8712a()) {
                if (graphQLPhoto != null) {
                    GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLPhoto, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnitItem.m8713j() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLInstagramPhotosFromFriendsFeedUnitItem.m8713j(), true);
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnitItem.m8714k() != null) {
            jsonGenerator.a("tracking", graphQLInstagramPhotosFromFriendsFeedUnitItem.m8714k());
        }
        if (graphQLInstagramPhotosFromFriendsFeedUnitItem.m8715l() != null) {
            jsonGenerator.a("num_friends_on_instagram", graphQLInstagramPhotosFromFriendsFeedUnitItem.m8715l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
