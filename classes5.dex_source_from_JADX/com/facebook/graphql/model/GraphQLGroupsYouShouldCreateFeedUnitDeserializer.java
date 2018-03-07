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

/* compiled from: otherEventDeclines */
public class GraphQLGroupsYouShouldCreateFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = new GraphQLGroupsYouShouldCreateFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupsYouShouldCreateFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLGroupsYouShouldCreateFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldCreateFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "cache_id", graphQLGroupsYouShouldCreateFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldCreateFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "debug_info", graphQLGroupsYouShouldCreateFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLGroupsYouShouldCreateFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "fetchTimeMs", graphQLGroupsYouShouldCreateFeedUnit.a_, 2, false);
                } else if ("gyscItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8539a(FieldAccessQueryTracker.a(jsonParser, "gyscItems"));
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
                    graphQLGroupsYouShouldCreateFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "gyscItems", graphQLGroupsYouShouldCreateFeedUnit.a_, 3, true);
                } else if ("gyscTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "gyscTitle"));
                    }
                    graphQLGroupsYouShouldCreateFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "gyscTitle", graphQLGroupsYouShouldCreateFeedUnit.a_, 4, true);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8539a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLGroupsYouShouldCreateFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "items", graphQLGroupsYouShouldCreateFeedUnit.a_, 5, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldCreateFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "short_term_cache_key", graphQLGroupsYouShouldCreateFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLGroupsYouShouldCreateFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "title", graphQLGroupsYouShouldCreateFeedUnit.a_, 7, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLGroupsYouShouldCreateFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnit, "tracking", graphQLGroupsYouShouldCreateFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLGroupsYouShouldCreateFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldCreateFeedUnit.class, new GraphQLGroupsYouShouldCreateFeedUnitDeserializer());
    }

    public GraphQLGroupsYouShouldCreateFeedUnitDeserializer() {
        a(GraphQLGroupsYouShouldCreateFeedUnit.class);
    }
}
