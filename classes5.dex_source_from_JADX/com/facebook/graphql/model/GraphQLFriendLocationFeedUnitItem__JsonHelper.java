package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFriendLocationCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: has_viewer_watched_video */
public final class GraphQLFriendLocationFeedUnitItem__JsonHelper {
    public static GraphQLFriendLocationFeedUnitItem m7580a(JsonParser jsonParser) {
        GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem = new GraphQLFriendLocationFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7582a(graphQLFriendLocationFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendLocationFeedUnitItem;
    }

    private static boolean m7582a(GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("approximate_location".equals(str)) {
            GraphQLLocation a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "approximate_location"));
            }
            graphQLFriendLocationFeedUnitItem.f3779d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "approximate_location", graphQLFriendLocationFeedUnitItem.a_, 0, true);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFriendLocationFeedUnitItem.f3780e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "hideable_token", graphQLFriendLocationFeedUnitItem.B_(), 1, false);
            return true;
        } else if ("location_category".equals(str)) {
            graphQLFriendLocationFeedUnitItem.f3781f = GraphQLFriendLocationCategory.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "location_category", graphQLFriendLocationFeedUnitItem.B_(), 2, false);
            return true;
        } else if ("location_context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "location_context"));
            }
            graphQLFriendLocationFeedUnitItem.f3782g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "location_context", graphQLFriendLocationFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLUser a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLFriendLocationFeedUnitItem.f3783h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "profile", graphQLFriendLocationFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("radius".equals(str)) {
            graphQLFriendLocationFeedUnitItem.f3784i = jsonParser.g() == JsonToken.VALUE_NULL ? 0.0d : jsonParser.G();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "radius", graphQLFriendLocationFeedUnitItem.B_(), 5, false);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFriendLocationFeedUnitItem.f3785j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "tracking", graphQLFriendLocationFeedUnitItem.B_(), 6, false);
            return true;
        } else if ("story_identifier".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLFriendLocationFeedUnitItem.f3786k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "story_identifier", graphQLFriendLocationFeedUnitItem.B_(), 7, false);
            return true;
        } else if ("friends_clusters".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFriendsLocationsCluster a3 = GraphQLFriendsLocationsCluster__JsonHelper.m7630a(FieldAccessQueryTracker.a(jsonParser, "friends_clusters"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLFriendLocationFeedUnitItem.f3787l = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "friends_clusters", graphQLFriendLocationFeedUnitItem.B_(), 8, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLFriendLocationFeedUnitItem.f3788m = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendLocationFeedUnitItem, "title", graphQLFriendLocationFeedUnitItem.B_(), 9, true);
            return true;
        }
    }

    public static void m7581a(JsonGenerator jsonGenerator, GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFriendLocationFeedUnitItem.m7568j() != null) {
            jsonGenerator.a("approximate_location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLFriendLocationFeedUnitItem.m7568j(), true);
        }
        if (graphQLFriendLocationFeedUnitItem.m7570l() != null) {
            jsonGenerator.a("hideable_token", graphQLFriendLocationFeedUnitItem.m7570l());
        }
        if (graphQLFriendLocationFeedUnitItem.m7571m() != null) {
            jsonGenerator.a("location_category", graphQLFriendLocationFeedUnitItem.m7571m().toString());
        }
        if (graphQLFriendLocationFeedUnitItem.m7572n() != null) {
            jsonGenerator.a("location_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendLocationFeedUnitItem.m7572n(), true);
        }
        if (graphQLFriendLocationFeedUnitItem.m7573o() != null) {
            jsonGenerator.a("profile");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLFriendLocationFeedUnitItem.m7573o(), true);
        }
        jsonGenerator.a("radius", graphQLFriendLocationFeedUnitItem.m7574p());
        if (graphQLFriendLocationFeedUnitItem.m7569k() != null) {
            jsonGenerator.a("tracking", graphQLFriendLocationFeedUnitItem.m7569k());
        }
        if (graphQLFriendLocationFeedUnitItem.m7575q() != null) {
            jsonGenerator.a("story_identifier", graphQLFriendLocationFeedUnitItem.m7575q());
        }
        jsonGenerator.a("friends_clusters");
        if (graphQLFriendLocationFeedUnitItem.m7576r() != null) {
            jsonGenerator.d();
            for (GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster : graphQLFriendLocationFeedUnitItem.m7576r()) {
                if (graphQLFriendsLocationsCluster != null) {
                    GraphQLFriendsLocationsCluster__JsonHelper.m7631a(jsonGenerator, graphQLFriendsLocationsCluster, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendLocationFeedUnitItem.m7577s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendLocationFeedUnitItem.m7577s(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
