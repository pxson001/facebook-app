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

/* compiled from: netego_timeline_collections */
public class GraphQLPlaceReviewFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = new GraphQLPlaceReviewFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPlaceReviewFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLPlaceReviewFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPlaceReviewFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "cache_id", graphQLPlaceReviewFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPlaceReviewFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "debug_info", graphQLPlaceReviewFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLPlaceReviewFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "fetchTimeMs", graphQLPlaceReviewFeedUnit.a_, 2, false);
                } else if ("items".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLPlaceReviewFeedUnitItem a = GraphQLPlaceReviewFeedUnitItem__JsonHelper.m20909a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLPlaceReviewFeedUnit.h = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "items", graphQLPlaceReviewFeedUnit.a_, 3, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPlaceReviewFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "short_term_cache_key", graphQLPlaceReviewFeedUnit.a_, 4, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLPlaceReviewFeedUnit.j = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "title", graphQLPlaceReviewFeedUnit.a_, 5, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPlaceReviewFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPlaceReviewFeedUnit, "tracking", graphQLPlaceReviewFeedUnit.a_, 6, false);
                }
                jsonParser.f();
            }
        }
        return graphQLPlaceReviewFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceReviewFeedUnit.class, new GraphQLPlaceReviewFeedUnitDeserializer());
    }

    public GraphQLPlaceReviewFeedUnitDeserializer() {
        a(GraphQLPlaceReviewFeedUnit.class);
    }
}
