package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: has_faceboxes */
public final class GraphQLFriendsLocationsCluster__JsonHelper {
    public static GraphQLFriendsLocationsCluster m7630a(JsonParser jsonParser) {
        GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster = new GraphQLFriendsLocationsCluster();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7632a(graphQLFriendsLocationsCluster, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendsLocationsCluster;
    }

    private static boolean m7632a(GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster, String str, JsonParser jsonParser) {
        if ("approximate_location".equals(str)) {
            GraphQLLocation graphQLLocation;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLLocation = null;
            } else {
                graphQLLocation = GraphQLLocation__JsonHelper.m8965a(FieldAccessQueryTracker.a(jsonParser, "approximate_location"));
            }
            graphQLFriendsLocationsCluster.f3796d = graphQLLocation;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsCluster, "approximate_location", graphQLFriendsLocationsCluster.a_, 0, true);
            return true;
        } else if (!"friends_count".equals(str)) {
            return false;
        } else {
            graphQLFriendsLocationsCluster.f3797e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsCluster, "friends_count", graphQLFriendsLocationsCluster.B_(), 1, false);
            return true;
        }
    }

    public static void m7631a(JsonGenerator jsonGenerator, GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFriendsLocationsCluster.m7624a() != null) {
            jsonGenerator.a("approximate_location");
            GraphQLLocation__JsonHelper.m8966a(jsonGenerator, graphQLFriendsLocationsCluster.m7624a(), true);
        }
        jsonGenerator.a("friends_count", graphQLFriendsLocationsCluster.m7627j());
        if (z) {
            jsonGenerator.g();
        }
    }
}
