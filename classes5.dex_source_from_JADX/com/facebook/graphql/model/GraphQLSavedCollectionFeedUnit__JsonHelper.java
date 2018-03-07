package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: VERTICAL_COMPONENTS_RECYCLE */
public final class GraphQLSavedCollectionFeedUnit__JsonHelper {
    public static boolean m21552a(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLSavedCollectionFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
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
            graphQLSavedCollectionFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "action_links", graphQLSavedCollectionFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "cache_id", graphQLSavedCollectionFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "debug_info", graphQLSavedCollectionFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLSavedCollectionFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "fetchTimeMs", graphQLSavedCollectionFeedUnit.B_(), 3, false);
            return true;
        } else if ("items".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21548a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
            graphQLSavedCollectionFeedUnit.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "items", graphQLSavedCollectionFeedUnit.B_(), 4, true);
            return true;
        } else if ("savedActionLinks".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "savedActionLinks"));
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
            graphQLSavedCollectionFeedUnit.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "savedActionLinks", graphQLSavedCollectionFeedUnit.B_(), 5, true);
            return true;
        } else if ("savedCollection".equals(str)) {
            GraphQLTimelineAppCollection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "savedCollection"));
            }
            graphQLSavedCollectionFeedUnit.k = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "savedCollection", graphQLSavedCollectionFeedUnit.B_(), 6, true);
            return true;
        } else if ("savedItems".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21548a(FieldAccessQueryTracker.a(jsonParser, "savedItems"));
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
            graphQLSavedCollectionFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "savedItems", graphQLSavedCollectionFeedUnit.B_(), 7, true);
            return true;
        } else if ("savedTitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "savedTitle"));
            }
            graphQLSavedCollectionFeedUnit.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "savedTitle", graphQLSavedCollectionFeedUnit.B_(), 8, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "short_term_cache_key", graphQLSavedCollectionFeedUnit.B_(), 9, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLSavedCollectionFeedUnit.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "title", graphQLSavedCollectionFeedUnit.B_(), 10, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "tracking", graphQLSavedCollectionFeedUnit.B_(), 11, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "local_last_negative_feedback_action_type", graphQLSavedCollectionFeedUnit.B_(), 12, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnit.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "local_story_visibility", graphQLSavedCollectionFeedUnit.B_(), 13, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLSavedCollectionFeedUnit.s = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnit, "local_story_visible_height", graphQLSavedCollectionFeedUnit.B_(), 14, false);
            return true;
        }
    }
}
