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

/* compiled from: merge */
public class GraphQLWorkCommunityTrendingFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m22504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = new GraphQLWorkCommunityTrendingFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLWorkCommunityTrendingFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLWorkCommunityTrendingFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLWorkCommunityTrendingFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "cache_id", graphQLWorkCommunityTrendingFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLWorkCommunityTrendingFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "debug_info", graphQLWorkCommunityTrendingFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLWorkCommunityTrendingFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "fetchTimeMs", graphQLWorkCommunityTrendingFeedUnit.a_, 2, false);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLWorkCommunityTrendingFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "short_term_cache_key", graphQLWorkCommunityTrendingFeedUnit.a_, 3, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLWorkCommunityTrendingFeedUnit.i = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "title", graphQLWorkCommunityTrendingFeedUnit.a_, 4, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLWorkCommunityTrendingFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "tracking", graphQLWorkCommunityTrendingFeedUnit.a_, 5, false);
                } else if ("trending_stories".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLWorkCommunityTrendingFeedUnitItem a = GraphQLWorkCommunityTrendingFeedUnitItem__JsonHelper.m22513a(FieldAccessQueryTracker.a(jsonParser, "trending_stories"));
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
                    graphQLWorkCommunityTrendingFeedUnit.k = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnit, "trending_stories", graphQLWorkCommunityTrendingFeedUnit.a_, 6, true);
                }
                jsonParser.f();
            }
        }
        return graphQLWorkCommunityTrendingFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWorkCommunityTrendingFeedUnit.class, new GraphQLWorkCommunityTrendingFeedUnitDeserializer());
    }

    public GraphQLWorkCommunityTrendingFeedUnitDeserializer() {
        a(GraphQLWorkCommunityTrendingFeedUnit.class);
    }
}
