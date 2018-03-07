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

/* compiled from: original_video */
public class GraphQLGroupsYouShouldJoinFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit = new GraphQLGroupsYouShouldJoinFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupsYouShouldJoinFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLGroupsYouShouldJoinFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldJoinFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "cache_id", graphQLGroupsYouShouldJoinFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldJoinFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "debug_info", graphQLGroupsYouShouldJoinFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLGroupsYouShouldJoinFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "fetchTimeMs", graphQLGroupsYouShouldJoinFeedUnit.a_, 2, false);
                } else if ("gysjItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8556a(FieldAccessQueryTracker.a(jsonParser, "gysjItems"));
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
                    graphQLGroupsYouShouldJoinFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "gysjItems", graphQLGroupsYouShouldJoinFeedUnit.a_, 3, true);
                } else if ("gysjTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "gysjTitle"));
                    }
                    graphQLGroupsYouShouldJoinFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "gysjTitle", graphQLGroupsYouShouldJoinFeedUnit.a_, 4, true);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8556a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLGroupsYouShouldJoinFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "items", graphQLGroupsYouShouldJoinFeedUnit.a_, 5, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldJoinFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "short_term_cache_key", graphQLGroupsYouShouldJoinFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLGroupsYouShouldJoinFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "title", graphQLGroupsYouShouldJoinFeedUnit.a_, 7, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldJoinFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldJoinFeedUnit, "tracking", graphQLGroupsYouShouldJoinFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLGroupsYouShouldJoinFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldJoinFeedUnit.class, new GraphQLGroupsYouShouldJoinFeedUnitDeserializer());
    }

    public GraphQLGroupsYouShouldJoinFeedUnitDeserializer() {
        a(GraphQLGroupsYouShouldJoinFeedUnit.class);
    }
}
