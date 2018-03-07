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

/* compiled from: null values are not allowed */
public class GraphQLPagesYouMayLikeFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9577a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = new GraphQLPagesYouMayLikeFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPagesYouMayLikeFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLPagesYouMayLikeFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "cache_id", graphQLPagesYouMayLikeFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "debug_info", graphQLPagesYouMayLikeFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLPagesYouMayLikeFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "fetchTimeMs", graphQLPagesYouMayLikeFeedUnit.a_, 2, false);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20579a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLPagesYouMayLikeFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "items", graphQLPagesYouMayLikeFeedUnit.a_, 3, true);
                } else if ("pymlItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20579a(FieldAccessQueryTracker.a(jsonParser, "pymlItems"));
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
                    graphQLPagesYouMayLikeFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "pymlItems", graphQLPagesYouMayLikeFeedUnit.a_, 4, true);
                } else if ("pymlPageBrowserCategory".equals(i)) {
                    GraphQLPageBrowserCategoryInfo graphQLPageBrowserCategoryInfo;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPageBrowserCategoryInfo = null;
                    } else {
                        graphQLPageBrowserCategoryInfo = GraphQLPageBrowserCategoryInfo__JsonHelper.m9478a(FieldAccessQueryTracker.a(jsonParser, "pymlPageBrowserCategory"));
                    }
                    graphQLPagesYouMayLikeFeedUnit.j = graphQLPageBrowserCategoryInfo;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "pymlPageBrowserCategory", graphQLPagesYouMayLikeFeedUnit.a_, 5, true);
                } else if ("pymlTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pymlTitle"));
                    }
                    graphQLPagesYouMayLikeFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "pymlTitle", graphQLPagesYouMayLikeFeedUnit.a_, 6, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "short_term_cache_key", graphQLPagesYouMayLikeFeedUnit.a_, 7, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLPagesYouMayLikeFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "title", graphQLPagesYouMayLikeFeedUnit.a_, 8, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "tracking", graphQLPagesYouMayLikeFeedUnit.a_, 9, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "local_last_negative_feedback_action_type", graphQLPagesYouMayLikeFeedUnit.a_, 10, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPagesYouMayLikeFeedUnit.p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "local_story_visibility", graphQLPagesYouMayLikeFeedUnit.a_, 11, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLPagesYouMayLikeFeedUnit.q = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayLikeFeedUnit, "local_story_visible_height", graphQLPagesYouMayLikeFeedUnit.a_, 12, false);
                }
                jsonParser.f();
            }
        }
        return graphQLPagesYouMayLikeFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnit.class, new GraphQLPagesYouMayLikeFeedUnitDeserializer());
    }

    public GraphQLPagesYouMayLikeFeedUnitDeserializer() {
        a(GraphQLPagesYouMayLikeFeedUnit.class);
    }
}
