package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: organic_pagepost_following_button */
public class GraphQLIncomingFriendRequestFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit = new GraphQLIncomingFriendRequestFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLIncomingFriendRequestFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLIncomingFriendRequestFeedUnit.f4285d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4286e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "cache_id", graphQLIncomingFriendRequestFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4287f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "debug_info", graphQLIncomingFriendRequestFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLIncomingFriendRequestFeedUnit.f4288g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "fetchTimeMs", graphQLIncomingFriendRequestFeedUnit.a_, 2, false);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4289h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "id", graphQLIncomingFriendRequestFeedUnit.a_, 3, false);
                } else if ("requests".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLIncomingFriendRequestFeedUnitItem a = GraphQLIncomingFriendRequestFeedUnitItem__JsonHelper.m8670a(FieldAccessQueryTracker.a(jsonParser, "requests"));
                            if (a != null) {
                                collection.add(a);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLIncomingFriendRequestFeedUnit.f4290i = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "requests", graphQLIncomingFriendRequestFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4291j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "short_term_cache_key", graphQLIncomingFriendRequestFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLIncomingFriendRequestFeedUnit.f4292k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "title", graphQLIncomingFriendRequestFeedUnit.a_, 7, true);
                } else if ("titleForSummary".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
                    }
                    graphQLIncomingFriendRequestFeedUnit.f4293l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "titleForSummary", graphQLIncomingFriendRequestFeedUnit.a_, 8, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4294m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "tracking", graphQLIncomingFriendRequestFeedUnit.a_, 9, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLIncomingFriendRequestFeedUnit.f4295n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLIncomingFriendRequestFeedUnit, "url", graphQLIncomingFriendRequestFeedUnit.a_, 10, false);
                }
                jsonParser.f();
            }
        }
        return graphQLIncomingFriendRequestFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLIncomingFriendRequestFeedUnit.class, new GraphQLIncomingFriendRequestFeedUnitDeserializer());
    }

    public GraphQLIncomingFriendRequestFeedUnitDeserializer() {
        a(GraphQLIncomingFriendRequestFeedUnit.class);
    }
}
