package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFriendsLocationsFeedType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: page_post_like_story */
public class GraphQLFriendsLocationsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = new GraphQLFriendsLocationsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFriendsLocationsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLFriendsLocationsFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFriendsLocationsFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "cache_id", graphQLFriendsLocationsFeedUnit.a_, 0, false);
                } else if ("creation_time".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0;
                    } else {
                        r4 = jsonParser.F();
                    }
                    graphQLFriendsLocationsFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "creation_time", graphQLFriendsLocationsFeedUnit.a_, 1, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFriendsLocationsFeedUnit.g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "debug_info", graphQLFriendsLocationsFeedUnit.a_, 2, false);
                } else if ("description".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
                    }
                    graphQLFriendsLocationsFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "description", graphQLFriendsLocationsFeedUnit.a_, 3, true);
                } else if ("fetchTimeMs".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0;
                    } else {
                        r4 = jsonParser.F();
                    }
                    graphQLFriendsLocationsFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "fetchTimeMs", graphQLFriendsLocationsFeedUnit.a_, 4, false);
                } else if ("footer".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "footer"));
                    }
                    graphQLFriendsLocationsFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "footer", graphQLFriendsLocationsFeedUnit.a_, 5, true);
                } else if ("friendsLocationsItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLFriendLocationFeedUnitItem__JsonHelper.m7580a(FieldAccessQueryTracker.a(jsonParser, "friendsLocationsItems"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLFriendsLocationsFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "friendsLocationsItems", graphQLFriendsLocationsFeedUnit.a_, 6, true);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLFriendLocationFeedUnitItem__JsonHelper.m7580a(FieldAccessQueryTracker.a(jsonParser, "items"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLFriendsLocationsFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "items", graphQLFriendsLocationsFeedUnit.a_, 7, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFriendsLocationsFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "short_term_cache_key", graphQLFriendsLocationsFeedUnit.a_, 8, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLFriendsLocationsFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "title", graphQLFriendsLocationsFeedUnit.a_, 9, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFriendsLocationsFeedUnit.o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "tracking", graphQLFriendsLocationsFeedUnit.a_, 10, false);
                } else if ("feed_type".equals(i)) {
                    graphQLFriendsLocationsFeedUnit.p = GraphQLFriendsLocationsFeedType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLFriendsLocationsFeedUnit, "feed_type", graphQLFriendsLocationsFeedUnit.a_, 11, false);
                }
                jsonParser.f();
            }
        }
        return graphQLFriendsLocationsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsLocationsFeedUnit.class, new GraphQLFriendsLocationsFeedUnitDeserializer());
    }

    public GraphQLFriendsLocationsFeedUnitDeserializer() {
        a(GraphQLFriendsLocationsFeedUnit.class);
    }
}
