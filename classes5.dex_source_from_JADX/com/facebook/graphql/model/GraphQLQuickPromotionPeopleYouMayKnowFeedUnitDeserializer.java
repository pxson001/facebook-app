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

/* compiled from: nearby_locations */
public class GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLQuickPromotionPeopleYouMayKnowFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "cache_id", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "debug_info", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "fetchTimeMs", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 2, false);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20686a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "items", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 3, true);
                } else if ("pymkItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20686a(FieldAccessQueryTracker.a(jsonParser, "pymkItems"));
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
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "pymkItems", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 4, true);
                } else if ("pymkTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pymkTitle"));
                    }
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "pymkTitle", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 5, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "short_term_cache_key", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "title", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 7, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionPeopleYouMayKnowFeedUnit, "tracking", graphQLQuickPromotionPeopleYouMayKnowFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLQuickPromotionPeopleYouMayKnowFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, new GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer());
    }

    public GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer() {
        a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class);
    }
}
