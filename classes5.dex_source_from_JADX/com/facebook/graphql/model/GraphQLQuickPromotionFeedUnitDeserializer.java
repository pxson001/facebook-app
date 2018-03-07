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

/* compiled from: need JSON Array to contain As.WRAPPER_ARRAY type information for class  */
public class GraphQLQuickPromotionFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = new GraphQLQuickPromotionFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLQuickPromotionFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLQuickPromotionFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "cache_id", graphQLQuickPromotionFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "debug_info", graphQLQuickPromotionFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLQuickPromotionFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "fetchTimeMs", graphQLQuickPromotionFeedUnit.a_, 2, false);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21247a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLQuickPromotionFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "items", graphQLQuickPromotionFeedUnit.a_, 3, true);
                } else if ("quick_promotion_items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLQuickPromotionFeedUnitItem__JsonHelper.m21247a(FieldAccessQueryTracker.a(jsonParser, "quick_promotion_items"));
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
                    graphQLQuickPromotionFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "quick_promotion_items", graphQLQuickPromotionFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "short_term_cache_key", graphQLQuickPromotionFeedUnit.a_, 5, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLQuickPromotionFeedUnit.k = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "title", graphQLQuickPromotionFeedUnit.a_, 6, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "tracking", graphQLQuickPromotionFeedUnit.a_, 7, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "local_last_negative_feedback_action_type", graphQLQuickPromotionFeedUnit.a_, 8, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLQuickPromotionFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "local_story_visibility", graphQLQuickPromotionFeedUnit.a_, 9, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLQuickPromotionFeedUnit.o = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionFeedUnit, "local_story_visible_height", graphQLQuickPromotionFeedUnit.a_, 10, false);
                }
                jsonParser.f();
            }
        }
        return graphQLQuickPromotionFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionFeedUnit.class, new GraphQLQuickPromotionFeedUnitDeserializer());
    }

    public GraphQLQuickPromotionFeedUnitDeserializer() {
        a(GraphQLQuickPromotionFeedUnit.class);
    }
}
