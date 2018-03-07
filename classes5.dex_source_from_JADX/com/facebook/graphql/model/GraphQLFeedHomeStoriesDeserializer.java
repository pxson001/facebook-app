package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: page_visits */
public class GraphQLFeedHomeStoriesDeserializer extends FbJsonDeserializer {
    public Object m7457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFeedHomeStories graphQLFeedHomeStories = new GraphQLFeedHomeStories();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFeedHomeStories = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("approximate_new_unit_count".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLFeedHomeStories.d = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "approximate_new_unit_count", graphQLFeedHomeStories.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFeedHomeStories.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "debug_info", graphQLFeedHomeStories.a_, 1, false);
                } else if ("edges".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLFeedUnitEdge a = GraphQLFeedUnitEdge__JsonHelper.m7471a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                            if (a != null) {
                                r4.add(a);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLFeedHomeStories.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "edges", graphQLFeedHomeStories.a_, 2, true);
                } else if ("low_engagement_deduplication_keys".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (o != null) {
                                r4.add(o);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLFeedHomeStories.g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "low_engagement_deduplication_keys", graphQLFeedHomeStories.a_, 3, false);
                } else if ("no_feed_polling".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLFeedHomeStories.h = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "no_feed_polling", graphQLFeedHomeStories.a_, 4, false);
                } else if ("page_info".equals(i)) {
                    GraphQLPageInfo graphQLPageInfo;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPageInfo = null;
                    } else {
                        graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                    }
                    graphQLFeedHomeStories.i = graphQLPageInfo;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "page_info", graphQLFeedHomeStories.a_, 5, true);
                } else if ("query_function".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFeedHomeStories.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "query_function", graphQLFeedHomeStories.a_, 6, false);
                } else if ("query_title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFeedHomeStories.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFeedHomeStories, "query_title", graphQLFeedHomeStories.a_, 7, false);
                }
                jsonParser.f();
            }
        }
        return graphQLFeedHomeStories;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedHomeStories.class, new GraphQLFeedHomeStoriesDeserializer());
    }

    public GraphQLFeedHomeStoriesDeserializer() {
        a(GraphQLFeedHomeStories.class);
    }
}
