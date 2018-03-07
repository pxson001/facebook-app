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

/* compiled from: orca */
public class GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit = new GraphQLInstagramPhotosFromFriendsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLInstagramPhotosFromFriendsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLInstagramPhotosFromFriendsFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInstagramPhotosFromFriendsFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "cache_id", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInstagramPhotosFromFriendsFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "debug_info", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLInstagramPhotosFromFriendsFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "fetchTimeMs", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 2, false);
                } else if ("igPffItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8718a(FieldAccessQueryTracker.a(jsonParser, "igPffItems"));
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
                    graphQLInstagramPhotosFromFriendsFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "igPffItems", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 3, true);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8718a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLInstagramPhotosFromFriendsFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "items", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInstagramPhotosFromFriendsFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "short_term_cache_key", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 5, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLInstagramPhotosFromFriendsFeedUnit.k = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "title", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 6, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLInstagramPhotosFromFriendsFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLInstagramPhotosFromFriendsFeedUnit, "tracking", graphQLInstagramPhotosFromFriendsFeedUnit.a_, 7, false);
                }
                jsonParser.f();
            }
        }
        return graphQLInstagramPhotosFromFriendsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, new GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer());
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer() {
        a(GraphQLInstagramPhotosFromFriendsFeedUnit.class);
    }
}
