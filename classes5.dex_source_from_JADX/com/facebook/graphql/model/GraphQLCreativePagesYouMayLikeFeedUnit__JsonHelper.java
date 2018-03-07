package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: ipad_sidefeed_group_about */
public final class GraphQLCreativePagesYouMayLikeFeedUnit__JsonHelper {
    public static boolean m6904a(GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLCreativePagesYouMayLikeFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "cache_id", graphQLCreativePagesYouMayLikeFeedUnit.a_, 0, false);
            return true;
        } else if ("creativePymlItems".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6900a(FieldAccessQueryTracker.a(jsonParser, "creativePymlItems"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLCreativePagesYouMayLikeFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "creativePymlItems", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 1, true);
            return true;
        } else if ("creativePymlTitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "creativePymlTitle"));
            }
            graphQLCreativePagesYouMayLikeFeedUnit.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "creativePymlTitle", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 2, true);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "debug_info", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 3, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLCreativePagesYouMayLikeFeedUnit.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "fetchTimeMs", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 4, false);
            return true;
        } else if ("items".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6900a(FieldAccessQueryTracker.a(jsonParser, "items"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLCreativePagesYouMayLikeFeedUnit.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "items", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 5, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "short_term_cache_key", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 6, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLCreativePagesYouMayLikeFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "title", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 7, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "tracking", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 8, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "local_last_negative_feedback_action_type", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 9, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCreativePagesYouMayLikeFeedUnit.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "local_story_visibility", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 10, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLCreativePagesYouMayLikeFeedUnit.p = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLCreativePagesYouMayLikeFeedUnit, "local_story_visible_height", graphQLCreativePagesYouMayLikeFeedUnit.B_(), 11, false);
            return true;
        }
    }
}
